package sh.update.android101_1;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		private Android101 android101;

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			
			android101 = new Android101((TextView)rootView.findViewById(R.id.textview));
			
			final Button run = (Button) rootView.findViewById(R.id.run_button);
			final EditText editText = (EditText) rootView.findViewById(R.id.edittext);
			
			editText.setOnEditorActionListener(new OnEditorActionListener() {
			    @Override
			    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
			        boolean handled = false;
			        if (actionId == EditorInfo.IME_ACTION_GO) {
			        	run.performClick();
			            handled = true;
			        }
			        return handled;
			    }
			});
			
			
			run.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					android101.run(editText.getText().toString());
				}
			});
			
			return rootView;
		}
	}

}
