package example.presenter;

import android.app.Activity;
import android.util.Log;
import example.model.FragmentSignupModel;
import example.model.IFragmentSignupModel;
import example.view.IFragmentSignupView;

public class FragmentSignupPresenter implements IFragmentSignupPresenter,
		IFragmentSignupModel.OnSignupFinishedListener {

	private IFragmentSignupView fragmentView;
	private IFragmentSignupModel fragmentSignupModel;

	public FragmentSignupPresenter(IFragmentSignupView fragmentView) {
		this.fragmentView = fragmentView;
		this.fragmentSignupModel = new FragmentSignupModel();
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
		fragmentView.success();
	}

	@Override
	public void createuser(String sEmail, String sPassword, String sName,
			String sContact, Activity activity) {
		// TODO Auto-generated method stub
		Log.d("Presenter", "Onclick");
		fragmentSignupModel.create(sEmail, sPassword, sName, sContact, this,
				activity);
	}

	@Override
	public void onNameError() {
		// TODO Auto-generated method stub
		fragmentView.setNameError();
	}

	@Override
	public void onContactError() {
		// TODO Auto-generated method stub
		fragmentView.setContactError();
	}

	@Override
	public void onEmailInvalidError() {
		// TODO Auto-generated method stub
		fragmentView.setEmailInValidError();
	}

	@Override
	public void onPasswordInvalidError() {
		// TODO Auto-generated method stub
		fragmentView.setPasswordInValidError();
	}

	@Override
	public void onPasswordSplCharError() {
		// TODO Auto-generated method stub
		fragmentView.setPasswordSpecialCharError();
	}

	@Override
	public void onPasswordLengthError() {
		// TODO Auto-generated method stub
		fragmentView.setPasswordLengthError();
	}

	@Override
	public void onContactLengthError() {
		// TODO Auto-generated method stub
		fragmentView.setContactLengthError();
	}

	@Override
	public void onEmailExists() {
		// TODO Auto-generated method stub
		fragmentView.setEmailExistsError();
	}

}
