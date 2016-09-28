package example.app1;

import java.util.HashMap;
import java.util.Map;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class TabsPagerAdapter extends FragmentPagerAdapter {
	private Map<Integer, String> mfarg;
	FragmentManager mfragmManager;
	LoginFragment expense;
	SignupFragment receiv;
	
	public TabsPagerAdapter(FragmentManager fm,LoginFragment expense,SignupFragment receiv) {
		super(fm);
		mfragmManager=fm;
		mfarg = new HashMap<Integer,String>();  
		this.expense = expense;
		this.receiv = receiv;
		
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity
			return expense;
		case 1:
			// Games fragment activity
			return receiv;
		
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 2;
	}
	
//	 @Override
//	    public Object instantiateItem(ViewGroup container, int position) {
//	        Object obj = super.instantiateItem(container, position);
//	        if (obj instanceof Fragment) {
//	            // record the fragment tag here.
//	            Fragment f = (Fragment) obj;
//	            String tag = f.getTag();
//	            Log.d("tagfragment", tag);
//	            mfarg.put(position, tag);
//	            
//	        }
//	        return obj;
//	    }
//	 
	 public Fragment getFragment(int position) {
	        String tag = mfarg.get(position);
	        Log.d("tagfragment", tag);
	        if (tag == null)
	            return null;
	        return mfragmManager.findFragmentByTag(tag);
	}
	 


}
