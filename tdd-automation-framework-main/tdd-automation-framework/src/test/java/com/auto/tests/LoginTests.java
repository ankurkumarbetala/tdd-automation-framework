package com.auto.tests;

import org.testng.annotations.Test;

import com.framework.core.components.DataProviderUtils;

public class LoginTests /* extends Hooks */ {

	@Test(dataProvider = "ExcelDataProvider", dataProviderClass = DataProviderUtils.class)
	public void loginScenario(String UserName, String Password, String FirstName, String LastName)
			throws Exception {
		System.out.println("UserName: " + UserName + ", Password: " + Password + ", FirstName: "
				+ FirstName + ", LastName: " + LastName);
		/*
		 * HomePage homePage = new HomePage();// HomePage LoginPage loginPage =
		 * homePage.clickOnSignIn();// LoginPage homePage = loginPage.loginAs(UserName,
		 * Password); String loginUser = homePage.getCustomerName();
		 */
		// TestAsserts.assertEquals("TarunSachdeva", loginUser);

		// Thread.sleep(4000);
	}

}
