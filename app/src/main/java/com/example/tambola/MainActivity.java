package com.example.tambola;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    SharedPreferences setting;
    String pach;
    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Log.e("stuf",  getpath(R.drawable.a2));

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                try {
                    SQLiteOpenHelper sqLiteOpenHelper=new Sqlitechild(getApplicationContext());
                    SQLiteDatabase db=sqLiteOpenHelper.getReadableDatabase();

                    Cursor cursor=db.query("location",
                            new String[]{"locationchild","ID"},"ID = ?",new String[]{"1"},null,null,null);
                    if (cursor.moveToFirst()){
                        pach=cursor.getString(0);

                    }

                }catch (SQLiteException ex){
                    Log.e("stuf", "Cancel" );
                }



                if (pach==null){
                    startActivity(new Intent(MainActivity.this,ChoosePlay.class));
                }else if (pach.equals("gmail")){
                    startActivity(new Intent(MainActivity.this,Category_Main.class));
                }

                finish();
            }
        },3000);

    }

    @Override
    public void onBackPressed() {

    }
    @Override
    protected void onDestroy() {

        Log.e("stuf", "onDestroy");
        sqlite sqlite = new sqlite(getApplicationContext());
        sqlite.delall();

        super.onDestroy();
    }
    public Uri getURLForResource (int resourceId) {
        //use BuildConfig.APPLICATION_ID instead of R.class.getPackage().getName() if both are not same
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId);
    }
    public String getpath(int R){
        Bitmap bm = BitmapFactory.decodeResource( getResources(), R);
        File file = new File(Environment.getExternalStorageDirectory(), "ic_launcher.PNG");
        String path=file.getAbsolutePath();

        FileOutputStream outStream = null;
        try {
            outStream = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.PNG, 100, outStream);
            outStream.flush();
            outStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (file.exists()){
                Log.e("stuf", "onCreate: ");
            }
        }
        return path;
    }
}