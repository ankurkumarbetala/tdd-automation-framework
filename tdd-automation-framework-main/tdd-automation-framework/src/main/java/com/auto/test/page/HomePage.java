package com.auto.test.page;

import com.framework.core.components.WebComponents;

public class HomePage extends WebComponents {

	static String PageName = HomePage.class.getSimpleName(); // HomePage

	public HomePage() {
		super(PageName);
	}

	public LoginPage clickOnSignIn() throws Exception {
		clickElement("btn_SignIn");
		return new LoginPage();
	}

	public String getCustomerName() throws Exception {
		String text = getTextFromElement("lbl_CustomerName");
		return text;
	}
	
	public void EnterEmailForRegistration(String email) throws Exception{
		typeInto("tbx_EmailCreate",email);
	}
	
	public void ClickCreateAnAccount() throws Exception{
		clickElement("btn_CreateAnAccount");
	}
	
	
	public RegistrationPage createAnAccountAs(String email) throws Exception{
		EnterEmailForRegistration(email);
		ClickCreateAnAccount();
		return new RegistrationPage();
	}
}
