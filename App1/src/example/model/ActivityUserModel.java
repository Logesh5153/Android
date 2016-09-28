package example.model;

import android.app.Activity;
import example.app1.Database;
import example.app1.NewUsersDAO;

public class ActivityUserModel implements IActivityUserModel {

	Database db;

	@Override
	public void login(String email, String password,
			OnLoginFinishedListener listener, Activity activity) {
		// TODO Auto-generated method stub

		db = new Database(activity);

		NewUsersDAO newUsers = db.getByEmail(email, password);
		listener.onSuccess(newUsers);
	}
}
