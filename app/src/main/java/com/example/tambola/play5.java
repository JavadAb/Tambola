package com.example.tambola;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
//
//import com.github.nkzawa.emitter.Emitter;
//import com.github.nkzawa.socketio.client.IO;
//import com.github.nkzawa.socketio.client.Socket;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import tech.gusavila92.websocketclient.WebSocketClient;

public class play5 extends AppCompatActivity {
    String am;
    boolean blite1=false;
    boolean blite2=false;
    boolean blite3=false;
    boolean blite4=false;
    boolean blite5=false;
    ImageView imgpush,imgpush2,imgpush3,imgpush4,imgpush5;
    TextView orang1_blite6,orang2_blite6,orang3_blite6,orang4_blite6,orang5_blite6;
    startActivitys startActivitys;
    ArrayList<String> ticketNumber;
    JSONArray jsonlist;
    TextView tik,tedadcheeps;
    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,txt12,txt13,txt14,txt15,txt16,txt17,txt18,txt19,txt20,txt21,txt22,txt23,txt24,txt25,txt26,txt27;
    TextView txt1b,txt2b,txt3b,txt4b,txt5b,txt6b,txt7b,txt8b,txt9b,txt10b,txt11b,txt12b,txt13b,txt14b,txt15b,txt16b,txt17b,txt18b,txt19b,txt20b,txt21b,txt22b,txt23b,txt24b,txt25b,txt26b,txt27b;
    TextView txt1c,txt2c,txt3c,txt4c,txt5c,txt6c,txt7c,txt8c,txt9c,txt10c,txt11c,txt12c,txt13c,txt14c,txt15c,txt16c,txt17c,txt18c,txt19c,txt20c,txt21c,txt22c,txt23c,txt24c,txt25c,txt26c,txt27c;
    TextView txt1d,txt2d,txt3d,txt4d,txt5d,txt6d,txt7d,txt8d,txt9d,txt10d,txt11d,txt12d,txt13d,txt14d,txt15d,txt16d,txt17d,txt18d,txt19d,txt20d,txt21d,txt22d,txt23d,txt24d,txt25d,txt26d,txt27d;
    TextView txt1e,txt2e,txt3e,txt4e,txt5e,txt6e,txt7e,txt8e,txt9e,txt10e,txt11e,txt12e,txt13e,txt14e,txt15e,txt16e,txt17e,txt18e,txt19e,txt20e,txt21e,txt22e,txt23e,txt24e,txt25e,txt26e,txt27e;
    private WebSocketClient webSocketClient=null;
//    Socket socket;
    Handler handler;

    TextView x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11,x12,x13,x14,x15,x16,x17,x18,x19,x20,x21,x22,x23,x24,x25,x26,x27,x28,x29,x30,x31,x32,x33,x34,x35,x36,x37,x38,x39,x40,x41,x42,x43,x44,x45,x46,x47,x48,x49,x50,x51,x52,x53,x54,x55,x56,x57,x58,x59,x60,x61,x62,x63,x64,x65,x66,x67,x68,x69,x70,x71,x72,x73,x74,x75,x76,x77,x78,x79,x80,x81,x82,x83,x84,x85,x86,x87,x88,x89,x90;


    ArrayList<Integer> arrayList;
    ArrayList<Integer> arrayList2;
    ArrayList<Integer> arrayList3;
    ArrayList<Integer> arrayList4;
    ArrayList<Integer> arrayList5;


    ImageView play1,play2,play3,play4,load;
    TextView adad;
    String corn1,corn2,corn3,corn4;
    String corn1b,corn2b,corn3b,corn4b;
    String corn1c,corn2c,corn3c,corn4c;
    String corn1d,corn2d,corn3d,corn4d;
    String corn1e,corn2e,corn3e,corn4e;

    String erly1,erly2,erly3,erly4,erly5;
    String erly1b,erly2b,erly3b,erly4b,erly5b;
    String erly1c,erly2c,erly3c,erly4c,erly5c;
    String erly1d,erly2d,erly3d,erly4d,erly5d;
    String erly1e,erly2e,erly3e,erly4e,erly5e;

    String a1,a2,a3,a4,a5,a6,a7,a8,a9;
    String a1b,a2b,a3b,a4b,a5b,a6b,a7b,a8b,a9b;
    String a1c,a2c,a3c,a4c,a5c,a6c,a7c,a8c,a9c;
    String a1d,a2d,a3d,a4d,a5d,a6d,a7d,a8d,a9d;
    String a1e,a2e,a3e,a4e,a5e,a6e,a7e,a8e,a9e;

    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    String b1b,b2b,b3b,b4b,b5b,b6b,b7b,b8b,b9b;
    String b1c,b2c,b3c,b4c,b5c,b6c,b7c,b8c,b9c;
    String b1d,b2d,b3d,b4d,b5d,b6d,b7d,b8d,b9d;
    String b1e,b2e,b3e,b4e,b5e,b6e,b7e,b8e,b9e;
    String token;

    String c1,c2,c3,c4,c5,c6,c7,c8,c9;
    String c1b,c2b,c3b,c4b,c5b,c6b,c7b,c8b,c9b;
    String c1c,c2c,c3c,c4c,c5c,c6c,c7c,c8c,c9c;
    String c1d,c2d,c3d,c4d,c5d,c6d,c7d,c8d,c9d;
    String c1e,c2e,c3e,c4e,c5e,c6e,c7e,c8e,c9e;

    String adadfinal;


    JSONArray jsonArray;
    JSONObject jsonwin;


    ArrayList<Object> arrayList_blit1;
    ArrayList<Object> firstline_a;
    ArrayList<Object> secendline_a;
    ArrayList<Object> threeline_a;
    ArrayList<Object> corner_a;

    ArrayList<Object> arrayList_blit2;
    ArrayList<Object> firstline_b;
    ArrayList<Object> secendlin_b;
    ArrayList<Object> threeline_b;
    ArrayList<Object> corner_b;

    ArrayList<Object> arrayList_blit3;
    ArrayList<Object> firstline_c;
    ArrayList<Object> secendlin_c;
    ArrayList<Object> threeline_c;
    ArrayList<Object> corner_c;

    ArrayList<Object> arrayList_blit4;
    ArrayList<Object> firstline_d;
    ArrayList<Object> secendlin_d;
    ArrayList<Object> threeline_d;
    ArrayList<Object> corner_d;

    ArrayList<Object> arrayList_blit5;
    ArrayList<Object> firstline_e;
    ArrayList<Object> secendlin_e;
    ArrayList<Object> threeline_e;
    ArrayList<Object> corner_e;

    ArrayList<Object> trfirst_a;
    ArrayList<Object> trfirst_b;
    ArrayList<Object> trfirst_c;
    ArrayList<Object> trfirst_d;
    ArrayList<Object> trfirst_e;

    ArrayList<Object> trsecend_a;
    ArrayList<Object> trsecend_b;
    ArrayList<Object> trsecend_c;
    ArrayList<Object> trsecend_d;
    ArrayList<Object> trsecend_e;


    ArrayList<Object> trthree_a;
    ArrayList<Object> trthree_b;
    ArrayList<Object> trthree_c;
    ArrayList<Object> trthree_d;
    ArrayList<Object> trthree_e;


    ArrayList<Object> tr_full_a;
    ArrayList<Object> tr_full_b;
    ArrayList<Object> tr_full_c;
    ArrayList<Object> tr_full_d;
    ArrayList<Object> tr_full_e;
    boolean isadmin=false;


    ArrayList<Object> tr_corner_a;
    ArrayList<Object> tr_corner_b;
    ArrayList<Object> tr_corner_c;
    ArrayList<Object> tr_corner_d;
    ArrayList<Object> tr_corner_e;


    boolean startgame=false;
    private int delay=7000;
    String image;
    private String ticket;
    TextView txtcorner,txterly,txtfierstline,txtsecendline,txtthreeline,txtfull;
    private ImageView play5,play6;
    private String name;
     ArrayList<Object> random;
     ArrayList<Object> arrayList_b;

//    {
//        try {
//            socket = IO.socket("http://192.168.56.1:8000/");
//        } catch (URISyntaxException e) {}
//    }

