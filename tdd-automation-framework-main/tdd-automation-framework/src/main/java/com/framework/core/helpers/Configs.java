package com.framework.core.helpers;

import java.io.File;
import java.io.FileReader;

import com.auto.core.properties.Container;
import com.framework.core.browser.Browser;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

public class Configs {

	public static String AppUrl;

	public static String takeScreenshot;

	public static String defaultWaitTime;

	public static Long longWaitTime;

	public static Long mediumWaitTime;

	public static Long shortWaitTime;

	public static String ifLoggingEnabled;

	public static String browser;

	public static String testResourceFolder;

	public static void initializeEnvironmentProperties() throws Exception {
		PropertyLoader propObj = new PropertyLoader();
		AppUrl = propObj.fetchProperty("App.Url");
		takeScreenshot = propObj.fetchProperty("App.TakeScreenshot");
		defaultWaitTime = propObj.fetchProperty("App.DefaultWaitTime");
		longWaitTime = Long.valueOf(propObj.fetchProperty("App.LongWaitTime"));
		mediumWaitTime = Long.valueOf(propObj.fetchProperty("App.MediumWaitTime"));
		shortWaitTime = Long.valueOf(propObj.fetchProperty("App.ShortWaitTime"));
		ifLoggingEnabled = propObj.fetchProperty("App.GenerateLogs");
		browser = propObj.fetchProperty("App.Browser");
		testResourceFolder = propObj.fetchProperty("App.TestResourceFolder");
	}

	/*
	 * @SuppressWarnings("deprecation") public static void
	 * initializeEnvironmentProperties() throws Exception { JsonParser parser = new
	 * JsonParser(); Object obj = parser.parse(new
	 * FileReader(System.getProperty("user.dir") + File.separator +
	 * "src//test//resources//configs//properties.json")); String res =
	 * obj.toString(); Gson gson = new Gson(); Container propObj = new Container();
	 * propObj = gson.fromJson(res, Container.class);
	 * 
	 * 
	 * if(System.getProperty("envName").equalsIgnoreCase("sit")) { browser =
	 * propObj.getSit().getBrowser();
	 * 
	 * }
	 * 
	 * }
	 */
}
