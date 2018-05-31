package com.example.borodin.tracker_android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;

import static com.example.borodin.tracker_android.SmsService.INCOMPARCE1;
import static com.example.borodin.tracker_android.SmsService.INCOMPARCE2;

public class SMSMonitor extends BroadcastReceiver {
    private static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null && ACTION.compareToIgnoreCase(intent.getAction()) == 0) {
            Object[] pduArray = (Object[]) intent.getExtras().get("pdus");
            SmsMessage[] messages = new SmsMessage[pduArray.length];
            for (int i = 0; i < pduArray.length; i++) {
                messages[i] = SmsMessage.createFromPdu((byte[]) pduArray[i]);
            }
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            StringBuilder bodyText = new StringBuilder();
            for (int i = 0; i < messages.length; i++) {
                bodyText.append(messages[i].getMessageBody());
            }
            String body = bodyText.toString();
            Intent mIntent = new Intent(context, SmsService.class);
            mIntent.putExtra(INCOMPARCE1, incomingNumber);//передача номера
            mIntent.putExtra(INCOMPARCE2, body);//и содержимого смс собщения в SmsService
            context.startService(mIntent);
            abortBroadcast();
        }
    }
}