    int ggg=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play5);
        random=new ArrayList<>();

        tik=(TextView)findViewById(R.id.ttdddttdd5);
        tedadcheeps=(TextView)findViewById(R.id.tiketzarb5);

        ticketNumber=new ArrayList<String>();
        jsonlist=new JSONArray();

        startActivitys=new startActivitys();

        x1=(TextView)findViewById(R.id.x1);
        x2=(TextView)findViewById(R.id.x2);
        x3=(TextView)findViewById(R.id.x3);
        x4=(TextView)findViewById(R.id.x4);
        x5=(TextView)findViewById(R.id.x5);
        x6=(TextView)findViewById(R.id.x6);
        x7=(TextView)findViewById(R.id.x7);
        x8=(TextView)findViewById(R.id.x8);
        x9=(TextView)findViewById(R.id.x9);
        x10=(TextView)findViewById(R.id.x10);
        x11=(TextView)findViewById(R.id.x11);
        x12=(TextView)findViewById(R.id.x12);
        x13=(TextView)findViewById(R.id.x13);
        x14=(TextView)findViewById(R.id.x14);
        x15=(TextView)findViewById(R.id.x15);
        x16=(TextView)findViewById(R.id.x16);
        x17=(TextView)findViewById(R.id.x17);
        x18=(TextView)findViewById(R.id.x18);
        x19=(TextView)findViewById(R.id.x19);
        x20=(TextView)findViewById(R.id.x20);
        x21=(TextView)findViewById(R.id.x21);
        x22=(TextView)findViewById(R.id.x22);
        x23=(TextView)findViewById(R.id.x23);
        x24=(TextView)findViewById(R.id.x24);
        x25=(TextView)findViewById(R.id.x25);
        x26=(TextView)findViewById(R.id.x26);
        x27=(TextView)findViewById(R.id.x27);
        x28=(TextView)findViewById(R.id.x28);
        x29=(TextView)findViewById(R.id.x29);
        x30=(TextView)findViewById(R.id.x30);
        x31=(TextView)findViewById(R.id.x31);
        x32=(TextView)findViewById(R.id.x32);
        x33=(TextView)findViewById(R.id.x33);
        x34=(TextView)findViewById(R.id.x34);
        x35=(TextView)findViewById(R.id.x35);
        x36=(TextView)findViewById(R.id.x36);
        x37=(TextView)findViewById(R.id.x37);
        x38=(TextView)findViewById(R.id.x38);
        x39=(TextView)findViewById(R.id.x39);
        x40=(TextView)findViewById(R.id.x40);
        x41=(TextView)findViewById(R.id.x41);
        x42=(TextView)findViewById(R.id.x42);
        x43=(TextView)findViewById(R.id.x43);
        x44=(TextView)findViewById(R.id.x44);
        x45=(TextView)findViewById(R.id.x45);
        x46=(TextView)findViewById(R.id.x46);
        x47=(TextView)findViewById(R.id.x47);
        x48=(TextView)findViewById(R.id.x48);
        x49=(TextView)findViewById(R.id.x49);
        x50=(TextView)findViewById(R.id.x50);
        x51=(TextView)findViewById(R.id.x51);
        x52=(TextView)findViewById(R.id.x52);
        x53=(TextView)findViewById(R.id.x53);
        x54=(TextView)findViewById(R.id.x54);
        x55=(TextView)findViewById(R.id.x55);
        x56=(TextView)findViewById(R.id.x56);
        x57=(TextView)findViewById(R.id.x57);
        x58=(TextView)findViewById(R.id.x58);
        x59=(TextView)findViewById(R.id.x59);
        x60=(TextView)findViewById(R.id.x60);
        x61=(TextView)findViewById(R.id.x61);
        x62=(TextView)findViewById(R.id.x62);
        x63=(TextView)findViewById(R.id.x63);
        x64=(TextView)findViewById(R.id.x64);
        x65=(TextView)findViewById(R.id.x65);
        x66=(TextView)findViewById(R.id.x66);
        x67=(TextView)findViewById(R.id.x67);
        x68=(TextView)findViewById(R.id.x68);
        x69=(TextView)findViewById(R.id.x69);
        x70=(TextView)findViewById(R.id.x70);
        x71=(TextView)findViewById(R.id.x71);
        x72=(TextView)findViewById(R.id.x72);
        x73=(TextView)findViewById(R.id.x73);
        x74=(TextView)findViewById(R.id.x74);
        x75=(TextView)findViewById(R.id.x75);
        x76=(TextView)findViewById(R.id.x76);
        x77=(TextView)findViewById(R.id.x77);
        x78=(TextView)findViewById(R.id.x78);
        x79=(TextView)findViewById(R.id.x79);
        x80=(TextView)findViewById(R.id.x80);
        x81=(TextView)findViewById(R.id.x81);
        x82=(TextView)findViewById(R.id.x82);
        x83=(TextView)findViewById(R.id.x83);
        x84=(TextView)findViewById(R.id.x84);
        x85=(TextView)findViewById(R.id.x85);
        x86=(TextView)findViewById(R.id.x86);
        x87=(TextView)findViewById(R.id.x87);
        x88=(TextView)findViewById(R.id.x88);
        x89=(TextView)findViewById(R.id.x89);
        x90=(TextView)findViewById(R.id.x90);

        arrayList_b=new ArrayList<>();

        tr_full_a=new ArrayList<>();
        tr_full_b=new ArrayList<>();
        tr_full_c=new ArrayList<>();
        tr_full_d=new ArrayList<>();
        tr_full_e=new ArrayList<>();

        trfirst_a=new ArrayList<>();
        trfirst_b=new ArrayList<>();
        trfirst_c=new ArrayList<>();
        trfirst_d=new ArrayList<>();
        trfirst_e=new ArrayList<>();

        trsecend_a=new ArrayList<>();
        trsecend_b=new ArrayList<>();
        trsecend_c=new ArrayList<>();
        trsecend_d=new ArrayList<>();
        trsecend_e=new ArrayList<>();

        trthree_a=new ArrayList<>();
        trthree_b=new ArrayList<>();
        trthree_c=new ArrayList<>();
        trthree_d=new ArrayList<>();
        trthree_e=new ArrayList<>();

        tr_corner_a=new ArrayList<>();
        tr_corner_b=new ArrayList<>();
        tr_corner_c=new ArrayList<>();
        tr_corner_d=new ArrayList<>();
        tr_corner_e=new ArrayList<>();

        corner_a=new ArrayList<>();
        corner_b=new ArrayList<>();
        corner_c=new ArrayList<>();
        corner_d=new ArrayList<>();
        corner_e=new ArrayList<>();


        firstline_a=new ArrayList<>();
        firstline_b=new ArrayList<>();
        firstline_c=new ArrayList<>();
        firstline_d=new ArrayList<>();
        firstline_e=new ArrayList<>();


        secendline_a=new ArrayList<>();
        secendlin_b=new ArrayList<>();
        secendlin_c=new ArrayList<>();
        secendlin_d=new ArrayList<>();
        secendlin_e=new ArrayList<>();


        threeline_a=new ArrayList<>();
        threeline_b=new ArrayList<>();
        threeline_c=new ArrayList<>();
        threeline_d=new ArrayList<>();
        threeline_e=new ArrayList<>();


        ProgressDialog dialogpross = new ProgressDialog(play5.this);
        dialogpross.setMessage("Please wait..");
        dialogpross.show();
        dialogpross.setCancelable(false);
        dialogpross.setCanceledOnTouchOutside(false);

        jsonArray=new JSONArray();

        Intent intent=getIntent();
        ticket=intent.getStringExtra("numberticket");

        jsonwin=new JSONObject();
        try {
            jsonwin.put("winearlyfive","");
            jsonwin.put("winfirstline","");
            jsonwin.put("winsecondline","");
            jsonwin.put("winthirdline","");
            jsonwin.put("wincorners","");
            jsonwin.put("winfull","");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        txtcorner=(TextView)findViewById(R.id.txtwincorner5);
        txterly=(TextView)findViewById(R.id.txtwinerlyfive5);
        txtfierstline=(TextView)findViewById(R.id.txtwinfirstline5);
        txtsecendline=(TextView)findViewById(R.id.txtwinsecendline5);
        txtthreeline=(TextView)findViewById(R.id.txtwinthreline5);
        txtfull=(TextView)findViewById(R.id.txtwinful5);

        adad=(TextView)findViewById(R.id.numbersite5);

        play1=(ImageView)findViewById(R.id.player15);
        play2=(ImageView)findViewById(R.id.player25);
        play3=(ImageView)findViewById(R.id.player35);
        play4=(ImageView)findViewById(R.id.player45);
        play5=(ImageView)findViewById(R.id.player55);
        play6=(ImageView)findViewById(R.id.player65);

        arrayList_blit1=new ArrayList<>();
        arrayList_blit2=new ArrayList<>();
        arrayList_blit3=new ArrayList<>();
        arrayList_blit4=new ArrayList<>();
        arrayList_blit5=new ArrayList<>();
        try {
            SQLiteOpenHelper sqLiteOpenHelper=new sqlite(getApplicationContext());
            SQLiteDatabase db=sqLiteOpenHelper.getReadableDatabase();

            Cursor cursor=db.query("Token",
                    new String[]{"Tok"},null,null,null,null,null);
            if (cursor.moveToFirst()){
                token = cursor.getString(0);

            }

        }catch (SQLiteException ex){
            Log.e("stuf", "Cancel" );
        }
        try {
            SQLiteOpenHelper sqLiteOpenHelper=new sqlite(getApplicationContext());
            SQLiteDatabase db=sqLiteOpenHelper.getReadableDatabase();

            Cursor cursor=db.query("Tokenbb",
                    new String[]{"Namestring","Imagestring"},null,null,null,null,null);
            if (cursor.moveToFirst()){
                name = cursor.getString(0);
                image = cursor.getString(1);

            }

        }catch (SQLiteException ex){
            Log.e("stuf", "Cancel" );
        }

        URI uri = null;

        try {
            uri=new URI("ws://185.255.89.127:8081/ws/chat/"+token+"/"+ticket+"/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        webSocketClient=new WebSocketClient(uri) {
            @Override
            public void onOpen() {
                Log.e("kos", "onOpen: " );

            }

            @Override
            public void onTextReceived(String message) {
                Log.e("kos", message );
                Handler handlertos=new Handler(Looper.getMainLooper());



                JSONObject jsonObject= null;
                JSONObject jso=null;
                JSONObject jsonObject10=null;

                // JSONArray jsonArray = new JSONArray();
                String strng=null;
                try {

                    jso = new JSONObject(message);
                    jsonObject=jso.getJSONObject("message");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    if (startgame) {
                        if (jsonObject.has("users")){
                            jsonArray.put(jsonObject.getString("users"));
                            Log.e("kos42", jsonArray.toString());}
                    }

                    try {
                        JSONObject js=jsonObject.getJSONObject("winearlyfive");
                        jsonwin=  updatejson(jsonwin,"winearlyfive","",js);
                        Log.e("kos251", jsonwin.toString());
                        play1.setImageBitmap(getBitmap(js.getString("image")));
                        String nm=js.getString("name");
                        handlertos.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(play5.this, nm+" "+"Win erly five", Toast.LENGTH_SHORT).show();
                            }
                        });
                        checkwin();
                    } catch (Exception exception) {
                        //  Log.e("kos", exception.toString() );
                        exception.printStackTrace();
                    }
                    try {
                        //   Log.e("kos251", "wiiiiiiiiiin");
                        JSONObject js=jsonObject.getJSONObject("winfirstline");
                        jsonwin=  updatejson(jsonwin,"winfirstline","",js);
                        Log.e("kos251", jsonwin.toString());
                        play2.setImageBitmap(getBitmap(js.getString("image")));
                        String nm=js.getString("name");
                        handlertos.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(play5.this, nm+" "+"Win top line", Toast.LENGTH_SHORT).show();
                            }
                        });
                        checkwin();
                    } catch (Exception exception) {
                        // Log.e("kos", exception.toString() );
                        exception.printStackTrace();
                    }
                    try {
                        //    Log.e("kos251", "wiiiiiiiiiin");
                        JSONObject js=jsonObject.getJSONObject("winsecondline");
                        jsonwin=  updatejson(jsonwin,"winsecondline","",js);
                        Log.e("kos251", jsonwin.toString());
                        play3.setImageBitmap(getBitmap(js.getString("image")));
                        String nm=js.getString("name");
                        handlertos.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(play5.this, nm+" "+"Win midle line", Toast.LENGTH_SHORT).show();
                            }
                        });
                        checkwin();
                    } catch (Exception exception) {
                        //    Log.e("kos", exception.toString() );
                        exception.printStackTrace();
                    }
                    try {
                        //    Log.e("kos251", "wiiiiiiiiiin");
                        JSONObject js=jsonObject.getJSONObject("winthirdline");
                        jsonwin=  updatejson(jsonwin,"winthirdline","",js);
                        Log.e("kos251", jsonwin.toString());
                        play4.setImageBitmap(getBitmap(js.getString("image")));
                        String nm=js.getString("name");
                        handlertos.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(play5.this, nm+" "+"Win botom line", Toast.LENGTH_SHORT).show();
                            }
                        });
                        checkwin();
                    } catch (Exception exception) {
                        //   Log.e("kos", exception.toString() );
                        exception.printStackTrace();
                    }
                    try {
                        //   Log.e("kos251", "wiiiiiiiiiin");
                        JSONObject js=jsonObject.getJSONObject("wincorners");
                        jsonwin=  updatejson(jsonwin,"wincorners","",js);
                        Log.e("kos251", jsonwin.toString());
                        play5.setImageBitmap(getBitmap(js.getString("image")));

                        String nm=js.getString("name");
                        handlertos.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(play5.this, nm+" "+"Win corners", Toast.LENGTH_SHORT).show();
                            }
                        });

                        checkwin();
                    } catch (Exception exception) {
                        //  Log.e("kos", exception.toString() );
                        exception.printStackTrace();
                    }
                    try {
                        //    Log.e("kos251", "wiiiiiiiiiin");
                        JSONObject js=jsonObject.getJSONObject("winfull");
                        jsonwin=  updatejson(jsonwin,"winfull","",js);
                        Log.e("kos251", jsonwin.toString());
                        play6.setImageBitmap(getBitmap(js.getString("image")));
                        String nm=js.getString("name");
                        handlertos.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(play5.this, nm+" "+"Win full home", Toast.LENGTH_SHORT).show();
                            }
                        });
                        checkwin();
                    } catch (Exception exception) {
                        //  Log.e("kos", exception.toString() );
                        exception.printStackTrace();
                    }
                }catch (JSONException e){
                    Log.e("kos22", e.toString() );
                }


                try {
                    if (startgame){
                        adadfinal= jsonObject.getString("number");
                        Log.e("kos31", jsonObject.getString("number") );
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adad.setText(adadfinal);
                                startActivitys.set(com.example.tambola.play5.this,adad,R.anim.animzoomin);
                                // Stuff that updates the UI




                                switch (adadfinal) {
                                    case "1":
                                        x1.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "2":
                                        x2.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "3":
                                        x3.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "4":
                                        x4.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "5":
                                        x5.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "6":
                                        x6.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "7":
                                        x7.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "8":
                                        x8.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "9":
                                        x9.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "10":
                                        x10.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "11":
                                        x11.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "12":
                                        x12.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "13":
                                        x13.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "14":
                                        x14.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "15":
                                        x15.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "16":
                                        x16.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "17":
                                        x17.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "18":
                                        x18.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "19":
                                        x19.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "20":
                                        x20.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "21":
                                        x21.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "22":
                                        x22.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "23":
                                        x23.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "24":
                                        x24.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "25":
                                        x25.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "26":
                                        x26.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "27":
                                        x27.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "28":
                                        x28.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "29":
                                        x29.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "30":
                                        x30.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "31":
                                        x31.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "32":
                                        x32.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "33":
                                        x33.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "34":
                                        x34.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "35":
                                        x35.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "36":
                                        x36.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "37":
                                        x37.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "38":
                                        x38.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "39":
                                        x39.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "40":
                                        x40.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "41":
                                        x41.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "42":
                                        x42.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "43":
                                        x43.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "44":
                                        x44.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "45":
                                        x45.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "46":
                                        x46.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "47":
                                        x47.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "48":
                                        x48.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "49":
                                        x49.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "50":
                                        x50.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "51":
                                        x51.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "52":
                                        x52.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "53":
                                        x53.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "54":
                                        x54.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "55":
                                        x55.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "56":
                                        x56.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "57":
                                        x57.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "58":
                                        x58.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "59":
                                        x59.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "60":
                                        x60.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "61":
                                        x61.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "62":
                                        x62.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "63":
                                        x63.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "64":
                                        x64.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "65":
                                        x65.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "66":
                                        x66.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "67":
                                        x67.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "68":
                                        x68.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "69":
                                        x69.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "70":
                                        x70.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "71":
                                        x71.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "72":
                                        x72.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "73":
                                        x73.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "74":
                                        x74.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "75":
                                        x75.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "76":
                                        x76.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "77":
                                        x77.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "78":
                                        x78.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "79":
                                        x79.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "80":
                                        x80.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "81":
                                        x81.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "82":
                                        x82.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "83":
                                        x83.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "84":
                                        x84.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "85":
                                        x85.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "86":
                                        x86.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "87":
                                        x87.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "88":
                                        x80.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "89":
                                        x89.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                    case "90":
                                        x90.setTextColor(getResources().getColor(R.color.white));
                                        break;
                                }

                            }
                        });

                    }
                } catch (JSONException e) {
                    Log.e("kos34", e.toString() );
                    e.printStackTrace();
                }


                try {

                    if (jso.getString("message").equals(token+"  is admin")){
                     isadmin=true;
                    }

                    else if (jso.getString("message").equals("start")){
                        Log.e("kos", "ok" );
                        startgame=true;
                        JSONObject jsonmessage=new JSONObject();
                        JSONObject jsonmsg=new JSONObject();
                        JSONObject jsonuser=new JSONObject();
                        jsonuser.put("token",token);
                        jsonuser.put("name",name);
                        jsonuser.put("tc",ticket);
                        jsonuser.put("image",image);
                        jsonmsg.put("users",jsonuser);
                        jsonmessage.put("message",jsonmsg);
                        webSocketClient.send(jsonmessage.toString());
                        //send sale
                        sale(String.valueOf(Integer.parseInt(ticket)*10),true);
                        dialogpross.dismiss();
                        if (isadmin){
                            Handler handlercoleer=new Handler(Looper.getMainLooper());
                            handlercoleer.post(new Runnable() {
                                @Override
                                public void run() {
                                    Log.e("kos", "handler" );
                                    getrandomnumber();
                                    handlercoleer.postDelayed(this,delay);
                                }
                            });}
                    }


                    else if (jso.get("message").equals("Left Chat")){
                        play5.this.finish();
                    }


                    if (startgame&&ggg==0){

                        Handler handler=new Handler(Looper.getMainLooper());
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    int wholechips = 0;
                                    int i=0;

                                    Log.e("kosr", jsonArray.toString() );

                                    while (i<jsonArray.length()){

                                        int    tickt = Integer.parseInt(new JSONObject(jsonArray.getString(i)).getString("tc"));
                                        Log.e("kospar", String.valueOf(tickt));

                                        wholechips+=tickt;
                                        Log.e("kosparwhole", String.valueOf(wholechips));
                                        i++;
                                    }


                                    tik.setText(String.valueOf(wholechips));
                                    int ss=wholechips*10;
                                    tedadcheeps.setText(String.valueOf(ss));
                                    ggg=1;

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },25000);


                    }

                } catch (JSONException e) {
                    Log.e("kos545", e.toString() );
                    e.printStackTrace();
                }
            }
            @Override
            public void onBinaryReceived(byte[] data) {

            }

            @Override
            public void onPingReceived(byte[] data) {

            }

            @Override
            public void onPongReceived(byte[] data) {

            }

            @Override
            public void onException(Exception e) {
                Log.e("kos1000", e.toString() );

            }

            @Override
            public void onCloseReceived() {

            }
        };
        webSocketClient.setConnectTimeout(10000);
        webSocketClient.setReadTimeout(20000);
