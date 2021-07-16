package com.framework.core.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.core.browser.WebDriverManager;
import com.framework.core.helpers.Configs;

public class ElementFinder {

	WebDriver driver;

	public ElementFinder() {
		driver = WebDriverManager.getRealWebDriver().get();
	}

	public WebElement findElementByXpath(String elementName, String pageName) throws Exception {
		System.out.println(elementName + ", " + pageName);
		String xpath = RepositoryLoader.FetchElementValue("xpath", pageName,
				System.getProperty("envName"), elementName);
		WebElement element = waitForPresenceOfElement(xpath);
		waitForElementToBeVisible(element);
		ScrollIntoView(element);
		jsHighlighter(element);
		return element;
	}

	public void ScrollIntoView(WebElement element) {
		try {
			JavascriptExecutor jScriptObject = (JavascriptExecutor) driver;
			jScriptObject.executeScript("arguments[0].scrollIntoView()", element);
		} catch (Exception e) {
			System.out.println("Could not scroll into view of element");
			e.printStackTrace();

		}
	}

	public void jsHighlighter(WebElement element) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;');",
					element);
			Thread.sleep(300);
			js.executeScript("arguments[0].setAttribute('style', 'border: none;');", element);
			Thread.sleep(300);
		} catch (Exception e) {
			System.err.println("Failed to highlight the page");
			e.printStackTrace();
		}
	}

	public WebElement findElementById(String elementName, String pageName) throws Exception {
		String id = RepositoryLoader.FetchElementValue("id", pageName,
				System.getProperty("envName"), elementName);
		WebElement element = waitForPresenceOfElement(id);
		waitForElementToBeVisible(element);
		return element;
	}

	public void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Configs.mediumWaitTime);// ExplicitWait
		wait.until(ExpectedConditions.visibilityOf(element));
	};

	public WebElement waitForPresenceOfElement(String value) {
		WebElement element = null;
		try {
			System.out.println(value);
			WebDriverWait wait = new WebDriverWait(driver, Configs.mediumWaitTime);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Configs.mediumWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Configs.mediumWaitTime);
		wait.until(ExpectedConditions.invisibilityOf(element));

	}
}
