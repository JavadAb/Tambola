package com.example.tambola;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
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
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    ImageView playsadeee,playparty,share,email,video;

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




        profile=(ImageView)findViewById(R.id.imgprof4);
        name=(TextView)findViewById(R.id.txtnameprof);
        level=(TextView)findViewById(R.id.txtlevelprof);

        plassece=(ImageView)findViewById(R.id.imgplasyelow);
        txtsece=(TextView)findViewById(R.id.txtsece);

        plasghalb=(ImageView)findViewById(R.id.imgplasgreen);
        txtghalb=(TextView)findViewById(R.id.txtghalb);

        plasrade=(ImageView)findViewById(R.id.imgplasblue);
        txtrade=(TextView)findViewById(R.id.txtrade);

        playsadeee=(ImageView)findViewById(R.id.imgplaysade);
        playparty=(ImageView)findViewById(R.id.imgplayparty);

        cheep=(TextView)findViewById(R.id.cheep);

        share=(ImageView)findViewById(R.id.share);
        email=(ImageView)findViewById(R.id.email);
        video=(ImageView)findViewById(R.id.video);

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
                gettransaction();
            }
        });
        txtsece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Transaction();
                gettransaction();
            }
        });

        playsadeee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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


                String url="Http://185.255.89.127:8081/apibazi/crispTransactions/";
                StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("stuf",response );

                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String status=jsonObject.getString("status");
                            if (status.equals("eror")){
                                Toast.makeText(Category_Main.this, "you dont have eny transaction", Toast.LENGTH_SHORT).show();
                            }else {
                                ArrayList<String> number=new ArrayList<>();
                                ArrayList<String> price=new ArrayList<>();
                                ArrayList<String> tarikh=new ArrayList<>();

                                RecyclerView recyclerViewgetcv=(RecyclerView)view1.findViewById(R.id.recycheep);
                                adapter_Cheep  adapter = new adapter_Cheep(number,price,tarikh,Category_Main.this);
                                recyclerViewgetcv.setAdapter(adapter);
//                        new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerViewgetcv);
                                LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
                                recyclerViewgetcv.setLayoutManager(layoutManager);
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
                        return params;
                    }
                };

                RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);





                AlertDialog dialog1=al.create();
                dialog1.setCanceledOnTouchOutside(true);
                dialog1.show();

            }
        });

    }

    public void Transaction(){
        final BottomSheetDialog dialog=new BottomSheetDialog(Category_Main.this,R.style.BottomSheetDialogTheme);
        dialog.setContentView(R.layout.layot_buy);
        dialog.setCanceledOnTouchOutside(false);

       TextView texttedadsece=(TextView)dialog.findViewById(R.id.txtsecebuy);
        TextView txtbuycoins=(TextView)dialog.findViewById(R.id.txtbuycoins);
        TextView txtaddbuycoins=(TextView)dialog.findViewById(R.id.txtaddbuycoins);
        TextView txtcoinsale=(TextView)dialog.findViewById(R.id.txtcoinsale);
        TextView txtnegcoinsale=(TextView)dialog.findViewById(R.id.txtnegcoinsale);

        txtaddbuycoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtbuycoins.getText().toString().isEmpty()){
                    String tedadsece=txtbuycoins.getText().toString();
                    amont=tedadsece+"$";
                    charge();
                    txtbuycoins.setText("");
//                    generateCheckSum();
                }else {
                    Toast.makeText(Category_Main.this, "enter coins", Toast.LENGTH_SHORT).show();
                }

            }
        });

        txtnegcoinsale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtnegcoinsale.getText().toString().isEmpty()){
                    String tedadsece=txtnegcoinsale.getText().toString();
                    amont=tedadsece+"$";
                sell();
                    txtbuycoins.setText("");
//                    generateCheckSum();
                }else {
                    Toast.makeText(Category_Main.this, "enter coins", Toast.LENGTH_SHORT).show();
                }

            }
        });
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

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
       charge();
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
    public void charge(){
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
            }
        })
        {
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String> params=new HashMap<String, String>();
                params.put("token",token);
                params.put("amount",amont);
                params.put("type","charge");
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


}