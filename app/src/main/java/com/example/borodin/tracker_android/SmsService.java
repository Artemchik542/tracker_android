package com.example.borodin.tracker_android;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class SmsService extends Service {
    //public static final String WHERE_MY_CAT_ACTION = "com.example.borodin.tracker_android.action.CAT";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String INCOMPARCE = "sms_body";
        String number = intent.getExtras().getString(INCOMPARCE);
        String sms_body = intent.getExtras().getString(INCOMPARCE);

        /*Intent intent1 = new Intent();
        intent1.setAction(WHERE_MY_CAT_ACTION);
        intent1.putExtra("com.example.borodin.tracker_android.broadcast.Message",number);
        intent1.putExtra("com.example.borodin.tracker_android.broadcast.Message",sms_body);
        intent1.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent1);*/

        return START_STICKY;
    }


}