//        webSocketClient.enableAutomaticReconnection(5000);
        webSocketClient.connect();

        arrayList=new ArrayList<>();
        arrayList2=new ArrayList<>();
        arrayList3=new ArrayList<>();
        arrayList4=new ArrayList<>();
        arrayList5=new ArrayList<>();



        txt1=(TextView)findViewById(R.id.txt1_blit5);
        txt2=(TextView)findViewById(R.id.txt2_blit5);
        txt3=(TextView)findViewById(R.id.txt3_blit5);
        txt4=(TextView)findViewById(R.id.txt4_blit5);
        txt5=(TextView)findViewById(R.id.txt5_blit5);
        txt6=(TextView)findViewById(R.id.txt6_blit5);
        txt7=(TextView)findViewById(R.id.txt7_blit5);
        txt8=(TextView)findViewById(R.id.txt8_blit5);
        txt9=(TextView)findViewById(R.id.txt9_blit5);
        txt10=(TextView)findViewById(R.id.txt10_blit5);
        txt11=(TextView)findViewById(R.id.txt11_blit5);
        txt12=(TextView)findViewById(R.id.txt12_blit5);
        txt13=(TextView)findViewById(R.id.txt13_blit5);
        txt14=(TextView)findViewById(R.id.txt14_blit5);
        txt15=(TextView)findViewById(R.id.txt15_blit5);
        txt16=(TextView)findViewById(R.id.txt16_blit5);
        txt17=(TextView)findViewById(R.id.txt17_blit5);
        txt18=(TextView)findViewById(R.id.txt18_blit5);
        txt19=(TextView)findViewById(R.id.txt19_blit5);
        txt20=(TextView)findViewById(R.id.txt20_blit5);
        txt21=(TextView)findViewById(R.id.txt21_blit5);
        txt22=(TextView)findViewById(R.id.txt22_blit5);
        txt23=(TextView)findViewById(R.id.txt23_blit5);
        txt24=(TextView)findViewById(R.id.txt24_blit5);
        txt25=(TextView)findViewById(R.id.txt25_blit5);
        txt26=(TextView)findViewById(R.id.txt26_blit5);
        txt27=(TextView)findViewById(R.id.txt27_blit5);


        txt1b=(TextView)findViewById(R.id.txt1_blit5b);
        txt2b=(TextView)findViewById(R.id.txt2_blit5b);
        txt3b=(TextView)findViewById(R.id.txt3_blit5b);
        txt4b=(TextView)findViewById(R.id.txt4_blit5b);
        txt5b=(TextView)findViewById(R.id.txt5_blit5b);
        txt6b=(TextView)findViewById(R.id.txt6_blit5b);
        txt7b=(TextView)findViewById(R.id.txt7_blit5b);
        txt8b=(TextView)findViewById(R.id.txt8_blit5b);
        txt9b=(TextView)findViewById(R.id.txt9_blit5b);
        txt10b=(TextView)findViewById(R.id.txt10_blit5b);
        txt11b=(TextView)findViewById(R.id.txt11_blit5b);
        txt12b=(TextView)findViewById(R.id.txt12_blit5b);
        txt13b=(TextView)findViewById(R.id.txt13_blit5b);
        txt14b=(TextView)findViewById(R.id.txt14_blit5b);
        txt15b=(TextView)findViewById(R.id.txt15_blit5b);
        txt16b=(TextView)findViewById(R.id.txt16_blit5b);
        txt17b=(TextView)findViewById(R.id.txt17_blit5b);
        txt18b=(TextView)findViewById(R.id.txt18_blit5b);
        txt19b=(TextView)findViewById(R.id.txt19_blit5b);
        txt20b=(TextView)findViewById(R.id.txt20_blit5b);
        txt21b=(TextView)findViewById(R.id.txt21_blit5b);
        txt22b=(TextView)findViewById(R.id.txt22_blit5b);
        txt23b=(TextView)findViewById(R.id.txt23_blit5b);
        txt24b=(TextView)findViewById(R.id.txt24_blit5b);
        txt25b=(TextView)findViewById(R.id.txt25_blit5b);
        txt26b=(TextView)findViewById(R.id.txt26_blit5b);
        txt27b=(TextView)findViewById(R.id.txt27_blit5b);

        txt1c=(TextView)findViewById(R.id.txt1_blit5c);
        txt2c=(TextView)findViewById(R.id.txt2_blit5c);
        txt3c=(TextView)findViewById(R.id.txt3_blit5c);
        txt4c=(TextView)findViewById(R.id.txt4_blit5c);
        txt5c=(TextView)findViewById(R.id.txt5_blit5c);
        txt6c=(TextView)findViewById(R.id.txt6_blit5c);
        txt7c=(TextView)findViewById(R.id.txt7_blit5c);
        txt8c=(TextView)findViewById(R.id.txt8_blit5c);
        txt9c=(TextView)findViewById(R.id.txt9_blit5c);
        txt10c=(TextView)findViewById(R.id.txt10_blit5c);
        txt11c=(TextView)findViewById(R.id.txt11_blit5c);
        txt12c=(TextView)findViewById(R.id.txt12_blit5c);
        txt13c=(TextView)findViewById(R.id.txt13_blit5c);
        txt14c=(TextView)findViewById(R.id.txt14_blit5c);
        txt15c=(TextView)findViewById(R.id.txt15_blit5c);
        txt16c=(TextView)findViewById(R.id.txt16_blit5c);
        txt17c=(TextView)findViewById(R.id.txt17_blit5c);
        txt18c=(TextView)findViewById(R.id.txt18_blit5c);
        txt19c=(TextView)findViewById(R.id.txt19_blit5c);
        txt20c=(TextView)findViewById(R.id.txt20_blit5c);
        txt21c=(TextView)findViewById(R.id.txt21_blit5c);
        txt22c=(TextView)findViewById(R.id.txt22_blit5c);
        txt23c=(TextView)findViewById(R.id.txt23_blit5c);
        txt24c=(TextView)findViewById(R.id.txt24_blit5c);
        txt25c=(TextView)findViewById(R.id.txt25_blit5c);
        txt26c=(TextView)findViewById(R.id.txt26_blit5c);
        txt27c=(TextView)findViewById(R.id.txt27_blit5c);




        txt1d=(TextView)findViewById(R.id.txt1_blit5d);
        txt2d=(TextView)findViewById(R.id.txt2_blit5d);
        txt3d=(TextView)findViewById(R.id.txt3_blit5d);
        txt4d=(TextView)findViewById(R.id.txt4_blit5d);
        txt5d=(TextView)findViewById(R.id.txt5_blit5d);
        txt6d=(TextView)findViewById(R.id.txt6_blit5d);
        txt7d=(TextView)findViewById(R.id.txt7_blit5d);
        txt8d=(TextView)findViewById(R.id.txt8_blit5d);
        txt9d=(TextView)findViewById(R.id.txt9_blit5d);
        txt10d=(TextView)findViewById(R.id.txt10_blit5d);
        txt11d=(TextView)findViewById(R.id.txt11_blit5d);
        txt12d=(TextView)findViewById(R.id.txt12_blit5d);
        txt13d=(TextView)findViewById(R.id.txt13_blit5d);
        txt14d=(TextView)findViewById(R.id.txt14_blit5d);
        txt15d=(TextView)findViewById(R.id.txt15_blit5d);
        txt16d=(TextView)findViewById(R.id.txt16_blit5d);
        txt17d=(TextView)findViewById(R.id.txt17_blit5d);
        txt18d=(TextView)findViewById(R.id.txt18_blit5d);
        txt19d=(TextView)findViewById(R.id.txt19_blit5d);
        txt20d=(TextView)findViewById(R.id.txt20_blit5d);
        txt21d=(TextView)findViewById(R.id.txt21_blit5d);
        txt22d=(TextView)findViewById(R.id.txt22_blit5d);
        txt23d=(TextView)findViewById(R.id.txt23_blit5d);
        txt24d=(TextView)findViewById(R.id.txt24_blit5d);
        txt25d=(TextView)findViewById(R.id.txt25_blit5d);
        txt26d=(TextView)findViewById(R.id.txt26_blit5d);
        txt27d=(TextView)findViewById(R.id.txt27_blit5d);



        txt1e=(TextView)findViewById(R.id.txt1_blit5e);
        txt2e=(TextView)findViewById(R.id.txt2_blit5e);
        txt3e=(TextView)findViewById(R.id.txt3_blit5e);
        txt4e=(TextView)findViewById(R.id.txt4_blit5e);
        txt5e=(TextView)findViewById(R.id.txt5_blit5e);
        txt6e=(TextView)findViewById(R.id.txt6_blit5e);
        txt7e=(TextView)findViewById(R.id.txt7_blit5e);
        txt8e=(TextView)findViewById(R.id.txt8_blit5e);
        txt9e=(TextView)findViewById(R.id.txt9_blit5e);
        txt10e=(TextView)findViewById(R.id.txt10_blit5e);
        txt11e=(TextView)findViewById(R.id.txt11_blit5e);
        txt12e=(TextView)findViewById(R.id.txt12_blit5e);
        txt13e=(TextView)findViewById(R.id.txt13_blit5e);
        txt14e=(TextView)findViewById(R.id.txt14_blit5e);
        txt15e=(TextView)findViewById(R.id.txt15_blit5e);
        txt16e=(TextView)findViewById(R.id.txt16_blit5e);
        txt17e=(TextView)findViewById(R.id.txt17_blit5e);
        txt18e=(TextView)findViewById(R.id.txt18_blit5e);
        txt19e=(TextView)findViewById(R.id.txt19_blit5e);
        txt20e=(TextView)findViewById(R.id.txt20_blit5e);
        txt21e=(TextView)findViewById(R.id.txt21_blit5e);
        txt22e=(TextView)findViewById(R.id.txt22_blit5e);
        txt23e=(TextView)findViewById(R.id.txt23_blit5e);
        txt24e=(TextView)findViewById(R.id.txt24_blit5e);
        txt25e=(TextView)findViewById(R.id.txt25_blit5e);
        txt26e=(TextView)findViewById(R.id.txt26_blit5e);
        txt27e=(TextView)findViewById(R.id.txt27_blit5e);






        int ticketNo=5;
        int i=0;
        while (i<3*ticketNo){
            ArrayList<String> adad=new ArrayList<String>();
            while (adad.size()<5){
                generaterandom(i,adad);
            }
            i++;
        }



        corn1=txt1.getText().toString();
        corn2=txt9.getText().toString();
        corn3=txt19.getText().toString();
        corn4=txt27.getText().toString();

        erly1=txt1.getText().toString();
        erly2=txt2.getText().toString();
        erly3=txt3.getText().toString();
        erly4=txt4.getText().toString();
        erly5=txt5.getText().toString();

        a1=txt1.getText().toString();
        a2=txt2.getText().toString();
        a3=txt3.getText().toString();
        a4=txt4.getText().toString();
        a5=txt5.getText().toString();
        a6=txt6.getText().toString();
        a7=txt7.getText().toString();
        a8=txt8.getText().toString();
        a9=txt9.getText().toString();

        b1=txt10.getText().toString();
        b2=txt11.getText().toString();
        b3=txt12.getText().toString();
        b4=txt13.getText().toString();
        b5=txt14.getText().toString();
        b6=txt15.getText().toString();
        b7=txt16.getText().toString();
        b8=txt17.getText().toString();
        b9=txt18.getText().toString();

        c1=txt19.getText().toString();
        c2=txt20.getText().toString();
        c3=txt21.getText().toString();
        c4=txt22.getText().toString();
        c5=txt23.getText().toString();
        c6=txt24.getText().toString();
        c7=txt25.getText().toString();
        c8=txt26.getText().toString();
        c9=txt27.getText().toString();



        corn1b=txt1b.getText().toString();
        corn2b=txt9b.getText().toString();
        corn3b=txt19b.getText().toString();
        corn4b=txt27b.getText().toString();

        erly1b=txt1b.getText().toString();
        erly2b=txt2b.getText().toString();
        erly3b=txt3b.getText().toString();
        erly4b=txt4b.getText().toString();
        erly5b=txt5b.getText().toString();

        a1b=txt1b.getText().toString();
        a2b=txt2b.getText().toString();
        a3b=txt3b.getText().toString();
        a4b=txt4b.getText().toString();
        a5b=txt5b.getText().toString();
        a6b=txt6b.getText().toString();
        a7b=txt7b.getText().toString();
        a8b=txt8b.getText().toString();
        a9b=txt9b.getText().toString();

        b1b=txt10b.getText().toString();
        b2b=txt11b.getText().toString();
        b3b=txt12b.getText().toString();
        b4b=txt13b.getText().toString();
        b5b=txt14b.getText().toString();
        b6b=txt15b.getText().toString();
        b7b=txt16b.getText().toString();
        b8b=txt17b.getText().toString();
        b9b=txt18b.getText().toString();

        c1b=txt19b.getText().toString();
        c2b=txt20b.getText().toString();
        c3b=txt21b.getText().toString();
        c4b=txt22b.getText().toString();
        c5b=txt23b.getText().toString();
        c6b=txt24b.getText().toString();
        c7b=txt25b.getText().toString();
        c8b=txt26b.getText().toString();
        c9b=txt27b.getText().toString();





        corn1c=txt1c.getText().toString();
        corn2c=txt9c.getText().toString();
        corn3c=txt19c.getText().toString();
        corn4c=txt27c.getText().toString();

        erly1c=txt1c.getText().toString();
        erly2c=txt2c.getText().toString();
        erly3c=txt3c.getText().toString();
        erly4c=txt4c.getText().toString();
        erly5c=txt5c.getText().toString();

        a1c=txt1c.getText().toString();
        a2c=txt2c.getText().toString();
        a3c=txt3c.getText().toString();
        a4c=txt4c.getText().toString();
        a5c=txt5c.getText().toString();
        a6c=txt6c.getText().toString();
        a7c=txt7c.getText().toString();
        a8c=txt8c.getText().toString();
        a9c=txt9c.getText().toString();

        b1c=txt10c.getText().toString();
        b2c=txt11c.getText().toString();
        b3c=txt12c.getText().toString();
        b4c=txt13c.getText().toString();
        b5c=txt14c.getText().toString();
        b6c=txt15c.getText().toString();
        b7c=txt16c.getText().toString();
        b8c=txt17c.getText().toString();
        b9c=txt18c.getText().toString();

        c1c=txt19c.getText().toString();
        c2c=txt20c.getText().toString();
        c3c=txt21c.getText().toString();
        c4c=txt22c.getText().toString();
        c5c=txt23c.getText().toString();
        c6c=txt24c.getText().toString();
        c7c=txt25c.getText().toString();
        c8c=txt26c.getText().toString();
        c9c=txt27c.getText().toString();







        corn1d=txt1d.getText().toString();
        corn2d=txt9d.getText().toString();
        corn3d=txt19d.getText().toString();
        corn4d=txt27d.getText().toString();

        erly1d=txt1d.getText().toString();
        erly2d=txt2d.getText().toString();
        erly3d=txt3d.getText().toString();
        erly4d=txt4d.getText().toString();
        erly5d=txt5d.getText().toString();

        a1d=txt1d.getText().toString();
        a2d=txt2d.getText().toString();
        a3d=txt3d.getText().toString();
        a4d=txt4d.getText().toString();
        a5d=txt5d.getText().toString();
        a6d=txt6d.getText().toString();
        a7d=txt7d.getText().toString();
        a8d=txt8d.getText().toString();
        a9d=txt9d.getText().toString();

        b1d=txt10d.getText().toString();
        b2d=txt11d.getText().toString();
        b3d=txt12d.getText().toString();
        b4d=txt13d.getText().toString();
        b5d=txt14d.getText().toString();
        b6d=txt15d.getText().toString();
        b7d=txt16d.getText().toString();
        b8d=txt17d.getText().toString();
        b9d=txt18d.getText().toString();

        c1d=txt19d.getText().toString();
        c2d=txt20d.getText().toString();
        c3d=txt21d.getText().toString();
        c4d=txt22d.getText().toString();
        c5d=txt23d.getText().toString();
        c6d=txt24d.getText().toString();
        c7d=txt25d.getText().toString();
        c8d=txt26d.getText().toString();
        c9d=txt27d.getText().toString();




        corn1e=txt1e.getText().toString();
        corn2e=txt9e.getText().toString();
        corn3e=txt19e.getText().toString();
        corn4e=txt27e.getText().toString();

        erly1e=txt1e.getText().toString();
        erly2e=txt2e.getText().toString();
        erly3e=txt3e.getText().toString();
        erly4e=txt4e.getText().toString();
        erly5e=txt5e.getText().toString();

        a1e=txt1e.getText().toString();
        a2e=txt2e.getText().toString();
        a3e=txt3e.getText().toString();
        a4e=txt4e.getText().toString();
        a5e=txt5e.getText().toString();
        a6e=txt6e.getText().toString();
        a7e=txt7e.getText().toString();
        a8e=txt8e.getText().toString();
        a9e=txt9e.getText().toString();

        b1e=txt10e.getText().toString();
        b2e=txt11e.getText().toString();
        b3e=txt12e.getText().toString();
        b4e=txt13e.getText().toString();
        b5e=txt14e.getText().toString();
        b6e=txt15e.getText().toString();
        b7e=txt16e.getText().toString();
        b8e=txt17e.getText().toString();
        b9e=txt18e.getText().toString();

        c1e=txt19e.getText().toString();
        c2e=txt20e.getText().toString();
        c3e=txt21e.getText().toString();
        c4e=txt22e.getText().toString();
        c5e=txt23e.getText().toString();
        c6e=txt24e.getText().toString();
        c7e=txt25e.getText().toString();
        c8e=txt26e.getText().toString();
        c9e=txt27e.getText().toString();


