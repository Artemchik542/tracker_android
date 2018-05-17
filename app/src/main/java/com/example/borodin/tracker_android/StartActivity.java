package com.example.borodin.tracker_android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;

/**
 * Created by Borodin on 16.05.2018.
 */

public class StartActivity extends AppCompatActivity {

    private Bitmap bitmap;
    private SurfaceHolder surfaceHolder;

    public StartActivity(Context context, SurfaceHolder surfaceHolder) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.Satellite);
        this.surfaceHolder = surfaceHolder;

    }
}
