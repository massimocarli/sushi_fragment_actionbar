package it.apogeo.sushi.fragment.nouifragmenttest;

import it.apogeo.sushi.fragment.nouifragmenttest.CounterFragment.CounterListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements CounterListener {
	
	/*
	 * The output for the counter
	 */
	private TextView mOutput;	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the reference to the TextView 
        mOutput = (TextView) findViewById(R.id.output);
        // We create the Fragment and put it into the layou        
        if (savedInstanceState == null) {
            Fragment fragment = new CounterFragment();
            fragment.setRetainInstance(true);
            getSupportFragmentManager().beginTransaction()
            	.add(R.id.container, fragment).commit();        	
        }
        Log.i("BUNDLE", ""+savedInstanceState);
    }

	@Override
	public void count(final int countValue) {
		runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				mOutput.setText("Counter: " + countValue);
			}
		});		
	}
    
}
