package com.masterandroid.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // ListView
    ListView listView;

    // Data to be displayed into list
    String[] mobileTypes = {
            "Galaxy Note 8", "Mate 20 pro", "Note 9 Plus", "Note 10 plus", "iphone X", "P30 pro hauwei"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listviewy);

        // Array Adapter:
        final ArrayAdapter adapter = new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            mobileTypes
        );

        listView.setAdapter(adapter);


        // Handling Click Events in ListView

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,
                        "Selected: " +adapter.getItem(position),
                        Toast.LENGTH_SHORT).show();
            }
        });






    }
}
