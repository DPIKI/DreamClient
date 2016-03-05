package ki13dpi.dreambarclient61.Class_Layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ki13dpi.dreambarclient61.Logic.ElemMenu;
import ki13dpi.dreambarclient61.R;
import ki13dpi.dreambarclient61.Logic.Singleton;

public class ListMenu extends AppCompatActivity {
    private ArrayAdapter<String> _categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);

        final Intent intent = new Intent(this,MenuItem.class);

        Singleton singleton = Singleton.getInstance();
        ArrayList<String> out = new ArrayList<>();

        //
        out = ListMenu.InitializeCategoryList(singleton.getElemMenuArrayList());
        //
        _categoryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,out);
        ListView listViewCategory = (ListView) findViewById(R.id.lv_Menu);
        listViewCategory.setAdapter(_categoryAdapter);


        listViewCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id){
                Toast.makeText(getApplicationContext(), ((TextView) itemClicked).getText(),
                        Toast.LENGTH_SHORT).show();
                String categoryName = ((TextView) itemClicked).getText().toString();
                intent.putExtra("category",categoryName);
                startActivity(intent);
            }
        });
    }

    //Формирует и возвращает список Категорий
    public static ArrayList<String> InitializeCategoryList(ArrayList<ElemMenu> elemMenuArrayList){
        ArrayList<String> categoryList = new ArrayList<>();
        boolean valid = true;

        for (ElemMenu item: elemMenuArrayList) {
            valid = true;
            for(int i=0;i<categoryList.size() && valid == true;i++){
                if(item.get_category().equals(categoryList.get(i))){
                    valid = false;
                }
            }
            if(valid == true){
                categoryList.add(item.get_category());
            }
        }
        return categoryList;
    }
}
