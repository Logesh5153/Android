package example.presenter;

import android.app.Activity;
import example.model.FragmentLoginModel;
import example.model.IFragmentLoginModel;
import example.view.IFragmentLoginView;

public class FragmentLoginPresenter implements IFragmentLoginPresenter,
		IFragmentLoginModel.OnLoginFinishedListener {

	private IFragmentLoginView fragmentView;
	private IFragmentLoginModel fragmentLoginModel;

	public FragmentLoginPresenter(IFragmentLoginView fragmentView) {
		this.fragmentView = fragmentView;
		this.fragmentLoginModel = new FragmentLoginModel();
	}

	@Override
	public void validateCredentials(String sEmail, String sPassword,
			Activity activity) {
		// TODO Auto-generated method stub
		fragmentLoginModel.login(sEmail, sPassword, this, activity);
	}

	@Override
	public void onEmailError() {
		// TODO Auto-generated method stub
		fragmentView.setEmailError();
	}

	@Override
	public void onPasswordError() {
		// TODO Auto-generated method stub
		fragmentView.setPasswordError();
	}

	@Override
	public void onSuccess() {
		// TODO Auto-generated method stub
		fragmentView.navigateToWelcomeActivity();
	}

	@Override
	public void onEmailPasswordError() {
		// TODO Auto-generated method stub
		fragmentView.setEmailPasswordError();
	}

}
