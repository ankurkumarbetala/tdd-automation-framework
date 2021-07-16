package com.framework.core.components;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.framework.core.browser.WebDriverManager;
import com.framework.core.helpers.Configs;
import com.framework.core.helpers.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class WebComponents {

	//Awaitility Lib for chekcing if the element is chaging dynamicically.//Eren recommened.
	
	
	
	WebDriver driver;
	String PageName = "";

	public WebComponents(String PageName) {
		this.PageName = PageName;
		driver = WebDriverManager.getRealWebDriver().get();
	}

	public String getWebPageTitle() {
		return driver.getTitle();
	}

	public String getWebPageURL() {
		return driver.getCurrentUrl();
	}

	public void launchWebPage(String url) {
		try {
			driver.get(url);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Launch WebPage [" + url + "]");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.ERROR,
					"Unable to launch WebPage [" + url + "]");
		}
	}

	public void navigateToWebPage(String url) {
		try {
			driver.navigate().to(url);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Launch WebPage [" + url + "]");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.ERROR,
					"Unable to Navigate to WebPage [" + url + "]");

		}

	}

	public void refreshWebPage() {
		driver.navigate().refresh();
	}

	public void clickElement(String elementName) throws Exception {
		try {
			ElementFinder findEle = new ElementFinder();
			WebElement element = findEle.findElementByXpath(elementName, PageName);// HomePage
			element.click();
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Clicked Element [" + elementName + "] successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.ERROR,
					"Unable to click an element [" + elementName + "]");
			throw e;
		}
	}

	public void clearField(String elementName) throws Exception {
		try {
			ElementFinder findEle = new ElementFinder();
			WebElement element = findEle.findElementByXpath(elementName, PageName);
			element.clear();
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Cleared Element [" + elementName + "] successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.ERROR,
					"Unable to clear element [" + elementName + "]");
			throw e;
		}
	}

	public void typeInto(String elementName, String valuesToType) throws Exception {
		try {
			ElementFinder findEle = new ElementFinder();
			WebElement element = findEle.findElementByXpath(elementName, PageName);
			clickElement(elementName);
			Thread.sleep(200);
			clearField(elementName);
			Thread.sleep(200);
			element.sendKeys(valuesToType);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Entered value [" + valuesToType + "]  for element [" + elementName + "]");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.ERROR, "Unable to enter value ["
					+ valuesToType + "]  for element [" + elementName + "]");
			throw e;
		}
	}

	public String getTextFromElement(String elementName) throws Exception {
		try {
			ElementFinder findEle = new ElementFinder();
			WebElement element = findEle.findElementByXpath(elementName, PageName);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Fetched text for an element [" + elementName + "]");

			return element.getText();
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.ERROR,
					"Unable to fetch text for an element [" + elementName + "]");
			throw e;
		}
	}

	public static String captureSnapshot(String testName, WebDriver driver) throws Exception {
		/*
		 * if(Configs.takeScreenshot.equalsIgnoreCase(TakeScreenshot.ALWAYS.toString()))
		 * {
		 * 
		 * }
		 */
		ThreadLocal<String> base64 = new ThreadLocal<String>();
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String snapshotFile = "data:image/png;base64,"
				+ screenshot.getScreenshotAs(OutputType.BASE64);
		base64.set(snapshotFile);
		return base64.get();
	}
	

	public void selectValueFromDdl(String by, String listOption, WebElement list) throws Exception {
		Select ddl_List = new Select(list);

		switch (by) {
		case "index":
			ddl_List.selectByIndex(Integer.valueOf(listOption));
			break;

		case "value":
			ddl_List.selectByValue(listOption);
			break;

		case "visibleText":
			ddl_List.selectByVisibleText(listOption);
			break;

		}

	}

	/*
	 * public void selectRdoBtnOption(String option) throws Exception { WebElement
	 * element = FindElementBy("xpath", "//label[contains(text(),'" + option +
	 * "')]"); clickOnElement(element); }
	 */
	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	/**
	 * 
	 * @param driver
	 * @param value
	 *            - the value to type into the textbox on alert
	 * @param option
	 *            - Either "accept/dismiss" for hitting OK button/ Cancel button
	 */
	public void typeIntoAlertAnd(WebDriver driver, String value, String option) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);

		if (option.equalsIgnoreCase("accept")) {
			acceptAlert(driver);
		} else {
			dismissAlert(driver);
		}
	}

	public void openNewTab(int noOfTabs) {
		if (noOfTabs > 0) {
			for (int i = 0; i < noOfTabs; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.open('about:blank','_blank');");

			}
		} else {
			System.out.println("Invalid number passed");
		} 
	}
	
	public void switchToIframe(String elementid) {
		driver.switchTo().frame(elementid);
	}

}
