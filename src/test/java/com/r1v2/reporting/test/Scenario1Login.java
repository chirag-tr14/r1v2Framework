package com.r1v2.reporting.test;


import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pageobjects.SCLoginPage;
import com.r1v2.common.BaseTest;


public class Scenario1Login extends BaseTest {

	private Map<String, String> td = getTestDataProperties();
	private SCLoginPage loginPage = null;

	@BeforeClass
	public void setUpOnce() {
		loginPage = getPageFactory().euroLoginPage();
	}

	@Test(priority = 1)
	public void testSC_1() {
		boolean actual = loginPage.openEuroSCLoginpage().veirfyPageTitle(
				td.get("admin_page_title"));
		Assert.assertEquals(actual, true, " login page is not displayed");
	}

	
	@Test(priority = 2)
	public void testSC_2() {
		boolean actual = loginPage.openEuroSCLoginpage()
				.goToHomePage(td.get("admin_username"),td.get("admin_password_invalid"))
				.veirfyPageTitle(td.get("admin_page_title"));
		Assert.assertEquals(actual, true, " Login page is not displayed");
	}

	@Test(priority = 3)
	public void testSC_3() {
		boolean actual = loginPage
				.openEuroSCLoginpage()
				.goToHomePage(td.get("admin_username_invalid"),
						td.get("admin_password"))
				.veirfyPageTitle(td.get("admin_page_title"));
		Assert.assertEquals(actual, true, " login page is not displayed");
	}

	@Test(priority = 4)
	public void testSC_4() {
		boolean actual = loginPage
				.openEuroSCLoginpage()
				.goToHomePage(td.get("admin_username_invalid"),
						td.get("admin_password_invalid"))
				.veirfyPageTitle(td.get("admin_page_title"));
		Assert.assertEquals(actual, true, " login page is not displayed");
	}

	@Test(priority = 5)
	public void testSC_5() {
		boolean actual = loginPage
				.openEuroSCLoginpage()
				.goToHomePage(td.get("admin_username_invalid"),
						td.get("admin_password_blank"))
				.accetpAlert()
				.veirfyPageTitle(td.get("admin_page_title"));
		Assert.assertEquals(actual, true, " login page is not displayed");
	}

	@Test(priority = 6)
	public void testSC_6() {
		boolean actual = loginPage
				.openEuroSCLoginpage()
				.goToHomePage(td.get("admin_username_invalid"),
						td.get("admin_password"))
				.veirfyPageTitle(td.get("admin_page_title"));
		Assert.assertEquals(actual, true, " login page is not displayed");
	}

	@Test(priority = 7)
	public void testSC_7() {
		boolean actual = loginPage
				.openEuroSCLoginpage()
				.goToHomePage(td.get("admin_username"),
						td.get("admin_password_blank"))
				.accetpAlert()
				.veirfyPageTitle(td.get("admin_page_title"));
		Assert.assertEquals(actual, true, " login page is not displayed");
	}

	@Test(priority = 8)
	public void testSC_8() {
	 boolean actual=loginPage
			 .openEuroSCLoginpage()
			 .VerifyhelpTextClikable();
	 Assert.assertEquals(actual, true, " help text  is not displayed");
	}
	
	// SC login

	@Test(priority = 9)
	public void testSC_9() {
		boolean actual = loginPage
				.openEuroSCLoginpage()
				.goToHomePage(td.get("admin_username"),
						td.get("admin_password"))
				.veirfyPageTitle(td.get("login_page_title"));
			Assert.assertEquals(actual, true, " Login Page is not displayed");
	
	}
	@Test(priority = 10)
	public void  testSC_10() {
			boolean actual=loginPage
				.closeBrowser();
			Assert.assertEquals(actual, true, " Login Page is not displayed");
		}
	
		

}
