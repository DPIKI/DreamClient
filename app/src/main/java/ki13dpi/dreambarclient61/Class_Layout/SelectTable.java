package ki13dpi.dreambarclient61.Class_Layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ki13dpi.dreambarclient61.R;
import ki13dpi.dreambarclient61.Logic.Singleton;

public class SelectTable extends AppCompatActivity {
    EditText et_selectTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_table);

        Singleton singleton = Singleton.getInstance();
        et_selectTable = (EditText)findViewById(R.id.et_selectTable);
        SetOnKeyListener(et_selectTable);

        TextView textViewNum = (TextView)findViewById(R.id.tv_tableNum);

        if(singleton.get_numberOfTable() == 0) {
            textViewNum.setText("Стол не выбран");
        }
        else {
            textViewNum.setText("Стол №"+Integer.toString(singleton.get_numberOfTable()));
        }

    }

    private void SetOnKeyListener(final EditText et_selectTable){
        /////////////////////////////////////////================Установка слушателя нажатия Enter
        et_selectTable.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        onClickSetNum(getCurrentFocus());
                        return true;
                    }
                return false;
            }
        });
        //////////////////////////////////////////================Установка слушателя нажатия Enter

    }

    public void onClickSetNum(View view){
        if (et_selectTable.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(),
                    "Неверно введен № стола", Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(),
                    "Повторите попытку", Toast.LENGTH_LONG).show();
        } else {
            int i_numTable;
            String s_num = et_selectTable.getText().toString();
            try {
                i_numTable = Integer.valueOf(s_num);
            } catch (NumberFormatException e) {
                i_numTable = -1;
            }
            if (i_numTable != -1) {
                Singleton singleton = Singleton.getInstance();
                singleton.set_numberOfTable(i_numTable);
                Toast.makeText(getApplicationContext(),
                        "Выбран стол №" + i_numTable, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,ListMenu.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(),
                        "Ошибка ввода стола", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onClickBack(View view){
        Intent intent = new Intent(this,General.class);
        startActivity(intent);
    }
}
