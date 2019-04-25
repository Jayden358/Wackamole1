package teencoder.androidprogramming;

import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import  android.os.Bundle;

public class Options extends Activity implements OnClickListener {

	@Override
	public void onClick(View v) {
		if (v.getId() != R.id.buttonPlay)
			return;
		Intent myIntent = new Intent(this,Game.class);
		
		int difficulty;
		
		EditText ev= (EditText)findViewById(R.id.entname);
		RadioButton easy = (RadioButton)findViewById(R.id.Easy);
		RadioButton medium = (RadioButton)findViewById(R.id.Medium);
		SeekBar sb = (SeekBar)findViewById(R.id.GameDuration);
		Spinner sp = (Spinner)findViewById(R.id.spinner1);
		
		
		
		if(easy.isChecked())
			difficulty= 3;
		else if (medium.isChecked())
			difficulty =2;
		else
			difficulty =3;
		
		
		String name = ev.getText().toString();
		int duration = sb.getProgress();
		
		int numMoles = sp.getSelectedItemPosition() + 3;
		
		saveSettingsInIntent(difficulty, name, numMoles, duration, myIntent);
		
		
		startActivity(myIntent);
		
		
		
		
	}
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options);
		
		
		setUpSpinner();
		
		Button playButton = (Button)findViewById(R.id.PlayButton);
		playButton.setOnClickListener(this);
		
		loadSettings();
	
	}
	
	
	
	private void setUpSpinner() {
		Spinner sp =(Spinner)findViewById(R.id.spinner1);
				
				String[] numMoles = {"3", "4", "5", "6", "7", "8"};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, numMoles);
		
		sp.setAdapter(adapter);
	}
	
	private void saveSettingsInIntent(int difficulty, String name, int numMoles,
			int duration, Intent myIntent) {
		myIntent.putExtra("Name", name);
		myIntent.putExtra("Difficulty", difficulty);
		myIntent.putExtra("Moles", numMoles);
		myIntent.putExtra("Duration", duration);
		
	}
	
	

}
