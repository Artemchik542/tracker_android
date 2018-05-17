package com.example.borodin.tracker_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    //EditText editText;
    TextView textView;
    ListView listView;
    static LinkedList<String> arrayList;// список для вывода на экран
    static String[] objectNamesArray = new String[]{"Plane_1", "Plane_2"};//список обьектов
    static String[] phoneNumberArray = new String[]{};//список номеров телефонов

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        listView = findViewById(R.id.arrayList);
        //editText = (EditText) findViewById(R.id.edittext);
        arrayList = new LinkedList<>();
        for (int i = 0; i < objectNamesArray.length; i++) {
            arrayList.add(objectNamesArray[i]);
        }
        ArrayAdapter<String> monthAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);

        //setListAdapter(monthAdapter);
    }
    public void AddArrayObject(View view){}//добавление обьекта на главные экран списка(Button Add)

    public void RemoveArrayObject(View view){}//удаление обьекта со списка(Button Remove)

    public void GoOnMap(View view){}//переход на экран с картой "MapActivity"

    Intent intent = new Intent(this, MapActivity.class);
}
