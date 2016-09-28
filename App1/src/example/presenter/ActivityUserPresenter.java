package example.presenter;

import android.app.Activity;
import example.app1.NewUsersDAO;
import example.model.ActivityUserModel;
import example.model.IActivityUserModel;
import example.view.IActivityUserView;

public class ActivityUserPresenter implements IActivityUserPresenter,
		IActivityUserModel.OnLoginFinishedListener {

	private IActivityUserView fragmentView;
	private IActivityUserModel fragmentLoginModel;

	public ActivityUserPresenter(IActivityUserView fragmentView) {
		this.fragmentView = fragmentView;
		this.fragmentLoginModel = new ActivityUserModel();
	}

	@Override
	public void setDetails(String email, String password, Activity activity) {
		// TODO Auto-generated method stub
		fragmentLoginModel.login(email, password, this, activity);
	}

	@Override
	public void onSuccess(NewUsersDAO newusers) {
		// TODO Auto-generated method stub
		fragmentView.setEmail(newusers);
	}

}
