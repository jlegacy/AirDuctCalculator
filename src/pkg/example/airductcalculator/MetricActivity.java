package pkg.example.airductcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class MetricActivity extends Activity {
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

	public static double getCFMValue(String CFMValue) {
		if (CFMValue.trim().compareTo("") == 0) {
			return 0.0;
		} else {
			return Double.valueOf(CFMValue);
		}
	}

	public static double getSquareRoundEditValue(String RoundToSquareValue) {
		if (RoundToSquareValue.trim().compareTo("") == 0) {
			return 0.0;
		} else {
			return Double.valueOf(RoundToSquareValue);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_metric);

		// if (savedInstanceState == null) {
		// getFragmentManager().beginTransaction()
		// .add(R.id.container, new PlaceholderFragment()).commit();
		// }
		Spinner spinner = (Spinner) findViewById(R.id.ductTypeSpinner);
		EditText editFriction = (EditText) findViewById(R.id.editFriction);
		EditText editCFM = (EditText) findViewById(R.id.editCFM);
		EditText squareRoundEdit = (EditText) findViewById(R.id.squareRoundEdit);

		TextView editVelocity = (TextView) findViewById(R.id.editVelocity);
		TextView textDuctSize = (TextView) findViewById(R.id.textDuctSize);
		TextView textWidthDuctSize = (TextView) findViewById(R.id.textWidthDuctSize);

		// retrieve value initially//
		MetricFriction g = MetricFriction.getInstance();
		if (g.getData() > 0) {
			editFriction.setText(String.valueOf(g.getData()));
		}

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
				// Toast.makeText(
				// getBaseContext(),
				// "Drop Down Contains"
				// + arg0.getSelectedItem().toString(),
				// Toast.LENGTH_SHORT).show();

				CalculateResults('U');

			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}

		});

		editVelocity.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				CalculateResults('U');

			}

		});

		textDuctSize.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				CalculateResults('U');

			}

		});

		textWidthDuctSize.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				CalculateResults('U');

			}

		});

		editFriction.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			EditText editFriction = (EditText) findViewById(R.id.editFriction);

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					// Store//
					MetricFriction g = MetricFriction.getInstance();
					if (editFriction.getText().toString().trim().compareTo("") != 0) {
						g.setData(Integer.valueOf(editFriction.getText()
								.toString()));
						CalculateResults('U');
					}

				}
			}

		});

		editCFM.setOnFocusChangeListener(new View.OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus) {
					// Toast.makeText(
					// getBaseContext(),
					// "CFM Contains" + editCFM.getText().toString(),
					// Toast.LENGTH_SHORT).show();
					// setCFMValue(editCFM.getText().toString());
					CalculateResults('U');

				}
			}

		});

		squareRoundEdit.setOnKeyListener(new View.OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				 if (event.getAction() == KeyEvent.ACTION_UP) {
					 CalculateResults('U');
			        }
				// TODO Auto-generated method stub
				return false;
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
		EditText squareRoundEdit = (EditText) findViewById(R.id.squareRoundEdit);

		TextView editVelocity = (TextView) findViewById(R.id.editVelocity);
		editVelocity.setText("");

		TextView textDuctSize = (TextView) findViewById(R.id.textDuctSize);
		textDuctSize.setText("");

		TextView textWidthDuctSize = (TextView) findViewById(R.id.textWidthDuctSize);
		textWidthDuctSize.setText("");

		double j66 = getCFMValue(editCFM.getText().toString());

		double j77 = getSquareRoundEditValue(squareRoundEdit.getText()
				.toString());

		double j62 = getFrictionValue(editFriction.getText().toString());

		double j59 = getDuctValue(spinner.getSelectedItem().toString());

		if ((j66 <= 0) || (j62 <= 0) || (j59 <= 0)) {
			return;
		}
		double e51 = j66 * 2118.879;
		double e52 = (.109136 * Math.pow(e51, 1.9));

		double f51 = j62 * .0040415;
		double d51 = e52 / f51;

		double d55 = Math.pow(d51, (1 / 5.02)) * j59;
		double e55 = d55 / 2;

		// j26 - I know this sucks for clarity, it going with it...
		double j73 = d55 * 25.4;

		double l77 = (3.14 * ((j73 / 2) * (j73 / 2)) / j77) * 1.18;

		double j69 = (e51 / ((e55 * e55 * 3.14)) * 144) * .0051;

		editVelocity.setText(String.valueOf(Math.ceil(j69 * 1000) / 1000));

		textDuctSize.setText(String.valueOf(Math.ceil(j73 * 1) / 1));
		
		if ((String.valueOf(Math.ceil(l77 * 10) / 10)).compareTo("Infinity") != 0)
				{
			textWidthDuctSize.setText(String.valueOf(Math.ceil(l77 * 10) / 10));
			
				}
		

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
