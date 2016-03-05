package ki13dpi.dreambarclient61.Class_Layout;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import ki13dpi.dreambarclient61.DataBase.DataBaseElem;
import ki13dpi.dreambarclient61.DataBase.DataBaseWork;
import ki13dpi.dreambarclient61.Logic.Singleton;

//TODO: заменил на ListMenu.java.
public class MenuCategory extends ListActivity{
    private ArrayAdapter<String> _categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Singleton singleton = Singleton.getInstance();
        ArrayList<String> out;
        //
        out = ListMenu.InitializeCategoryList(singleton.getElemMenuArrayList());
        //
       // DataBaseWork dataBaseWork;
       // dataBaseWork = new DataBaseWork(this);
      //  out = ListMenu.InitializeCategoryList(dataBaseWork.getElemMenuListFromDataBase());
       // dataBaseWork.close();

        _categoryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, out);
        setListAdapter(_categoryAdapter);
    }
}
