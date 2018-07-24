package com.core.reports;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

public static ExtentHtmlReporter htmlReporter;
public static ExtentReports report;
public static ExtentTest logger;

@BeforeSuite
public void extetnReport() {
	/*
	 * htmlReporter = new ExtentHtmlReporter (
	 * "F:\\IZMO FrameWork\\com.izomweb.com\\Reports\\Reports.html");
	 */
	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/Report.html");

	report = new ExtentReports();
	report.attachReporter(htmlReporter);
	report.setSystemInfo("OS", "Windows 10");
	report.setSystemInfo("Host Name", "10.125.3.18");
	report.setSystemInfo("Environment", "QA");
	report.setSystemInfo("User Name", "Rajesh");

	htmlReporter.config().setChartVisibilityOnOpen(true);
	htmlReporter.config().setDocumentTitle("Extent Report");
	htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	htmlReporter.config().setTheme(Theme.STANDARD);

}

@AfterMethod
 public void getResult(ITestResult result) throws IOException {

	if (result.getStatus() == ITestResult.FAILURE  ) {
	    logger.log(Status.FAIL, MarkupHelper
				.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
		logger.fail(result.getThrowable());
		
	} else if (result.getStatus() == ITestResult.SUCCESS) {
		logger.log(Status.PASS,
				MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		// logger.pass("Screen Shot :" +
		// logger.addScreenCaptureFromPath(screnshot));
	} else {
		logger.log(Status.SKIP,
				MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
		logger.skip(result.getThrowable());
		// logger.pass("Screen Shot :" +
		// logger.addScreenCaptureFromPath(screnshot));
	}
}


@AfterSuite
public void tearDown() {
	report.flush();

}

}