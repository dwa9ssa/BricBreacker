package ma.bricbreacker;

import ma.brickbreaker.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BricBreackerMain extends Activity {

	private int margeBarre = 200;
	private int margeBrique = 250;
	private int nbrBrique = 1;
	private int initialSpeed = 8;
	
	private EditText etMargeBrique;
	private EditText etNombreBriques;
	private EditText etVitesseBalle;
	private Button btnJouer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bric_breacker_main); 
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		etMargeBrique = (EditText) findViewById(R.id.etMargeBrique);
		etNombreBriques = (EditText) findViewById(R.id.etNombreBriques);
		etVitesseBalle = (EditText) findViewById(R.id.etVitesseBalle);
		btnJouer = (Button) findViewById(R.id.btnJouer);
		
		etMargeBrique.setText(String.valueOf(margeBrique));
		etNombreBriques.setText(String.valueOf(nbrBrique));
		etVitesseBalle.setText(String.valueOf(initialSpeed));
		
		btnJouer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(BricBreackerMain.this, GameActivity.class);
				intent.putExtra("margeBarre", margeBarre);
				intent.putExtra("margeBrique", Integer.valueOf(etMargeBrique.getText().toString()));
				intent.putExtra("nbrBrique", Integer.valueOf(etNombreBriques.getText().toString()));
				intent.putExtra("initialSpeed", Integer.valueOf(etVitesseBalle.getText().toString()));
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bric_breacker_main, menu);
		return true;
	}

}
