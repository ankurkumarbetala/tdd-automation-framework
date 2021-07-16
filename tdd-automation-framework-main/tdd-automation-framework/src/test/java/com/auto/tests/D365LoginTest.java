package com.auto.tests;

import org.testng.annotations.Test;

import com.auto.test.page.D365LoginPage;
import com.framework.core.helpers.Hooks;

public class D365LoginTest extends Hooks {

	@Test(invocationCount = 1)
	public void loggingIntoD365() throws Exception {
		D365LoginPage d365LoginPage = new D365LoginPage();
		d365LoginPage.enterUsername("danj@CRM982058.OnMicrosoft.com");
		d365LoginPage.enterPassword("TKc287SeNK");
		d365LoginPage.staySignedInPage();
		d365LoginPage.switchtoIframe();
		Thread.sleep(5000);
	}
	
}
