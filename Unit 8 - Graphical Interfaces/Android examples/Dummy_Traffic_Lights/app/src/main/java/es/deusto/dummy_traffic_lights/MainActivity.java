package es.deusto.dummy_traffic_lights;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {

	// UI reference variables
	private ImageView redLight;
	private ImageView yellowLight;
	private ImageView greenLight;
	private Button redButton;
	private Button yellowButton;
	private Button greenButton;

	// This is the method that is called by the Android framework when your Activity is being initiated.
	// Ideal for:
	//     1. Setting a content view to your Activity.
	//     2. Getting references to the views defined in your layout.
	//     3. Adding event listeners to your views.

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// This should always be the first call, consider this a formality now.
		super.onCreate(savedInstanceState);

		// Sets a layout for the Activity using the layout resource identifier
		setContentView(R.layout.traffic_lights);

		// Obtain a reference to the view with the given id. The id must be defined in the layout
		// referenced by 'R.layout.traffic_lights'
		redLight = findViewById(R.id.red_light);
		yellowLight = findViewById(R.id.yellow_light);
		greenLight = findViewById(R.id.green_light);
		redButton = findViewById(R.id.red_button);
		yellowButton = findViewById(R.id.yellow_button);
		greenButton = findViewById(R.id.green_button);

		// Assign click listeners to buttons
		redButton.setOnClickListener(this);
		yellowButton.setOnClickListener(this);
		greenButton.setOnClickListener(this);
	}

	// This method is defined in the 'View.OnClickListener' interface
	@Override
	public void onClick(View v) {
		turnLightsOff();

		if (v == redButton) {
			turnOnRedLight();
		} else if (v == yellowButton) {
			turnOnYellowLight();
		} else if (v == greenButton) {
			turnOnGreenLight();
		}
	}

	private void turnLightsOff() {
		redLight.setImageResource(R.drawable.light_off);
		yellowLight.setImageResource(R.drawable.light_off);
		greenLight.setImageResource(R.drawable.light_off);
	}
	
	private void turnOnRedLight() {
		redLight.setImageResource(R.drawable.red_on);
	}

	private void turnOnYellowLight() {
		yellowLight.setImageResource(R.drawable.yellow_on);
	}

	private void turnOnGreenLight() {
		greenLight.setImageResource(R.drawable.green_on);
	}

}
