package es.deusto.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String Message = "Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(Message, "onCreate method call");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Message, "onStart method call");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Message, "onStop method call");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Message, "onDestroy method call");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Message, "onPause method call");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Message, "onResume method call");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(Message, "onRestart method call");
    }
}
