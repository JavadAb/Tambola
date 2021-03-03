package com.example.tambola;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class Pay2 extends AppCompatActivity {
    public static final String PAYTM_PACKAGE_NAME="net.one97.paytm";


    TextView amount,paypaytm,msg,trannote;
    public static String patname,vpa,msgnote,status,sendamount,token;
    Uri uri;
    String tedadsece;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay2);

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



        Intent intent=getIntent();
         tedadsece=intent.getStringExtra("amount");




        amount=(TextView)findViewById(R.id.txtamount);
        amount.setText(tedadsece);

        paypaytm=(TextView)findViewById(R.id.txtpaypaytm);
        msg=(TextView)findViewById(R.id.txtmsg);
        trannote=(TextView)findViewById(R.id.edttransaction);

        patname="Venkata Satya Sudhakara Chowdary Putta";
        vpa="pvsschowdary@dbs";
        msgnote=trannote.getText().toString();
        sendamount=amount.getText().toString();

        paypaytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (patname!=null&&vpa!=null&&msgnote!=null&&sendamount!=null){
                    try {
                        uri=getpaytm(patname,vpa,msgnote,sendamount);
                        paywithpaytm(PAYTM_PACKAGE_NAME);
                    }catch (Exception e){
                        Toast.makeText(Pay2.this, "Faild", Toast.LENGTH_SHORT).show();
                        Log.e("kos", e.toString() );
                    }

                }else {
                    Toast.makeText(Pay2.this, "Please fill all the table", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static Uri getpaytm(String name,String upiid,String note, String amount){
        return new Uri.Builder()
                .scheme("upi")
                .authority("pay")
                .appendQueryParameter("pa",upiid)
                .appendQueryParameter("pn",name)
                .appendQueryParameter("tn",note)
                .appendQueryParameter("am",amount)
                .appendQueryParameter("cu","INR")
                .build();
    }

    public void paywithpaytm(String packagename){
        if (isAppinstall(this,packagename)){
            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setData(uri);
            i.setPackage(packagename);
            startActivityForResult(i,0);
        }else {
            AlertDialog.Builder alert=new AlertDialog.Builder(Pay2.this);
            alert.setTitle("Paytm");
            alert.setIcon(R.drawable.pay2);
            alert.setMessage("paytm is not installed please install");
            alert.setPositiveButton("Install", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    final String appPackageName = PAYTM_PACKAGE_NAME;// getPackageName() from Context or Activity object
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                    }
                }
            });
            alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog dialog=alert.create();
            dialog.show();
        }
    }
    public static boolean isAppinstall(Context context,String packagename){
        try {
            context.getPackageManager().getApplicationInfo(packagename,0);
            return true;
        }catch (PackageManager.NameNotFoundException e){
            return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null){
            status=data.getStringExtra("status").toLowerCase();
        }if (RESULT_OK==resultCode && status.equals("success")){
            charg();
            Toast.makeText(this, "Transaction successful"+data.getStringExtra("ApprovalRefNo"), Toast.LENGTH_LONG).show();
            msg.setText("Transaction successful of INR"+sendamount);
            msg.setTextColor(Color.GREEN);
        }else {
            Toast.makeText(this, "Transaction Filed", Toast.LENGTH_LONG).show();
            msg.setText("Transaction Filed of INR"+sendamount);
            msg.setTextColor(Color.RED);
        }
    }

    public void charg(){
        ProgressDialog dialogpross = new ProgressDialog(Pay2.this);
        dialogpross.setMessage("Please wait..");
        dialogpross.show();

        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpClient httpclient=new DefaultHttpClient();
                    HttpPost httpPost=new HttpPost("Http://185.255.89.127:8081/apibazi/changeCrisp/");

                    try {
                        MultipartEntity entity=new MultipartEntity();
                        try {
                            entity.addPart("token",new StringBody(token, Charset.forName("UTF8")));
                            entity.addPart("amount",new StringBody(tedadsece,Charset.forName("UTF8")));
                            entity.addPart("type",new StringBody("charge",Charset.forName("UTF8")));

                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        httpPost.setEntity(entity);


                        HttpResponse response=httpclient.execute(httpPost);
                        HttpEntity httpEntity=response.getEntity();
                        String _response= EntityUtils.toString(httpEntity); // content will be consume only once
                        try {

                            final JSONObject jObject=new JSONObject(_response);
                            String statu=jObject.getString("status");

                            if (statu.equals("ok")){
                                dialogpross.dismiss();
                                String currentCrips=jObject.getString("currentCrips");
                                Sqlitechild sqlite=new Sqlitechild(getApplicationContext());
                                sqlite.dellsece();
                                sqlite.insertsece(currentCrips);
                            }


                        }catch (JSONException e){
                            dialogpross.dismiss();
                            Toast.makeText(Pay2.this, "try again", Toast.LENGTH_SHORT).show();
                            Log.e("stuf", e.toString() );
                        }



                    }catch (ClientProtocolException e){
                        dialogpross.dismiss();
                        Toast.makeText(Pay2.this, "try again", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                        Log.e("stuf", e.toString() );
                    } catch (IOException e) {
                        dialogpross.dismiss();
                        Toast.makeText(Pay2.this, "try again", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                        Log.e("stuf", e.toString() );
                    }

                }
            }).start();


        }catch (Exception es){
            Log.e("stuf", es.toString()  );
        }

    }
}