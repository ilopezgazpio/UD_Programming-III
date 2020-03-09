package es.deusto.ingenieria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    TextView etSurname;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        etSurname = findViewById(R.id.etSurname);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (etSurname.getText().toString().isEmpty())
                {
                    Toast.makeText(Activity3.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String surname = etSurname.getText().toString().trim();
                    Intent intent = new Intent();
                    intent.putExtra("surname", surname);
                    setResult(RESULT_OK, intent);
                    Activity3.this.finish();
                }
            }
        });
    }
}
