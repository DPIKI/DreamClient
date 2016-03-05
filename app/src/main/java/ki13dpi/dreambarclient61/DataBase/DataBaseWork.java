package ki13dpi.dreambarclient61.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ki13dpi.dreambarclient61.Logic.ElemMenu;

/**
 * Created by prog1 on 03.03.2016.
 */
public class DataBaseWork {
    private static final String LOG_TAG = "my_tag";
    DataBaseHelper dbHelper;
    Context context;
    Cursor cursor;
    SQLiteDatabase db;
    List<DataBaseElem> dataBaseElemList;
    ArrayList<ElemMenu> elemMenuArrayList;

    public DataBaseWork(Context context) {
        this.context = context;
        dbHelper = new DataBaseHelper(context);
    }

    // возвращает количество записей в таблице
    public int getItemCount() {

        db = dbHelper.getReadableDatabase();

        cursor = db.query(DataBaseHelper.TABLE_NAME, null, null, null, null, null, null);
        int cnt = cursor.getCount();
        cursor.close();

        return cnt;
    }

    // метод для удаления строки по id
    public void deleteItem(int id) {
        db = dbHelper.getWritableDatabase();
        db.delete(DataBaseHelper.TABLE_NAME, DataBaseHelper.KEY_ID + "=" + id, null);
    }

    // метод возвращающий коллекцию всех данных в формате DataBaseElem
    public List<DataBaseElem> getDataBaseElemList() {
        cursor = db.query(DataBaseHelper.TABLE_NAME, null, null, null, null, null, null);
        dataBaseElemList = new ArrayList<DataBaseElem>();

        if (cursor.moveToFirst()) {

            int idColInd = cursor.getColumnIndex(DataBaseHelper.KEY_ID);
            int realIdColInd = cursor.getColumnIndex(DataBaseHelper.KEY_REAL_ID);
            int categoryColInd = cursor.getColumnIndex(DataBaseHelper.KEY_CATEGORY);
            int nameColInd = cursor.getColumnIndex(DataBaseHelper.KEY_NAME);

            do {
                DataBaseElem dataBaseElem = new DataBaseElem(
                        cursor.getInt(idColInd),
                        cursor.getInt(realIdColInd),
                        cursor.getString(categoryColInd),
                        cursor.getString(nameColInd));
                dataBaseElemList.add(dataBaseElem);
            } while (cursor.moveToNext());

        } else {
            Log.d(LOG_TAG, "В базе нет данных!");
        }

        cursor.close();

        return dataBaseElemList;

    }

    // метод возвращающий коллекцию всех данных в формате ElemMenu
    public ArrayList<ElemMenu> getElemMenuListFromDataBase(){
        elemMenuArrayList = new ArrayList<>();

        cursor = db.query(DataBaseHelper.TABLE_NAME, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int realIdColInd = cursor.getColumnIndex(DataBaseHelper.KEY_REAL_ID);
            int categoryColInd = cursor.getColumnIndex(DataBaseHelper.KEY_CATEGORY);
            int nameColInd = cursor.getColumnIndex(DataBaseHelper.KEY_NAME);

            do {
                ElemMenu elemMenu = new ElemMenu(
                        cursor.getInt(realIdColInd),
                        cursor.getString(categoryColInd),
                        cursor.getString(nameColInd));
                elemMenuArrayList.add(elemMenu);
                Log.d(LOG_TAG, "Добавлено в List: " + cursor.getString(nameColInd));
            } while (cursor.moveToNext());

        } else {
            Log.d(LOG_TAG, "В базе нет данных!");
        }
        cursor.close();

        return elemMenuArrayList;
    }

    public void addToBase(DataBaseElem dataBaseElem){
        db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(DataBaseHelper.KEY_REAL_ID, dataBaseElem.get_id());
        cv.put(DataBaseHelper.KEY_CATEGORY, dataBaseElem.get_category());
        cv.put(DataBaseHelper.KEY_NAME, dataBaseElem.get_name());
        db.insert(DataBaseHelper.TABLE_NAME, null, cv);

    }

    // здесь закрываем все соединения с базой и класс-помощник
    public void close() {
        dbHelper.close();
        db.close();
    }
}
