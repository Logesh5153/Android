package example.model;

import android.app.Activity;

public interface IFragmentSignupModel {

	interface OnSignupFinishedListener {
		void onEmailError();

		void onEmailInvalidError();

		void onPasswordError();

		void onPasswordInvalidError();

		void onPasswordSplCharError();

		void onPasswordLengthError();

		void onNameError();

		void onContactError();

		void onContactLengthError();

		void onSuccess();
		
		void onEmailExists();
	}

	void create(String email, String password, String name, String contact,
			OnSignupFinishedListener listener, Activity activity);

}
