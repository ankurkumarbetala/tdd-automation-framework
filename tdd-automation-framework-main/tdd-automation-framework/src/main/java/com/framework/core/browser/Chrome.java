package com.framework.core.browser;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.framework.core.helpers.Configs;

public class Chrome extends Browser {

	private ChromeOptions options;

	@Override
	public void setDefaultOptions() {
		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.setAcceptInsecureCerts(true);
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		options.addArguments("--disable-infobars");
		options.setExperimentalOption("useAutomationExtension", false);

	}

	@Override
	public WebDriver buildWebDriver() {
		setDefaultOptions();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
				+ "//src//test//resources//binaries//" + "chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Long.valueOf(Configs.shortWaitTime), TimeUnit.SECONDS);

		return driver;
	}

}
