package com.framework.core.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.framework.core.helpers.Configs;

public class InternetExplorer extends Browser {

	private InternetExplorerOptions options;

	@Override
	public void setDefaultOptions() {

		options = new InternetExplorerOptions();
		options.ignoreZoomSettings();
		options.introduceFlakinessByIgnoringSecurityDomains();
		options.requireWindowFocus();
		options.destructivelyEnsureCleanSession();
	}

	@Override
	public WebDriver buildWebDriver() {
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")
				+ "//src//test//resources//binaries//IEDriverServer.exe");
		setDefaultOptions();
		WebDriver driver = new InternetExplorerDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Long.valueOf(Configs.shortWaitTime),
				TimeUnit.SECONDS);

		return driver;
	}

}
