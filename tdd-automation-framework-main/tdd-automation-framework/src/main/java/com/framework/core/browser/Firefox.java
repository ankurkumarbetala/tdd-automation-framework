package com.framework.core.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.framework.core.helpers.Configs;

public class Firefox extends Browser {

	private FirefoxOptions options;

	@Override
	public void setDefaultOptions() {
		options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		options.addArguments("--start-maximized");
	}

	@Override
	public WebDriver buildWebDriver() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")
				+ "//src//test//resources//binaries//geckodriver.exe");
		setDefaultOptions();
		WebDriver driver = new FirefoxDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Long.valueOf(Configs.shortWaitTime), TimeUnit.SECONDS);

		return driver;
	}

}
