
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
                    builder.setTitle("Что-то не так")
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

                    if ((a.length() <= 4) && (b.length() <= 4) &&
                            (a.charAt(0) <= '9' && a.charAt(0) >= '0') && (a.charAt(1) <= '9' && a.charAt(1) >= '0') &&
                            (a.charAt(2) <= '9' && a.charAt(2) >= '0') && (b.charAt(0) <= '9' && b.charAt(0) >= '0') &&
                            (b.charAt(1) <= '9' && b.charAt(1) >= '0') && (b.charAt(2) <= '9' && b.charAt(2) >= '0')) {
                        if (a.charAt(0) == '0') {
                            if (b.charAt(0) == '0')
                                test.setText("Вы на " + a.charAt(1) + " этаже нового корпуса" + " Вам надо на " + b.charAt(1) + " этаж нового корпуса");
                            else
                                test.setText("Вы на " + a.charAt(1) + " этаже нового корпуса" + " Вам надо на " + b.charAt(0) + " этаж старого корпуса");
                        } else {
                            if (b.charAt(0) == '0')
                                test.setText("Вы на " + a.charAt(0) + " этаже старого корпуса" + " Вам надо на " + b.charAt(1) + " этаж нового курпуса");
                            else
                                test.setText("Вы на " + a.charAt(0) + " этаже старого корпуса" + " Вам надо на " + b.charAt(0) + " этаж старого корпуса");
                        }
                    }else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainAudi.this);
                        builder.setTitle("Что-то не так")
                                .setMessage("Номер обязан содержать только цифры и не более 4х символов")
                                .setCancelable(false)
                                .setNegativeButton("ОК, сейчас исправлю", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) { dialog.cancel();
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                        flag = 0;
                    }
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