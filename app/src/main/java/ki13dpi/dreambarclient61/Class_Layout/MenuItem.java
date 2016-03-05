package ki13dpi.dreambarclient61.Class_Layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ki13dpi.dreambarclient61.Logic.ElemMenu;
import ki13dpi.dreambarclient61.R;
import ki13dpi.dreambarclient61.Logic.Singleton;

public class MenuItem extends AppCompatActivity {
    private ArrayAdapter<String> _itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);

        String categorySelect = getIntent().getStringExtra("category");
        TextView categoryName = (TextView)findViewById(R.id.tv_categoryName);
        categoryName.setText(categorySelect);

        Singleton singleton = Singleton.getInstance();
        ArrayList<String> out = new ArrayList<>();

        for(ElemMenu item: singleton.getElemMenuArrayList()){
            if(item.get_category().equals(categorySelect)){
                out.add(item.get_name());
            }
        }
        _itemAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,out);
        ListView listViewItemMenu = (ListView) findViewById(R.id.lv_menuItem);
        listViewItemMenu.setAdapter(_itemAdapter);
    }

    public void onClickBackCategory(View view){
        Intent intent = new Intent(this,ListMenu.class);
        startActivity(intent);
    }
}
