package com.example.tambola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setting=getSharedPreferences("mypreference",MODE_PRIVATE);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String s=setting.getString("gmail","gmail");

                if (s.equals("gmail")){
                    startActivity(new Intent(MainActivity.this,Loginguse.class));
                }else {
                    startActivity(new Intent(MainActivity.this,ChoosePlay.class));
                }

                finish();
            }
        },3000);

    }

    @Override
    public void onBackPressed() {

    }
}