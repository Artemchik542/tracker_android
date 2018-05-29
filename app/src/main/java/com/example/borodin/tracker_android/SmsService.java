package com.example.borodin.tracker_android;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SmsService extends Service {
    //public static final String WHERE_MY_CAT_ACTION = "com.example.borodin.tracker_android.action.CAT";
    public static final String INFO = "INFO";
    public static final String CHANNEL = "SMS_SERVICE";
    public static final String INCOMPARCE = "sms_body";
    @Override
    public void onCreate() {
        // сообщение о создании службы
        Toast.makeText(this, "Сервис запущен", Toast.LENGTH_SHORT).show();
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String number = intent.getExtras().getString(INCOMPARCE);//передали пришедшие значения в локальные переманные
        String sms_body = intent.getExtras().getString(INCOMPARCE);//тоже

        Intent intent1 = new Intent(CHANNEL);// интент для отправки ответа
        intent1.putExtra(INFO,number);// добавляем в интент данные
        intent1.putExtra(INFO,sms_body);//тоже
        sendBroadcast(intent1);
        return START_NOT_STICKY;

    }
    @Override
    public void onDestroy() {
        //сообщение об остановке службы
        Toast.makeText(this, "Сервис остановлен", Toast.LENGTH_SHORT).show();
    }

}
