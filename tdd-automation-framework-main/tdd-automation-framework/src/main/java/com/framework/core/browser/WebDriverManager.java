package com.framework.core.browser;

import org.openqa.selenium.WebDriver;

import com.framework.core.helpers.Configs;

public class WebDriverManager {

	private static ThreadLocal<WebDriver> realWebDriver = new ThreadLocal<WebDriver>();

	public void loadDriver(BrowserType type) {
		Browser browser = getBrowser(type);
		realWebDriver.set(browser.buildWebDriver());
	}

	public static ThreadLocal<WebDriver> getRealWebDriver() {
		return realWebDriver;
	}

	public void initializeWebDriver() {
		loadDriver(BrowserType.valueOf(Configs.browser));
	}

	public Browser getBrowser(BrowserType type) {
		Browser browser = null;
		if (type == BrowserType.CHROME) {
			browser = new Chrome();
		} else if (type == BrowserType.FIREFOX) {
			browser = new Firefox();
		} else if (type == BrowserType.EDGE) {
			browser = new Edge();
		} else if (type == BrowserType.INTERNETEXPLORER) {
			browser = new InternetExplorer();
		}
		return browser;
	}

}
