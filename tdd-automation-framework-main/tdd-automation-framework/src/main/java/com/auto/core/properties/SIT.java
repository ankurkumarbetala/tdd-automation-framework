package com.auto.core.properties;

public class SIT {

	private String Url;

	private String TakeScreenshot;

	private String Browser;

	private String GenerateLogs;
	
	private String LongWaitTime;

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		this.Url = url;
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

	public String getLongWaitTime() {
		return LongWaitTime;
	}

	public void setLongWaitTime(String longWaitTime) {
		LongWaitTime = longWaitTime;
	}

}
