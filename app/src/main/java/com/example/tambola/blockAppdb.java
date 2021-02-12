package com.example.tambola;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class blockAppdb extends SQLiteOpenHelper {
    private static final String DBName="myfoblockapp";
    private static final int DBVersion=1;
    private  final String ID="id";
    private  final String js="js";
    private  final String TABLENAME="tablebl";


    public blockAppdb(@Nullable Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase mydb) {
        String cQuery="CREATE TABLE "+TABLENAME+"("+ID+" INTEGER PRIMARY KEY,"+js+" TEXT);";
        mydb.execSQL(cQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void Insertjs(String obj){
        SQLiteDatabase idb = null;
        ContentValues icv = null;
        try {
            idb=this.getWritableDatabase();
            icv=new ContentValues();
            icv.put(js,obj);
            idb.insert(TABLENAME,null,icv);
        }catch (Exception e){}finally {
            if (idb!=null){
                idb.close();
            }if (icv!=null){
                icv.clear();
            }

        }

    }
    public ArrayList<String> getjs(){
        ArrayList<String> conta = null;
        SQLiteDatabase gdb = null;
        String gQuery=null;
        Cursor gCur = null;
        try {
            conta=new ArrayList<String>();
            gdb=this.getReadableDatabase();
            gQuery="SELECT * FROM tablebl";
            gCur=gdb.rawQuery(gQuery,null);

            while (gCur.moveToNext()){
                conta.add(gCur.getString(1));

            }
        }catch (Exception e){

        }finally {
            if (gdb!=null){
                gdb.close();
            }if (gCur!=null){
                gCur.close();
            }

        }


        return conta;
    }

    public void delall(){
        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();
            db.execSQL("DELETE FROM tablebl"); //delete all rows in a table

        }catch (Exception e){

        }finally {
            if (db!=null){
                db.close();
            }
        }

    }

}
