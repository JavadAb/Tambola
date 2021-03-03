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
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


//import com.github.nkzawa.emitter.Emitter;
//import com.github.nkzawa.socketio.client.IO;
//import com.github.nkzawa.socketio.client.Socket;

//import org.java_websocket.client.WebSocketClient;
//import org.java_websocket.handshake.ServerHandshake;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.JsonObject;

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


public class Play extends AppCompatActivity {

    String am;
    int ggg=0;
    TextView tik,tedadcheeps;
    boolean isadmin=false;
    ArrayList<String> ticketNumber;
    JSONArray jsonlist;

    ImageView imgpush;
    startActivitys startActivitys;
    boolean blite1=false;
    TextView adad;
//    Socket socket;
    Handler handler;
    String corn1,corn2,corn3,corn4;
    String erly1,erly2,erly3,erly4,erly5;
    String a1,a2,a3,a4,a5,a6,a7,a8,a9;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    String c1,c2,c3,c4,c5,c6,c7,c8,c9;
    JSONArray jsonArray;
    JSONObject jsonwin;
    String token,name;
    TextView x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11,x12,x13,x14,x15,x16,x17,x18,x19,x20,x21,x22,x23,x24,x25,x26,x27,x28,x29,x30,x31,x32,x33,x34,x35,x36,x37,x38,x39,x40,x41,x42,x43,x44,x45,x46,x47,x48,x49,x50,x51,x52,x53,x54,x55,x56,x57,x58,x59,x60,x61,x62,x63,x64,x65,x66,x67,x68,x69,x70,x71,x72,x73,x74,x75,x76,x77,x78,x79,x80,x81,x82,x83,x84,x85,x86,x87,x88,x89,x90;

    ArrayList<Object> arrayList_b;
    boolean startgame=false;
  String wincorner,winerlyfive,winsath1,winsath2,winsath3;
  JSONObject jsonObjectwinnn;
    ImageView play1,play2,play3,play4,load;
    TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,txt12,txt13,txt14,txt15,txt16,txt17,txt18,txt19,txt20,txt21,txt22,txt23,txt24,txt25,txt26,txt27;
    ArrayList<Integer> arrayList,arrayList2;
    ArrayList<Object> chans;
    ArrayList<Object> firstline_a;
    ArrayList<Object> secendline_a;
    ArrayList<Object> threeline_a;
    ArrayList<Object> corner_a;

    String adadfinal;
    boolean first=false;
    private WebSocketClient webSocketClient=null;
    private int delay=7000;
     String image;
    private String ticket;
    TextView txtcorner,txterly,txtfierstline,txtsecendline,txtthreeline,txtfull;
    private ImageView play5,play6;
    boolean canscel=false;

    ArrayList<Object> trfirst_a;

    ArrayList<Object> trsecend_a;


    ArrayList<Object> trthree_a;


    ArrayList<Object> tr_full_a;

    ArrayList<Object> tr_corner_a;
    ArrayList<String> random;
     TextView oran1blit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ProgressDialog dialogpross = new ProgressDialog(Play.this);
        dialogpross.setMessage("Please wait..");
        dialogpross.show();
        dialogpross.setCancelable(false);
        dialogpross.setCanceledOnTouchOutside(false);

        tik=(TextView)findViewById(R.id.ttdddttdd);
        tedadcheeps=(TextView)findViewById(R.id.tiketzarb);
         startActivitys=new startActivitys();

        ticketNumber=new ArrayList<String>();
        jsonlist=new JSONArray();

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
         random=new ArrayList<>();

        tr_full_a=new ArrayList<>();

        trfirst_a=new ArrayList<>();

        trsecend_a=new ArrayList<>();

        trthree_a=new ArrayList<>();

        tr_corner_a=new ArrayList<>();

        corner_a=new ArrayList<>();


        firstline_a=new ArrayList<>();


        secendline_a=new ArrayList<>();


        threeline_a=new ArrayList<>();




        URI uri = null;

        txtcorner=(TextView)findViewById(R.id.txtwincorner);
        txterly=(TextView)findViewById(R.id.txtwinerlyfive);
        txtfierstline=(TextView)findViewById(R.id.txtwinfirstline);
        txtsecendline=(TextView)findViewById(R.id.txtwinsecendline);
        txtthreeline=(TextView)findViewById(R.id.txtwinthreline);
        txtfull=(TextView)findViewById(R.id.txtwinful);

        adad=(TextView)findViewById(R.id.numbersite);

        play1=(ImageView)findViewById(R.id.player1);
        play2=(ImageView)findViewById(R.id.player2);
        play3=(ImageView)findViewById(R.id.player3);
        play4=(ImageView)findViewById(R.id.player4);
        play5=(ImageView)findViewById(R.id.player5);
        play6=(ImageView)findViewById(R.id.player6);



