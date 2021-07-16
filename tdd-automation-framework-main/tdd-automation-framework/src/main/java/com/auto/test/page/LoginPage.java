package com.auto.test.page;

import com.framework.core.components.WebComponents;

public class LoginPage extends WebComponents {

	static String PageName = LoginPage.class.getSimpleName();

	public LoginPage() {
		super(PageName);
	}

	public void enterEmailAddress(String email) throws Exception {
		typeInto("tbx_EmailAddress", email);
	}

	public void enterPassword(String password) throws Exception {
		typeInto("tbx_Password", password);
	}

	public HomePage clickSignIn() throws Exception {
		clickElement("btn_SignIn");

		return new HomePage();
	}

	public HomePage loginAs(String userName, String password) throws Exception {
		enterEmailAddress(userName);
		enterPassword(password);
		return clickSignIn();
	}

}
