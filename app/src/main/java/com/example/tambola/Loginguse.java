package com.example.tambola;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

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
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Loginguse extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{
    GoogleApiClient googleApiClient;
    GoogleSignInOptions gso;
    GoogleSignInResult result;
   static   String pathimage;
    static Uri  uri;
    String namegmail,idgmail,adressgmail;
    EditText name;
   static ImageView prof;
    static ImageView gallery;
    static ImageView camera;
    TextView login;
    RecyclerView recyclerView_prof;

    SharedPreferences setting;
    SharedPreferences.Editor editor;

    private static final int IMAGE_PICK_CODE=10;
    private static final int CAMERA_PICK =102 ;
    private static final int PERMISSSION_CODE=1001;

    private static final int PERMISSSION_CODE2=10013;
    String play_gues;
    String gmail_log;

    DatabaseHandler databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginguse);

        Intent intent=getIntent();
         play_gues=intent.getStringExtra("btn");


        Log.e("stuf", play_gues );
        Sqlitechild sqlitechild=new Sqlitechild(getApplicationContext());

        databaseHandler = new DatabaseHandler(Loginguse.this);

        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();


        name=(EditText)findViewById(R.id.edtname);

        prof=(ImageView)findViewById(R.id.imgprof);
        gallery=(ImageView)findViewById(R.id.imggalery);
        camera=(ImageView)findViewById(R.id.imgcamera);

        login=(TextView)findViewById(R.id.btnlogin);

        FixRecycler();

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)    ==
                            PackageManager.PERMISSION_DENIED || checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                            PackageManager.PERMISSION_DENIED){
                        String[] permission={Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permission,PERMISSSION_CODE);

                    }else {
                        pickimagefromgalery();
                    }

                }else {
                    pickimagefromgalery();
                }
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.CAMERA)    ==
                            PackageManager.PERMISSION_DENIED || checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                            PackageManager.PERMISSION_DENIED){
                        String[] permission={Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA};
                        requestPermissions(permission,PERMISSSION_CODE2);

                    }else {
                        Camera();
                    }

                }else {
                    Camera();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (play_gues.equals("gmail")){

                    Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                        @Override
                        public void onResult(@NonNull Status status) {
                            if (status.isSuccess()){
//                            startActivity(new Intent(Loginguse.this,));
                                GoogleSignInAccount account=result.getSignInAccount();
                                if (result.isSuccess()){
                                    Log.e("stuf", account.getDisplayName());
                                    Log.e("stuf", account.getEmail() );
                                    Log.e("stuf", account.getId());
                                    if (!name.getText().toString().isEmpty()){

                                        sqlitechild.insertdata("gmail");


                                        ProgressDialog dialog = new ProgressDialog(Loginguse.this);
                                        dialog.setMessage("Please wait..");
                                        dialog.show();

                                        try {
                                          new Thread(new Runnable() {
                                              @Override
                                              public void run() {
                                                  HttpClient httpclient=new DefaultHttpClient();
                                                  HttpPost httpPost=new HttpPost("Http://185.255.89.127:8081/apibazi/login/");

                                                  try {
                                                      MultipartEntity entity=new MultipartEntity();
                                                      try {
                                                          entity.addPart("name",new StringBody(name.getText().toString(), Charset.forName("UTF8")));
                                                          entity.addPart("gmailAddress",new StringBody(account.getEmail(),Charset.forName("UTF8")));
                                                          entity.addPart("gmailId",new StringBody( account.getId(),Charset.forName("UTF8")));
                                                          entity.addPart("gmailName",new StringBody(account.getDisplayName(),Charset.forName("UTF8")));

                                                      } catch (UnsupportedEncodingException e) {
                                                          e.printStackTrace();
                                                      }
                                                      File file=new File(pathimage.toString());
                                                      FileBody fileBody=new FileBody(file);
                                                      entity.addPart("picture",fileBody);
                                                      httpPost.setEntity(entity);
                                                      sqlite sqliten=new sqlite(getApplicationContext());

                                                      HttpResponse response=httpclient.execute(httpPost);
                                                      HttpEntity httpEntity=response.getEntity();
                                                      String _response=EntityUtils.toString(httpEntity); // content will be consume only once
                                                      Log.e("stuf", _response);
                                                      try {

                                                          final JSONObject jObject=new JSONObject(_response);
                                                        String status=jObject.getString("status");
                                                          String token=jObject.getString("token");
                                                          Log.e("stuf", jObject.getString("status") );
                                                          Log.e("stuf", jObject.getString("token"));

                                                          if (status.equals("ok")){
                                                              dialog.dismiss();
                                                              sqliten.inserttoken(token);
                                                              sqliten.insertimage_name(BitMapToString(drawableToBitmap(prof.getDrawable())),name.getText().toString());
                                                              startActivity(new Intent(Loginguse.this,Category_Main.class));
                                                          }


                                                      }catch (JSONException e){
                                                          Log.e("stuf", e.toString() );
                                                      }



                                                  }catch (ClientProtocolException e){
                                                      e.printStackTrace();
                                                      Log.e("stuf", e.toString() );
                                                  } catch (IOException e) {
                                                      e.printStackTrace();
                                                      Log.e("stuf", e.toString() );
                                                  }

                                              }
                                          }).start();


                                        }catch (Exception es){
                                            Log.e("stuf", es.toString()  );
                                        }






                                    }
                                    else {
                                        Toast.makeText(Loginguse.this, "entername", Toast.LENGTH_SHORT).show();
                                    }
                                }else {
                                    startActivity(new Intent(Loginguse.this,ChoosePlay.class));
                                }


                            }else {
                                Toast.makeText(Loginguse.this, "Log out failded!", Toast.LENGTH_SHORT).show();
                            }
                        }


                    });
                }
                else if (play_gues.equals("gues")){
                    if (!name.getText().toString().isEmpty()){
                        sqlite sqlite=new sqlite(getApplicationContext());
                        sqlite.insertdata(BitMapToString(drawableToBitmap(prof.getDrawable())),name.getText().toString());
                   Intent intent1=new Intent(Loginguse.this,Category_Main.class);
                   startActivity(intent1);


                }
                }


            }
        });


    }
    private void Camera() {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_PICK);
       }

    private void pickimagefromgalery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, IMAGE_PICK_CODE);


    }

    public void FixRecycler(){
        ArrayList<String> arrayListimage=new ArrayList<>();
        arrayListimage.add(String.valueOf(R.drawable.a1));
        arrayListimage.add(String.valueOf(R.drawable.a2));
        arrayListimage.add(String.valueOf(R.drawable.a3));
        arrayListimage.add(String.valueOf(R.drawable.a4));
        arrayListimage.add(String.valueOf(R.drawable.a5));
        arrayListimage.add(String.valueOf(R.drawable.a6));
        arrayListimage.add(String.valueOf(R.drawable.a7));
        arrayListimage.add(String.valueOf(R.drawable.a8));
        arrayListimage.add(String.valueOf(R.drawable.a9));
        arrayListimage.add(String.valueOf(R.drawable.a10));
        arrayListimage.add(String.valueOf(R.drawable.a11));
        arrayListimage.add(String.valueOf(R.drawable.a12));


        RecyclerView recyclerViewgetcv=(RecyclerView)findViewById(R.id.recyprof);
        Adapter_profile  adapter = new Adapter_profile(arrayListimage,Loginguse.this);
        recyclerViewgetcv.setAdapter(adapter);

//                        new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerViewgetcv);
        StaggeredGridLayoutManager gridLayoutManager=new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        recyclerViewgetcv.setLayoutManager(gridLayoutManager);

    }


    @Override
    protected void onStart() {
        super.onStart();

        OptionalPendingResult<GoogleSignInResult> ops=Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if (ops.isDone()){
            GoogleSignInResult resultt=ops.get();
          result=resultt;
        }else {
            ops.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult result12) {
                    result=result12;
                }
            });
        }
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    public class Adapter_profile extends RecyclerView.Adapter<Adapter_profile.ViewHolder> {


        ArrayList<String> img;
        Context context;


        public Adapter_profile(ArrayList<String> img, Context context) {
            this.img = img;
            this.context = context;
        }

        public  class ViewHolder extends RecyclerView.ViewHolder {


            private CardView cardViieeww;
            public ViewHolder (CardView v){
                super(v);

                cardViieeww = v;
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            CardView cv = (CardView) LayoutInflater.from(context).inflate(R.layout.cardview_prof, parent , false);
            return new ViewHolder(cv);
        }

        @SuppressLint("NewApi")
        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            final CardView cardView = holder.cardViieeww;

            ImageView imageView=(ImageView)cardView.findViewById(R.id.img_card_prof);
            imageView.setImageResource(Integer.parseInt(img.get(position)));
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (position){
                        case 0:
                            prof.setImageResource(R.drawable.a1);
                          pathimage=getpath(R.drawable.a1);
                            Log.e("stuf", pathimage.toString() );
                            break;

                        case 1:
                            prof.setImageResource(R.drawable.a2);
                            pathimage=getpath(R.drawable.a2);
                            Log.e("stuf", pathimage.toString() );
                            break;

                        case 2:
                            prof.setImageResource(R.drawable.a3);
                            pathimage=getpath(R.drawable.a3);
                            Log.e("stuf", pathimage.toString() );
                            break;

                        case 3:
                            prof.setImageResource(R.drawable.a4);
                            pathimage=getpath(R.drawable.a4);
                            Log.e("stuf", pathimage.toString() );
                            break;

                        case 4:
                            prof.setImageResource(R.drawable.a5);
                            pathimage=getpath(R.drawable.a5);
                            Log.e("stuf", pathimage.toString() );
                            break;

                        case 5:
                            prof.setImageResource(R.drawable.a6);
                            pathimage=getpath(R.drawable.a6);
                            Log.e("stuf", pathimage.toString() );
                            break;

                        case 6:
                            prof.setImageResource(R.drawable.a7);
                            pathimage=getpath(R.drawable.a7);
                            Log.e("stuf", pathimage.toString() );
                            break;

                        case 7:
                            prof.setImageResource(R.drawable.a8);
                            pathimage=getpath(R.drawable.a8);
                            Log.e("stuf", pathimage.toString() );
                            break;

                        case 8:
                            prof.setImageResource(R.drawable.a9);
                            pathimage=getpath(R.drawable.a9);
                            Log.e("stuf", pathimage.toString() );
                            break;

                        case 9:
                            prof.setImageResource(R.drawable.a10);
                            pathimage=getpath(R.drawable.a10);
                            Log.e("stuf", pathimage.toString() );
                            break;

                        case 10:
                            prof.setImageResource(R.drawable.a11);
                            pathimage=getpath(R.drawable.a11);
                            Log.e("stuf", pathimage.toString() );
                            break;

                        case 11:
                            prof.setImageResource(R.drawable.a12);
                            pathimage=getpath(R.drawable.a12);
                            Log.e("stuf", pathimage.toString() );
                            break;



                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            return img.size();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode==IMAGE_PICK_CODE){
            Uri selectedImageUri = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            // Get the cursor
            Cursor cursor = getContentResolver().query(selectedImageUri,
                    filePathColumn, null, null, null);
            // Move to first row
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
          pathimage = cursor.getString(columnIndex);

            Log.e("stuf", pathimage.toString() );
            cursor.close();

            prof.setImageURI(selectedImageUri);
    }

        if (requestCode==CAMERA_PICK){
            Bitmap photo = (Bitmap) data.getExtras().get("data");

            Uri selectedImageUri = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            // Get the cursor
            Cursor cursor = getContentResolver().query(selectedImageUri,
                    filePathColumn, null, null, null);
            // Move to first row
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            pathimage= cursor.getString(columnIndex);

            Log.e("stuf", pathimage.toString() );
            cursor.close();

            prof.setImageBitmap(photo);

        }

}

    public static Bitmap drawableToBitmap (Drawable drawable) {
        Bitmap  bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if(bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if(drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;

    }

    //    public boolean isConnected() throws InterruptedException, IOException {
//        final String command = "ping -c 1 google.com";
//        return Runtime.getRuntime().exec(command).waitFor() == 0;
//    }
//
   @SuppressLint("MissingPermission")
    public boolean isOnline(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            return false;
        }
        return true;
    }
    public String BitMapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String temp = Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }







}

