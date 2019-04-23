package teencoder.androidprogramming;

import android.view.View;
import android.view.View.OnClickListener;

public class Options implements OnClickListener {

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	private void setUpSpinner() {
		spinner1;
		String[] MoleMaxNumbers = {"3", "4", "5", "6", "7", "8"};
		MoleMaxNumbers.setAdapter(itemsAdapter);
	}

}
