package com.example.tambola;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import java.util.ArrayList;

public class Loginguse extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{
    GoogleApiClient googleApiClient;
    GoogleSignInOptions gso;
    GoogleSignInResult result;

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
         gmail_log=intent.getStringExtra("btnn");

        setting=getSharedPreferences("mypreference",MODE_PRIVATE);

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

                if (gmail_log.equals("gmail")){

                    Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                        @Override
                        public void onResult(@NonNull Status status) {
                            if (status.isSuccess()){
//                            startActivity(new Intent(Loginguse.this,));
                                if (result.isSuccess()){

                                    if (!name.getText().toString().isEmpty()){


                                        GoogleSignInAccount account=result.getSignInAccount();

                                        Log.e("stuf", account.getDisplayName());
                                        Log.e("stuf",account.getEmail());
                                        Log.e("stuf", account.getId());
                                        Toast.makeText(Loginguse.this, "Log out sucsess", Toast.LENGTH_SHORT).show();

                                        editor=setting.edit();
                                        editor.putString("gmail","gmail");
                                        editor.apply();
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
                   Intent intent1=new Intent(Loginguse.this,Category_Main.class);
                   startActivity(intent1);

//                   databaseHandler.storeimage(new Modelclass(name,prof));
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
        arrayListimage.add(String.valueOf(R.drawable.person));
        arrayListimage.add(String.valueOf(R.drawable.person));
        arrayListimage.add(String.valueOf(R.drawable.person));
        arrayListimage.add(String.valueOf(R.drawable.person));
        arrayListimage.add(String.valueOf(R.drawable.person));
        arrayListimage.add(String.valueOf(R.drawable.person));
        arrayListimage.add(String.valueOf(R.drawable.person));
        arrayListimage.add(String.valueOf(R.drawable.person));
        arrayListimage.add(String.valueOf(R.drawable.person));
        arrayListimage.add(String.valueOf(R.drawable.person));
        arrayListimage.add(String.valueOf(R.drawable.person));
        arrayListimage.add(String.valueOf(R.drawable.person));
        arrayListimage.add(String.valueOf(R.drawable.person));
        arrayListimage.add(String.valueOf(R.drawable.person));
        arrayListimage.add(String.valueOf(R.drawable.person));
        arrayListimage.add(String.valueOf(R.drawable.person));

        RecyclerView recyclerViewgetcv=(RecyclerView)findViewById(R.id.recyprof);
        Adapter_profile  adapter = new Adapter_profile(arrayListimage,Loginguse.this);
        recyclerViewgetcv.setAdapter(adapter);

//                        new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerViewgetcv);
        StaggeredGridLayoutManager gridLayoutManager=new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        recyclerViewgetcv.setLayoutManager(gridLayoutManager);

    }

//    private void handelsigningresult(GoogleSignInResult result){
//        if (result.isSuccess()){
//            GoogleSignInAccount account=result.getSignInAccount();
//
//            Log.e("stuf", account.getDisplayName());
//            Log.e("stuf",account.getEmail());
//            Log.e("stuf", account.getId());
//
////            name.setText(account.getDisplayName());
////            emal.setText(account.getEmail());
////            id.setText(account.getId());
//        }else {
////            getmainActivity();
//        }
//    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e("stuf", "start" );
        OptionalPendingResult<GoogleSignInResult> ops= Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if (ops.isDone()){
             result=ops.get();
        }else {
            ops.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult result2) {
                 result=result2;
                }
            });
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    public static class Adapter_profile extends RecyclerView.Adapter<Adapter_profile.ViewHolder> {


        ArrayList<String> img;
        Context context;


        public Adapter_profile(ArrayList<String> img, Context context) {
            this.img = img;
            this.context = context;
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {


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
                            prof.setImageResource(R.drawable.person);
                            break;

                        case 1:
                            prof.setImageResource(R.drawable.person);
                            break;

                        case 2:
                            prof.setImageResource(R.drawable.person);
                            break;

                        case 3:
                            prof.setImageResource(R.drawable.person);
                            break;

                        case 4:
                            prof.setImageResource(R.drawable.person);
                            break;

                        case 5:
                            prof.setImageResource(R.drawable.person);
                            break;

                        case 6:
                            prof.setImageResource(R.drawable.person);
                            break;

                        case 7:
                            prof.setImageResource(R.drawable.person);
                            break;

                        case 8:
                            prof.setImageResource(R.drawable.person);
                            break;

                        case 9:
                            prof.setImageResource(R.drawable.person);
                            break;

                        case 10:
                            prof.setImageResource(R.drawable.person);
                            break;

                        case 11:
                            prof.setImageResource(R.drawable.person);
                            break;

                        case 12:
                            prof.setImageResource(R.drawable.person);
                            break;

                        case 13:
                            prof.setImageResource(R.drawable.person);
                            break;

                        case 14:
                            prof.setImageResource(R.drawable.person);
                            break;

                        case 15:
                            prof.setImageResource(R.drawable.person);
                            break;



                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            return img.size();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode==IMAGE_PICK_CODE){
            Uri selectedImageUri = data.getData();
            prof.setImageURI(selectedImageUri);
    }

        if (requestCode==CAMERA_PICK){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            prof.setImageBitmap(photo);

        }
        else {
            Toast.makeText(this, "you cant pick", Toast.LENGTH_SHORT).show();
        }
}}