//        Random randd = new Random();
//        Random rand2 = new Random();
//
//
//
//
//        int i=0;
//        while (i<15){
//            int value=randd.nextInt(27)+1;
//            if (arrayList.contains(value)){
//            }else {
//                arrayList.add(value);
//                switch (value){
//                    case 1:
//                        getrandomnumber_b(txt1);
//                        firstline_a.add(value);
//                        corner_a.add(value);
//
//                        break;
//                    case 2:
//                        getrandomnumber_b(txt2);
//                        firstline_a.add(value);
//                        break;
//                    case 3:
//                        getrandomnumber_b(txt3);
//                        firstline_a.add(value);
//                        break;
//                    case 4:
//                        getrandomnumber_b(txt4);
//                        firstline_a.add(value);
//                        break;
//                    case 5:
//                        getrandomnumber_b(txt5);
//                        firstline_a.add(value);
//                        break;
//                    case 6:
//                        getrandomnumber_b(txt6);
//                        firstline_a.add(value);
//                        break;
//                    case 7:
//                        getrandomnumber_b(txt7);
//                        firstline_a.add(value);
//                        break;
//                    case 8:
//                        getrandomnumber_b(txt8);
//                        firstline_a.add(value);
//                        break;
//                    case 9:
//                        getrandomnumber_b(txt9);
//                        firstline_a.add(value);
//                        corner_a.add(value);
//                        break;
//
//                    case 10:
//                        getrandomnumber_b(txt10);
//                        secendline_a.add(value);
//                        break;
//                    case 11:
//                        getrandomnumber_b(txt11);
//                        secendline_a.add(value);
//                        break;
//                    case 12:
//                        getrandomnumber_b(txt12);
//                        secendline_a.add(value);
//                        break;
//                    case 13:
//                        getrandomnumber_b(txt13);
//                        secendline_a.add(value);
//                        break;
//                    case 14:
//                        getrandomnumber_b(txt14);
//                        secendline_a.add(value);
//                        break;
//                    case 15:
//                        getrandomnumber_b(txt15);
//                        secendline_a.add(value);
//                        break;
//                    case 16:
//                        getrandomnumber_b(txt16);
//                        secendline_a.add(value);
//                        break;
//                    case 17:
//                        getrandomnumber_b(txt17);
//                        secendline_a.add(value);
//                        break;
//                    case 18:
//                        getrandomnumber_b(txt18);
//                        secendline_a.add(value);
//                        break;
//                    case 19:
//                        getrandomnumber_b(txt19);
//                        secendline_a.add(value);
//                        corner_a.add(value);
//                        break;
//
//                    case 20:
//                        getrandomnumber_b(txt20);
//                        threeline_a.add(value);
//                        break;
//                    case 21:
//                        getrandomnumber_b(txt21);
//                        threeline_a.add(value);
//                        break;
//                    case 22:
//                        getrandomnumber_b(txt22);
//                        threeline_a.add(value);
//                        break;
//                    case 23:
//                        getrandomnumber_b(txt23);
//                        threeline_a.add(value);
//                        break;
//                    case 24:
//                        getrandomnumber_b(txt24);
//                        threeline_a.add(value);
//                        break;
//                    case 25:
//                        getrandomnumber_b(txt25);
//                        threeline_a.add(value);
//                        break;
//                    case 26:
//                        getrandomnumber_b(txt26);
//                        threeline_a.add(value);
//                        break;
//                    case 27:
//                        getrandomnumber_b(txt27);
//                        threeline_a.add(value);
//                        corner_a.add(value);
//                        break;
//
//                }
//                i++;
//            }
//        }
//
//
//
//        int i2=0;
//        while (i2<15){
//            int value2=randd.nextInt(27)+1;
//            if (arrayList2.contains(value2)){
//
//            }else {
//                arrayList2.add(value2);
//                switch (value2){
//                    case 1:
//                        getrandomnumber_b(txt1b);
//                        firstline_b.add(value2);
//                        corner_b.add(value2);
//                        break;
//                    case 2:
//                        getrandomnumber_b(txt2b);
//                        firstline_b.add(value2);
//                        break;
//                    case 3:
//                        getrandomnumber_b(txt3b);
//                        firstline_b.add(value2);
//                        break;
//                    case 4:
//                        getrandomnumber_b(txt4b);
//                        firstline_b.add(value2);
//                        break;
//                    case 5:
//                        getrandomnumber_b(txt5b);
//                        firstline_b.add(value2);
//                        break;
//                    case 6:
//                        getrandomnumber_b(txt6b);
//                        firstline_b.add(value2);
//                        break;
//                    case 7:
//                        getrandomnumber_b(txt7b);
//                        firstline_b.add(value2);
//                        break;
//                    case 8:
//                        getrandomnumber_b(txt8b);
//                        firstline_b.add(value2);
//                        break;
//                    case 9:
//                        getrandomnumber_b(txt9b);
//                        firstline_b.add(value2);
//                        corner_b.add(value2);
//                        break;
//                    case 10:
//                        getrandomnumber_b(txt10b);
//                        secendlin_b.add(value2);
//                        break;
//                    case 11:
//                        getrandomnumber_b(txt11b);
//                        secendlin_b.add(value2);
//                        break;
//                    case 12:
//                        getrandomnumber_b(txt12b);
//                        secendlin_b.add(value2);
//                        break;
//                    case 13:
//                        getrandomnumber_b(txt13b);
//                        secendlin_b.add(value2);
//                        break;
//                    case 14:
//                        getrandomnumber_b(txt14b);
//                        secendlin_b.add(value2);
//                        break;
//                    case 15:
//                        getrandomnumber_b(txt15b);
//                        secendlin_b.add(value2);
//                        break;
//                    case 16:
//                        getrandomnumber_b(txt16b);
//                        secendlin_b.add(value2);
//                        break;
//                    case 17:
//                        getrandomnumber_b(txt17b);
//                        secendlin_b.add(value2);
//                        break;
//                    case 18:
//                        getrandomnumber_b(txt18b);
//                        secendlin_b.add(value2);
//                        corner_b.add(value2);
//                        break;
//                    case 19:
//                        getrandomnumber_b(txt19b);
//                        threeline_b.add(value2);
//                        corner_b.add(value2);
//                        break;
//                    case 20:
//                        getrandomnumber_b(txt20b);
//                        threeline_b.add(value2);
//                        break;
//                    case 21:
//                        getrandomnumber_b(txt21b);
//                        threeline_b.add(value2);
//                        break;
//                    case 22:
//                        getrandomnumber_b(txt22b);
//                        threeline_b.add(value2);
//                        break;
//                    case 23:
//                        getrandomnumber_b(txt23b);
//                        threeline_b.add(value2);
//                        break;
//                    case 24:
//                        getrandomnumber_b(txt24b);
//                        threeline_b.add(value2);
//                        break;
//                    case 25:
//                        getrandomnumber_b(txt25b);
//                        threeline_b.add(value2);
//                        break;
//                    case 26:
//                        getrandomnumber_b(txt26b);
//                        threeline_b.add(value2);
//                        break;
//                    case 27:
//                        getrandomnumber_b(txt27b);
//                        threeline_b.add(value2);
//                        corner_b.add(value2);
//                        break;
//                }
//                i2++;
//            }
//        }
//
//
//
//
//        int i3=0;
//        while (i3<15){
//            int value3=randd.nextInt(27)+1;
//            if (arrayList3.contains(value3)){
//
//            }else {
//                arrayList3.add(value3);
//                switch (value3){
//                    case 1:
//                        getrandomnumber_b(txt1c);
//                        firstline_c.add(value3);
//                        corner_c.add(value3);
//                        break;
//                    case 2:
//                        getrandomnumber_b(txt2c);
//                        firstline_c.add(value3);
//                        break;
//                    case 3:
//                        getrandomnumber_b(txt3c);
//                        firstline_c.add(value3);
//                        break;
//                    case 4:
//                        getrandomnumber_b(txt4c);
//                        firstline_c.add(value3);
//                        break;
//                    case 5:
//                        getrandomnumber_b(txt5c);
//                        firstline_c.add(value3);
//                        break;
//                    case 6:
//                        getrandomnumber_b(txt6c);
//                        firstline_c.add(value3);
//                        break;
//                    case 7:
//                        getrandomnumber_b(txt7c);
//                        firstline_c.add(value3);
//                        break;
//                    case 8:
//                        getrandomnumber_b(txt8c);
//                        firstline_c.add(value3);
//                        break;
//                    case 9:
//                        getrandomnumber_b(txt9c);
//                        firstline_c.add(value3);
//                        corner_c.add(value3);
//                        break;
//                    case 10:
//                        getrandomnumber_b(txt10c);
//                        secendlin_c.add(value3);
//                        break;
//                    case 11:
//                        getrandomnumber_b(txt11c);
//                        secendlin_c.add(value3);
//                        break;
//                    case 12:
//                        getrandomnumber_b(txt12c);
//                        secendlin_c.add(value3);
//                        break;
//                    case 13:
//                        getrandomnumber_b(txt13c);
//                        secendlin_c.add(value3);
//                        break;
//                    case 14:
//                        getrandomnumber_b(txt14c);
//                        secendlin_c.add(value3);
//                        break;
//                    case 15:
//                        getrandomnumber_b(txt15c);
//                        secendlin_c.add(value3);
//                        break;
//                    case 16:
//                        getrandomnumber_b(txt16c);
//                        secendlin_c.add(value3);
//                        break;
//                    case 17:
//                        getrandomnumber_b(txt17c);
//                        secendlin_c.add(value3);
//                        break;
//                    case 18:
//                        getrandomnumber_b(txt18c);
//                        secendlin_c.add(value3);
//                        break;
//                    case 19:
//                        getrandomnumber_b(txt19c);
//                        threeline_c.add(value3);
//                        corner_c.add(value3);
//                        break;
//                    case 20:
//                        getrandomnumber_b(txt20c);
//                        threeline_c.add(value3);
//                        break;
//                    case 21:
//                        getrandomnumber_b(txt21c);
//                        threeline_c.add(value3);
//                        break;
//                    case 22:
//                        getrandomnumber_b(txt22c);
//                        threeline_c.add(value3);
//                        break;
//                    case 23:
//                        getrandomnumber_b(txt23c);
//                        threeline_c.add(value3);
//                        break;
//                    case 24:
//                        getrandomnumber_b(txt24c);
//                        threeline_c.add(value3);
//                        break;
//                    case 25:
//                        getrandomnumber_b(txt25c);
//                        threeline_c.add(value3);
//                        break;
//                    case 26:
//                        getrandomnumber_b(txt26c);
//                        threeline_c.add(value3);
//                        break;
//                    case 27:
//                        getrandomnumber_b(txt27c);
//                        threeline_c.add(value3);
//                        corner_c.add(value3);
//                        break;
//                }
//                i3++;
//            }
//        }
//
//
//
//
//
//
//        int i4=0;
//        while (i4<15){
//            int value4=randd.nextInt(27)+1;
//            if (arrayList4.contains(value4)){
//
//            }else {
//                arrayList4.add(value4);
//                switch (value4){
//                    case 1:
//                        getrandomnumber_b(txt1d);
//                        firstline_d.add(value4);
//                        corner_d.add(value4);
//                        break;
//                    case 2:
//                        getrandomnumber_b(txt2d);
//                        firstline_d.add(value4);
//                        break;
//                    case 3:
//                        getrandomnumber_b(txt3d);
//                        firstline_d.add(value4);
//                        break;
//                    case 4:
//                        getrandomnumber_b(txt4d);
//                        firstline_d.add(value4);
//                        break;
//                    case 5:
//                        getrandomnumber_b(txt5d);
//                        firstline_d.add(value4);
//                        break;
//                    case 6:
//                        getrandomnumber_b(txt6d);
//                        firstline_d.add(value4);
//                        break;
//                    case 7:
//                        getrandomnumber_b(txt7d);
//                        firstline_d.add(value4);
//                        break;
//                    case 8:
//                        getrandomnumber_b(txt8d);
//                        firstline_d.add(value4);
//                        break;
//                    case 9:
//                        getrandomnumber_b(txt9d);
//                        firstline_d.add(value4);
//                        corner_d.add(value4);
//                        break;
//                    case 10:
//                        getrandomnumber_b(txt10d);
//                        secendlin_d.add(value4);
//                        break;
//                    case 11:
//                        getrandomnumber_b(txt11d);
//                        secendlin_d.add(value4);
//                        break;
//                    case 12:
//                        getrandomnumber_b(txt12d);
//                        secendlin_d.add(value4);
//                        break;
//                    case 13:
//                        getrandomnumber_b(txt13d);
//                        secendlin_d.add(value4);
//                        break;
//                    case 14:
//                        getrandomnumber_b(txt14d);
//                        secendlin_d.add(value4);
//                        break;
//                    case 15:
//                        getrandomnumber_b(txt15d);
//                        secendlin_d.add(value4);
//                        break;
//                    case 16:
//                        getrandomnumber_b(txt16d);
//                        secendlin_d.add(value4);
//                        break;
//                    case 17:
//                        getrandomnumber_b(txt17d);
//                        secendlin_d.add(value4);
//                        break;
//                    case 18:
//                        getrandomnumber_b(txt18d);
//                        secendlin_d.add(value4);
//                        break;
//                    case 19:
//                        getrandomnumber_b(txt19d);
//                        threeline_d.add(value4);
//                        corner_d.add(value4);
//                        break;
//                    case 20:
//                        getrandomnumber_b(txt20d);
//                        threeline_d.add(value4);
//                        break;
//                    case 21:
//                        getrandomnumber_b(txt21d);
//                        threeline_d.add(value4);
//                        break;
//                    case 22:
//                        getrandomnumber_b(txt22d);
//                        threeline_d.add(value4);
//                        break;
//                    case 23:
//                        getrandomnumber_b(txt23d);
//                        threeline_d.add(value4);
//                        break;
//                    case 24:
//                        getrandomnumber_b(txt24d);
//                        threeline_d.add(value4);
//                        break;
//                    case 25:
//                        getrandomnumber_b(txt25d);
//                        threeline_d.add(value4);
//                        break;
//                    case 26:
//                        getrandomnumber_b(txt26d);
//                        threeline_d.add(value4);
//                        break;
//                    case 27:
//                        getrandomnumber_b(txt27d);
//                        threeline_d.add(value4);
//                        corner_d.add(value4);
//                        break;
//                }
//                i4++;
//            }
//        }
//
//
//
//
//
//
//        int i5=0;
//        while (i5<15){
//            int value5=randd.nextInt(27)+1;
//            if (arrayList5.contains(value5)){
//
//            }else {
//                arrayList5.add(value5);
//                switch (value5){
//                    case 1:
//                        getrandomnumber_b(txt1e);
//                        firstline_e.add(value5);
//                        corner_e.add(value5);
//                        break;
//                    case 2:
//                        getrandomnumber_b(txt2e);
//                        firstline_e.add(value5);
//                        break;
//                    case 3:
//                        getrandomnumber_b(txt3e);
//                        firstline_e.add(value5);
//                        break;
//                    case 4:
//                        getrandomnumber_b(txt4e);
//                        firstline_e.add(value5);
//                        break;
//                    case 5:
//                        getrandomnumber_b(txt5e);
//                        firstline_e.add(value5);
//                        break;
//                    case 6:
//                        getrandomnumber_b(txt6e);
//                        firstline_e.add(value5);
//                        break;
//                    case 7:
//                        getrandomnumber_b(txt7e);
//                        firstline_e.add(value5);
//                        break;
//                    case 8:
//                        getrandomnumber_b(txt8e);
//                        firstline_e.add(value5);
//                        break;
//                    case 9:
//                        getrandomnumber_b(txt9e);
//                        firstline_e.add(value5);
//                        corner_e.add(value5);
//                        break;
//                    case 10:
//                        getrandomnumber_b(txt10e);
//                        secendlin_e.add(value5);
//                        break;
//                    case 11:
//                        getrandomnumber_b(txt11e);
//                        secendlin_e.add(value5);
//                        break;
//                    case 12:
//                        getrandomnumber_b(txt12e);
//                        secendlin_e.add(value5);
//                        break;
//                    case 13:
//                        getrandomnumber_b(txt13e);
//                        secendlin_e.add(value5);
//                        break;
//                    case 14:
//                        getrandomnumber_b(txt14e);
//                        secendlin_e.add(value5);
//                        break;
//                    case 15:
//                        getrandomnumber_b(txt15e);
//                        secendlin_e.add(value5);
//                        break;
//                    case 16:
//                        getrandomnumber_b(txt16e);
//                        secendlin_e.add(value5);
//                        break;
//                    case 17:
//                        getrandomnumber_b(txt17e);
//                        secendlin_e.add(value5);
//                        break;
//                    case 18:
//                        getrandomnumber_b(txt18e);
//                        secendlin_e.add(value5);
//
//                        break;
//                    case 19:
//                        getrandomnumber_b(txt19e);
//                        threeline_e.add(value5);
//                        corner_e.add(value5);
//                        break;
//                    case 20:
//                        getrandomnumber_b(txt20e);
//                        threeline_e.add(value5);
//                        break;
//                    case 21:
//                        getrandomnumber_b(txt21e);
//                        threeline_e.add(value5);
//                        break;
//                    case 22:
//                        getrandomnumber_b(txt22e);
//                        threeline_e.add(value5);
//                        break;
//                    case 23:
//                        getrandomnumber_b(txt23e);
//                        threeline_e.add(value5);
//                        break;
//                    case 24:
//                        getrandomnumber_b(txt24e);
//                        threeline_e.add(value5);
//                        break;
//                    case 25:
//                        getrandomnumber_b(txt25e);
//                        threeline_e.add(value5);
//                        break;
//                    case 26:
//                        getrandomnumber_b(txt26e);
//                        threeline_e.add(value5);
//                        break;
//                    case 27:
//                        getrandomnumber_b(txt27e);
//                        threeline_e.add(value5);
//                        corner_e.add(value5);
//                        break;
//                }
//                i5++;
//            }
//        }




        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (a1.equals(adad.getText().toString())){
                        arrayList_blit1.add(1);
                        txt1.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                        Log.e("stuf", "nis" );
                    }
                }

            }
        });
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (a2.equals(adad.getText().toString())){
                        arrayList_blit1.add(2);
                        txt2.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (a3.equals(adad.getText().toString())){
                        arrayList_blit1.add(3);
                        txt3.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (a4.equals(adad.getText().toString())){

                        arrayList_blit1.add(4);
                        txt4.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (a5.equals(adad.getText().toString())){

                        arrayList_blit1.add(5);
                        txt5.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (a6.equals(adad.getText().toString())){
                        arrayList_blit1.add(6);
                        txt6.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (a7.equals(adad.getText().toString())){
                        arrayList_blit1.add(7);
                        txt7.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (a8.equals(adad.getText().toString())){
                        arrayList_blit1.add(8);
                        txt8.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (a9.equals(adad.getText().toString())){
                        arrayList_blit1.add(9);
                        txt9.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (b1.equals(adad.getText().toString())){
                        arrayList_blit1.add(10);
                        txt10.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
        txt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (b2.equals(adad.getText().toString())){
                        arrayList_blit1.add(11);
                        txt11.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        txt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (b3.equals(adad.getText().toString())){
                        arrayList_blit1.add(12);
                        txt12.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        txt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (b4.equals(adad.getText().toString())){
                        arrayList_blit1.add(13);
                        txt13.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (b5.equals(adad.getText().toString())){
                        arrayList_blit1.add(14);
                        txt14.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (b6.equals(adad.getText().toString())){
                        arrayList_blit1.add(15);
                        txt15.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (b7.equals(adad.getText().toString())){
                        arrayList_blit1.add(16);
                        txt16.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (b8.equals(adad.getText().toString())){
                        arrayList_blit1.add(17);
                        txt17.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (b9.equals(adad.getText().toString())){
                        arrayList_blit1.add(18);
                        txt18.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (c1.equals(adad.getText().toString())){
                        arrayList_blit1.add(19);
                        txt19.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (c2.equals(adad.getText().toString())){
                        arrayList_blit1.add(20);
                        txt20.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (c3.equals(adad.getText().toString())){
                        arrayList_blit1.add(21);
                        txt21.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (c4.equals(adad.getText().toString())){
                        arrayList_blit1.add(22);
                        txt22.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        txt23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (c5.equals(adad.getText().toString())){
                        arrayList_blit1.add(23);
                        txt23.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (c6.equals(adad.getText().toString())){
                        arrayList_blit1.add(24);
                        txt24.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        txt25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (c7.equals(adad.getText().toString())){
                        arrayList_blit1.add(25);
                        txt25.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (c8.equals(adad.getText().toString())){
                        arrayList_blit1.add(26);
                        txt26.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (c9.equals(adad.getText().toString())){
                        arrayList_blit1.add(27);
                        txt27.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });




        txt1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (a1b.equals(adad.getText().toString())){
                        arrayList_blit2.add(1);
                        txt1b.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                        Log.e("stuf", "nis" );
                    }
                }

            }
        });
        txt2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (a2b.equals(adad.getText().toString())){
                        arrayList_blit2.add(2);
                        txt2b.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt3b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (a3b.equals(adad.getText().toString())){
                        arrayList_blit2.add(3);
                        txt3b.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt4b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (a4b.equals(adad.getText().toString())){
                        arrayList_blit2.add(4);
                        txt4b.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt5b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (a5b.equals(adad.getText().toString())){
                        arrayList_blit2.add(5);
                        txt5b.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt6b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (a6b.equals(adad.getText().toString())){
                        arrayList_blit2.add(6);
                        txt6b.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt7b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (a7b.equals(adad.getText().toString())){
                        arrayList_blit2.add(7);
                        txt7b.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt8b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (a8b.equals(adad.getText().toString())){
                        arrayList_blit2.add(8);
                        txt8b.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt9b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (a9b.equals(adad.getText().toString())){
                        arrayList_blit2.add(9);
                        txt9b.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt10b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (b1b.equals(adad.getText().toString())){
                        arrayList_blit2.add(10);
                        txt10b.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt11b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (b2b.equals(adad.getText().toString())){
                        arrayList_blit2.add(11);
                        txt11b.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        txt12b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (b3b.equals(adad.getText().toString())){
                        arrayList_blit2.add(12);
                        txt12b.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        txt13b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (b4b.equals(adad.getText().toString())){
                        arrayList_blit2.add(13);
                        txt13b.setBackgroundResource(R.drawable.pushing);

                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt14b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (b5b.equals(adad.getText().toString())){
                        arrayList_blit2.add(14);
                        txt14b.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt15b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){

                    if (b6b.equals(adad.getText().toString())){
                        arrayList_blit2.add(15);
                        txt15b.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        txt16b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){

                    if (b7b.equals(adad.getText().toString())){
                        arrayList_blit2.add(16);
                        txt16b.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        txt17b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){

                    if (b8b.equals(adad.getText().toString())){
                        arrayList_blit2.add(17);
                        txt17b.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        txt18b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (b9b.equals(adad.getText().toString())){
                        arrayList_blit2.add(18);
                        txt18b.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt19b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (c1b.equals(adad.getText().toString())){
                        arrayList_blit2.add(19);
                        txt19b.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt20b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (c2b.equals(adad.getText().toString())){
                        arrayList_blit2.add(20);
                        txt20b.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt21b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (c3b.equals(adad.getText().toString())){
                        arrayList_blit2.add(21);
                        txt21b.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt22b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (c4b.equals(adad.getText().toString())){
                        arrayList_blit2.add(22);
                        txt22b.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        txt23b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (c5b.equals(adad.getText().toString())){
                        arrayList_blit2.add(23);
                        txt23b.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt24b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (c6b.equals(adad.getText().toString())){
                        arrayList_blit2.add(24);
                        txt24b.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        txt25b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (c7b.equals(adad.getText().toString())){
                        arrayList_blit2.add(25);
                        txt25b.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt26b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (c8b.equals(adad.getText().toString())){
                        arrayList_blit2.add(26);
                        txt26b.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt27b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    if (c9b.equals(adad.getText().toString())){
                        arrayList_blit2.add(27);
                        txt27b.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });






        txt1c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (a1c.equals(adad.getText().toString())){
                        arrayList_blit3.add(1);
                        txt1c.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                        Log.e("stuf", "nis" );
                    }
                }

            }
        });
        txt2c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (a2c.equals(adad.getText().toString())){

                        arrayList_blit3.add(2);
                        txt2c.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt3c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (a3c.equals(adad.getText().toString())){

                        arrayList_blit3.add(3);
                        txt3c.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt4c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (a4c.equals(adad.getText().toString())){
                        arrayList_blit3.add(4);
                        txt4c.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt5c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (a5c.equals(adad.getText().toString())){
                        arrayList_blit3.add(5);
                        txt5c.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt6c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (a6c.equals(adad.getText().toString())){
                        arrayList_blit3.add(6);
                        txt6c.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt7c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (a7c.equals(adad.getText().toString())){
                        arrayList_blit3.add(7);
                        txt7c.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt8c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (a8c.equals(adad.getText().toString())){
                        arrayList_blit3.add(8);
                        txt8c.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt9c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (a9c.equals(adad.getText().toString())){
                        arrayList_blit3.add(9);
                        txt9c.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt10c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (b1c.equals(adad.getText().toString())){
                        arrayList_blit3.add(10);
                        txt10c.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt11c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (b2c.equals(adad.getText().toString())){
                        arrayList_blit3.add(11);
                        txt11c.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        txt12c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (b3c.equals(adad.getText().toString())){
                        arrayList_blit3.add(12);
                        txt12c.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        txt13c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (b4c.equals(adad.getText().toString())){
                        arrayList_blit3.add(13);
                        txt13c.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt14c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){

                    if (b5c.equals(adad.getText().toString())){
                        arrayList_blit3.add(14);
                        txt14c.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        txt15c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (b6c.equals(adad.getText().toString())){
                        arrayList_blit3.add(15);
                        txt15c.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt16c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (b7c.equals(adad.getText().toString())){
                        arrayList_blit3.add(16);
                        txt16c.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt17c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (b8c.equals(adad.getText().toString())){
                        arrayList_blit3.add(17);
                        txt17c.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt18c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (b9c.equals(adad.getText().toString())){
                        arrayList_blit3.add(18);
                        txt18c.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt19c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (c1c.equals(adad.getText().toString())){
                        arrayList_blit3.add(19);
                        txt19c.setBackgroundResource(R.drawable.pushing);

                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt20c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (c2c.equals(adad.getText().toString())){
                        arrayList_blit3.add(20);
                        txt20c.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt21c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (c3c.equals(adad.getText().toString())){
                        arrayList_blit3.add(21);
                        txt21c.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt22c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (c4c.equals(adad.getText().toString())){
                        arrayList_blit3.add(22);
                        txt22c.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        txt23c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (c5c.equals(adad.getText().toString())){
                        arrayList_blit3.add(23);
                        txt23c.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt24c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (c6c.equals(adad.getText().toString())){
                        arrayList_blit3.add(24);
                        txt24c.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        txt25c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (c7c.equals(adad.getText().toString())){
                        arrayList_blit3.add(25);
                        txt25c.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt26c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (c8c.equals(adad.getText().toString())){
                        arrayList_blit3.add(26);
                        txt26c.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt27c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    if (c9c.equals(adad.getText().toString())){
                        arrayList_blit3.add(27);
                        txt27c.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });







        txt1d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (a1d.equals(adad.getText().toString())){
                        arrayList_blit4.add(1);
                        txt1d.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                        Log.e("stuf", "nis" );
                    }
                }

            }
        });
        txt2d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (a2d.equals(adad.getText().toString())){
                        arrayList_blit4.add(2);
                        txt2d.setBackgroundResource(R.drawable.pushing);

                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (a3d.equals(adad.getText().toString())){
                        arrayList_blit4.add(3);
                        txt3d.setBackgroundResource(R.drawable.pushing);

                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt4d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (a4d.equals(adad.getText().toString())){
                        arrayList_blit4.add(4);
                        txt4d.setBackgroundResource(R.drawable.pushing);

                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt5d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (a5d.equals(adad.getText().toString())){
                        arrayList_blit4.add(5);
                        txt5d.setBackgroundResource(R.drawable.pushing);

                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt6d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (a6d.equals(adad.getText().toString())){
                        arrayList_blit4.add(6);
                        txt6d.setBackgroundResource(R.drawable.pushing);

                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt7d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (a7d.equals(adad.getText().toString())){
                        arrayList_blit4.add(7);
                        txt7d.setBackgroundResource(R.drawable.pushing);

                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt8d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (a8d.equals(adad.getText().toString())){
                        arrayList_blit4.add(8);
                        txt8d.setBackgroundResource(R.drawable.pushing);

                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt9d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (a9d.equals(adad.getText().toString())){
                        arrayList_blit4.add(9);
                        txt9d.setBackgroundResource(R.drawable.pushing);

                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt10d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (b1d.equals(adad.getText().toString())){
                        arrayList_blit4.add(10);
                        txt10d.setBackgroundResource(R.drawable.pushing);

                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt11d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (b2d.equals(adad.getText().toString())){
                        arrayList_blit4.add(11);
                        txt11d.setBackgroundResource(R.drawable.pushing);

                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        txt12d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (b3d.equals(adad.getText().toString())){
                        arrayList_blit4.add(12);
                        txt12d.setBackgroundResource(R.drawable.pushing);

                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        txt13d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (b4d.equals(adad.getText().toString())){
                        arrayList_blit4.add(13);
                        txt13d.setBackgroundResource(R.drawable.pushing);

                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt14d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (b5d.equals(adad.getText().toString())){
                        arrayList_blit4.add(14);
                        txt14d.setBackgroundResource(R.drawable.pushing);

                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt15d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (b6d.equals(adad.getText().toString())){
                        arrayList_blit4.add(15);
                        txt15d.setBackgroundResource(R.drawable.pushing);

                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt16d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (b7d.equals(adad.getText().toString())){
                        arrayList_blit4.add(16);
                        txt16d.setBackgroundResource(R.drawable.pushing);

                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt17d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (b8d.equals(adad.getText().toString())){
                        arrayList_blit4.add(17);
                        txt17d.setBackgroundResource(R.drawable.pushing);

                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt18d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (b9d.equals(adad.getText().toString())){
                        arrayList_blit4.add(18);
                        txt18d.setBackgroundResource(R.drawable.pushing);

                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt19d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (c1d.equals(adad.getText().toString())){
                        arrayList_blit4.add(19);
                        txt19d.setBackgroundResource(R.drawable.pushing);

                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt20d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (c2d.equals(adad.getText().toString())){
                        arrayList_blit4.add(20);
                        txt20d.setBackgroundResource(R.drawable.pushing);

                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt21d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (c3d.equals(adad.getText().toString())){
                        arrayList_blit4.add(21);
                        txt21d.setBackgroundResource(R.drawable.pushing);

                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt22d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (c4d.equals(adad.getText().toString())){
                        arrayList_blit4.add(22);
                        txt22d.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        txt23d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (c5d.equals(adad.getText().toString())){
                        arrayList_blit4.add(23);
                        txt23d.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt24d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (c6d.equals(adad.getText().toString())){
                        arrayList_blit4.add(24);
                        txt24d.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        txt25d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (c7d.equals(adad.getText().toString())){
                        arrayList_blit4.add(25);
                        txt25d.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt26d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (c8d.equals(adad.getText().toString())){
                        arrayList_blit4.add(26);
                        txt26d.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt27d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite4==false){
                    if (c9d.equals(adad.getText().toString())){
                        arrayList_blit4.add(27);
                        txt27d.setBackgroundResource(R.drawable.pushing);

                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });





        txt1e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (a1e.equals(adad.getText().toString())){
                        arrayList_blit5.add(1);
                        txt1e.setBackgroundResource(R.drawable.pushing);

                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                        Log.e("stuf", "nis" );
                    }
                }

            }
        });
        txt2e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (a2e.equals(adad.getText().toString())){
                        arrayList_blit5.add(2);
                        txt2e.setBackgroundResource(R.drawable.pushing);

                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt3e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (a3e.equals(adad.getText().toString())){
                        arrayList_blit5.add(3);
                        txt3e.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt4e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (a4e.equals(adad.getText().toString())){

                        arrayList_blit5.add(4);
                        txt4e.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt5e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (a5e.equals(adad.getText().toString())){

                        arrayList_blit5.add(5);
                        txt5e.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt6e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (a6e.equals(adad.getText().toString())){

                        arrayList_blit5.add(6);
                        txt6e.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt7e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (a7e.equals(adad.getText().toString())){

                        arrayList_blit5.add(7);
                        txt7e.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt8e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (a8e.equals(adad.getText().toString())){

                        arrayList_blit5.add(8);
                        txt8e.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt9e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (a9e.equals(adad.getText().toString())){

                        arrayList_blit5.add(9);
                        txt9e.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt10e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (b1e.equals(adad.getText().toString())){

                        arrayList_blit5.add(10);
                        txt10e.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt11e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (b2e.equals(adad.getText().toString())){
                        arrayList_blit5.add(11);
                        txt11e.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        txt12e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (b3e.equals(adad.getText().toString())){
                        arrayList_blit5.add(12);
                        txt12e.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        txt13e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (b4e.equals(adad.getText().toString())){
                        arrayList_blit5.add(13);
                        txt13e.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt14e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (b5e.equals(adad.getText().toString())){

                        arrayList_blit5.add(14);
                        txt14e.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt15e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (b6e.equals(adad.getText().toString())){

                        arrayList_blit5.add(15);
                        txt15e.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt16e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (b7e.equals(adad.getText().toString())){

                        arrayList_blit4.add(16);
                        txt16e.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt17e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (b8e.equals(adad.getText().toString())){

                        arrayList_blit5.add(17);
                        txt17e.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt18e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (b9e.equals(adad.getText().toString())){

                        arrayList_blit5.add(18);
                        txt18e.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt19e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (c1e.equals(adad.getText().toString())){

                        arrayList_blit5.add(19);
                        txt19e.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt20e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (c2e.equals(adad.getText().toString())){
                        arrayList_blit5.add(20);
                        txt20e.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt21e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (c3e.equals(adad.getText().toString())){
                        arrayList_blit5.add(21);
                        txt21e.setBackgroundResource(R.drawable.pushing);
                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt22e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (c4e.equals(adad.getText().toString())){
                        arrayList_blit5.add(22);
                        txt22e.setBackgroundResource(R.drawable.pushing);

                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        txt23e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (c5e.equals(adad.getText().toString())){
                        arrayList_blit5.add(23);
                        txt23e.setText("");
                        txt23e.setBackgroundResource(R.drawable.pushing);

                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt24e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (c6e.equals(adad.getText().toString())){
                        arrayList_blit5.add(24);
                        txt24e.setBackgroundResource(R.drawable.pushing);

                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        txt25e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (c7e.equals(adad.getText().toString())){
                        arrayList_blit5.add(25);
                        txt25e.setBackgroundResource(R.drawable.pushing);

                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt26e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (c8e.equals(adad.getText().toString())){
                        arrayList_blit5.add(26);
                        txt26e.setBackgroundResource(R.drawable.pushing);

                    }else {

                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        txt27e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite5==false){
                    if (c9e.equals(adad.getText().toString())){
                        arrayList_blit5.add(27);
                        txt27e.setBackgroundResource(R.drawable.pushing);

                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



        imgpush=(ImageView)findViewById(R.id.imgpushing1_blit6);
        imgpush2=(ImageView)findViewById(R.id.imgpushing2_blit5);
        imgpush3=(ImageView)findViewById(R.id.imgpushing3_blit5);
        imgpush4=(ImageView)findViewById(R.id.imgpushing4_blit5);
        imgpush5=(ImageView)findViewById(R.id.imgpushing5_blit5);

        orang1_blite6=(TextView)findViewById(R.id.orang_1_blite5);
        orang2_blite6=(TextView)findViewById(R.id.orang_2_blite5);
        orang3_blite6=(TextView)findViewById(R.id.orang_3_blite5);
        orang4_blite6=(TextView)findViewById(R.id.orang_4_blite5);
        orang5_blite6=(TextView)findViewById(R.id.orang_5_blite5);

        orang1_blite6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    final BottomSheetDialog dialog = new BottomSheetDialog(play5.this, R.style.BottomSheetDialogTheme);
                    dialog.setContentView(R.layout.sheet_clime);
                    dialog.setCanceledOnTouchOutside(true);

//                case "winearlyfive":
//                factor=0.17;
//                break;
//                case "winfirstline":
//                factor=0.08;
//                break;
//                case "winsecondline":
//                factor=0.08;
//                break;
//                case "winthirdline":
//                factor=0.08;
//                break;
//                case "wincorners":
//                factor=0.08;
//                break;
//                case "winfull":
                    CardView crderly = (CardView) dialog.findViewById(R.id.crderly);
                    CardView crdtop = (CardView) dialog.findViewById(R.id.crdtop);
                    CardView crdbotom = (CardView) dialog.findViewById(R.id.crdbotom);
                    CardView crdmidle = (CardView) dialog.findViewById(R.id.crdmidle);
                    CardView crdcorn = (CardView) dialog.findViewById(R.id.crdcorner);
                    CardView crdfull = (CardView) dialog.findViewById(R.id.crdfull);

                    TextView erly = (TextView) dialog.findViewById(R.id.txterlyfive);
                    TextView top = (TextView) dialog.findViewById(R.id.txttopline);
                    TextView midle = (TextView) dialog.findViewById(R.id.txtmidleline);
                    TextView botom = (TextView) dialog.findViewById(R.id.txtbotomline);
                    TextView corn = (TextView) dialog.findViewById(R.id.txtcorneline);
                    TextView full = (TextView) dialog.findViewById(R.id.txtfullhome);

                    erly.setText(AmountText("winearlyfive"));
                    top.setText(AmountText("winfirstline"));
                    midle.setText(AmountText("winsecondline"));
                    botom.setText(AmountText("winthirdline"));
                    corn.setText(AmountText("wincorners"));
                    full.setText(AmountText("winfull"));


                    crderly.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (arrayList_blit1.size() == 5) {
                                win("winearlyfive");
                            } else {
                                blite1 = true;
                                imgpush.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });

                    crdtop.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i = 0;
                            while (i < firstline_a.size()) {
                                if (arrayList_blit1.contains(firstline_a.get(i))) {
                                    trfirst_a.add("tr");
                                }
                                i++;
                            }


                            if (trfirst_a.size() == firstline_a.size()) {
                                win("winfirstline");
                            } else {
                                blite1 = true;
                                imgpush.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }

                        }
                    });


                    crdmidle.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            int i = 0;
                            while (i < secendline_a.size()) {
                                if (arrayList_blit1.contains(secendline_a.get(i))) {
                                    trsecend_a.add("tr");
                                }
                                i++;
                            }


                            if (trsecend_a.size() == secendline_a.size()) {
                                win("winsecondline");
                            } else {
                                blite1 = true;
                                imgpush.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });

                    crdbotom.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i = 0;
                            while (i < threeline_a.size()) {
                                if (arrayList_blit1.contains(threeline_a.get(i))) {
                                    trthree_a.add("tr");
                                }
                                i++;
                            }

                            if (trthree_a.size() == threeline_a.size()) {
                                win("winthirdline");
                            } else {
                                blite1 = true;
                                imgpush.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });

                    crdcorn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i = 0;
                            while (i < corner_a.size()) {
                                if (arrayList_blit1.contains(corner_a.get(i))) {
                                    tr_corner_a.add("tr");
                                }
                                i++;
                            }

                            if (tr_corner_a.size() == corner_a.size()) {
                                win("wincorners");
                            } else {
                                blite1 = true;
                                imgpush.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }


                        }
                    });

                    crdfull.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (trfirst_a.size() == firstline_a.size() && trsecend_a.size() == secendline_a.size() && trthree_a.size() == threeline_a.size()) {
                                win("winfull");
                            } else {
                                blite1 = true;
                                imgpush.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });


                    dialog.show();
                }
            }
        });


        orang2_blite6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite2==false){
                    final BottomSheetDialog dialog = new BottomSheetDialog(play5.this, R.style.BottomSheetDialogTheme);
                    dialog.setContentView(R.layout.sheet_clime);
                    dialog.setCanceledOnTouchOutside(true);

//                case "winearlyfive":
//                factor=0.17;
//                break;
//                case "winfirstline":
//                factor=0.08;
//                break;
//                case "winsecondline":
//                factor=0.08;
//                break;
//                case "winthirdline":
//                factor=0.08;
//                break;
//                case "wincorners":
//                factor=0.08;
//                break;
//                case "winfull":
                    CardView crderly = (CardView) dialog.findViewById(R.id.crderly);
                    CardView crdtop = (CardView) dialog.findViewById(R.id.crdtop);
                    CardView crdbotom = (CardView) dialog.findViewById(R.id.crdbotom);
                    CardView crdmidle = (CardView) dialog.findViewById(R.id.crdmidle);
                    CardView crdcorn = (CardView) dialog.findViewById(R.id.crdcorner);
                    CardView crdfull = (CardView) dialog.findViewById(R.id.crdfull);

                    TextView erly = (TextView) dialog.findViewById(R.id.txterlyfive);
                    TextView top = (TextView) dialog.findViewById(R.id.txttopline);
                    TextView midle = (TextView) dialog.findViewById(R.id.txtmidleline);
                    TextView botom = (TextView) dialog.findViewById(R.id.txtbotomline);
                    TextView corn = (TextView) dialog.findViewById(R.id.txtcorneline);
                    TextView full = (TextView) dialog.findViewById(R.id.txtfullhome);

                    erly.setText(AmountText("winearlyfive"));
                    top.setText(AmountText("winfirstline"));
                    midle.setText(AmountText("winsecondline"));
                    botom.setText(AmountText("winthirdline"));
                    corn.setText(AmountText("wincorners"));
                    full.setText(AmountText("winfull"));


                    crderly.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (arrayList_blit2.size() == 5) {
                                win("winearlyfive");

                            } else {
                                blite2 = true;
                                imgpush2.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });

                    crdtop.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i = 0;
                            while (i < firstline_b.size()) {
                                if (arrayList_blit2.contains(firstline_b.get(i))) {
                                    trfirst_b.add("tr");
                                }
                                i++;
                            }


                            if (trfirst_b.size() == firstline_b.size()) {
                                win("winfirstline");

                            } else {
                                blite2 = true;
                                imgpush2.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }

                        }
                    });


                    crdmidle.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            int i = 0;
                            while (i < secendlin_b.size()) {
                                if (arrayList_blit2.contains(secendlin_b.get(i))) {
                                    trsecend_b.add("tr");
                                }
                                i++;
                            }


                            if (trsecend_b.size() == secendlin_b.size()) {
                                win("winsecondline");

                            } else {
                                blite2 = true;
                                imgpush2.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });

                    crdbotom.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i = 0;
                            while (i < threeline_b.size()) {
                                if (arrayList_blit2.contains(threeline_b.get(i))) {
                                    trthree_b.add("tr");
                                }
                                i++;
                            }

                            if (trthree_b.size() == threeline_b.size()) {
                                win("winthirdline");

                            } else {
                                blite2 = true;
                                imgpush2.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });

                    crdcorn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i = 0;
                            while (i < corner_b.size()) {
                                if (arrayList_blit2.contains(corner_b.get(i))) {
                                    tr_corner_b.add("tr");
                                }
                                i++;
                            }

                            if (tr_corner_b.size() == corner_b.size()) {
                                win("wincorners");

                            } else {
                                blite2 = true;
                                imgpush2.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }


                        }
                    });

                    crdfull.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (trfirst_b.size() == firstline_b.size() && trsecend_b.size() == secendlin_b.size() && trthree_b.size() == threeline_b.size()) {
                                win("winfull");

                            } else {
                                blite2 = true;
                                imgpush2.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });


                    dialog.show();
                }
            }
        });


        orang3_blite6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite3==false){
                    final BottomSheetDialog dialog = new BottomSheetDialog(play5.this, R.style.BottomSheetDialogTheme);
                    dialog.setContentView(R.layout.sheet_clime);
                    dialog.setCanceledOnTouchOutside(true);

//                case "winearlyfive":
//                factor=0.17;
//                break;
//                case "winfirstline":
//                factor=0.08;
//                break;
//                case "winsecondline":
//                factor=0.08;
//                break;
//                case "winthirdline":
//                factor=0.08;
//                break;
//                case "wincorners":
//                factor=0.08;
//                break;
//                case "winfull":
                    CardView crderly = (CardView) dialog.findViewById(R.id.crderly);
                    CardView crdtop = (CardView) dialog.findViewById(R.id.crdtop);
                    CardView crdbotom = (CardView) dialog.findViewById(R.id.crdbotom);
                    CardView crdmidle = (CardView) dialog.findViewById(R.id.crdmidle);
                    CardView crdcorn = (CardView) dialog.findViewById(R.id.crdcorner);
                    CardView crdfull = (CardView) dialog.findViewById(R.id.crdfull);

                    TextView erly = (TextView) dialog.findViewById(R.id.txterlyfive);
                    TextView top = (TextView) dialog.findViewById(R.id.txttopline);
                    TextView midle = (TextView) dialog.findViewById(R.id.txtmidleline);
                    TextView botom = (TextView) dialog.findViewById(R.id.txtbotomline);
                    TextView corn = (TextView) dialog.findViewById(R.id.txtcorneline);
                    TextView full = (TextView) dialog.findViewById(R.id.txtfullhome);

                    erly.setText(AmountText("winearlyfive"));
                    top.setText(AmountText("winfirstline"));
                    midle.setText(AmountText("winsecondline"));
                    botom.setText(AmountText("winthirdline"));
                    corn.setText(AmountText("wincorners"));
                    full.setText(AmountText("winfull"));


                    crderly.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (arrayList_blit3.size() == 5) {
                                win("winearlyfive");

                            } else {
                                blite3 = true;
                                imgpush3.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });

                    crdtop.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i = 0;
                            while (i < firstline_c.size()) {
                                if (arrayList_blit3.contains(firstline_c.get(i))) {
                                    trfirst_c.add("tr");
                                }
                                i++;
                            }


                            if (trfirst_c.size() == firstline_c.size()) {
                                win("winfirstline");

                            } else {
                                blite3 = true;
                                imgpush3.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }

                        }
                    });


                    crdmidle.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            int i = 0;
                            while (i < secendlin_c.size()) {
                                if (arrayList_blit3.contains(secendlin_c.get(i))) {
                                    trsecend_c.add("tr");
                                }
                                i++;
                            }


                            if (trsecend_c.size() == secendlin_c.size()) {
                                win("winsecondline");

                            } else {
                                blite3 = true;
                                imgpush3.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });

                    crdbotom.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i = 0;
                            while (i < threeline_c.size()) {
                                if (arrayList_blit3.contains(threeline_c.get(i))) {
                                    trthree_c.add("tr");
                                }
                                i++;
                            }

                            if (trthree_c.size() == threeline_c.size()) {
                                win("winthirdline");
                                dialog.dismiss();
                            } else {
                                blite3 = true;
                                imgpush3.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });

                    crdcorn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i = 0;
                            while (i < corner_c.size()) {
                                if (arrayList_blit3.contains(corner_c.get(i))) {
                                    tr_corner_c.add("tr");
                                }
                                i++;
                            }

                            if (tr_corner_c.size() == corner_c.size()) {
                                win("wincorners");

                            } else {
                                blite3 = true;
                                imgpush3.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }


                        }
                    });

                    crdfull.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (trfirst_c.size() == firstline_c.size() && trsecend_c.size() == secendlin_c.size() && trthree_c.size() == threeline_c.size()) {
                                win("winfull");

                            } else {
                                blite3 = true;
                                imgpush3.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });


                    dialog.show();
                }
            }
        });


        orang4_blite6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (blite4==false){

                    final BottomSheetDialog dialog = new BottomSheetDialog(play5.this, R.style.BottomSheetDialogTheme);
                    dialog.setContentView(R.layout.sheet_clime);
                    dialog.setCanceledOnTouchOutside(true);

//                case "winearlyfive":
//                factor=0.17;
//                break;
//                case "winfirstline":
//                factor=0.08;
//                break;
//                case "winsecondline":
//                factor=0.08;
//                break;
//                case "winthirdline":
//                factor=0.08;
//                break;
//                case "wincorners":
//                factor=0.08;
//                break;
//                case "winfull":
                    CardView crderly = (CardView) dialog.findViewById(R.id.crderly);
                    CardView crdtop = (CardView) dialog.findViewById(R.id.crdtop);
                    CardView crdbotom = (CardView) dialog.findViewById(R.id.crdbotom);
                    CardView crdmidle = (CardView) dialog.findViewById(R.id.crdmidle);
                    CardView crdcorn = (CardView) dialog.findViewById(R.id.crdcorner);
                    CardView crdfull = (CardView) dialog.findViewById(R.id.crdfull);

                    TextView erly = (TextView) dialog.findViewById(R.id.txterlyfive);
                    TextView top = (TextView) dialog.findViewById(R.id.txttopline);
                    TextView midle = (TextView) dialog.findViewById(R.id.txtmidleline);
                    TextView botom = (TextView) dialog.findViewById(R.id.txtbotomline);
                    TextView corn = (TextView) dialog.findViewById(R.id.txtcorneline);
                    TextView full = (TextView) dialog.findViewById(R.id.txtfullhome);

                    erly.setText(AmountText("winearlyfive"));
                    top.setText(AmountText("winfirstline"));
                    midle.setText(AmountText("winsecondline"));
                    botom.setText(AmountText("winthirdline"));
                    corn.setText(AmountText("wincorners"));
                    full.setText(AmountText("winfull"));


                    crderly.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (arrayList_blit4.size() == 5) {
                                win("winearlyfive");
                            } else {
                                blite4 = true;
                                imgpush4.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });

                    crdtop.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i = 0;
                            while (i < firstline_d.size()) {
                                if (arrayList_blit4.contains(firstline_d.get(i))) {
                                    trfirst_d.add("tr");
                                }
                                i++;
                            }


                            if (trfirst_d.size() == firstline_d.size()) {
                                win("winfirstline");
                            } else {
                                blite4 = true;
                                imgpush4.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }

                        }
                    });


                    crdmidle.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            int i = 0;
                            while (i < secendlin_d.size()) {
                                if (arrayList_blit4.contains(secendlin_d.get(i))) {
                                    trsecend_d.add("tr");
                                }
                                i++;
                            }


                            if (trsecend_d.size() == secendlin_d.size()) {
                                win("winsecondline");
                            } else {
                                blite4 = true;
                                imgpush4.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });

                    crdbotom.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i = 0;
                            while (i < threeline_d.size()) {
                                if (arrayList_blit4.contains(threeline_d.get(i))) {
                                    trthree_d.add("tr");
                                }
                                i++;
                            }

                            if (trthree_d.size() == threeline_d.size()) {
                                win("winthirdline");
                            } else {
                                blite4 = true;
                                imgpush4.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });

                    crdcorn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i = 0;
                            while (i < corner_d.size()) {
                                if (arrayList_blit4.contains(corner_d.get(i))) {
                                    tr_corner_d.add("tr");
                                }
                                i++;
                            }

                            if (tr_corner_d.size() == corner_d.size()) {
                                win("wincorners");
                            } else {
                                blite4 = true;
                                imgpush4.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }


                        }
                    });

                    crdfull.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (trfirst_d.size() == firstline_d.size() && trsecend_d.size() == secendlin_d.size() && trthree_d.size() == threeline_d.size()) {
                                win("winfull");
                            } else {
                                blite4 = true;
                                imgpush4.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });


                    dialog.show();
                }
            }
        });




        orang5_blite6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (blite5==false){


                    final BottomSheetDialog dialog=new BottomSheetDialog(play5.this,R.style.BottomSheetDialogTheme);
                    dialog.setContentView(R.layout.sheet_clime);
                    dialog.setCanceledOnTouchOutside(true);

//                case "winearlyfive":
//                factor=0.17;
//                break;
//                case "winfirstline":
//                factor=0.08;
//                break;
//                case "winsecondline":
//                factor=0.08;
//                break;
//                case "winthirdline":
//                factor=0.08;
//                break;
//                case "wincorners":
//                factor=0.08;
//                break;
//                case "winfull":
                    CardView crderly=(CardView)dialog.findViewById(R.id.crderly);
                    CardView crdtop=(CardView)dialog.findViewById(R.id.crdtop);
                    CardView crdbotom=(CardView)dialog.findViewById(R.id.crdbotom);
                    CardView crdmidle=(CardView)dialog.findViewById(R.id.crdmidle);
                    CardView crdcorn=(CardView)dialog.findViewById(R.id.crdcorner);
                    CardView crdfull=(CardView)dialog.findViewById(R.id.crdfull);

                    TextView erly=(TextView)dialog.findViewById(R.id.txterlyfive);
                    TextView top=(TextView)dialog.findViewById(R.id.txttopline);
                    TextView midle=(TextView)dialog.findViewById(R.id.txtmidleline);
                    TextView botom=(TextView)dialog.findViewById(R.id.txtbotomline);
                    TextView corn=(TextView)dialog.findViewById(R.id.txtcorneline);
                    TextView full=(TextView)dialog.findViewById(R.id.txtfullhome);

                    erly.setText(AmountText("winearlyfive"));
                    top.setText(AmountText("winfirstline"));
                    midle.setText(AmountText("winsecondline"));
                    botom.setText(AmountText("winthirdline"));
                    corn.setText(AmountText("wincorners"));
                    full.setText(AmountText("winfull"));


                    crderly.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (arrayList_blit5.size()==5){
                                win("winearlyfive");
                            }else {
                                blite5=true;
                                imgpush5.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });

                    crdtop.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i=0;
                            while (i<firstline_e.size()){
                                if (arrayList_blit5.contains( firstline_e.get(i))){
                                    trfirst_e.add("tr");
                                }
                                i++;
                            }



                            if (trfirst_e.size()==firstline_e.size())
                            {
                                win("winfirstline");
                            }else {
                                blite5=true;
                                imgpush5.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }

                        }
                    });


                    crdmidle.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            int i=0;
                            while (i<secendlin_e.size()){
                                if (arrayList_blit5.contains( secendlin_e.get(i))){
                                    trsecend_e.add("tr");
                                }
                                i++;
                            }


                            if (trsecend_e.size()==secendlin_e.size())
                            {
                                win("winsecondline");

                            }else {
                                blite5=true;
                                imgpush5.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });

                    crdbotom.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i=0;
                            while (i<threeline_e.size()){
                                if (arrayList_blit5.contains( threeline_e.get(i))){
                                    trthree_e.add("tr");
                                }
                                i++;
                            }

                            if (trthree_e.size()==threeline_e.size())
                            {
                                win("winthirdline");

                            }else {
                                blite5=true;
                                imgpush5.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });

                    crdcorn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int i=0;
                            while (i<corner_e.size()){
                                if (arrayList_blit5.contains( corner_e.get(i))){
                                    tr_corner_e.add("tr");
                                }
                                i++;
                            }

                            if (tr_corner_e.size()==corner_e.size()){
                                win("wincorners");

                            }else {
                                blite5=true;
                                imgpush5.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }


                        }
                    });

                    crdfull.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (trfirst_e.size()==firstline_e.size()&&trsecend_e.size()==secendlin_e.size()&&trthree_e.size()==threeline_e.size()) {
                                win("winfull");

                            }else {
                                blite5=true;
                                imgpush5.setBackgroundResource(R.drawable.pushing);
                                dialog.dismiss();
                            }
                        }
                    });



                    dialog.show();
                }
            }
        });









    }
    @Override
    protected void onDestroy() {
        webSocketClient.close();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        webSocketClient.close();
        super.onStop();
    }
    public void sale(String amount,boolean salee){
        String type = null;
        if (salee){
            type="sell";
        }else {
            type="charge";
        }
        String url="Http://185.255.89.127:8081/apibazi/changeCrisp/";
        String finalType = type;
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("kosres",response );
                try {
                    JSONObject jsonObjec=new JSONObject(response);
                    String statu=jsonObjec.getString("status");

                    if (statu.equals("ok")){
                        //   dialogpross.dismiss();
                        String currentCrips=jsonObjec.getString("currentCrips");
                        Sqlitechild sqlite=new Sqlitechild(getApplicationContext());
                        sqlite.dellsece();


                        sqlite.insertsece(currentCrips);
                        //  Toast.makeText(Play.this, "Good luck", Toast.LENGTH_SHORT).show();
                        // startActivity(new Intent(Play.this,Play.class).putExtra("numberticket","1"));

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("stuf", error.toString() );
                //dialogpross.dismiss();
                Toast.makeText(play5.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String> params=new HashMap<String, String>();
                params.put("token",token);
                params.put("amount",amount);
                params.put("type", finalType);
                return params;
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
    public static JSONObject updatejson(JSONObject obj, String keyMain,String valueMain, JSONObject newValue) throws Exception {
        // We need to know keys of Jsonobject
        JSONObject json = new JSONObject();
        Iterator iterator = obj.keys();
        String key = null;
        while (iterator.hasNext()) {
            key = (String) iterator.next();
            // if object is just string we change value in key
            if ((obj.optJSONArray(key)==null) && (obj.optJSONObject(key)==null)) {
                if ((key.equals(keyMain)) && (obj.get(key).toString().equals(valueMain))) {
                    // put new value
                    obj.put(key, newValue);
                    return obj;
                }
            }

            // if it's jsonobject
            if (obj.optJSONObject(key) != null) {
                updatejson(obj.getJSONObject(key), keyMain, valueMain, newValue);
            }

            // if it's jsonarray
            if (obj.optJSONArray(key) != null) {
                JSONArray jArray = obj.getJSONArray(key);
                for (int i=0;i<jArray.length();i++) {
                    updatejson(jArray.getJSONObject(i), keyMain, valueMain, newValue);
                }
            }
        }
        return obj;
    }
    public void win(String key){
        try {
            if (jsonwin.getString(key).equals("")){
                Log.e("kosrtr", "if true ");
                JSONObject jsonessagee=new JSONObject();
                JSONObject jsonwinn=new JSONObject();
                jsonwinn.put(key,new JSONObject().put("token",token).put("name",name).put("image",image));
                jsonessagee.put("message",jsonwinn);
                webSocketClient.send(jsonessagee.toString());
                int wholechips = 0;
                double factor=0;
                int i=0;
                Log.e("kosr", jsonArray.toString() );
                while (i<jsonArray.length()){
                    int tickt= Integer.parseInt(new JSONObject(jsonArray.getString(i)).getString("tc"));
                    Log.e("kospar", String.valueOf(tickt));

                    wholechips+=tickt;
                    Log.e("kosparwhole", String.valueOf(wholechips));
                    i++;
                }
                switch (key){
                    case "winearlyfive":
                        factor=0.17;
                        break;
                    case "winfirstline":
                        factor=0.08;
                        break;
                    case "winsecondline":
                        factor=0.08;
                        break;
                    case "winthirdline":
                        factor=0.08;
                        break;
                    case "wincorners":
                        factor=0.08;
                        break;
                    case "winfull":
                        factor=0.34;
                        break;


                }
                int amount= (int) ((wholechips*factor)*10);
                Log.e("kosparwholechips", String.valueOf(wholechips) );
                Log.e("kosparfactor", String.valueOf(factor) );
                Log.e("kosparamount", String.valueOf(amount) );
                sale(String.valueOf(amount),false);
            }else {
                switch (key){
                    case "winearlyfive":
                        Toast.makeText(this, "Win erly five faild", Toast.LENGTH_SHORT).show();
                        break;
                    case "winfirstline":
                        Toast.makeText(this, "Win top line faild", Toast.LENGTH_SHORT).show();
                        break;
                    case "winsecondline":
                        Toast.makeText(this, "Win midle line faild", Toast.LENGTH_SHORT).show();
                        break;
                    case "winthirdline":
                        Toast.makeText(this, "Win botom line faild", Toast.LENGTH_SHORT).show();
                        break;
                    case "wincorners":
                        Toast.makeText(this, "Win corners faild", Toast.LENGTH_SHORT).show();
                        break;
                    case "winfull":
                        Toast.makeText(this, "Win full home faild", Toast.LENGTH_SHORT).show();
                        break;
                }}
        } catch (JSONException e) {
            Log.e("kosrtr", e.toString());
            e.printStackTrace();
        }
    }
    public void checkwin(){
        Log.e("kos251", "checkwin: ");
        try {
            if (random.size()==90){
                Handler handler=new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        com.example.tambola.play5.this.finish();
                        Toast.makeText(play5.this, "Game Over", Toast.LENGTH_SHORT).show();

                    }
                },10000);
            }

        }
        catch (Exception e) {
            Log.e("kos251", e.toString());
            e.printStackTrace();
        }
    }
//


//        }
//    }
//

//    public void Cornerwin(){
//
//
//        int i=0;
//        while (i<corner_a.size()){
//            if (arrayList_blit1.contains( corner_a.get(i))){
//                tr_corner_a.add("tr");
//            }
//            i++;
//        }
//
//        int ib=0;
//        while (ib<corner_b.size()){
//            if (arrayList_blit2.contains( corner_b.get(ib))){
//                tr_corner_b.add("tr");
//            }
//            ib++;
//        }
//
//        int ic=0;
//        while (ib<corner_c.size()){
//            if (arrayList_blit3.contains( corner_c.get(ic))){
//                tr_corner_c.add("tr");
//            }
//            ic++;
//        }
//
//        int id=0;
//        while (ib<corner_d.size()){
//            if (arrayList_blit4.contains( corner_d.get(id))){
//                tr_corner_d.add("tr");
//            }
//            id++;
//        }
//
//        int ie=0;
//        while (ib<corner_e.size()){
//            if (arrayList_blit5.contains( corner_e.get(ie))){
//                tr_corner_e.add("tr");
//            }
//            ie++;
//        }
//
//
//        if (tr_corner_a.size()==corner_a.size()){
//            win("wincorners");
//        }
//
//        else if(tr_corner_b.size()==corner_b.size()){
//            win("wincorners");
//
//        }
//        else if (tr_corner_c.size()==corner_c.size()){
//            win("wincorners");
//        }
//
//        else if (tr_corner_d.size()==corner_d.size()){
//            win("wincorners");
//        }
//        else if (tr_corner_e.size()==corner_e.size()){
//            win("wincorners");
//        }
//
//
//    }
//    public void Erlyfivewin(){
//        if (arrayList_blit1.size()==5){
//            win("winearlyfive");
//        }else if (arrayList_blit2.size()==5){
//            win("winearlyfive");
//        }else if (arrayList_blit3.size()==5){
//            win("winearlyfive");
//        }else if (arrayList_blit4.size()==5){
//            win("winearlyfive");
//        }else if (arrayList_blit5.size()==5){
//            win("winearlyfive");
//        }
//    }
//    public void Fierstlinewin(){
//
//        int i=0;
//        while (i<firstline_a.size()){
//            if (arrayList_blit1.contains( firstline_a.get(i))){
//                trfirst_a.add("tr");
//            }
//            i++;
//        }
//
//        int ib=0;
//        while (ib<firstline_b.size()){
//            if (arrayList_blit2.contains( firstline_b.get(ib))){
//                trfirst_b.add("tr");
//            }
//            ib++;
//        }
//
//        int ic=0;
//        while (ib<firstline_c.size()){
//            if (arrayList_blit3.contains( firstline_c.get(ic))){
//                trfirst_c.add("tr");
//            }
//            ic++;
//        }
//
//        int id=0;
//        while (ib<firstline_d.size()){
//            if (arrayList_blit4.contains( firstline_d.get(id))){
//                trfirst_d.add("tr");
//            }
//            id++;
//        }
//
//        int ie=0;
//        while (ib<firstline_e.size()){
//            if (arrayList_blit5.contains( firstline_e.get(ie))){
//                trfirst_e.add("tr");
//            }
//            ie++;
//        }
//
//
//        if (trfirst_a.size()==firstline_a.size())
//        {
//            win("winfirstline");
//        }
//        else if (trfirst_b.size()==firstline_b.size()){
//            win("winfirstline");
//        }
//        else if (trfirst_c.size()==firstline_c.size()){
//            win("winfirstline");
//        }
//        else if (trfirst_d.size()==firstline_d.size()){
//            win("winfirstline");
//        }
//        else if (trfirst_e.size()==firstline_e.size()){
//            win("winfirstline");
//        }
//
//    }
//    public void Secendlinewin(){
//
//
//        int i=0;
//        while (i<secendline_a.size()){
//            if (arrayList_blit1.contains( secendline_a.get(i))){
//                trsecend_a.add("tr");
//            }
//            i++;
//        }
//
//        int ib=0;
//        while (ib<secendlin_b.size()){
//            if (arrayList_blit2.contains( secendlin_b.get(ib))){
//                trsecend_b.add("tr");
//            }
//            ib++;
//        }
//
//        int ic=0;
//        while (ib<secendlin_c.size()){
//            if (arrayList_blit3.contains( secendlin_c.get(ic))){
//                trsecend_c.add("tr");
//            }
//            ic++;
//        }
//
//        int id=0;
//        while (ib<secendlin_d.size()){
//            if (arrayList_blit4.contains( secendlin_d.get(id))){
//                trsecend_d.add("tr");
//            }
//            id++;
//        }
//
//        int ie=0;
//        while (ib<secendlin_e.size()){
//            if (arrayList_blit5.contains( secendlin_e.get(ie))){
//                trsecend_e.add("tr");
//            }
//            ie++;
//        }
//
//
//
//        if (trsecend_a.size()==secendline_a.size())
//        {
//            win("winsecondline");
//        }
//        else if (trsecend_b.size()==secendlin_b.size()){
//            win("winsecondline");
//        }
//        else if (trsecend_c.size()==secendlin_c.size()){
//            win("winsecondline");
//        }else if (trsecend_d.size()==secendlin_d.size()){
//            win("winsecondline");
//        }else if (trsecend_e.size()==secendlin_e.size()){
//            win("winsecondline");
//        }
//    }
//    public void Threelinewin(){
//
//
//        int i=0;
//        while (i<threeline_a.size()){
//            if (arrayList_blit1.contains( threeline_a.get(i))){
//                trthree_a.add("tr");
//            }
//            i++;
//        }
//
//        int ib=0;
//        while (ib<threeline_b.size()){
//            if (arrayList_blit2.contains( threeline_b.get(ib))){
//                trthree_b.add("tr");
//            }
//            ib++;
//        }
//
//        int ic=0;
//        while (ib<threeline_c.size()){
//            if (arrayList_blit3.contains( threeline_c.get(ic))){
//                trthree_c.add("tr");
//            }
//            ic++;
//        }
//
//        int id=0;
//        while (ib<threeline_d.size()){
//            if (arrayList_blit4.contains( threeline_d.get(id))){
//                trthree_d.add("tr");
//            }
//            id++;
//        }
//
//        int ie=0;
//        while (ib<threeline_e.size()){
//            if (arrayList_blit5.contains( threeline_e.get(ie))){
//                trthree_e.add("tr");
//            }
//            ie++;
//        }
//
//
//
//        if (trthree_a.size()==threeline_a.size())
//        {
//            win("winthirdline");
//        }
//        else if (trthree_b.size()==threeline_b.size()){
//            win("winthirdline");
//        }
//        else if (trthree_c.size()==threeline_c.size()){
//            win("winthirdline");
//        }
//        else if (trthree_d.size()==threeline_d.size()){
//            win("winthirdline");
//        }
//        else if (trthree_e.size()==threeline_e.size()){
//            win("winthirdline");
//        }
//    }
//    public void Fullewin() {
//
//        if (trfirst_a.size()==firstline_a.size()&&trsecend_a.size()==secendline_a.size()&&trthree_a.size()==threeline_a.size()) {
//            win("winfull");
//        }
//        else if (trfirst_b.size()==firstline_b.size()&&trsecend_b.size()==secendlin_b.size()&&trthree_b.size()==threeline_b.size()) {
//            win("winfull");
//        }
//        else if (trfirst_c.size()==firstline_c.size()&&trsecend_c.size()==secendlin_c.size()&&trthree_c.size()==threeline_c.size()) {
//            win("winfull");
//        }
//        else if (trfirst_d.size()==firstline_d.size()&&trsecend_d.size()==secendlin_d.size()&&trthree_d.size()==threeline_d.size()) {
//            win("winfull");
//        }
//        else if (trfirst_e.size()==firstline_e.size()&&trsecend_e.size()==secendlin_e.size()&&trthree_e.size()==threeline_e.size()){
//            win("winfull");
//        }
//
//    }
    public static Bitmap getBitmap(String encodedImage)
    {
        byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
        return (BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length));
    }
    public void getrandomnumber(){
        Random rand2 = new Random();
        int a=rand2.nextInt(90)+1;
        if (random.contains(String.valueOf(a))){
            getrandomnumber();
        }else {
            random.add(String.valueOf(a));
            JSONObject jsonObject1coler=new JSONObject();
            try {
                jsonObject1coler.put("number",a);
                JSONObject jsonsend=new JSONObject();
                jsonsend.put("message",jsonObject1coler);
//                                    Log.e("kos", jsonsend.toString() );
                webSocketClient.send(jsonsend.toString());


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
//    public void getrandomnumber_b(TextView view){
//        Random rand2 = new Random();
//        int a=rand2.nextInt(90)+1;
//        if (arrayList_b.contains(String.valueOf(a))){
//            getrandomnumber_b(view);
//        }else {
//            arrayList_b.add(String.valueOf(a));
//            view.setText(String.valueOf(a));
//        }
//
//    }

    public String AmountText(String key){
        try {
            int wholechips = 0;
            double factor=0;
            int i=0;
            while (i<jsonArray.length()){


                int  tickt = Integer.parseInt(new JSONObject(jsonArray.getString(i)).getString("tc"));


                Log.e("kospar", String.valueOf(tickt));

                wholechips+=tickt;
                Log.e("kosparwhole", String.valueOf(wholechips));
                i++;
            }

            switch (key){
                case "winearlyfive":
                    factor=0.17;
                    break;
                case "winfirstline":
                    factor=0.08;
                    break;
                case "winsecondline":
                    factor=0.08;
                    break;
                case "winthirdline":
                    factor=0.08;
                    break;
                case "wincorners":
                    factor=0.08;
                    break;
                case "winfull":
                    factor=0.34;
                    break;
            }
            int amount= (int) ((wholechips*factor)*10);
            am=String.valueOf(amount);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return am;
    }





    public void generaterandom(int i,ArrayList<String> adad){
        int random= new Random().nextInt(9)+1;
        if (adad.size()==0){
            random=1;
        }else if (adad.size()==1){
            random=9;
        }
        // int random= new Random().nextInt(9)+1;
        if (adad.contains(String.valueOf(random))){
            generaterandom(i,adad);
        }else {
            adad.add(String.valueOf(random));
            String position= String.valueOf(random+(i*9));
            generateadadasli(random,position,i);
        }

    }
    public void generateadadasli(int random,String position,int i) {
        int random2 = new Random().nextInt(10) + 1;
        String adadasli = String.valueOf(((random - 1) * 10) + random2);
        if (ticketNumber.contains(adadasli)) {
            generateadadasli(random, position, i);
        } else {
            ticketNumber.add(adadasli);
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("position", String.valueOf(random));
                jsonObject.put("number", adadasli);
                jsonObject.put("ticketNo", String.valueOf((i / 3) + 1));
                jsonObject.put("row", String.valueOf((i % 3) + 1));
                jsonlist.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.e("position", "position : " + position + "\n" + "adad : " + adadasli);

            switch (position) {
                case "1":
                    txt1.setText(adadasli);
                    firstline_a.add(1);
                    corner_a.add(1);
                    break;
                case "2":
                    txt2.setText(adadasli);
                    firstline_a.add(2);
                    break;
                case "3":
                    txt3.setText(adadasli);
                    firstline_a.add(3);
                    break;
                case "4":
                    txt4.setText(adadasli);
                    firstline_a.add(4);
                    break;
                case "5":
                    txt5.setText(adadasli);
                    firstline_a.add(5);
                    break;
                case "6":
                    txt6.setText(adadasli);
                    firstline_a.add(6);
                    break;
                case "7":
                    txt7.setText(adadasli);
                    firstline_a.add(7);
                    break;
                case "8":
                    txt8.setText(adadasli);
                    firstline_a.add(8);
                    break;
                case "9":
                    txt9.setText(adadasli);
                    firstline_a.add(9);
                    corner_a.add(9);
                    break;
                case "10":
                    txt10.setText(adadasli);
                    secendline_a.add(10);
                    break;
                case "11":
                    txt11.setText(adadasli);
                    secendline_a.add(11);
                    break;
                case "12":
                    txt12.setText(adadasli);
                    secendline_a.add(12);
                    break;
                case "13":
                    txt13.setText(adadasli);
                    secendline_a.add(13);
                    break;
                case "14":
                    txt14.setText(adadasli);
                    secendline_a.add(14);
                    break;
                case "15":
                    txt15.setText(adadasli);
                    secendline_a.add(15);
                    break;
                case "16":
                    txt16.setText(adadasli);
                    secendline_a.add(16);
                    break;
                case "17":
                    txt17.setText(adadasli);
                    secendline_a.add(17);
                    break;
                case "18":
                    txt18.setText(adadasli);
                    secendline_a.add(18);
                    break;
                case "19":
                    txt19.setText(adadasli);
                    threeline_a.add(19);
                    corner_a.add(19);
                    break;
                case "20":
                    txt20.setText(adadasli);
                    threeline_a.add(20);
                    break;
                case "21":
                    txt21.setText(adadasli);
                    threeline_a.add(21);
                    break;
                case "22":
                    txt22.setText(adadasli);
                    threeline_a.add(22);
                    break;
                case "23":
                    txt23.setText(adadasli);
                    threeline_a.add(23);
                    break;
                case "24":
                    txt24.setText(adadasli);
                    threeline_a.add(24);
                    break;
                case "25":
                    txt25.setText(adadasli);
                    threeline_a.add(25);
                    break;
                case "26":
                    txt26.setText(adadasli);
                    threeline_a.add(26);
                    break;
                case "27":
                    txt27.setText(adadasli);
                    threeline_a.add(27);
                    corner_a.add(27);
                    break;


                case "28":
                    txt1b.setText(adadasli);
                    firstline_b.add(28);
                    corner_b.add(28);
                    break;

                case "29":
                    txt2b.setText(adadasli);
                    firstline_b.add(29);
                    break;

                case "30":
                    txt3b.setText(adadasli);
                    firstline_b.add(30);
                    break;

                case "31":
                    txt4b.setText(adadasli);
                    firstline_b.add(31);
                    break;

                case "32":
                    txt5b.setText(adadasli);
                    firstline_b.add(32);
                    break;

                case "33":
                    txt6b.setText(adadasli);
                    firstline_b.add(33);
                    break;

                case "34":
                    txt7b.setText(adadasli);
                    firstline_b.add(34);
                    break;

                case "35":
                    txt8b.setText(adadasli);
                    firstline_b.add(35);
                    break;

                case "36":
                    txt9b.setText(adadasli);
                    firstline_b.add(36);
                    corner_b.add(36);
                    break;

                case "37":
                    txt10b.setText(adadasli);
                    secendlin_b.add(37);
                    break;

                case "38":
                    txt11b.setText(adadasli);
                    secendlin_b.add(38);
                    break;

                case "39":
                    txt12b.setText(adadasli);
                    secendlin_b.add(39);
                    break;

                case "40":
                    txt13b.setText(adadasli);
                    secendlin_b.add(40);
                    break;

                case "41":
                    txt14b.setText(adadasli);
                    secendlin_b.add(41);
                    break;

                case "42":
                    txt15b.setText(adadasli);
                    secendlin_b.add(42);
                    break;

                case "43":
                    txt16b.setText(adadasli);
                    secendlin_b.add(43);
                    break;

                case "44":
                    txt17b.setText(adadasli);
                    secendlin_b.add(44);
                    break;

                case "45":
                    txt18b.setText(adadasli);
                    secendlin_b.add(45);
                    break;

                case "46":
                    txt19b.setText(adadasli);
                    threeline_b.add(46);
                    corner_b.add(46);
                    break;

                case "47":
                    txt20b.setText(adadasli);
                    threeline_b.add(47);
                    break;

                case "48":
                    txt21b.setText(adadasli);
                    threeline_b.add(48);
                    break;
                case "49":
                    txt22b.setText(adadasli);
                    threeline_b.add(49);
                    break;

                case "50":
                    txt23b.setText(adadasli);
                    threeline_b.add(50);
                    break;

                case "51":
                    txt24b.setText(adadasli);
                    threeline_b.add(51);
                    break;

                case "52":
                    txt25b.setText(adadasli);
                    threeline_b.add(52);
                    break;

                case "53":
                    txt26b.setText(adadasli);
                    threeline_b.add(53);
                    break;

                case "54":
                    txt27b.setText(adadasli);
                    threeline_b.add(54);
                    corner_b.add(54);
                    break;


                case "55":
                    txt1c.setText(adadasli);
                    firstline_c.add(55);
                    corner_c.add(55);
                    break;

                case "56":
                    txt2c.setText(adadasli);
                    firstline_c.add(56);
                    break;

                case "57":
                    txt3c.setText(adadasli);
                    firstline_c.add(57);
                    break;

                case "58":
                    txt4c.setText(adadasli);
                    firstline_c.add(58);
                    break;

                case "59":
                    txt5c.setText(adadasli);
                    firstline_c.add(59);
                    break;

                case "60":
                    txt6c.setText(adadasli);
                    firstline_c.add(60);
                    break;

                case "61":
                    txt7c.setText(adadasli);
                    firstline_c.add(61);
                    break;

                case "62":
                    txt8c.setText(adadasli);
                    firstline_c.add(62);
                    break;

                case "63":
                    txt9c.setText(adadasli);
                    firstline_c.add(position);
                    corner_c.add(63);
                    break;

                case "64":
                    txt10c.setText(adadasli);
                    secendlin_c.add(64);
                    break;

                case "65":
                    txt11c.setText(adadasli);
                    secendlin_c.add(65);
                    break;

                case "66":
                    txt12c.setText(adadasli);
                    secendlin_c.add(66);
                    break;

                case "67":
                    txt13c.setText(adadasli);
                    secendlin_c.add(67);
                    break;

                case "68":
                    txt14c.setText(adadasli);
                    secendlin_c.add(68);
                    break;

                case "69":
                    txt15c.setText(adadasli);
                    secendlin_c.add(69);
                    break;

                case "70":
                    txt16c.setText(adadasli);
                    secendlin_c.add(70);
                    break;

                case "71":
                    txt17c.setText(adadasli);
                    secendlin_c.add(71);
                    break;

                case "72":
                    txt18c.setText(adadasli);
                    secendlin_c.add(72);
                    break;

                case "73":
                    txt19c.setText(adadasli);
                    threeline_c.add(73);
                    corner_c.add(73);
                    break;

                case "74":
                    txt20c.setText(adadasli);
                    threeline_c.add(74);
                    break;

                case "75":
                    txt21c.setText(adadasli);
                    threeline_c.add(75);
                    break;

                case "76":
                    txt22c.setText(adadasli);
                    threeline_c.add(76);
                    break;

                case "77":
                    txt23c.setText(adadasli);
                    threeline_c.add(77);
                    break;

                case "78":
                    txt24c.setText(adadasli);
                    threeline_c.add(78);
                    break;

                case "79":
                    txt25c.setText(adadasli);
                    threeline_c.add(79);
                    break;

                case "80":
                    txt26c.setText(adadasli);
                    threeline_c.add(80);
                    break;
                case "81":
                    txt27c.setText(adadasli);
                    threeline_c.add(81);
                    corner_c.add(81);
                    break;


                case "82":
                    txt1d.setText(adadasli);
                    firstline_d.add(82);
                    corner_d.add(82);
                    break;

                case "83":
                    txt2d.setText(adadasli);
                    firstline_d.add(83);
                    break;

                case "84":
                    txt3d.setText(adadasli);
                    firstline_d.add(84);
                    break;

                case "85":
                    txt4d.setText(adadasli);
                    firstline_d.add(85);
                    break;

                case "86":
                    txt5d.setText(adadasli);
                    firstline_d.add(86);
                    break;

                case "87":
                    txt6d.setText(adadasli);
                    firstline_d.add(87);
                    break;

                case "88":
                    txt7d.setText(adadasli);
                    firstline_d.add(88);
                    break;

                case "89":
                    txt8d.setText(adadasli);
                    firstline_d.add(89);
                    break;

                case "90":
                    txt9d.setText(adadasli);
                    firstline_d.add(90);
                    corner_d.add(90);
                    break;

                case "91":
                    txt10d.setText(adadasli);
                    secendlin_d.add(91);
                    break;

                case "92":
                    txt11d.setText(adadasli);
                    secendlin_d.add(92);
                    break;

                case "93":
                    txt12d.setText(adadasli);
                    secendlin_d.add(93);
                    break;

                case "94":
                    txt13d.setText(adadasli);
                    secendlin_d.add(94);
                    break;

                case "95":
                    txt14d.setText(adadasli);
                    secendlin_d.add(95);
                    break;

                case "96":
                    txt15d.setText(adadasli);
                    secendlin_d.add(96);
                    break;

                case "97":
                    txt16d.setText(adadasli);
                    secendlin_d.add(97);
                    break;

                case "98":
                    txt17d.setText(adadasli);
                    secendlin_d.add(98);
                    break;

                case "99":
                    txt18d.setText(adadasli);
                    secendlin_d.add(99);
                    break;

                case "100":
                    txt19d.setText(adadasli);
                    threeline_d.add(100);
                    corner_d.add(100);
                    break;

                case "101":
                    txt20d.setText(adadasli);
                    threeline_d.add(101);
                    break;
                case "102":
                    txt21d.setText(adadasli);
                    threeline_d.add(102);
                    break;

                case "103":
                    txt22d.setText(adadasli);
                    threeline_d.add(103);
                    break;

                case "104":
                    txt23d.setText(adadasli);
                    threeline_d.add(104);
                    break;

                case "105":
                    txt24d.setText(adadasli);
                    threeline_d.add(105);
                    break;

                case "106":
                    txt25d.setText(adadasli);
                    threeline_d.add(106);
                    break;

                case "107":
                    txt26d.setText(adadasli);
                    threeline_d.add(107);
                    break;

                case "108":
                    txt27d.setText(adadasli);
                    threeline_d.add(108);
                    corner_d.add(108);
                    break;




                case "109":
                    txt1e.setText(adadasli);
                    firstline_e.add(109);
                    corner_e.add(109);
                    break;

                case "110":
                    txt2e.setText(adadasli);
                    firstline_e.add(110);
                    break;

                case "111":
                    txt3e.setText(adadasli);
                    firstline_e.add(111);
                    break;

                case "112":
                    txt4e.setText(adadasli);
                    firstline_e.add(112);
                    break;

                case "113":
                    txt5e.setText(adadasli);
                    firstline_e.add(113);
                    break;

                case "114":
                    txt6e.setText(adadasli);
                    firstline_e.add(114);
                    break;

                case "115":
                    txt7e.setText(adadasli);
                    firstline_e.add(115);
                    break;

                case "116":
                    txt8e.setText(adadasli);
                    firstline_e.add(116);
                    break;

                case "117":
                    txt9e.setText(adadasli);
                    firstline_e.add(117);
                    corner_e.add(117);
                    break;

                case "118":
                    txt10e.setText(adadasli);
                    secendlin_e.add(118);
                    break;

                case "119":
                    txt11e.setText(adadasli);
                    secendlin_e.add(119);
                    break;

                case "120":
                    txt12e.setText(adadasli);
                    secendlin_e.add(120);
                    break;

                case "121":
                    txt13e.setText(adadasli);
                    secendlin_e.add(121);
                    break;

                case "122":
                    txt14e.setText(adadasli);
                    secendlin_e.add(122);
                    break;

                case "123":
                    txt15e.setText(adadasli);
                    secendlin_e.add(123);
                    break;

                case "124":
                    txt16e.setText(adadasli);
                    secendlin_e.add(124);
                    break;

                case "125":
                    txt17e.setText(adadasli);
                    secendlin_e.add(125);
                    break;

                case "126":
                    txt18e.setText(adadasli);
                    secendlin_e.add(126);
                    break;

                case "127":
                    txt19e.setText(adadasli);
                    threeline_e.add(127);
                    corner_e.add(127);
                    break;

                case "128":
                    txt20e.setText(adadasli);
                    threeline_e.add(128);
                    break;

                case "129":
                    txt21e.setText(adadasli);
                    threeline_e.add(129);
                    break;

                case "130":
                    txt22e.setText(adadasli);
                    threeline_e.add(130);
                    break;

                case "131":
                    txt23e.setText(adadasli);
                    threeline_e.add(131);
                    break;

                case "132":
                    txt24e.setText(adadasli);
                    threeline_e.add(132);
                    break;

                case "133":
                    txt25e.setText(adadasli);
                    threeline_e.add(133);
                    break;

                case "134":
                    txt26e.setText(adadasli);
                    threeline_e.add(134);
                    break;

                case "135":
                    txt27e.setText(adadasli);
                    threeline_e.add(135);
                    corner_e.add(135);
                    break;








            }
        }
    }
}