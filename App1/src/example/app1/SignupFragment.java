package example.app1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import example.presenter.FragmentSignupPresenter;
import example.presenter.IFragmentSignupPresenter;
import example.view.IFragmentSignupView;

public class SignupFragment extends Fragment implements IFragmentSignupView {
	Database db;
	Typeface tf;
	EditText eEmail, ePassword, eName, eContactNumber;
	Button bCreate;
	IFragmentSignupPresenter presenter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_signup, container,
				false);

		eEmail = (EditText) rootView.findViewById(R.id.editTextEmail);
		ePassword = (EditText) rootView.findViewById(R.id.editTextPassword);
		eName = (EditText) rootView.findViewById(R.id.editTextName);
		eContactNumber = (EditText) rootView.findViewById(R.id.editTextNumber);
		bCreate = (Button) rootView.findViewById(R.id.buttoncreate);
		presenter = new FragmentSignupPresenter(this);

		bCreate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.d("Create", "Onclick");
				presenter.createuser(eEmail.getText().toString().trim(),
						ePassword.getText().toString().trim(), eName.getText()
								.toString().trim(), eContactNumber.getText()
								.toString().trim(), getActivity());

			}
		});

		return rootView;
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
	public void setNameError() {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "Name Should not be Empty",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void setContactError() {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "Contact Number Should not be Empty",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void success() {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "Account Created Successfully",
				Toast.LENGTH_SHORT).show();
		Intent i = new Intent(getActivity(), MainActivity.class);
		startActivity(i);
		getActivity().finish();
	}

	@Override
	public void setEmailInValidError() {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "Please Enter valid email",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void setPasswordInValidError() {
		// TODO Auto-generated method stub
		Toast.makeText(
				getActivity(),
				"Password should contains atleast 1 uppercase,1 lowercase and 1 digit",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void setPasswordSpecialCharError() {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(),
				"Password Should contain atleast 1 special Character",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void setPasswordLengthError() {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "Password length should be atleast 6",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void setContactLengthError() {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "Contact Number Length should be 10",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void setEmailExistsError() {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "Email Already Exists",
				Toast.LENGTH_SHORT).show();
	}

}
