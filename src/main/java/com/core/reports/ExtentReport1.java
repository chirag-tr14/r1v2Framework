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

public class ExtentReport1 {

public static ExtentHtmlReporter htmlReporter;
public static ExtentReports report;
public static ExtentTest extentTest;

@BeforeSuite
public void setUp() {
	
	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/Report.html");
	report = new ExtentReports();
	report.attachReporter(htmlReporter);
	
}

@AfterMethod
 public void getResult(ITestResult result)  {

	if (result.getStatus() == ITestResult.FAILURE  ) {
		
	    extentTest.fail(MarkupHelper
				.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
		extentTest.fail(result.getThrowable());
		
	} else if (result.getStatus() == ITestResult.SUCCESS) {
		extentTest.pass(
				MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		// logger.pass("Screen Shot :" +
		// logger.addScreenCaptureFromPath(screnshot));
	} else {
		extentTest.skip(
				MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
		extentTest.skip(result.getThrowable());
		// logger.pass("Screen Shot :" +
		// logger.addScreenCaptureFromPath(screnshot));
	}
}

@AfterSuite
public void tearDown() {
	report.flush();

}

}
