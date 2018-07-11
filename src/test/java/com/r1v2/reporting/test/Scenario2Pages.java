package com.r1v2.reporting.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pageobjects.PageBuilderPage;
import com.qa.pageobjects.SCHomePage;
import com.r1v2.common.BaseTest;

public class Scenario2Pages extends BaseTest{
	private Map<String, String> td = getTestDataProperties();
	SCHomePage schomepage;
	PageBuilderPage  pagebuilderpage;
	
	@BeforeClass
	public void setUpOnce1() {
		schomepage=getPageFactory().scHomePage();
		pagebuilderpage=getPageFactory().pagebuilderpage();
		schomepage.openEuroSCLoginpage()
			.goToHomePage(td.get("admin_username"),td.get("admin_password"));
		
	}
	@Test()
	public void testRD_2_1() {
		boolean actual = schomepage.verifyLogOutAndChangePasswordLinks();
		Assert.assertEquals(actual,true,"is not displayed on SC Home Page");
		
	}
	/*@Test()
	public void testRD_2_2() {
		boolean actual = schomepage.verifylogoutButtonFunctionality();
		Assert.assertEquals(actual,true,"is not displayed on SC Home Page");
	}*/

	@Test()
	public void testRD_2_3() {
			boolean actual= schomepage.selectOrganization()
		  		 .selectSiteList(td.get("login_site_name"));
			Assert.assertEquals(actual, true, " Site Name is not searching ");
	
	}
		@Test()
	public void testRD_2_4() {
			boolean actual= schomepage
					.navigatePageBuilder();
			Assert.assertEquals(actual, true, " Current Browser is not closed ");
	
	}
		//content Page Add
	
	public void tesrRD_2_5(){
		boolean actual= pagebuilderpage
				.verifyContentPageButton();
		Assert.assertEquals(actual, true, " Radio Button is Not Displyed  ");
	}
	
}
