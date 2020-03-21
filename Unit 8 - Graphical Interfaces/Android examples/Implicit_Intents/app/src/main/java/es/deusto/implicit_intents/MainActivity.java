package es.deusto.implicit_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button btnMap, btnWeb, btnCall, btnCallFiend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById (R.id.btnCall);
        btnCallFiend = findViewById (R.id.btnCallFriend);
        btnMap = findViewById (R.id.btnMap);
        btnWeb = findViewById (R.id.btnWeb);


        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });


        btnCallFiend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:686589665"));
                startActivity(intent);
            }
        });


        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Deusto Donostia"));
                startActivity(intent);

            }
        });


        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.es"));
                startActivity(intent);
            }
        });
    }
}
