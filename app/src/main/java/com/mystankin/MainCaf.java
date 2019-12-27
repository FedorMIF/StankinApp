package com.mystankin;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainCaf extends AppCompatActivity {

    Button Back;
    String[] data = {"ИИСТ", "ИАР", "Математика", "еще что то", "Физика"};
    String[] num = {"0001", "0002", "0003", "0004", "0005"};
    List<String> dlist = new ArrayList<String>();
    List<String> nlist = new ArrayList<String>();
    String a,b,c;
    EditText editrstst1;
    TextView te;
    int flag = 1, pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_caf);

        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Выберете кафедру");
        spinner.setSelection(0);


        editrstst1 = (EditText) findViewById(R.id.strtAudi2);
        te = (TextView) findViewById(R.id.textView7);

        final Button button = (Button) findViewById(R.id.button);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Выбрна кафедра: " + data[position] , Toast.LENGTH_SHORT).show();
                pos = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editrstst1.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainCaf.this);
                    builder.setTitle("Не верное значение")
                            .setMessage("Введите номер кабинета состоящий из цифр и буквы")
                            .setCancelable(false)
                            .setNegativeButton("ОК, сейчас исправлю", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                    flag = 0;
                }
                else {
                    a = editrstst1.getText().toString();
                    b = num[pos];

                            c = a + b;
                    te.setText("Результат сложения = " + c);
                }
            }

        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
