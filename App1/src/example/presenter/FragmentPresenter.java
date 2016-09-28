

package example.presenter;

import example.view.IFragmentView;

public class FragmentPresenter implements IFragmentPresenter {

    private IFragmentView fragmentView;

    public FragmentPresenter(IFragmentView fragmentView) {
        this.fragmentView = fragmentView;
    }

	@Override
	public void setFragment(int iFragmentCode) {
		// TODO Auto-generated method stub
	if(iFragmentCode==1)
		fragmentView.setLoginFragment();
	else
		fragmentView.setSignupFragment();
		
	}

   

}
