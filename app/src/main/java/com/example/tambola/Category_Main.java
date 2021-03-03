



package com.example.tambola;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.EditText;
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
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.JsonArray;
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Category_Main extends AppCompatActivity implements PaytmPaymentTransactionCallback {
    String s;
    String imagerequest;
    String namerequest;
    ImageView profile,plassece,plasghalb,plasrade;
    TextView name,level,txtsece,txtghalb,txtrade,cheep;
    String sec="0";
    ImageView playsadeee,playparty,share,email,video,mosaviright;
    CardView crdtop,crddown;
    SharedPreferences setting,prefsece;
    String amont;
    TextView btnbuysece;
    TextView txttedadsece;
    blockAppdb blockAppdb;
    private String pach;
    private String imagstring,namestring;
    private String token;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category__main);
        txtsece=(TextView)findViewById(R.id.txtsece);
        crdtop=(CardView)findViewById(R.id.crdmain);
        crddown=(CardView)findViewById(R.id.crddownmain);

        startActivitys startActivitys=new startActivitys();
        startActivitys.set(Category_Main.this,crdtop,R.anim.animzoomin);
        startActivitys.set(Category_Main.this,crddown,R.anim.animzoomin);
        sqlite sqlite=new sqlite(getApplicationContext());
        Sqlitechild sqlitechild=new Sqlitechild(getApplicationContext());
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
//        chargal();
        Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                try {
                    SQLiteOpenHelper sqLiteOpenHelper=new Sqlitechild(getApplicationContext());
                    SQLiteDatabase db=sqLiteOpenHelper.getReadableDatabase();

                    Cursor cursor=db.query("Curentsece",
                            new String[]{"location"},null,null,null,null,null);
                    if (cursor.moveToFirst()){
                        sec = cursor.getString(0);
                        if (sec==null){
                            txtsece.setText("0");
                            Log.e("stuf", "0000000000" );
                        }else {
                            txtsece.setText(sec);
                            Log.e("stuf", sec+"charge" );
                        }

                    }

                }catch (SQLiteException ex){
                    Log.e("stuf", "Cancel" );
                }

                handler.postDelayed(this,5000);
            }
        });




        profile=(ImageView)findViewById(R.id.imgprof4);
        name=(TextView)findViewById(R.id.txtnameprof);

        plassece=(ImageView)findViewById(R.id.imgplasyelow);

        playsadeee=(ImageView)findViewById(R.id.imgplaysade);


        cheep=(TextView)findViewById(R.id.cheep);

        share=(ImageView)findViewById(R.id.share);
        email=(ImageView)findViewById(R.id.email);
        video=(ImageView)findViewById(R.id.video);

        startActivitys.set(Category_Main.this,profile,R.anim.animzoomin);
        startActivitys.set(Category_Main.this,name,R.anim.animzoomin);
        startActivitys.set(Category_Main.this,plassece,R.anim.animzoomin);
        startActivitys.set(Category_Main.this,playsadeee,R.anim.animzoomin);
        startActivitys.set(Category_Main.this,cheep,R.anim.animzoomin);
        startActivitys.set(Category_Main.this,share,R.anim.animzoomin);
        startActivitys.set(Category_Main.this,email,R.anim.animzoomin);
        startActivitys.set(Category_Main.this,video,R.anim.animzoomin);
        blockAppdb=new blockAppdb(getApplicationContext());

        try {
            SQLiteOpenHelper sqLiteOpenHelper=new Sqlitechild(getApplicationContext());
            SQLiteDatabase db=sqLiteOpenHelper.getReadableDatabase();

            Cursor cursor=db.query("location",
                    new String[]{"locationchild","ID"},"ID = ?",new String[]{"1"},null,null,null);
            if (cursor.moveToFirst()){
                pach = cursor.getString(0);

            }

        }catch (SQLiteException ex){
            Log.e("stuf", "Cancel" );
        }

        if (pach.equals("gmail")){

            try {
                SQLiteOpenHelper sqLiteOpenHelper=new sqlite(getApplicationContext());
                SQLiteDatabase db=sqLiteOpenHelper.getReadableDatabase();

                Cursor cursor=db.query("Tokenbb",
                        new String[]{"Imagestring","Namestring"},null,null,null,null,null);
                if (cursor.moveToFirst()){
                    imagstring = cursor.getString(0);
                    namestring=cursor.getString(1);

                    name.setText(namestring);
                    profile.setImageBitmap(getBitmap(imagstring));
                }

            }catch (SQLiteException ex){
                Log.e("stuf", "Cancel" );
            }

        }else if (pach==null){
            try {
                SQLiteOpenHelper sqLiteOpenHelper=new sqlite(getApplicationContext());
                SQLiteDatabase db=sqLiteOpenHelper.getReadableDatabase();

                Cursor cursor=db.query("Tokenpar",
                        new String[]{"Tokenparent","Tokenchild"},null,null,null,null,null);
                if (cursor.moveToFirst()){
                    imagstring = cursor.getString(0);
                    namestring=cursor.getString(1);

                    name.setText(namestring);
                    profile.setImageBitmap(getBitmap(imagstring));
                }

            }catch (SQLiteException ex){
                Log.e("stuf", "Cancel" );
            }

        }





        plassece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Transaction();
            }
        });
        txtsece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Transaction();
            }
        });

        playsadeee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivitys.set(Category_Main.this,playsadeee,R.anim.animzoomin);
                startActivity(new Intent(Category_Main.this,Category_belit.class));
            }
        });

        cheep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder al=new AlertDialog.Builder(Category_Main.this);
                LayoutInflater inflater=Category_Main.this.getLayoutInflater();
                View view1=inflater.inflate(R.layout.layout_cheep,null);
                al.setView(view1);

                ImageView imageView=(ImageView)view1.findViewById(R.id.imgprofcheep);
                TextView textView=(TextView)view1.findViewById(R.id.txtnamecheep);
                TextView textViewnumber=(TextView)view1.findViewById(R.id.txtnumbersece);


                if (pach==null){

                    try {
                        SQLiteOpenHelper sqLiteOpenHelper=new sqlite(getApplicationContext());
                        SQLiteDatabase db=sqLiteOpenHelper.getReadableDatabase();

                        Cursor cursor=db.query("Tokenpar",
                                new String[]{"Tokenparent","Tokenchild"},null,null,null,null,null);
                        if (cursor.moveToFirst()){
                            imagstring = cursor.getString(0);
                            namestring=cursor.getString(1);
                            imageView.setImageBitmap(getBitmap(imagstring));
                            textView.setText(namestring);
                        }

                    }catch (SQLiteException ex){
                        Log.e("stuf", "Cancel" );
                    }

                }else if (pach.equals("gmail")){
                    try {
                        SQLiteOpenHelper sqLiteOpenHelper=new sqlite(getApplicationContext());
                        SQLiteDatabase db=sqLiteOpenHelper.getReadableDatabase();

                        Cursor cursor=db.query("Tokenbb",
                                new String[]{"Imagestring","Namestring"},null,null,null,null,null);
                        if (cursor.moveToFirst()){
                            imagstring = cursor.getString(0);
                            namestring=cursor.getString(1);

                            textView.setText(namestring);
                            imageView.setImageBitmap(getBitmap(imagstring));
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
                                textViewnumber .setText("0");
                                Log.e("stuf", "0000000000" );
                            }else {
                                textViewnumber.setText(sec);
                                Log.e("stuf", sec+"charge" );
                            }

                        }

                    }catch (SQLiteException ex){
                        Log.e("stuf", "Cancel" );
                    }

                }




                try {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            HttpClient httpclient=new DefaultHttpClient();
                            HttpPost httpPost=new HttpPost("Http://185.255.89.127:8081/apibazi/crispTransactions/");

                            try {
                                MultipartEntity entity=new MultipartEntity();
                                try {
                                    entity.addPart("token",new StringBody(token, Charset.forName("UTF8")));

                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                                httpPost.setEntity(entity);


                                HttpResponse response=httpclient.execute(httpPost);
                                HttpEntity httpEntity=response.getEntity();
                                String _response= EntityUtils.toString(httpEntity); // content will be consume only once
                                try {

                                    final JSONObject jObject=new JSONObject(_response);
                                    String status=jObject.getString("status");
                                    if (status.equals("eror")){
                                        Toast.makeText(Category_Main.this, "you dont have eny transaction", Toast.LENGTH_SHORT).show();
                                    }else if (status.equals("ok")){

                                        JSONArray jsonArray=new JSONArray(jObject.getString("crispTransactions"));

                                        ArrayList<String> amont=new ArrayList<>(jsonArray.length());
                                        ArrayList<String> type=new ArrayList<>(jsonArray.length());
                                        ArrayList<String> data=new ArrayList<>(jsonArray.length());

                                        for (int i=0;i<jsonArray.length();i++){
                                            JSONObject jsonObjectb=jsonArray.getJSONObject(i);

                                            amont.add(jsonObjectb.getString("amount"));
                                            type.add(jsonObjectb.getString("type"));
                                            data.add(jsonObjectb.getString("date"));

                                        }
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                RecyclerView recyclerViewgetcv=(RecyclerView)view1.findViewById(R.id.recycheep);
                                                adapter_Cheep  adapter = new adapter_Cheep(amont,type,data,Category_Main.this);
                                                recyclerViewgetcv.setAdapter(adapter);
//                        new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerViewgetcv);
                                                LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
                                                recyclerViewgetcv.setLayoutManager(layoutManager);
                                                // Stuff that updates the UI
                                            }
                                        });


                                    }

                                }catch (JSONException e){
                                    Toast.makeText(Category_Main.this, "try again", Toast.LENGTH_SHORT).show();
                                    Log.e("stuf", e.toString() );
                                }



                            }catch (ClientProtocolException e){
                                Toast.makeText(Category_Main.this, "try again", Toast.LENGTH_SHORT).show();
                                e.printStackTrace();
                                Log.e("stuf", e.toString() );
                            } catch (IOException e) {
                                Toast.makeText(Category_Main.this, "try again", Toast.LENGTH_SHORT).show();
                                e.printStackTrace();
                                Log.e("stuf", e.toString() );
                            }

                        }
                    }).start();


                }catch (Exception es){
                    Log.e("stuf", es.toString()  );
                }



                AlertDialog dialog1=al.create();
                dialog1.setCanceledOnTouchOutside(true);
                dialog1.show();



            }
        });

    }

    public void Transaction(){
        final BottomSheetDialog dialog=new BottomSheetDialog(Category_Main.this,R.style.BottomSheetDialogTheme);
        dialog.setContentView(R.layout.layot_buy);
        dialog.setCanceledOnTouchOutside(true);
        TextView texttedadsece=(TextView)dialog.findViewById(R.id.txtsecebuy);
        try {
            SQLiteOpenHelper sqLiteOpenHelper=new Sqlitechild(getApplicationContext());
            SQLiteDatabase db=sqLiteOpenHelper.getReadableDatabase();

            Cursor cursor=db.query("Curentsece",
                    new String[]{"location"},null,null,null,null,null);
            if (cursor.moveToFirst()){
                sec = cursor.getString(0);
                if (sec==null){

                }else {
                    texttedadsece.setText(sec);
                }

            }

        }catch (SQLiteException ex){
            Log.e("stuf", "Cancel" );
        }

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



        TextView txtbuycoins=(TextView)dialog.findViewById(R.id.txtbuycoins);
        TextView txtaddbuycoins=(TextView)dialog.findViewById(R.id.txtaddbuycoins);
        TextView txtcoinsale=(TextView)dialog.findViewById(R.id.txtcoinsale);
        TextView txtnegcoinsale=(TextView)dialog.findViewById(R.id.txtnegcoinsale);

        try {


            txtaddbuycoins.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
                @Override
                public void onClick(View view) {
                    if (!txtbuycoins.getText().toString().isEmpty()){
                    ProgressDialog dialogpross = new ProgressDialog(Category_Main.this);
                    dialogpross.setMessage("Please wait..");
                    dialogpross.show();
                        String tedadsece=txtbuycoins.getText().toString();
//
////                   startActivity(new Intent(Category_Main.this,Pay2.class).putExtra("amount",tedadsece));
                        try {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    //Toast.makeText(Category_Main.this, "first test is true", Toast.LENGTH_SHORT).show();

                                    HttpClient httpclient=new DefaultHttpClient();
                                    HttpPost httpPost=new HttpPost("Http://185.255.89.127:8081/apibazi/changeCrisp/");
                                    Handler handler=new Handler(Looper.getMainLooper());
                                    try {
                                        MultipartEntity entity=new MultipartEntity();
                                        try {
                                            entity.addPart("token",new StringBody(token, Charset.forName("UTF8")));
                                            entity.addPart("amount",new StringBody(tedadsece,Charset.forName("UTF8")));
                                            entity.addPart("type",new StringBody("charge",Charset.forName("UTF8")));

                                        } catch (UnsupportedEncodingException e) {
                                            handler.post(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(Category_Main.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                        }
                                        httpPost.setEntity(entity);

                                        HttpResponse response=httpclient.execute(httpPost);
                                        HttpEntity httpEntity=response.getEntity();
                                        Sqlitechild sqlite=new Sqlitechild(getApplicationContext());
                                        String _response= EntityUtils.toString(httpEntity); // content will be consume only once
                                        Log.e("TAG231", _response );
                                        try {
                                           final JSONObject jsonObjec=new JSONObject(_response);
                                            String statu=jsonObjec.getString("status");
                                            if (statu.equals("ok")){
                                                String currentCrips=jsonObjec.getString("currentCrips");
                                                sqlite.dellsece();
                                                sqlite.insertsece(currentCrips);
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        dialogpross.dismiss();
                                                       dialog.dismiss();
                                                    }
                                                });
                                            }
                                            else {
                                                handler.post(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Toast.makeText(Category_Main.this, "Faild try again", Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                            }

                                        } catch (JSONException e) {
                                            dialogpross.dismiss();
                                            handler.post(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(Category_Main.this, "Faild try again", Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                            e.printStackTrace();
                                        }



                                    }catch (ClientProtocolException e){

                                        //     dialogpross.dismiss();
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(Category_Main.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    } catch (IOException e) {
                                        //       dialogpross.dismiss();
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(Category_Main.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }

                                }
                            }).start();


                        }catch (Exception es){
                            Toast.makeText(Category_Main.this, es.getMessage(), Toast.LENGTH_SHORT).show();
                            Log.e("stuf", es.toString()  );
                        }
//

//                    generateCheckSum();
                    }else {
                        Toast.makeText(Category_Main.this, "enter coins", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }catch (Exception exception){
            Toast.makeText(this, exception.toString(), Toast.LENGTH_SHORT).show();
        }

        try {


            txtnegcoinsale.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
                @Override
                public void onClick(View view) {
                    if (!txtcoinsale.getText().toString().isEmpty()){

                        int s= Integer.parseInt(txtcoinsale.getText().toString());
                        int sece2= Integer.parseInt(sec);

                        if (sece2>s){

                            String tedadsece=txtcoinsale.getText().toString();
                            amont=tedadsece;

//
//
//                        AlertDialog.Builder al=new AlertDialog.Builder(Category_Main.this);
//                        View viewal=getLayoutInflater().inflate(R.layout.view_alert,null);
//                        al.setView(viewal);
//                        al.setTitle("Account Number");
//                        al.setMessage("Please enter Account Number");
//                        EditText editTextalert=(EditText)viewal.findViewById(R.id.edtid);
//                        al.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        });
//                        al.setPositiveButton("Confirmation ",null);
//                        AlertDialog alertDialog=al.create();
//                        alertDialog.show();
//
////accountNumber
//                        Button button1=alertDialog.getButton(android.app.AlertDialog.BUTTON_POSITIVE);
//                        button1.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                if (!editTextalert.getText().toString().isEmpty()){
//
//                                    ProgressDialog dialogpross = new ProgressDialog(Category_Main.this);
//                                    dialogpross.setMessage("Please wait..");
//                                    dialogpross.show();
//
//                        try {
//                            new Thread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    HttpClient httpclient=new DefaultHttpClient();
//                                    HttpPost httpPost=new HttpPost("Http://185.255.89.127:8081/apibazi/changeCrisp/");
//
//                                    try {
//                                        MultipartEntity entity=new MultipartEntity();
//                                        try {
//                                            entity.addPart("token",new StringBody(token, Charset.forName("UTF8")));
//                                            entity.addPart("amount",new StringBody(tedadsece,Charset.forName("UTF8")));
//                                            entity.addPart("type",new StringBody("sell",Charset.forName("UTF8")));
//                                            entity.addPart("accountNumber",new StringBody(editTextalert.getText().toString(),Charset.forName("UTF8")));
//
//                                        } catch (UnsupportedEncodingException e) {
//                                            e.printStackTrace();
//                                        }
//                                        httpPost.setEntity(entity);
//
//
//                                        HttpResponse response=httpclient.execute(httpPost);
//                                        HttpEntity httpEntity=response.getEntity();
//                                        String _response= EntityUtils.toString(httpEntity); // content will be consume only once
//                                        try {
//
//                                            final JSONObject jObject=new JSONObject(_response);
//                                            String statu=jObject.getString("status");
//
//                                            if (statu.equals("ok")){
//                                                dialogpross.dismiss();
//                                                dialog.dismiss();
//                                                String currentCrips=jObject.getString("currentCrips");
//                                                Sqlitechild sqlite=new Sqlitechild(getApplicationContext());
//                                                sqlite.dellsece();
//                                                sqlite.insertsece(currentCrips);
//                                                texttedadsece.setText(currentCrips);
//                                                txtbuycoins.setText("");
//                                            }
//
//
//                                        }catch (JSONException e){
//                                            dialog.dismiss();
//                                            dialogpross.dismiss();
//                                            Toast.makeText(Category_Main.this, "try again", Toast.LENGTH_SHORT).show();
//                                            Log.e("stuf", e.toString() );
//                                        }
//
//
//
//                                    }catch (ClientProtocolException e){
//                                        dialog.dismiss();
//                                        dialogpross.dismiss();
//                                        Toast.makeText(Category_Main.this, "try again", Toast.LENGTH_SHORT).show();
//                                        e.printStackTrace();
//                                        Log.e("stuf", e.toString() );
//                                    } catch (IOException e) {
//                                        dialog.dismiss();
//                                        dialogpross.dismiss();
//                                        Toast.makeText(Category_Main.this, "try again", Toast.LENGTH_SHORT).show();
//                                        e.printStackTrace();
//                                        Log.e("stuf", e.toString() );
//                                    }
//
//                                }
//                            }).start();
//
//
//                        }catch (Exception es){
//                            Log.e("stuf", es.toString()  );
//                        }
//
//                                }else {
//                                    Toast.makeText(Category_Main.this, "Enter account number", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });


                            ProgressDialog dialogpross = new ProgressDialog(Category_Main.this);
                            dialogpross.setMessage("Please wait..");
                            dialogpross.show();

                            try {
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        HttpClient httpclient=new DefaultHttpClient();
                                        HttpPost httpPost=new HttpPost("Http://185.255.89.127:8081/apibazi/changeCrisp/");
                                        Handler handler=new Handler(Looper.getMainLooper());
                                        try {
                                            MultipartEntity entity=new MultipartEntity();
                                            try {
                                                entity.addPart("token",new StringBody(token, Charset.forName("UTF8")));
                                                entity.addPart("amount",new StringBody(tedadsece,Charset.forName("UTF8")));
                                                entity.addPart("type",new StringBody("sell",Charset.forName("UTF8")));

                                            } catch (UnsupportedEncodingException e) {
                                                handler.post(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Toast.makeText(Category_Main.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                            }
                                            httpPost.setEntity(entity);


                                            HttpResponse response=httpclient.execute(httpPost);
                                            HttpEntity httpEntity=response.getEntity();
                                            Sqlitechild sqlite=new Sqlitechild(getApplicationContext());
                                            String _response= EntityUtils.toString(httpEntity); // content will be consume only once
                                            try {

                                                final JSONObject jObject=new JSONObject(_response);
                                                String statu=jObject.getString("status");

                                                if (statu.equals("ok")){
                                                    String currentCrips=jObject.getString("currentCrips");

                                                    sqlite.dellsece();
                                                    sqlite.insertsece(currentCrips);
                                                    dialogpross.dismiss();
                                                }


                                            }catch (JSONException e){
                                                dialogpross.dismiss();
                                                handler.post(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Toast.makeText(Category_Main.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                            }



                                        }catch (ClientProtocolException e){
                                            dialogpross.dismiss();
                                            e.printStackTrace();
                                            handler.post(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(Category_Main.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                        } catch (IOException e) {
                                            dialogpross.dismiss();
                                            e.printStackTrace();
                                            handler.post(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(Category_Main.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                        }

                                    }
                                }).start();


                            }catch (Exception es){
                                Toast.makeText(Category_Main.this, es.getMessage(), Toast.LENGTH_SHORT).show();
                                Log.e("stuf", es.toString()  );
                            }


                        }else {
                            Toast.makeText(Category_Main.this, "your cheeps low", Toast.LENGTH_SHORT).show();
                        }

//                    generateCheckSum();
                    }else {
                        Toast.makeText(Category_Main.this, "enter coins", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }

        dialog.show();
    }
    //2B:48:5E:E4:83:34:14:2B:A4:2E:EA:12:1D:F9:ED:2D:FD:1C:F8:6F
    private void generateCheckSum() {
        Toast.makeText(this, "buy", Toast.LENGTH_SHORT).show();

        //getting the tax amount first.
        String txnAmount = amont;

        //creating a retrofit object.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //creating the retrofit api service
        Api apiService = retrofit.create(Api.class);

        //creating paytm object
        //containing all the values required
        final Paytm paytm = new Paytm(
                Constants.M_ID,
                Constants.CHANNEL_ID,
                txnAmount,
                Constants.WEBSITE,
                Constants.CALLBACK_URL,
                Constants.INDUSTRY_TYPE_ID
        );

        //creating a call object from the apiService
        Call<Checksum> call = apiService.getChecksum(
                paytm.getmId(),
                paytm.getOrderId(),
                paytm.getCustId(),
                paytm.getChannelId(),
                paytm.getTxnAmount(),
                paytm.getWebsite(),
                paytm.getCallBackUrl(),
                paytm.getIndustryTypeId()
        );

        //making the call to generate checksum
        call.enqueue(new Callback<Checksum>() {
            @Override
            public void onResponse(Call<Checksum> call, retrofit2.Response<Checksum> response) {

                //once we get the checksum we will initiailize the payment.
                //the method is taking the checksum we got and the paytm object as the parameter
                initializePaytmPayment(response.body().getChecksumHash(), paytm);
            }

            @Override
            public void onFailure(Call<Checksum> call, Throwable t) {

            }
        });
    }

    private void initializePaytmPayment(String checksumHash, Paytm paytm) {

        //getting paytm service
        PaytmPGService Service = PaytmPGService.getStagingService();

        //use this when using for production
        //PaytmPGService Service = PaytmPGService.getProductionService();

        //creating a hashmap and adding all the values required
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("MID", Constants.M_ID);
        paramMap.put("ORDER_ID", paytm.getOrderId());
        paramMap.put("CUST_ID", paytm.getCustId());
        paramMap.put("CHANNEL_ID", paytm.getChannelId());
        paramMap.put("TXN_AMOUNT", paytm.getTxnAmount());
        paramMap.put("WEBSITE", paytm.getWebsite());
        paramMap.put("CALLBACK_URL", paytm.getCallBackUrl());
        paramMap.put("CHECKSUMHASH", checksumHash);
        paramMap.put("INDUSTRY_TYPE_ID", paytm.getIndustryTypeId());


        //creating a paytm order object using the hashmap
        PaytmOrder order = new PaytmOrder((HashMap<String, String>) paramMap);

        //intializing the paytm service
        Service.initialize(order, null);

        //finally starting the payment transaction
        Service.startPaymentTransaction(this, true, true, this);

    }

    public static Bitmap getBitmap(String encodedImage)
    {
        byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
        return (BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length));
    }


    @Override
    public void onTransactionResponse(Bundle inResponse) {

    }

    @Override
    public void networkNotAvailable() {

    }

    @Override
    public void clientAuthenticationFailed(String inErrorMessage) {

    }

    @Override
    public void someUIErrorOccurred(String inErrorMessage) {

    }

    @Override
    public void onErrorLoadingWebPage(int iniErrorCode, String inErrorMessage, String inFailingUrl) {

    }

    @Override
    public void onBackPressedCancelTransaction() {

    }

    @Override
    public void onTransactionCancel(String inErrorMessage, Bundle inResponse) {

    }

    public void sell(){
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

        String url="Http://185.255.89.127:8081/apibazi/changeCrisp/";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("stuf",response );

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("stuf", error.toString() );
                Toast.makeText(Category_Main.this, "This section is not perfect", Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String> params=new HashMap<String, String>();
                params.put("token",token);
                params.put("amount",amont);
                params.put("type","sell");
                params.put("accountNumber","");
                return params;
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
    public void gettransaction(){

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


        String url="Http://185.255.89.127:8081/apibazi/crispTransactions/";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("gfgfgf",response );

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("stuf", error.toString() );
            }
        })
        {
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String> params=new HashMap<String, String>();
                params.put("token",token);
                return params;
            }
        };

        RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }

    public void chargal(){
        String url="Http://185.255.89.127:8081/apibazi/changeCrisp/";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("stuf",response );

                try {
                    JSONObject jsonObjec=new JSONObject(response);
                    String statu=jsonObjec.getString("status");

                    if (statu.equals("ok")){
                        String currentCrips=jsonObjec.getString("currentCrips");
                        Sqlitechild sqlite=new Sqlitechild(getApplicationContext());
                        sqlite.dellsece();
                        sqlite.insertsece(currentCrips);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("stuf", error.toString() );
            }
        })
        {
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String> params=new HashMap<String, String>();
                params.put("token",token);
                params.put("amount","0");
                params.put("type","charge");
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


}