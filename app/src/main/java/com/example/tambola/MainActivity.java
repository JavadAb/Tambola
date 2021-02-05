package com.example.tambola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();

        Toast.makeText(this, "salam jigaar", Toast.LENGTH_SHORT).show();
    }
}