package ki13dpi.dreambarclient61;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import ki13dpi.dreambarclient61.DataBase.DataBaseElem;
import ki13dpi.dreambarclient61.DataBase.DataBaseHelper;
import ki13dpi.dreambarclient61.DataBase.DataBaseWork;
import ki13dpi.dreambarclient61.Logic.ElemMenu;
import ki13dpi.dreambarclient61.Logic.Singleton;

public class Debug extends AppCompatActivity {
    DataBaseHelper _dataBaseHelper;
    EditText category, name, id;

    //
    private static final String LOG_TAG = "my_tag";
    DataBaseWork dataBaseWork;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);
    }

    public void onAddClick(View view){
        ElemMenu elemMenu;
        elemMenu = new ElemMenu();

        category = (EditText)findViewById(R.id.category);
        name = (EditText)findViewById(R.id.name);
        id = (EditText)findViewById(R.id.idi);

        elemMenu.set_category(category.getText().toString());
        elemMenu.set_name(name.getText().toString());
        elemMenu.set_id(Integer.valueOf(id.getText().toString()));

        Singleton singleton = Singleton.getInstance();
        singleton.addToMenu(elemMenu);
    }

    public void onClickAddDB(View view){
        category = (EditText)findViewById(R.id.category);
        name = (EditText)findViewById(R.id.name);
        id = (EditText)findViewById(R.id.idi);

        dataBaseWork = new DataBaseWork(this);
        // получаем количество записей в базе перед изменениями
        int mCount = dataBaseWork.getItemCount();
        Log.d(LOG_TAG, "Количество записей в базе:" + mCount);

        DataBaseElem dataBaseElem = new DataBaseElem(1,Integer.valueOf(id.getText().toString()),category.getText().toString(),name.getText().toString());
        dataBaseWork.addToBase(dataBaseElem);

        dataBaseWork.close();
    }

    public void onClickShowDataBase(View view){

        dataBaseWork = new DataBaseWork(this);
        // получаем количество записей в базе перед изменениями
        int mCount = dataBaseWork.getItemCount();
        Toast.makeText(Debug.this, "Количество записей в базе:" + mCount, Toast.LENGTH_SHORT).show();
        Log.d(LOG_TAG, "Количество записей в базе:" + mCount);

        // выводим все имеющиеся записи в лог
        List<DataBaseElem> dataBaseElemList = dataBaseWork.getDataBaseElemList();
        for (DataBaseElem dataBaseElem : dataBaseElemList) {
            Toast.makeText(Debug.this, "ID: " + dataBaseElem.get_realID() + " Category: " + dataBaseElem.get_category()
                    + " Name " + dataBaseElem.get_name(), Toast.LENGTH_SHORT).show();
            Log.d(LOG_TAG, "ID: " + dataBaseElem.get_realID() + " Category: " + dataBaseElem.get_category()
                            + " Name " + dataBaseElem.get_name());
        }
        dataBaseWork.close();
    }
}
