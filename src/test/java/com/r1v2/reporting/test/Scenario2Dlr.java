package com.r1v2.reporting.test;

import java.util.List;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.core.util.CSVTable;
import com.core.util.CSVTableRow;
import com.core.util.PropertyFileUtil;
import com.qa.pageobjects.SCPages;
import com.r1v2.common.BaseTest;

public class Scenario2Dlr extends BaseTest{
	public static final Logger logger = LogManager.getLogger(Scenario2Dlr.class);

	SCPages scpages;
	private Map<String, String> td = getTestDataProperties();
	private PropertyFileUtil propUtil = new PropertyFileUtil("config");

	CSVTable loginpage = new CSVTable(td.get(propUtil.getString("region")+".loginDataFilePath"));
	List<CSVTableRow> login = loginpage.getRecords();

	CSVTable pagebuilderpage = new CSVTable(td.get(propUtil.getString("region")+".PageBuilderFilePath"));
	List<CSVTableRow> page = pagebuilderpage.getRecords();
	CSVTableRow pagesdata = page.get(0);


	@BeforeClass
	public void setUpOnce1() {
		CSVTableRow logindata = login.get(0);
			scpages=getPageFactory().scHomePage();
			scpages.openSCLoginpage()
			.goToHomePage(logindata.getString("admin_username"),logindata.getString("admin_password"));	
	}
	
	@Test(priority=1)
	public void testPG_1() {
		boolean actual = scpages.verifyLogOutAndChangePasswordLinks();
		Assert.assertEquals(actual,true,"is not displayed on SC Home Page");
	}
	
	@Test(priority=2)
	public void testPG_2() {
		
		boolean actual= scpages.selectOrganization()
				.selectSiteList(pagesdata.getString("Dealers"));
				scpages.navigatePageBuilder();
		Assert.assertEquals(actual, true, " Navigate to PageBuilder Page on  Respective Dealer ");
	}
	
	//content Page Add
	@Test(priority=3)
	public void testPG_3() {
			boolean actual= scpages
					.verifyContentPageButton();
			Assert.assertEquals(actual, true, " Radio Button is Selected on PageBuilder Page ");
	}

	@Test(priority=4)
	public void testPG_4() {
		
			boolean actual= scpages
					.verifyMandatoryField();
			scpages.pageTitle(pagesdata.getString("Title"));
			scpages.verifyMandatoryField();
			scpages.pageUrl(pagesdata.getString("url"));
			Assert.assertEquals(actual, true, " Title and Url  data  passing on Adding Page ");
	}
	
	@Test(priority=5)
	public void testPG_5() {
					boolean actual= scpages
					.selectDepartmentdropdownitem(pagesdata.getString("Department"));
					scpages.resposniveContent(pagesdata.getString("Responsive_Content"));
				Assert.assertEquals(actual, true, " Selecting Depsrtment and Responsive Contnet data passing Responsive Editor ");
	}

	@Test(priority=6)
	public void testPG_6() {
			boolean actual= scpages
					.savePage();
		Assert.assertEquals(actual, true, " Responsive Content  data  passing on Responsive Editor  ");
		}

	


//Speical Page Add

	@Test(priority=10)
	public void testPG_10(){
		boolean actual=scpages.navigatePageBuilder();
		      scpages.verifySpecialPageButton();
			Assert.assertEquals(actual, true, " Navigate to PageBuilder Page on  Respective Dealer ");
	}
	
	@Test(priority=11)
	public void testPG_11(){
		CSVTableRow pagesdata = page.get(2);
		boolean actual= scpages
				.verifyMandatoryField();
		scpages.pageTitle(pagesdata.getString("Title")); 
		scpages.verifyMandatoryField();
		scpages.pageUrl(pagesdata.getString("url"));
		Assert.assertEquals(actual, true, " Title and Url  data  passing on Adding Page ");
	}
	
	@Test(priority=12)
	public void testPG_12() {
			CSVTableRow pagesdata = page.get(2);
				boolean actual= scpages
					.selectDepartmentdropdownitem(pagesdata.getString("Department"));
						testPG_6();
				Assert.assertEquals(actual, true, " Selecting Depsrtment and Responsive Contnet data passing Responsive Editor ");
	}
	
	

}

	/*@Test(priority=12)
	public void testPG_09() {
					boolean actual= scpages.
			processqueUrl(pagesdata.getString("Process_Que"));        
		Assert.assertEquals(actual, true, " Responsive Content  data  passing on Responsive Editor  ");
	}*/

	
	/*@AfterTest()
	public void testPG_10() {
				  initWebDriver();
		scpages.frontendSite(pagesdata.getString("Dealers"));
		
	//Assert.assertEquals(actual, true, " Responsive Content  data  passing on Responsive Editor  ");
*/
	
	
	
	
	

	

