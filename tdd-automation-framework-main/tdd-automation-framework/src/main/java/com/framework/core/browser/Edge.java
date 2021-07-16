package com.framework.core.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.framework.core.helpers.Configs;

public class Edge extends Browser {

	private EdgeOptions options;

	@Override
	public void setDefaultOptions() {
		options = new EdgeOptions();
	}

	@Override
	public WebDriver buildWebDriver() {
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")
				+ "//src//test//resources//binaries//msedgedriver.exe");
		setDefaultOptions();
		WebDriver driver = new EdgeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Long.valueOf(Configs.shortWaitTime), TimeUnit.SECONDS);

		return driver;
	}

}
