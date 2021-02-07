package com.example.tambola;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class DatabaseHandler extends SQLiteOpenHelper {
    Context context;
    private static String DATABASE_NAME="mysql";
    private static int DATABASE_VERSION=1;
    private ByteArrayOutputStream objectbyteArrayOutputStream;
    private byte[] imagebyte;
    private static String crateTableQury="create table imageInfo(imageName TEXT" + ",image BLOB)";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(crateTableQury);
            Toast.makeText(context, "Table createed successful in database", Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void storeimage(Modelclass obgectmodelclass){
        try {
            SQLiteDatabase obgectsqLiteDatabase=this.getWritableDatabase();
            Bitmap imagetostorebitmap=obgectmodelclass.getBitmap();
            objectbyteArrayOutputStream=new ByteArrayOutputStream();
            imagetostorebitmap.compress(Bitmap.CompressFormat.JPEG,100,objectbyteArrayOutputStream);
            imagebyte=objectbyteArrayOutputStream.toByteArray();

            ContentValues objectcontentvalu=new ContentValues();
            objectcontentvalu.put("imageName",obgectmodelclass.getImagename());
            objectcontentvalu.put("image",imagebyte);

           Long checkdata= obgectsqLiteDatabase.insert("imageInfo",null,objectcontentvalu);
           if (checkdata!=-1){
               Toast.makeText(context, "Data aded into our table", Toast.LENGTH_SHORT).show();
               obgectsqLiteDatabase.close();
           }else {
               Toast.makeText(context, "Faild into our table", Toast.LENGTH_SHORT).show();
           }
        } catch (Exception ex){
        Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
    }
    }
}
