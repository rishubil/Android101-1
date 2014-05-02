package sh.update.android101_1;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

public class Android101Helper {
	private TextView mTextView;
	
	public Android101Helper(TextView textview) {
		mTextView = textview;
		mTextView.setMovementMethod(new ScrollingMovementMethod());
	}
	
	/**
	 * print string to textview
	 * @param output String to output
	 */
	protected void print(String output) {
		if (mTextView == null) {
			Log.e("Android101Helper", "mTextView is null.");
			return;
		} else if (output == null) {
			Log.w("Android101Helper", "output is null.");
			return;
		}
		
	    mTextView.append(output);
	    
	    final int scrollAmount = mTextView.getLayout().getLineTop(mTextView.getLineCount()) - mTextView.getHeight();
	    if (scrollAmount > 0) {
	        mTextView.scrollTo(0, scrollAmount);
	    } else {
	        mTextView.scrollTo(0, 0);
	    }
		
	}
}
