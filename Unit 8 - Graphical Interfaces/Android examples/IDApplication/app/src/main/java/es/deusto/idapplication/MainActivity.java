package es.deusto.idapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btnSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);
        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                // Following Sourth African ID number
                String idNumber = etID.getText().toString().trim();
                String date_birth = idNumber.substring(0, 6);
                int gender = Integer.parseInt( Character.toString(idNumber.charAt(6)) );
                String sGender = ( gender < 5 )  ? "Female" : "Male";

                int nationality = Integer.parseInt( Character.toString(idNumber.charAt(10)) );
                String sNationality = (nationality == 0) ? "SA Citizen" : "Permanent Resident";

                tvResults.setText(
                        getString(R.string.dob) + date_birth + "\n" +
                        getString(R.string.gender) + sGender + "\n" +
                        getString(R.string.nationality) + sNationality
                );
                tvResults.setVisibility(View.VISIBLE);
            }
        });
    }
}
