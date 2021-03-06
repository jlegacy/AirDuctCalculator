package pkg.example.airductcalculator;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainSplash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_splash);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		addListenerOnButton();
		
	}
	
	public void addListenerOnButton() {
		
		final Context context = this;
		
		Button ImperialButton  = (Button) findViewById(R.id.ImperialButton);
		Button MetricButton  = (Button) findViewById(R.id.MetricButton);
		
		ImperialButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				 Intent intent = new Intent(context, MainActivity.class);
                 startActivity(intent);   

			}

		});
		
		MetricButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				 Intent intent = new Intent(context, MetricActivity.class);
                 startActivity(intent);   

			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_splash, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main_splash,
					container, false);
			return rootView;
		}
	}

}
