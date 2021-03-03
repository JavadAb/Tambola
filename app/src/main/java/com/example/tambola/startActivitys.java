package com.example.tambola;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class startActivitys {
    public  void set(Context context,View view,int id){
        Animation a = AnimationUtils.loadAnimation(context,id);
        a.reset();
        view.clearAnimation();
        view.startAnimation(a);
      
}}
