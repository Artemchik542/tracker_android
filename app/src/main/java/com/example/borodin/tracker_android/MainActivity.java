package com.example.borodin.tracker_android;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends ListActivity {

    Button button1, button2;
    TextView textView;
    EditText editText1;
    //List<MyPlane> planes = new ArrayList<>();
    static String[] planeNamesArray = new String[]{"Plane_1", "Plane_2"};//список обьектов потом убрать
    public static String PLANE_NAME = "PLANE_NAME";
    public static String PLANE = "PLANE";
    final static String FILE_NAME = "dataFileGeolocation";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.txt1);
        button1 = (Button) findViewById(R.id.but1);
        button2 = (Button) findViewById(R.id.but2);
        editText1 = (EditText) findViewById(R.id.edt1);
        makeNewList();
        checkEnableGPS();
        ArrayAdapter<String> planeAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, planeNamesArray);

        //planeAdapter.getItem(0);
        setListAdapter(planeAdapter);

    }


public List<MyPlane> makeNewList(){
    List<MyPlane> myPlanes = new ArrayList<>();
    File internalStorageDir = getFilesDir();
    try {

        File file = new File(  "res/dataFileGeolocation");
        //Toast.makeText(this, internalStorageDir.toString(), Toast.LENGTH_LONG).show();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            MyPlane plane = new MyPlane(arr[0], arr[1], new GeoLocation( Double.valueOf(arr[2]), Double.valueOf(arr[3]), Double.valueOf(arr[4])));
            myPlanes.add(plane);
        }
        scanner.close();
        return myPlanes;
    } catch (FileNotFoundException e) {
        Toast.makeText(this, "Что то пошло не так: " + e.getMessage(), Toast.LENGTH_LONG).show();
        return myPlanes;
    }

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
        intent.putExtra(PLANE_NAME, planeNamesArray[position]);//вывести тестовые данные
        //intent.putExtra(PLANE, (Parcelable) planes.get(position));
        //Toast.makeText(this, "Выбранная позиция: ", Toast.LENGTH_LONG).show();
        startActivity(intent);
    }



    public void AddArrayObject(View view){}//добавление обьекта на главные экран списка(Button Add)

    public void RemoveArrayObject(View view){}//удаление обьекта со списка(Button Remove)



    public void Synchronize(Double[] doubles){}// синхронизация данных
}
