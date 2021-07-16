package com.auto.core.properties;

import com.google.gson.annotations.SerializedName;

public class UAT {

//	@SerializedName("Url")
	private String Url;

	private String TakeScreenshot;

	private String Browser;

	private String GenerateLogs;

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getTakeScreenshot() {
		return TakeScreenshot;
	}

	public void setTakeScreenshot(String takeScreenshot) {
		TakeScreenshot = takeScreenshot;
	}

	public String getBrowser() {
		return Browser;
	}

	public void setBrowser(String browser) {
		Browser = browser;
	}

	public String getGenerateLogs() {
		return GenerateLogs;
	}

	public void setGenerateLogs(String generateLogs) {
		GenerateLogs = generateLogs;
	}

}
