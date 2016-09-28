package example.app1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import example.presenter.FragmentPresenter;
import example.presenter.IFragmentPresenter;
import example.view.IFragmentView;

public class MainActivity extends FragmentActivity implements IFragmentView,
		View.OnClickListener {

	private IFragmentPresenter presenter;
	private CustomViewpager viewPager;
	LoginFragment login;
	SignupFragment signup;
	ProgressBar progressBar;
	TabsPagerAdapter mAdapter;
	Fragment fragment;
	int resume;
	Button bLogin, bSignup;
	int iColorWhite, iColorBlue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		login = new LoginFragment();
		signup = new SignupFragment();
		viewPager = (CustomViewpager) findViewById(R.id.pager);
		bLogin = (Button) findViewById(R.id.button1);

		bSignup = (Button) findViewById(R.id.button2);

		iColorWhite = getResources().getColor(R.color.colorWhite);
		iColorBlue = getResources().getColor(R.color.colorblue);

		bLogin.setTextColor(iColorWhite);
		bSignup.setTextColor(iColorBlue);
		bLogin.setBackgroundColor(iColorBlue);
		bSignup.setBackgroundColor(iColorWhite);
		bLogin.setBackground(getResources()
				.getDrawable(R.drawable.buttonstyle1));
		bSignup.setBackground(getResources().getDrawable(
				R.drawable.buttonstyleright));

		mAdapter = new TabsPagerAdapter(getSupportFragmentManager(), login,
				signup);

		viewPager.setAdapter(mAdapter);

		bLogin.setOnClickListener(this);
		bSignup.setOnClickListener(this);
		presenter = new FragmentPresenter(this);

		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				fragment = ((FragmentPagerAdapter) viewPager.getAdapter())
						.getItem(arg0);

				if (arg0 == 1 && fragment != null) {
					fragment.onResume();

				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.button1:
			presenter.setFragment(1);

			break;
		case R.id.button2:
			presenter.setFragment(2);
			break;
		default:
			break;
		}
	}

	@Override
	public void setLoginFragment() {
		// TODO Auto-generated method stub
		viewPager.setCurrentItem(0);
		resume = 1;
		bLogin.setTextColor(iColorWhite);
		bSignup.setTextColor(iColorBlue);
		bLogin.setBackgroundColor(iColorBlue);
		bSignup.setBackgroundColor(iColorWhite);
		bLogin.setBackground(getResources()
				.getDrawable(R.drawable.buttonstyle1));
		bSignup.setBackground(getResources().getDrawable(
				R.drawable.buttonstyleright));

	}

	@Override
	public void setSignupFragment() {
		// TODO Auto-generated method stub
		viewPager.setCurrentItem(1);
		resume = 1;
		bLogin.setTextColor(iColorBlue);
		bSignup.setTextColor(iColorWhite);
		bLogin.setBackgroundColor(iColorWhite);
		bSignup.setBackgroundColor(iColorBlue);
		bSignup.setBackground(getResources().getDrawable(
				R.drawable.buttonshaperight));
		bLogin.setBackground(getResources().getDrawable(R.drawable.buttonstyle));

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		if (resume == 1) {
			bLogin.setPressed(true);
			bLogin.setTextColor(iColorWhite);
		} else if (resume == 2) {
			bSignup.setPressed(true);
			bSignup.setTextColor(iColorWhite);
		}

	}
}
