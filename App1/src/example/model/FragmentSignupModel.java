package example.model;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import example.app1.Database;
import example.app1.NewUsersDAO;

public class FragmentSignupModel implements IFragmentSignupModel {

	Database db;
	NewUsersDAO newUsers;

	@Override
	public void create(String email, String password, String name,
			String contact, OnSignupFinishedListener listener, Activity activity) {
		// TODO Auto-generated method stub

		Log.d("Model", "Onclick");
		boolean error = false;
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		String PASSWORD_REGEX = "^(?=.*[_\\W]).+$";
		String PASSWORD_REGEX_CHAR = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$";
		// String email1 = "user@domain.com";
		Boolean b = email.matches(EMAIL_REGEX);
		Boolean bPasswordSpl = password.matches(PASSWORD_REGEX);
		Boolean bPassword = password.matches(PASSWORD_REGEX_CHAR);

		if (TextUtils.isEmpty(email)) {
			listener.onEmailError();
			error = true;
			return;
		}
		if ((!b)) {
			listener.onEmailInvalidError();
			error = true;
			return;
		}
		if (TextUtils.isEmpty(name) || name.equals("")) {
			listener.onNameError();
			error = true;
			return;
		}
		if (TextUtils.isEmpty(password)) {
			listener.onPasswordError();
			error = true;
			return;
		}

		if (!bPassword) {
			listener.onPasswordInvalidError();
			error = true;
			return;
		}
		if (!bPasswordSpl) {
			listener.onPasswordSplCharError();
			error = true;
			return;
		}
		if (password.length() < 6) {
			listener.onPasswordLengthError();
			error = true;
			return;
		}

		if (TextUtils.isEmpty(contact)) {
			listener.onContactError();
			error = true;
			return;
		}

		if (contact.length() != 10) {
			listener.onContactLengthError();
			error = true;
			return;
		}
		if (!error) {
			db = new Database(activity);
			NewUsersDAO checkUser = db.getByEmail(email);
			if (checkUser != null) {
				listener.onEmailExists();
			} else {
				newUsers = new NewUsersDAO();
				newUsers.setEmail(email);
				newUsers.setPassword(password);
				newUsers.setName(name);
				newUsers.setMobile(contact);
				db.addData(newUsers);
				listener.onSuccess();
			}

		}
	}
}
