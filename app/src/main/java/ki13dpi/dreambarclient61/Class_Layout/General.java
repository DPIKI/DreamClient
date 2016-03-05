package ki13dpi.dreambarclient61.Class_Layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ki13dpi.dreambarclient61.Debug;
import ki13dpi.dreambarclient61.R;

public class General extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
    }

    public void onClickNewOrder(View view){
        Intent intent = new Intent(this,SelectTable.class);
        startActivity(intent);
    }
    public void onDebugClick(View view){
        Intent intent = new Intent(this,Debug.class);
        startActivity(intent);
    }

    public void onClickMenu(View view){
        Intent intent = new Intent(this, ListMenu.class);
        startActivity(intent);
    }
}
