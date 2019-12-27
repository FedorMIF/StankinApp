package com.mystankin;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainAudi extends AppCompatActivity {

    String a,b,c;
    EditText editrstst1;
    EditText editrstst2;
    TextView test;
    int flag = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_audi);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        editrstst1 = (EditText) findViewById(R.id.strtAudi);
        editrstst2 = (EditText) findViewById(R.id.endAudi);
        test = (TextView) findViewById(R.id.textView6);

        final Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editrstst1.getText().toString().equals("")||editrstst2.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainAudi.this);
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
                    b = editrstst2.getText().toString();

                    c = a + b;
                    test.setText("Результат сложения = " + c);
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
