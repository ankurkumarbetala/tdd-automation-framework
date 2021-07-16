package com.framework.core.helpers;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.framework.core.browser.WebDriverManager;
import com.framework.core.components.WebComponents;
import com.relevantcodes.extentreports.LogStatus;

public class Hooks implements ITestListener {

	public WebDriver driver;

	@BeforeSuite
	public void setUpEnvironment() throws Exception {
		Configs.initializeEnvironmentProperties(); // application properties
	}

	@BeforeTest
	public void setUpTestConfigs() {

	}

	@BeforeMethod
	public void initBrowser() throws Exception {
		WebDriverManager driverManager = new WebDriverManager();
		driverManager.initializeWebDriver(); // Initialize driver so that it is available to all the
		driver = WebDriverManager.getRealWebDriver().get();
		driver.get(Configs.AppUrl);
	}

	@AfterTest
	public void tearDownTests() {

	}

	@AfterMethod
	public void TearDownBrowser() {
		driver.close();// closing the browser using driver.quit
	}

	@AfterSuite()
	public void tearDownEnvironment() {
		driver.quit();
	}
	
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName(); //ValidateShoppingCart();
	}


	@Override
	public void onTestStart(ITestResult result) {
		ExtentTestManager.startTest(getTestMethodName(result),"");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			String base64 =WebComponents.captureSnapshot(getTestMethodName(result), WebDriverManager.getRealWebDriver().get());
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed");
		ExtentTestManager.getTest().log(LogStatus.FAIL,
				ExtentTestManager.getTest().addBase64ScreenShot(base64));
		}catch(Exception e) {
			
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(LogStatus.SKIP, "Test SKIPPED");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentTestManager.stopTest();
		ExtentManager.getReporter().flush();

	}

}
