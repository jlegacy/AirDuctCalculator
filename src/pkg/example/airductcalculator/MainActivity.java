package pkg.example.airductcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	String[] day;

	public static double getDuctValue(String ductType) {
		if (ductType.compareTo("metal duct") == 0) {
			return 1.00;
		}
		if (ductType.compareTo("duct board") == 0) {
			return 1.05;
		}
		if (ductType.compareTo("flex duct") == 0) {
			return 1.10;
		}
		return 0.0;
	}

	public static double getFrictionValue(String frictionValue) {
		if (frictionValue.trim().compareTo("") == 0) {
			return 0.0;
		} else {
			return Double.valueOf(frictionValue);
		}
	}

	public static int getCFMValue(String CFMValue) {
		if (CFMValue.trim().compareTo("") == 0) {
			return 0;
		} else {
			return Integer.valueOf(CFMValue);
		}
	}

	public static double getRoundToSquareValue(String RoundToSquareValue) {
		if (RoundToSquareValue.trim().compareTo("") == 0) {
			return 0.0;
		} else {
			return Double.valueOf(RoundToSquareValue);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// if (savedInstanceState == null) {
		// getFragmentManager().beginTransaction()
		// .add(R.id.container, new PlaceholderFragment()).commit();
		// }
		Spinner spinner = (Spinner) findViewById(R.id.ductTypeSpinner);
		EditText editFriction = (EditText) findViewById(R.id.editFriction);
		EditText editCFM = (EditText) findViewById(R.id.editCFM);
		EditText squareRoundEdit = (EditText) findViewById(R.id.squareRoundEdit);

		// ***********************************************
		// Set up Duct Type Spinner Actions
		// ***********************************************

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.ductType_arrays,
				android.R.layout.simple_spinner_item);

		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Toast.makeText(
						getBaseContext(),
						"Drop Down Contains"
								+ arg0.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
			
				//CalculateResults('U');

			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}

		});

		editFriction.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			EditText editFriction = (EditText) findViewById(R.id.editFriction);

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					Toast.makeText(
							getBaseContext(),
							"Friction Contains"
									+ editFriction.getText().toString(), Toast.LENGTH_SHORT).show();
					// setFrictionValue(editFriction.getText().toString());
					// CalculateResults('U');

				}
			}

		});

		editCFM.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			EditText editCFM = (EditText) findViewById(R.id.editCFM);

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					Toast.makeText(
							getBaseContext(),
							"CFM Contains" + editCFM.getText().toString(), Toast.LENGTH_SHORT).show();
					// setCFMValue(editCFM.getText().toString());
					// CalculateResults('U');

				}
			}

		});

		squareRoundEdit
				.setOnFocusChangeListener(new View.OnFocusChangeListener() {
					EditText squareRoundEdit = (EditText) findViewById(R.id.squareRoundEdit);

					@Override
					public void onFocusChange(View v, boolean hasFocus) {
						if (!hasFocus) {
							Toast.makeText(
									getBaseContext(),
									"Round to Square"
											+ squareRoundEdit.getText()
													.toString(),
									Toast.LENGTH_SHORT).show();
							// setRoundToSquareValue(squareRoundEdit.getText().toString());
						//	CalculateResults('U');

						}
					}

				});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	
	public void CalculateResults(char Units) {
		
	
		Spinner spinner = (Spinner) findViewById(R.id.ductTypeSpinner);
		EditText editFriction = (EditText) findViewById(R.id.editFriction);
		EditText editCFM = (EditText) findViewById(R.id.editCFM);
	//	EditText squareRoundEdit = (EditText) findViewById(R.id.squareRoundEdit);
		
		TextView editVelocity = (TextView) findViewById(R.id.editVelocity);
		editVelocity.setText("nan");
		return;
		/*
		// j17
		int j17 = getCFMValue(editCFM.getText().toString());
		// f5
		double f5 = getFrictionValue(editFriction.getText().toString());
		// k7
		double k7 = getDuctValue(spinner.getSelectedItem().toString());

		if ((j17 <= 0) || (f5 <= 0) || (k7 <= 0)) {
			editVelocity.setText("nan");
			return;
		}

		// e6
		double e6 = (.109136 * Math.pow(j17, 1.9));

		// d5
		double d5 = e6 / f5;
		// d9
		double d9 = Math.pow(d5, (1 / 5.02)) * k7;
		// j26 - I know this sucks for clarity, it going with it...
		double j26 = d9;
		// j23
		double j23 = j17 / (((j26 / 2 * j26 / 2) * 3.14) / 144);

	
		editVelocity.setText(String.valueOf(j23)); */

	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	/*
	 * public static class PlaceholderFragment extends Fragment {
	 * 
	 * public PlaceholderFragment() { }
	 * 
	 * @Override public View onCreateView(LayoutInflater inflater, ViewGroup
	 * container, Bundle savedInstanceState) { View rootView =
	 * inflater.inflate(R.layout.fragment_main, container, false); return
	 * rootView; } }
	 */

}
