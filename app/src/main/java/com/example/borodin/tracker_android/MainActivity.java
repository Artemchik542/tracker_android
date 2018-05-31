package com.example.borodin.tracker_android;

import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.provider.Settings;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends ListActivity {

    TextView textView;
    EditText editText1, editText2;
    public static List<MyPlane> PLANES = new ArrayList<>();
    static String[] planeNamesArray = new String[]{"Plane_1", "Plane_2"};//список обьектов потом убрать
    public static String PLANE_NAME = "PLANE_NAME";
    public static String PLANE = "PLANE";
    final static String FILE_NAME = "dataFileGeolocation";
    public static final String INFO = "INFO";
    ServiceConnection sConn;
    boolean bound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.txt1);
        editText1 = (EditText) findViewById(R.id.edt1);
        editText2 = (EditText) findViewById(R.id.edt2);
        checkEnableGPS();
        ArrayAdapter<String> planeAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, planeNamesArray);
        PLANES.add(new MyPlane("Plane_1", "+79139371678",
                new GeoLocation( 55.0, 82.0, 127.0)));//тестовае данные
        PLANES.add(new MyPlane("Plane_2", "+1312354312",
                new GeoLocation( 50.0, 50.0, 50.0)));//тоже
        //planeAdapter.getItem(0);
        setListAdapter(planeAdapter);
        Intent intent = new Intent(this, SmsService.class);
        registerReceiver(receiver, new IntentFilter(SmsService.CHANNEL));

        sConn = new ServiceConnection() {
            public void onServiceConnected(ComponentName name, IBinder binder) {
                bound = true;
            }

            public void onServiceDisconnected(ComponentName name) {
                bound = false;
            }
        };
        bindService(intent, sConn, BIND_AUTO_CREATE);
    }


    private void checkEnableGPS() {
        String provider = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
        if (!provider.equals("")) {
            textView.setText("GPS включен");
        }else{
            textView.setText("GPS выключен");
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {// слушатель нажатий в списке
        super.onListItemClick(l, v, position, id);
        String month = (String) getListAdapter().getItem(position);
        Toast.makeText(this, month, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, MapActivity.class);
        intent.putExtra(PLANE_NAME, position);//передаем позицию выбранного обьекта в массиве
        //intent.putExtra(PLANE, (Parcelable) PLANES.get(position));
        Toast.makeText(this, "Выбранная позиция: " + (position+1), Toast.LENGTH_LONG).show();
        startActivity(intent);
    }

    protected BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String number = new String(intent.getStringExtra(SmsService.INFO));//получаем номер смс сообщения
            String body = new String(intent.getStringExtra(SmsService.INFO));//и содержимое смс
            String[] arr1 = body.split(" ");//разделяем содержимое

            for (int i = 0; i < PLANES.size(); i++) {
                if (number.equals(PLANES.get(i).phone)){
                    PLANES.get(i).geoLocations.add(0, new GeoLocation( Double.valueOf(arr1[0]),
                            Double.valueOf(arr1[1]), Double.valueOf(arr1[2])));//добавляем\заменяем положение обьекта
                    break;
                }
            }
        }
    };

    public void AddArrayObject(View view){

        PLANES.add(new MyPlane(editText1.getText().toString(), editText2.getText().toString(),
                new GeoLocation( Double.valueOf(0), Double.valueOf(0), Double.valueOf(0))));//добавить самолет в список
    }//добавление обьекта на главные экран списка(Button Add)

    public void RemoveArrayObject(View view){
        //PLANES.remove(editText1.getText().toString());
    }//удаление обьекта со списка(Button Remove)

}