        jsonArray=new JSONArray();
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

//46e55d07aa188c1a33648b854cc640a2
//48e7938dd4278c886f2dff7ca537987d
//4be8736d13c32bd95538e6a080ebcd76
//efa6377f07c5c38dc871ef97ca8ca664
        //e3f7c7433604664a50c258bd7a4073c1
        //fd01bef6309e26a6c4bb19090203c367

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
                                Toast.makeText(Play.this, nm+" "+"Win erly five", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(Play.this, nm+" "+"Win top line", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(Play.this, nm+" "+"Win midle line", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(Play.this, nm+" "+"Win botom line", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(Play.this, nm+" "+"Win corners", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(Play.this, nm+" "+"Win full home", Toast.LENGTH_SHORT).show();
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
                                startActivitys.set(Play.this,adad,R.anim.animzoomin);
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
                            });
                        }


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


                    else if (jso.get("message").equals("Left Chat")){
                        Play.this.finish();
                    }




                } catch (JSONException e) {
                    Log.e("kos545", e.toString() );
                    e.printStackTrace();
                }}









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
                Log.e("kos876", e.toString() );

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
     chans=new ArrayList<>();





        txt1=(TextView)findViewById(R.id.txt1_blit1);
        txt2=(TextView)findViewById(R.id.txt2_blit1);
        txt3=(TextView)findViewById(R.id.txt3_blit1);
        txt4=(TextView)findViewById(R.id.txt4_blit1);
        txt5=(TextView)findViewById(R.id.txt5_blit1);
        txt6=(TextView)findViewById(R.id.txt6_blit1);
        txt7=(TextView)findViewById(R.id.txt7_blit1);
        txt8=(TextView)findViewById(R.id.txt8_blit1);
        txt9=(TextView)findViewById(R.id.txt9_blit1);
        txt10=(TextView)findViewById(R.id.txt10_blit1);
        txt11=(TextView)findViewById(R.id.txt11_blit1);
        txt12=(TextView)findViewById(R.id.txt12_blit1);
        txt13=(TextView)findViewById(R.id.txt13_blit1);
        txt14=(TextView)findViewById(R.id.txt14_blit1);
        txt15=(TextView)findViewById(R.id.txt15_blit1);
        txt16=(TextView)findViewById(R.id.txt16_blit1);
        txt17=(TextView)findViewById(R.id.txt17_blit1);
        txt18=(TextView)findViewById(R.id.txt18_blit1);
        txt19=(TextView)findViewById(R.id.txt19_blit1);
        txt20=(TextView)findViewById(R.id.txt20_blit1);
        txt21=(TextView)findViewById(R.id.txt21_blit1);
        txt22=(TextView)findViewById(R.id.txt22_blit1);
        txt23=(TextView)findViewById(R.id.txt23_blit1);
        txt24=(TextView)findViewById(R.id.txt24_blit1);
        txt25=(TextView)findViewById(R.id.txt25_blit1);
        txt26=(TextView)findViewById(R.id.txt26_blit1);
        txt27=(TextView)findViewById(R.id.txt27_blit1);


//
//        Random randd = new Random();
//        Random rand2 = new Random();
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
//                        break;
//
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


        Log.e("TAG", arrayList.toString());

        adad.setText(adadfinal);


