package com.masterandroid.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 1- ListView
    ListView listView;


    //2- Data
    String[] title = {
            "Master Android Pro App",
            "Master Flutter App",
            "Master Android App",
            "Youtube Channel",
            "Rate Us"
    };

    String[] description = {
            "Learn android app development from zero to hero",
            "Learn Flutter from scratch",
            "Helping more than 780,000+ Developers to learn android",
            "AndroidMasterApp is our official channel",
            "Keep us making new tutorials, Rate us 5 stars on Udemy"
    };


    // Images as an array
    Integer[] imgs = {
            R.drawable.masterpro,
            R.drawable.loggo,
            R.drawable.masterandroid,
            R.drawable.youtube,
            R.drawable.satar
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListAdapter adapter = new MyListAdapter(
                this,
                title,
                description,
                imgs);


        listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Handling click Events on items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Item 1 Selected:
                if(position == 0){
                    Toast.makeText(MainActivity.this,
                            "Item 1 Selected", Toast.LENGTH_SHORT).show();
                }
                // Item 2 Selected:
                if(position == 1){
                    Toast.makeText(MainActivity.this,
                            "Item 2 Selected", Toast.LENGTH_SHORT).show();
                }
                // Item 2 Selected:
                if(position == 2){
                    Toast.makeText(MainActivity.this,
                            "Item 3 Selected", Toast.LENGTH_SHORT).show();
                }
                // Item 1 Selected:
                if(position == 3){
                    Toast.makeText(MainActivity.this,
                            "Item 4 Selected", Toast.LENGTH_SHORT).show();
                }




            }
        });







    }
}
