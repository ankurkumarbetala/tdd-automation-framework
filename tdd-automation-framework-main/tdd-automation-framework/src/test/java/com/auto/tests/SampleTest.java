package com.auto.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.framework.core.browser.WebDriverManager;
import com.framework.core.components.ScreenRecorderUtil;
import com.framework.core.helpers.Configs;

public class SampleTest {

/*	@BeforeSuite
	public void beforeEverythingElse() throws Exception {
		Configs.initializeEnvironmentProperties();
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		WebDriverManager driverManager = new WebDriverManager();
		driverManager.initializeWebDriver();
	}

	@Test
	public void launchBrowser_Test1() throws Exception {
		//ScreenRecorderUtil.startRecord("TestRecording");
		WebDriverManager.realWebDriver.get().get("https://www.amazon.ca");
		Thread.sleep(4000);
		//ScreenRecorderUtil.stopRecord();
	}

	@AfterMethod
	public void tearDown() {
		WebDriverManager.realWebDriver.get().quit();
	}
*/
}
