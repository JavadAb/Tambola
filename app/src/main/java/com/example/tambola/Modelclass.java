package com.example.tambola;

import android.graphics.Bitmap;

public class Modelclass {
    private String imagename;
    private Bitmap bitmap;

    public Modelclass(String imagename, Bitmap bitmap) {
        this.imagename = imagename;
        this.bitmap = bitmap;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
