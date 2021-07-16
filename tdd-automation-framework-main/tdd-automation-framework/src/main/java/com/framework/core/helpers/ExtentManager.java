package com.framework.core.helpers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports suiteReport;

	public static synchronized ExtentReports getReporter() {
		try {
			if (suiteReport == null) {
				Configs.initializeEnvironmentProperties();
				String extentReportPath = Configs.testResourceFolder + "test-reports";
				extentReportPath = StringHelper.generateFolderPath(extentReportPath);
				File f = new File(extentReportPath);
				if (!f.isDirectory()) {
					f.mkdirs();
				}
				suiteReport = new ExtentReports(extentReportPath + "//TestResults.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suiteReport;
	}

}
