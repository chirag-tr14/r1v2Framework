package com.r1v2.reporting.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pageobjects.SCLoginPage;
import com.qa.pageobjects.SCPages;
import com.r1v2.common.BaseTest;

public class Scenario2Dlr extends BaseTest{
	private Map<String, String> td = getTestDataProperties();
	SCPages scpages;

	@BeforeClass
	public void setUpOnce1() {
		scpages=getPageFactory().scHomePage();
			scpages.openEuroSCLoginpage()
			.goToHomePage(td.get("admin_username"),td.get("admin_password"));
		
	}
	@Test()
	public void testPG_2_1() {
		boolean actual = scpages.verifyLogOutAndChangePasswordLinks();
		Assert.assertEquals(actual,true,"is not displayed on SC Home Page");
		
	}
	/*@Test()
	public void testRD_2_2() {
		boolean actual = scpages.verifylogoutButtonFunctionality();
		Assert.assertEquals(actual,true,"is not displayed on SC Home Page");
	}*/

	@Test()
	public void testPG_2_3() {
			boolean actual= scpages.selectOrganization()
		  		 .selectSiteList(td.get("login_site_name"));
			Assert.assertEquals(actual, true, " Site Name is not searching ");
	
	}
	@Test()
	public void testPG_2_4() {
			boolean actual= scpages
					.navigatePageBuilder();
			Assert.assertEquals(actual, true, " Navigate to PageBuilder Page on Home Page ");
	
	}
		//content Page Add
	@Test()
	public void testPG_2_5() {
			boolean actual= scpages
					.verifyContentPageButton();
			Assert.assertEquals(actual, true, " Radio Button is Selected on PageBuilder Page ");
	
	}
	
	
	@Test()
	public void testPG_2_7() {
		boolean actual=scpages
				 .selectDepartmentdropdownitem(td.get("departments"));
		Assert.assertEquals(actual, true, " Department Dropdown list is not selected ");
		
	}
	
	
}


	

