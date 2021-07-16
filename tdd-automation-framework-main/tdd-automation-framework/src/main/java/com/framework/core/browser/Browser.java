package com.framework.core.browser;

import org.openqa.selenium.WebDriver;

public abstract class Browser {

	public abstract void setDefaultOptions();

	public abstract WebDriver buildWebDriver();
}
