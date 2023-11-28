package com.framework.Reports;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportTest {
	public static ExtentReports report() {

		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("./imPAC/Reports.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("IMPAC");
		spark.config().setReportName("Test Execution");
		extent.attachReporter(spark);
		// ExtentTest test = extent.createTest("imPAC Test Reports");

		return extent;
	}
}