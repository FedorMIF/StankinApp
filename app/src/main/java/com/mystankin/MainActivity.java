package com.mystankin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClickBtn( View v ) {
        switch (v.getId()) {
            case R.id.but_Audi:
                Intent intent1 = new Intent(this, MainAudi.class);
                startActivity(intent1);
                break;
            case R.id.but_Caf:
                Intent intent2 = new Intent(this, MainCaf.class);
                startActivity(intent2);
                break;
            //case R.id.but_Ped:
            default:
                break;
        }
    }
}
