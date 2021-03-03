package com.example.tambola;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Category_belit extends AppCompatActivity {
    String token,sec;
    Integer secnahaiee=0;
    ImageView table1,table2,table3,table4,table5,table6;
    ImageView imageView;
    TextView txtdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_belit);


        try {
            SQLiteOpenHelper sqLiteOpenHelper=new sqlite(getApplicationContext());
            SQLiteDatabase db=sqLiteOpenHelper.getReadableDatabase();

            Cursor cursor=db.query("Token",
                    new String[]{"Tok"},null,null,null,null,null);
            if (cursor.moveToFirst()){
                token = cursor.getString(0);

                Log.e("stuf", "token"+" "+token );

            }

        }catch (SQLiteException ex){
            Log.e("stuf", "Cancel" );
        }



        try {
            SQLiteOpenHelper sqLiteOpenHelper=new Sqlitechild(getApplicationContext());
            SQLiteDatabase db=sqLiteOpenHelper.getReadableDatabase();

            Cursor cursor=db.query("Curentsece",
                    new String[]{"location"},null,null,null,null,null);
            if (cursor.moveToFirst()){
                sec = cursor.getString(0);
                if (sec==null){
                    secnahaiee=0;
                }else {
                    secnahaiee= Integer.valueOf(sec);
                }
                Log.e("stuf", "secenahaiee"+" "+secnahaiee );
                Toast.makeText(this, "secenahaiee"+" "+secnahaiee, Toast.LENGTH_SHORT).show();

            }

        }catch (SQLiteException ex){
            Log.e("stuf", "Cancel" );
        }

        startActivitys startActivitys=new startActivitys();

        table1=(ImageView)findViewById(R.id.imgtable1);
        table2=(ImageView)findViewById(R.id.imgtable2);
        table3=(ImageView)findViewById(R.id.imgtable3);
        table4=(ImageView)findViewById(R.id.imgtable4);
        table5=(ImageView)findViewById(R.id.imgtable5);
        table6=(ImageView)findViewById(R.id.imgtable6);
        imageView=(ImageView)findViewById(R.id.imgnatnnnnnnnn);
        txtdown=(TextView)findViewById(R.id.txtblitdown);

        startActivitys.set(Category_belit.this,table1,R.anim.animzoomin);
        startActivitys.set(Category_belit.this,table2,R.anim.animzoomin);
        startActivitys.set(Category_belit.this,table3,R.anim.animzoomin);
        startActivitys.set(Category_belit.this,table4,R.anim.animzoomin);
        startActivitys.set(Category_belit.this,table5,R.anim.animzoomin);
        startActivitys.set(Category_belit.this,table6,R.anim.animzoomin);
        startActivitys.set(Category_belit.this,imageView,R.anim.animzoomin);
        startActivitys.set(Category_belit.this,txtdown,R.anim.animzoomin);

        table1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secnahaiee<10||secnahaiee==null){
                    startActivitys.set(Category_belit.this,table1,R.anim.shake);
                    Toast.makeText(Category_belit.this, "Cheeps low", Toast.LENGTH_SHORT).show();
                }else {

                    startActivity(new Intent(Category_belit.this,Play.class).putExtra("numberticket","1"));
                    startActivitys.set(Category_belit.this,table1,R.anim.animzoomin);
                }


            }
        });

        table2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secnahaiee<20||secnahaiee==null){
                    startActivitys.set(Category_belit.this,table2,R.anim.shake);
                    Toast.makeText(Category_belit.this, "Cheeps low", Toast.LENGTH_SHORT).show();
                }else {

                                    startActivity(new Intent(Category_belit.this,Play2.class).putExtra("numberticket","2"));
                    startActivitys.set(Category_belit.this,table2,R.anim.animzoomin);
                }

            }
        });

        table3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secnahaiee<30||secnahaiee==null){
                    startActivitys.set(Category_belit.this,table3,R.anim.shake);
                    Toast.makeText(Category_belit.this, "Cheeps low", Toast.LENGTH_SHORT).show();
                }else {
                                    startActivity(new Intent(Category_belit.this,play3.class).putExtra("numberticket","3"));
                    startActivitys.set(Category_belit.this,table3,R.anim.animzoomin);
                }

            }
        });

        table4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secnahaiee<40||secnahaiee==null){
                    startActivitys.set(Category_belit.this,table4,R.anim.shake);
                    Toast.makeText(Category_belit.this, "Cheeps low", Toast.LENGTH_SHORT).show();
                }else {

                                    startActivity(new Intent(Category_belit.this,play4.class).putExtra("numberticket","4"));
                    startActivitys.set(Category_belit.this,table4,R.anim.animzoomin);

                }
            }
        });

        table5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secnahaiee<50||secnahaiee==null){
                    startActivitys.set(Category_belit.this,table5,R.anim.shake);
                    Toast.makeText(Category_belit.this, "Cheeps low", Toast.LENGTH_SHORT).show();
                }else {

                                    startActivity(new Intent(Category_belit.this,play5.class).putExtra("numberticket","5"));
                    startActivitys.set(Category_belit.this,table5,R.anim.animzoomin);
                }
            }
        });

        table6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secnahaiee<60||secnahaiee==null){
                    startActivitys.set(Category_belit.this,table6,R.anim.shake);
                    Toast.makeText(Category_belit.this, "Cheeps low", Toast.LENGTH_SHORT).show();
                }else {

                                    startActivity(new Intent(Category_belit.this,play6.class).putExtra("numberticket","6"));
                    startActivitys.set(Category_belit.this,table6,R.anim.animzoomin);
                }
            }
        });
    }

}