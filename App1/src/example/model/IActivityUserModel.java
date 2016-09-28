package example.model;

import android.app.Activity;
import example.app1.NewUsersDAO;

public interface IActivityUserModel {

	interface OnLoginFinishedListener {

		void onSuccess(NewUsersDAO newusers);
	}

	void login(String email,String password,OnLoginFinishedListener listener, Activity activity);

}
