package net.morodomi.lecture5;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * Activity for Android Lecture 5
 * Controls AsyncTask and Dialog
 * @author Masahiro Morodomi <morodomi at gmail.com>
 *
 */
public class AsyncActivity extends Activity implements OnClickListener{
	private static final int DIALOG_PROGRESS = 0;
	private static final int CALCULATION_NUMBER = 10000;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// set onc click listener
		findViewById(R.id.start).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// execute calculation asynchronously.
		new AsyncCalc().execute(CALCULATION_NUMBER);
	}

	/** Called by Android Framework with showDialog(id) method */
	@Override
	protected Dialog onCreateDialog(int id) {
		switch(id) {
		// if id matches DIALOG_PROGRESS, show progress dialog
		case DIALOG_PROGRESS:
			ProgressDialog progressDialog = new ProgressDialog(this);
			progressDialog.setMessage(getString(R.string.calculating));
			return progressDialog;
		}
		// if id does not match with any, return null
		return null;
	}

	/**
	 * private class that calculate numbers asynchronously.
	 * @author Masahiro Morodomi <morodomi at gmail.com>
	 */
	class AsyncCalc extends AsyncTask<Integer, Void, Long> {
		// save start and end time
		private long startTime;
		private long endTime;

		@Override
		protected void onPreExecute() {}

		@Override
		protected Long doInBackground(Integer... params) {
			// saving start time
			startTime = System.currentTimeMillis();
			long response = 0;
			// calculate summation of the param.
			while(params[0] > 0) {
				response += params[0];
				params[0]--;
			}
			// saving end time
			endTime = System.currentTimeMillis();
			// passing the value to onPostExecute
			return response;
		}
	
		@Override
		protected void onPostExecute(Long result) {
			// display time and answer
			((TextView) findViewById(R.id.time)).setText("Time Diff: " + (endTime - startTime) + " ms");
			((TextView) findViewById(R.id.result)).setText("Result: " + result);
		}
	}
}