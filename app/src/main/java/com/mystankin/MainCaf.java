package com.mystankin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.EmptyStackException;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import android.os.Environment;
import java.io.FileOutputStream;
import android.Manifest;
import android.content.pm.PackageManager;


import com.google.android.material.snackbar.Snackbar;

public class MainCaf extends AppCompatActivity {

    Button Back;
    //String[] data = {"ИИСТ", "ИАР", "Математика", "еще что то", "Физика"};
    //String[] num = {"0001", "0002", "0003", "0004", "0005"};
    String data = "ИИСТ";
    String num = "0001";
    List<String> datal = new ArrayList<String>();
    List<String> numl = new ArrayList<String>();
    String a,b,c;
    EditText editrstst1;
    TextView te;
    int flag = 1, pos;

//    public void EnableRuntimePermission(){
//
//        if (ActivityCompat.shouldShowRequestPermissionRationale(MainCaf.this, new String[]{
//                Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, RequestPermissionCode))
//        {
//
//            Toast.makeText(MainCaf.this,"CONTACTS permission allows us to Access CONTACTS app", Toast.LENGTH_LONG).show();
//
//        } else {
//
//            ActivityCompat.requestPermissions(MainCaf.this,new String[]{
//                    Manifest.permission.READ_CONTACTS}, RequestPermissionCode);
//
//        }
//    }
//
//    public void PermissionStatus(){
//
//        RequestCheckResult = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS);
//
//        if (RequestCheckResult == PackageManager.PERMISSION_GRANTED){
//
//            RequestTF = true;
//
//        } else {
//
//            RequestTF = false;
//
//        }
//
//    }

    private void writeDataFile() {
        try {
            /*
             * Создается объект файла, при этом путь к файлу находиться методом класcа Environment
             * Обращение идёт, как и было сказано выше к внешнему накопителю
             */
            File myFile = new File(Environment.getExternalStorageDirectory().toString() + "/" + "data.txt");
            myFile.createNewFile();                                         // Создается файл, если он не был создан
            if (myFile.length() == 0) {
                FileOutputStream outputStream = new FileOutputStream(myFile);   // После чего создаем поток для записи
                outputStream.write(data.getBytes());                            // и производим непосредственно запись
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeNumFile() {
        try {
            /*
             * Создается объект файла, при этом путь к файлу находиться методом класcа Environment
             * Обращение идёт, как и было сказано выше к внешнему накопителю
             */
            File myFile = new File(Environment.getExternalStorageDirectory().toString() + "/" + "num.txt");
            myFile.createNewFile();                                         // Создается файл, если он не был создан
            if (myFile.length() == 0) {
                FileOutputStream outputStream = new FileOutputStream(myFile);   // После чего создаем поток для записи
                outputStream.write(num.getBytes());                            // и производим непосредственно запись
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readDataFile() {
        setContentView(R.layout.activity_main_caf);
        File myFile = new File(Environment.getExternalStorageDirectory().toString() + "/" + "data.txt");
        try {
            FileInputStream inputStream = new FileInputStream(myFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //StringBuilder stringBuilder = new StringBuilder();
            String line;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    datal.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void readNumFile() {
        setContentView(R.layout.activity_main_caf);
        File myFile = new File(Environment.getExternalStorageDirectory().toString() + "/" + "num.txt");
        try {
            FileInputStream inputStream = new FileInputStream(myFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //StringBuilder stringBuilder = new StringBuilder();
            String line;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    numl.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        writeDataFile();
        writeNumFile();
        readDataFile();
        readNumFile();

        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datal);
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
                Toast.makeText(getBaseContext(), "Выбрна кафедра: " + datal.get(position) , Toast.LENGTH_SHORT).show();
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
                    b = numl.get(pos);

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
