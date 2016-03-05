package ki13dpi.dreambarclient61.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by prog1 on 02.03.2016.
 */

// DataBaseHelper отвечает только за создание и обновление базы данных
public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = "my_tag";

    public static final String TABLE_NAME = "menu";

    public static final String KEY_ID = "_id";
    public static final String KEY_REAL_ID = "realID";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_NAME = "name";

    private static final String DATABASE_NAME = "menuDataBase";
    private static final int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.d(LOG_TAG, "DBH constr");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ("
                + KEY_ID + " integer primary key autoincrement,"
                + KEY_REAL_ID + " integer,"
                + KEY_CATEGORY + " text,"
                + KEY_NAME + " text" + ");");
        ContentValues cv = new ContentValues();

        cv.put(KEY_REAL_ID, "1");
        cv.put(KEY_CATEGORY, "Beer");
        cv.put(KEY_NAME, "Carlsberg");
        db.insert(TABLE_NAME, null, cv);

        cv.put(KEY_REAL_ID, "2");
        cv.put(KEY_CATEGORY, "Beer");
        cv.put(KEY_NAME, "Jigul");
        db.insert(TABLE_NAME, null, cv);

        cv.put(KEY_REAL_ID,"3");
        cv.put(KEY_CATEGORY, "Pizza");
        cv.put(KEY_NAME, "Small");
        db.insert(TABLE_NAME, null, cv);

        cv.put(KEY_REAL_ID,"55");
        cv.put(KEY_CATEGORY, "Pizza");
        cv.put(KEY_NAME, "Big");
        db.insert(TABLE_NAME, null, cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }
}
