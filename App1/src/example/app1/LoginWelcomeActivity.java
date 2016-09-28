package example.app1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import example.presenter.ActivityUserPresenter;
import example.presenter.IActivityUserPresenter;
import example.view.IActivityUserView;

public class LoginWelcomeActivity extends Activity implements IActivityUserView {

	TextView tName, tEmail, tNumber,tSignout;
	IActivityUserPresenter presenter;
	Typeface tf;
	String sEmail, sPassword,sSignout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_welcome);

		tEmail = (TextView) findViewById(R.id.textViewEmail);
		tName = (TextView) findViewById(R.id.textViewName);
		tNumber = (TextView) findViewById(R.id.textViewNumber);
		tSignout = (TextView) findViewById(R.id.tright);
		
		String fontPath = "fonts/icomoon.ttf";
		tf = Typeface.createFromAsset(getAssets(), fontPath);

		 sSignout = getResources().getString(R.string.signout);

		Intent intent = getIntent();
		sEmail = intent.getStringExtra("email");
		sPassword = intent.getStringExtra("password");
		
		presenter = new ActivityUserPresenter(this);

		presenter.setDetails(sEmail, sPassword, LoginWelcomeActivity.this);
		
		tSignout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent  i = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(i);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_welcome, menu);
		return true;
	}

	@Override
	public void setEmail(NewUsersDAO newusers) {
		// TODO Auto-generated method stub
		tSignout.setText(sSignout);
		tSignout.setTypeface(tf);
		tEmail.setText(newusers.getEmail());
		tName.setText(newusers.getName());
		tNumber.setText(newusers.getMobile());
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent  i = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(i);
		finish();
	}
}
