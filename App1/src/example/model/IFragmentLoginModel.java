package example.model;

import android.app.Activity;

public interface IFragmentLoginModel {

	interface OnLoginFinishedListener {
		void onEmailError();

		void onPasswordError();

		void onEmailPasswordError();

		void onSuccess();
	}

	void login(String email, String password, OnLoginFinishedListener listener,
			Activity activity);

}
