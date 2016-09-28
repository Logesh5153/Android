package example.app1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import example.presenter.FragmentLoginPresenter;
import example.presenter.IFragmentLoginPresenter;
import example.view.IFragmentLoginView;

public class LoginFragment extends Fragment implements IFragmentLoginView {
	Typeface tf;
	Database db;
	Button bSubmit;
	EditText eEmail, ePassword;
	IFragmentLoginPresenter presenter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_login, container,
				false);

		eEmail = (EditText) rootView.findViewById(R.id.editTextEmail);
		ePassword = (EditText) rootView.findViewById(R.id.editTextPassword);
		bSubmit = (Button) rootView.findViewById(R.id.buttonSubmit);

		db = new Database(getActivity());
		presenter = new FragmentLoginPresenter(this);

		String fontPath = "fonts/icomoon.ttf";
		tf = Typeface.createFromAsset(getActivity().getAssets(), fontPath);

		String s2 = getResources().getString(R.string.signin);

		bSubmit.setText(s2 + " Login");
		bSubmit.setTypeface(tf);

		bSubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				presenter.validateCredentials(eEmail.getText().toString()
						.trim(), ePassword.getText().toString().trim(),
						getActivity());

			}
		});

		return rootView;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void setEmailError() {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "Email Should not be Empty",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void setPasswordError() {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "Password Should not be Empty",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void navigateToWelcomeActivity() {
		// TODO Auto-generated method stub
		Intent i = new Intent(getActivity(), LoginWelcomeActivity.class);
		i.putExtra("email", eEmail.getText().toString());
		i.putExtra("password", ePassword.getText().toString());
		startActivity(i);
		getActivity().finish();
	}

	@Override
	public void setEmailPasswordError() {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "Invalid Email / Password Error",
				Toast.LENGTH_SHORT).show();
	}

}
