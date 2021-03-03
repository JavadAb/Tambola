package com.example.tambola;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;
import com.tbruyelle.rxpermissions2.RxPermissions;

public class ChoosePlay extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{
    private GoogleApiClient googleApiClient;
    private static final int SIGN_ID=10;

    SharedPreferences setting;
    SharedPreferences.Editor editor;
    private String imagstring;
    private String namestring;
    SignInButton signInButton;

    static final Integer internet=10;
    static final Integer ACCESS_NETWORK_STATE=50;

    static final Integer READ_SMS=30;
    static final Integer RECEIVE_SMS=40;

    static final Integer ACCESS_FINE_LOCATION=20;
    ImageView tambolaaa,imghelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_play);


//        if (ContextCompat.checkSelfPermission(ChoosePlay.this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(ChoosePlay.this, new String[]{Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS}, 101);
//        }
        String[] permissions = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.INTERNET,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_NETWORK_STATE,Manifest.permission.READ_SMS,Manifest.permission.RECEIVE_SMS};

                // do your task.
                if (isOnline()){

                    GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
                    googleApiClient=new GoogleApiClient.Builder(ChoosePlay.this).enableAutoManage(ChoosePlay.this,ChoosePlay.this)
                            .addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions).build();

                    signInButton=(SignInButton)findViewById(R.id.googlesignid);
                    tambolaaa=(ImageView)findViewById(R.id.tambolaaa);
                    imghelp=(ImageView)findViewById(R.id.imghelp);
                    startActivitys startActivitys=new startActivitys();
                    startActivitys.set(ChoosePlay.this,tambolaaa,R.anim.animzoomin);
                    startActivitys.set(ChoosePlay.this,imghelp,R.anim.animzoomin);
                    startActivitys.set(ChoosePlay.this,signInButton,R.anim.animzoomin);
                    signInButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Permissions.check(ChoosePlay.this/*context*/, permissions, null/*rationale*/, null/*options*/, new PermissionHandler() {
                                @Override
                                public void onGranted() {
                            startActivitys.set(ChoosePlay.this,signInButton,R.anim.animzoomin);
                            Intent intent=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                            startActivityForResult(intent,SIGN_ID);   }
       });

                        }
                    });
                }else {
                    AlertDialog.Builder al=new AlertDialog.Builder(ChoosePlay.this);
                    al.setTitle("Internet");
                    al.setMessage("Your phone internet is off, please turn on your phone internet");
                    al.setIcon(android.R.drawable.ic_dialog_alert);
                    al.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            finish();
                        }
                    });


                    AlertDialog dialog1=al.create();
                    dialog1.setCanceledOnTouchOutside(false);
                    dialog1.show();
                }

//            }
//        });



    }
    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            Toast.makeText(getApplicationContext(), "No Internet connection!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==SIGN_ID){
            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()){
                startActivity(new Intent(ChoosePlay.this,Loginguse.class));
            }
}
}



}