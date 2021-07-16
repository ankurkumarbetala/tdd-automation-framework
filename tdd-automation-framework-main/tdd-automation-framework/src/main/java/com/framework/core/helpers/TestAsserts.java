package com.framework.core.helpers;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TestAsserts {

	public static void assertEquals(String expectedValue, String actualValue) {
		Assert.assertEquals(actualValue, expectedValue);
	}

	public static void assertNotEquals(String expectedValue, String actualValue) {
		Assert.assertNotEquals(actualValue, expectedValue);
	}

	public static void assertIfVisible(WebElement element) {
		Assert.assertTrue(element.isDisplayed());
	}

	public static void assertIfEnabled(WebElement element) {
		Assert.assertTrue(element.isEnabled());
	}

}
