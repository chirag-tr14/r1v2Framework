package com.r1v2.reporting.test;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.core.reports.TestNGCustomReporter;
import com.core.settings.GlobalSettings;
import com.core.util.CSVTable;
import com.core.util.CSVTableRow;
import com.opencsv.CSVReader;
import com.qa.pageobjects.SCLoginPage;
import com.qa.pageobjects.SCPages;
import com.r1v2.common.BaseTest;

public class Scenario2Dlr extends BaseTest{
	public static final Logger logger = LogManager.getLogger(Scenario2Dlr.class);
	
	
	SCPages scpages;
	GlobalSettings csvfile= new GlobalSettings();
	SCLoginPage browser;
	private Map<String, String> td = getTestDataProperties();
	CSVTable t = new CSVTable(td.get("mx_loginDataFilePath"));
	List<CSVTableRow> records = t.getRecords();
	CSVTableRow record = records.get(0);
	
	
	
	@BeforeClass
	public void setUpOnce1() {
			scpages=getPageFactory().scHomePage();
			scpages.openSCLoginpage()
			.goToHomePage(record.getString("admin_username"),record.getString("admin_password"));	
	}
	@Test()
	public void testPG_1() {
		boolean actual = scpages.verifyLogOutAndChangePasswordLinks();
		Assert.assertEquals(actual,true,"is not displayed on SC Home Page");
		
	}
	
	@Test()
	public void testPG_2() {
		
		boolean actual= scpages.selectOrganization().selectSiteList(record.getString("Dealers"));
				scpages.navigatePageBuilder();
		Assert.assertEquals(actual, true, " Navigate to PageBuilder Page on  Respective Dealer ");
	
	}
	
		//content Page Add
	@Test()
	public void testPG_3() {
			boolean actual= scpages
					.verifyContentPageButton();
			Assert.assertEquals(actual, true, " Radio Button is Selected on PageBuilder Page ");
	}

	@Test()
	public void testPG_4() {
		
			boolean actual= scpages
					.verifyMandatoryField();
			scpages.pageTitle(record.getString("Title"));
			scpages.verifyMandatoryField();
			scpages.pageUrl(record.getString("url"));
			Assert.assertEquals(actual, true, " Title and Url  data  passing on Adding Page ");
	}
	
	@Test()
	public void testPG_5() {
					boolean actual= scpages
					.selectDepartmentdropdownitem(record.getString("Department"));
				Assert.assertEquals(actual, true, " Selecting Depasrtment on Department dropwdown field ");
	}

	@Test()
	public void testPG_7() {
		CSVTableRow record = records.get(1);
			boolean actual= scpages
					.resposniveContent(record.getString("Responsive_Content"));
			Assert.assertEquals(actual, true, " Responsive Content  data  passing on Responsive Editor  ");
	}
	
	@Test()
	public void testPG_8() {
			boolean actual= scpages
					.savePage();
		Assert.assertEquals(actual, true, " Responsive Content  data  passing on Responsive Editor  ");
		}
	
	/*@Test()
	public void testPG_10() {
		CSVTableRow record = records.get(0);
			boolean actual= scpages.
			processqueUrl(record.getString("Process_Que"));        
		Assert.assertEquals(actual, true, " Responsive Content  data  passing on Responsive Editor  ");
	}*/
	
	
	
	/*@AfterTest()
	public void testPG_10() {
		CSVTableRow record = records.get(0);
				  //initWebDriver();
		scpages.frontendSite(record.getString("Dealers"));
		
		*/
	// Assert.assertEquals(actual, true, " Responsive Content  data  passing on Responsive Editor  ");
		
	}
	
	

	

