package com.example.tambola;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlite extends SQLiteOpenHelper {

    static final String Db_name="TOKENParent";
    static final int Db_version=1;
    static final String name="Tableblock";


    Context context;


    public sqlite(Context context) {
        super(context, Db_name, null, Db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("CREATE TABLE " + "Tokenpar" + " ("
                + "Tokenparent" + " TEXT , "
                + "Tokenchild" +" TEXT);");

        db.execSQL("CREATE TABLE " + "Token" + " ("
                + "Tok" +" TEXT);");

        db.execSQL("CREATE TABLE " + "Tokenbb" + " ("
                + "Imagestring" + " TEXT , "
                + "Namestring" +" TEXT);");







    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertdata(String image, String name){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Tokenparent",image);
        contentValues.put("Tokenchild",name);

        Long result= db.insert("Tokenpar",null,contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }
    public boolean inserttoken(String token){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Tok",token);
        Long result= db.insert("Token",null,contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }

    public boolean insertimage_name(String image,String name){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Imagestring",image);
        contentValues.put("Namestring",name);
        Long result= db.insert("Tokenbb",null,contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }

    public void delall(){
        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();
            db.execSQL("DELETE FROM Tokenpar"); //delete all rows in a table

        }catch (Exception e){

        }finally {
            if (db!=null){
                db.close();
            }
        }

    }






}
