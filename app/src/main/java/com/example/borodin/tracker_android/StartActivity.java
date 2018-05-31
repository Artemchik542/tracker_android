package com.example.borodin.tracker_android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Borodin on 16.05.2018.
 */

public class StartActivity extends AppCompatActivity {
Button button1, button2, button3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.sat);
        setContentView(R.layout.start_activity);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Обработка нажатия
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Обработка нажатия
                Intent intent = new Intent(StartActivity.this,AboutActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Обработка нажатия
                Toast.makeText(StartActivity.this, "Нажмите ещё раз для выхода из приложения",
                        Toast.LENGTH_SHORT).show();
                onDestroy();

            }
        });
    }
}
