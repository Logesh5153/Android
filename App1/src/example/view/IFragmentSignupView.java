package example.view;

public interface IFragmentSignupView {

	void setEmailError();

	void setEmailInValidError();

	void setPasswordError();

	void setPasswordInValidError();

	void setPasswordSpecialCharError();

	void setPasswordLengthError();

	void setNameError();

	void setContactError();

	void setContactLengthError();

	void success();

	void setEmailExistsError();

}
