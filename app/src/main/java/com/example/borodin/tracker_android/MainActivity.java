package com.example.borodin.tracker_android;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends ListActivity {
    //EditText editText;
    //TextView textView;
    ListView listView;
    static String[] planeNamesArray = new String[]{"Plane_1", "Plane_2"};//список обьектов
    static String[] phoneNumberArray = new String[]{};//список номеров телефонов
    List<List<Double>> listOfLatitude = new ArrayList<>();//двумерный массив с данными о широте каждого обьекта
    List<List<Double>> listOfLongitude = new ArrayList<>();//двумерный массив с данными о долготе каждого обьекта
    List<List<Double>> listOfHeight = new ArrayList<>();//двумерный массив с данными о высоте каждого обьекта

public void ReadFile(){
    try {
        File file = new File("d:/dataFileGeolocation.txt");//тот ли файл в принципе?
        Scanner scanner = new Scanner(file);
        int all = scanner.nextInt();//считываем то сколько всего объектов у нас имеется в файле
        while (scanner.hasNext()) {
            for (int i = 0; i < all; i++) {
                planeNamesArray[i] = scanner.next();//чтение имен объектов
            }
            for (int i = 0; i < all; i++) {
                phoneNumberArray[i] = scanner.next();//чтение номеров телефонов
            }

            // по аналогии все остальные считывания из файла
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        Toast.makeText(this, "Что то пошло не так: "+e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}


    MyPlane[] makeArray() { //разделение списка данных на кажный объект по принципу ООП
        MyPlane[] arr = new MyPlane[planeNamesArray.length];
        for (int i = 0; i < arr.length; i++) {
            MyPlane plane = new MyPlane();
            plane.name = planeNamesArray[i];
            plane.phone = phoneNumberArray[i];
            plane.latitude = listOfLatitude.get(i)[];//?????!!!!! ГДЕ ОШИБКА?
            plane.longitude = listOfLongitude.get(i)[];
            plane.height = listOfHeight.get(i)[];
            arr[i] = plane;
        }
        return arr;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {//
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textView = findViewById(R.id.textview);
        listView = findViewById(R.id.arrayList);
        //editText = (EditText) findViewById(R.id.edittext);
        //makeArray();
        ArrayAdapter<String> planeAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, planeNamesArray);

        planeAdapter.getItem(0);
        listView.setAdapter(planeAdapter);

        }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {// слушатель нажатий
        super.onListItemClick(l, v, position, id);
        String month = (String) getListAdapter().getItem(position);
        Toast.makeText(this, month, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, StartActivity.class);
        intent.putExtra(planeNamesArray[0],listOfLatitude.get(0)[]);//?????!!!
// по аналогии сделать остальные интенты
        startActivity(intent);
    }


    public void AddArrayObject(View view){}//добавление обьекта на главные экран списка(Button Add)

    public void RemoveArrayObject(View view){}//удаление обьекта со списка(Button Remove)

    public void GoOnMap(View view){
        //Intent intent = new Intent(this, MapActivity.class);
    }//переход на экран с картой "MapActivity"

    public void Synchronize(Double[] doubles){}// синхронизация данных
}
