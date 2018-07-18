package com.r1v2.reporting.test;


import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.core.reports.ExtentReport;
import com.core.settings.GlobalSettings;
import com.core.util.CSVTable;
import com.core.util.CSVTableRow;
import com.core.util.PropertyFileUtil;
import com.qa.pageobjects.SCLoginPage;
import com.r1v2.common.BaseTest;


public class Scenario1Login extends BaseTest {

	private SCLoginPage loginPage = null;
	
	private PropertyFileUtil propUtil = new PropertyFileUtil("config");
	CSVTable t = new CSVTable(propUtil.getString("login_data_csv"));
	List<CSVTableRow> records = t.getRecords();
	CSVTableRow record = records.get(0);
	

	@BeforeClass
	public void setUpOnce() {
		loginPage = getPageFactory().adminLoginPage();
		//ExtentReport.logger.assignCategory("Login Euro Site Control");
		
	}

	@Test(priority = 1)
	public void testSC_1() {
		boolean actual = loginPage.openEuroSCLoginpage().
				veirfyPageTitle(record.getString("admin_page_title"));
		Assert.assertEquals(actual, true, " login page is not displayed");
		//ExtentReport.logger.assignCategory("Login Euro Site Control");
	}

	
	@Test(priority = 2)
	public void testSC_2() {
				boolean actual = loginPage.openEuroSCLoginpage()
					.goToHomePage(record.getString("admin_username"), record.getString("admin_password_invalid"))	
					.veirfyPageTitle(record.getString("admin_page_title"));
		Assert.assertEquals(actual, true, " Login page is not displayed");
		//ExtentReport.logger.assignCategory("Login Euro Site Control");
	}

	@Test(priority = 3)
	public void testSC_3() {
		boolean actual = loginPage
				.openEuroSCLoginpage()
				.goToHomePage(record.getString("admin_username_invalid"), record.getString("admin_password"))
				.veirfyPageTitle(record.getString("admin_page_title"));
		Assert.assertEquals(actual, true, " login page is not displayed");
		//ExtentReport.logger.assignCategory("Login Euro Site Control");
	}

	@Test(priority = 4)
	public void testSC_4() {
		boolean actual = loginPage
				.openEuroSCLoginpage()
				.goToHomePage(record.getString("admin_username_invalid"), record.getString("admin_password_invalid"))
				.veirfyPageTitle(record.getString("admin_page_title"));
		Assert.assertEquals(actual, true, " login page is not displayed");
		//ExtentReport.logger.assignCategory("Login Euro Site Control");
	}

	@Test(priority = 5)
	public void testSC_5() {
		boolean actual = loginPage
				.openEuroSCLoginpage()
				.goToHomePage(record.getString("admin_username_blank"),record.getString("admin_password_invalid"))
				//.accetpAlert()
			    .veirfyPageTitle(record.getString("admin_page_title"));
		Assert.assertEquals(actual, true, " login page is not displayed");
		//ExtentReport.logger.assignCategory("Login Euro Site Control");
	}

	@Test(priority = 6)
	public void testSC_6() {
		boolean actual = loginPage
				.openEuroSCLoginpage()
				.goToHomePage(record.getString("admin_username_invalid"), record.getString("admin_password"))
				.veirfyPageTitle(record.getString("admin_page_title"));
		Assert.assertEquals(actual, true, " login page is not displayed");
		//ExtentReport.logger.assignCategory("Login Euro Site Control");
	}

	@Test(priority = 7)
	public void testSC_7() {
		boolean actual = loginPage
				.openEuroSCLoginpage()
				.goToHomePage(record.getString("admin_username"), record.getString("admin_password_blank"))
				//.accetpAlert()
				.veirfyPageTitle(record.getString("admin_page_title"));
		Assert.assertEquals(actual, true, " login page is not displayed");
	}

	@Test(priority = 8)
	public void testSC_8() {
		boolean actual=loginPage
			 .openEuroSCLoginpage()
			 .VerifyhelpTextClikable();
	 Assert.assertEquals(actual, true, " help text  is not displayed");
	}
	
	@Test(priority = 9)
	public void testSC_9() {
		boolean actual = loginPage
				.openEuroSCLoginpage()
				.goToHomePage(record.getString("admin_username"), record.getString("admin_password"))
				.veirfyPageTitle(record.getString("login_page_title"));
			Assert.assertEquals(actual, true, " Login Page is not displayed");
	
	}
	@Test(priority = 10)
	public void  testSC_10() {
			boolean actual=loginPage
				.logoutAdmin();
			Assert.assertEquals(actual, true, " Login Page is not displayed");
		}

}
