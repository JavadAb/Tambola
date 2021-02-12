package com.example.tambola;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlitechild extends SQLiteOpenHelper {

    static final String Db_name = "TOKENNN";
    static final int Db_version = 1;
    static final String Table_name = "Tokenloc";
    static final String Table_name1 = "location";

    static final String List_block = "block";


    Context context;


    public Sqlitechild(Context context) {
        super(context, Db_name, null, Db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



        db.execSQL("CREATE TABLE " + Table_name1 + " ("
                + "ID" + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "locationchild" + " TEXT);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertdata(String tokenchild) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("locationchild", tokenchild);
        Long result = db.insert("location", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}