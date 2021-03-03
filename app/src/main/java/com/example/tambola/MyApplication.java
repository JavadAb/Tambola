package com.example.tambola;

import org.acra.*;
import org.acra.annotation.*;
import android.app.Application;


@ReportsCrashes(
        mailTo = "trt.teamtrt@gmail.com",
        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.crash_toast_text)

public class MyApplication extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();
        ACRA.init(this);
    }
}