        int ticketNo=1;
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




        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){
                    if (a1.equals(adad.getText().toString())){
                        chans.add(1);
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
                        chans.add(2);
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
                        chans.add(3);
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

                        chans.add(4);
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

                        chans.add(5);
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
                        chans.add(6);
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
                        chans.add(7);
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
                        chans.add(8);
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
                        chans.add(9);
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
                        chans.add(10);
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
                        chans.add(11);
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
                        chans.add(12);
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
                        chans.add(13);
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
                        chans.add(14);
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
                        chans.add(15);
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
                        chans.add(16);
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
                        chans.add(17);
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
                        chans.add(18);
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
                        chans.add(19);
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
                        chans.add(20);
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
                        chans.add(21);
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
                        chans.add(22);
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
                        chans.add(23);
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
                        chans.add(24);
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
                        chans.add(25);
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
                        chans.add(26);
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
                        chans.add(27);
                        txt27.setBackgroundResource(R.drawable.pushing);
                    }else {
                        Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



        imgpush=(ImageView)findViewById(R.id.imgpushin_b1);

        oran1blit1=(TextView)findViewById(R.id.oran1blit1);
        oran1blit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (blite1==false){


                final BottomSheetDialog dialog=new BottomSheetDialog(Play.this,R.style.BottomSheetDialogTheme);
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
                        if (chans.size()==5){
                           win("winearlyfive");

                        }else {
                            blite1=true;
                            imgpush.setBackgroundResource(R.drawable.pushing);
                            dialog.dismiss();
                        }
                    }
                });

                crdtop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int i=0;
                        while (i<firstline_a.size()){
                            if (chans.contains( firstline_a.get(i))){
                                trfirst_a.add(1);
                            }
                            i++;
                        }


                        if (trfirst_a.size()==firstline_a.size())
                        {
                            Log.e("TAGbang", "winnnnn" );
                          win("winfirstline");
                        }else {
                            blite1=true;
                            imgpush.setBackgroundResource(R.drawable.pushing);
                            dialog.dismiss();
                        }

                    }
                });


                crdmidle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int i=0;
                        while (i<secendline_a.size()){
                            if (chans.contains( secendline_a.get(i))){
                                trsecend_a.add(1);
                            }
                            i++;
                        }


                        if (trsecend_a.size()==secendline_a.size())
                        {

                         win("winsecondline");
                        }else {
                            blite1=true;
                            imgpush.setBackgroundResource(R.drawable.pushing);
                            dialog.dismiss();
                        }
                    }
                });

                crdbotom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int i=0;
                        while (i<threeline_a.size()){
                            if (chans.contains( threeline_a.get(i))){
                                trthree_a.add(1);
                            }
                            i++;
                        }




                        if (trthree_a.size()==threeline_a.size())
                        {
                            Log.e("TAGbang","winnn threeee");
                        win("winthirdline");
                        }else {
                            blite1=true;
                            imgpush.setBackgroundResource(R.drawable.pushing);
                            dialog.dismiss();
                        }
                    }
                });

                crdcorn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int i=0;
                        while (i<corner_a.size()){
                            if (chans.contains( corner_a.get(i))){
                                tr_corner_a.add(1);
                            }
                            i++;
                        }

                        if (tr_corner_a.size()==corner_a.size()){
                          win("wincorners");
                        }else {
                            blite1=true;
                            imgpush.setBackgroundResource(R.drawable.pushing);
                            dialog.dismiss();
                        }


                    }
                });

                crdfull.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (trfirst_a.size()==firstline_a.size()&&trsecend_a.size()==secendline_a.size()&&trthree_a.size()==threeline_a.size()) {
                           win("winfull");
                        }else {
                            blite1=true;
                            imgpush.setBackgroundResource(R.drawable.pushing);
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
//                Toast.makeText(Play.this, error.toString(), Toast.LENGTH_SHORT).show();
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
    public void checkwin(){
        Log.e("kos251", "checkwin: ");
        try {
            if (random.size()==90){
                Handler handler=new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        com.example.tambola.Play.this.finish();
                        Toast.makeText(Play.this, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                },5000);
            }

        }
        catch (Exception e) {
            Log.e("kos251", e.toString());
            e.printStackTrace();
        }
    }
//    public void Cornerwin(){
//
//
//        int i=0;
//        while (i<corner_a.size()){
//            if (chans.contains( corner_a.get(i))){
//                tr_corner_a.add("tr");
//            }
//            i++;
//        }
//
//        if (tr_corner_a.size()==corner_a.size()){
//            win("wincorners");
//        }
//
//
//
//    }
//    public void Erlyfivewin(){
//        if (chans.size()==5){
//            win("winearlyfive");
//        }
//    }
//    public void Fierstlinewin(){
//
//        int i=0;
//        while (i<firstline_a.size()){
//            if (chans.contains( firstline_a.get(i))){
//                trfirst_a.add("tr");
//            }
//            i++;
//        }
//
//
//
//        if (trfirst_a.size()==firstline_a.size())
//        {
//            win("winfirstline");
//        }
//
//
//    }
//    public void Secendlinewin(){
//
//
//        int i=0;
//        while (i<secendline_a.size()){
//            if (chans.contains( secendline_a.get(i))){
//                trsecend_a.add("tr");
//            }
//            i++;
//        }
//
//
//        if (trsecend_a.size()==secendline_a.size())
//        {
//            win("winsecondline");
//        }
//
//    }
//    public void Threelinewin(){
//
//
//        int i=0;
//        while (i<threeline_a.size()){
//            if (chans.contains( threeline_a.get(i))){
//                trthree_a.add("tr");
//            }
//            i++;
//        }
//
//
//        if (trthree_a.size()==threeline_a.size())
//        {
//            win("winthirdline");
//        }
//
//
//    }
//    public void Fullewin() {
//
//        if (trfirst_a.size()==firstline_a.size()&&trsecend_a.size()==secendline_a.size()&&trthree_a.size()==threeline_a.size()) {
//            win("winfull");
//        }
//
//    }
    public static Bitmap getBitmap(String encodedImage)
    {
        byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
        return (BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length));
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
    public void generateadadasli(int random,String position,int i){
        int random2=new Random().nextInt(10)+1;
        String adadasli= String.valueOf(((random-1)*10)+random2);
        if (ticketNumber.contains(adadasli)) {
            generateadadasli(random,position,i);
        }else {
            ticketNumber.add(adadasli);
            JSONObject jsonObject=new JSONObject();
            try {
                jsonObject.put("position",String.valueOf(random));
                jsonObject.put("number",adadasli);
                jsonObject.put("ticketNo",String.valueOf((i/3)+1));
                jsonObject.put("row",String.valueOf((i%3)+1));
                jsonlist.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.e("position", "position : "+position+"\n"+"adad : "+adadasli );

            switch (position){
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

            }}

    }


//    public void aaaaalll(){
//        Random rand2 = new Random();
//        int a=rand2.nextInt(90)+1;
//        if (random.contains(String.valueOf(a))){
//            aaaaalll();
//        }else {
//            random.add(String.valueOf(a));}
//        adad.setText(String.valueOf(a));
//    }
}
