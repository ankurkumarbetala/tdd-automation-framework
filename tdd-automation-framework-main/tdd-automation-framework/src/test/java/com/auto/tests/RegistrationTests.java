package com.auto.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.auto.test.page.HomePage;
import com.auto.test.page.RegistrationPage;
import com.framework.core.components.DataProviderUtils;
import com.framework.core.helpers.DataUtils;
import com.framework.core.helpers.Hooks;

public class RegistrationTests extends Hooks {

	/*
	 * @Test(dataProvider = "ExcelDataProvider", dataProviderClass =
	 * DataProviderUtils.class) public void registerUser(String UserName, String
	 * Password, String FirstName, String LastName) throws Exception { HomePage
	 * homePage = new HomePage(); homePage.clickOnSignIn(); RegistrationPage
	 * registrationPage = homePage.createAnAccountAs(UserName);
	 * registrationPage.registerUserAs(UserName, Password, FirstName, LastName);
	 * Thread.sleep(4000); }
	 */
	@Test(invocationCount = 1)
	public void registerUserUsingRandomData() throws Exception {
		String email = RandomStringUtils.randomAlphabetic(8) + "@abc.com";
		HomePage homePage = new HomePage();
		homePage.clickOnSignIn();

		RegistrationPage registrationPage = homePage.createAnAccountAs(email);
		registrationPage.registerUserAs(email, RandomStringUtils.randomAlphanumeric(8),
				RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphabetic(8));
		Thread.sleep(4000);
	}

}