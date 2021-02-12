package com.example.tambola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Category_belit extends AppCompatActivity {

    ImageView table1,table2,table3,table4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_belit);

        table1=(ImageView)findViewById(R.id.imgtable1);
        table2=(ImageView)findViewById(R.id.imgtable2);
        table3=(ImageView)findViewById(R.id.imgtable3);
        table4=(ImageView)findViewById(R.id.imgtable4);

        table1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        table2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        table3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        table4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}