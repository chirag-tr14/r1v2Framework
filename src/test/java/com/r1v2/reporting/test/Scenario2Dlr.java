package com.r1v2.reporting.test;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.core.util.CSVTable;
import com.core.util.CSVTableRow;
import com.qa.pageobjects.SCLoginPage;
import com.qa.pageobjects.SCPages;
import com.r1v2.common.BaseTest;

public class Scenario2Dlr extends BaseTest{
	private Map<String, String> td = getTestDataProperties();
	SCPages scpages;
	CSVTable t = new CSVTable("F:\\IZMO FrameWork\\com.r1v2.com\\src\\main\\resource\\TestData.csv");
	List<CSVTableRow> records = t.getRecords();
	
	
	
	
	
	
	@BeforeClass
	public void setUpOnce1() {
		CSVTableRow record = records.get(0);
		scpages=getPageFactory().scHomePage();
			scpages.openEuroSCLoginpage()
			.goToHomePage(record.getString("admin_username"),record.getString("admin_password"));
		
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
		CSVTableRow record = records.get(6);
			boolean actual= scpages.selectOrganization()
		  		 .selectSiteList(record.getString("admin_username"));
					//.selectSiteList(td.get("login_site_name"));
			  
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


	

