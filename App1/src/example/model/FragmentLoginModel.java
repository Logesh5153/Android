package example.model;

import android.app.Activity;
import android.text.TextUtils;
import example.app1.Database;
import example.app1.NewUsersDAO;

public class FragmentLoginModel implements IFragmentLoginModel {

	Database db;

	@Override
	public void login( String email,  String password,
			 OnLoginFinishedListener listener,  Activity activity) {

		boolean error = false;
		if (TextUtils.isEmpty(email)) {
			listener.onEmailError();
			error = true;
			return;
		}
		if (TextUtils.isEmpty(password) ) {
			listener.onPasswordError();
			error = true;
			return;
		}
		
		if (!error) {
			db = new Database(activity);

			NewUsersDAO newUsers = db.getByEmail(email, password);
			if (newUsers != null) {

				listener.onSuccess();
			} else {
				listener.onEmailPasswordError();
				error = true;
			}

		}

	}
}
