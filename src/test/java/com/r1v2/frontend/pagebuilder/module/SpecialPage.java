package com.r1v2.frontend.pagebuilder.module;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.core.util.CSVTable;
import com.core.util.CSVTableRow;
import com.core.util.PropertyFileUtil;
import com.qa.sc.pageobjects.SCPages;
import com.r1v2.backend.pagebuilder.module.ScenarioContentPage;
import com.r1v2.backend.pagebuilder.module.ScenarioSpecialPage;
import com.r1v2.common.BaseTest;
import com.r1v2.common.DataBase;

public class SpecialPage extends BaseTest{
	public static final Logger logger = LogManager.getLogger(ScenarioContentPage.class);
	DataBase database;
	SCPages pages;
	ScenarioSpecialPage spec=new ScenarioSpecialPage();
	private Map<String, String> td = getTestDataProperties();
	private PropertyFileUtil propUtil = new PropertyFileUtil("config");

	CSVTable loginpage = new CSVTable(td.get(propUtil.getString("region")+".loginDataFilePath"));
	List<CSVTableRow> login = loginpage.getRecords();

	CSVTable pagebuilderpage = new CSVTable(td.get(propUtil.getString("region")+".PageBuilderFilePath"));
	List<CSVTableRow> page = pagebuilderpage.getRecords();
	CSVTableRow pagesdata = page.get(0);
	
	String regiondatabase=td.get(propUtil.getString("region")+".env");
	 
	@BeforeClass
	public void setUpOnce1() {
			 database=getPageFactory().databse();
			 pages=getPageFactory().scHomePage();

	}
	
	@Test(priority=1)
	public void testPG_1() {
		CSVTableRow pagesdata = page.get(3);
		
				
	    String sqlQuery = "select page_url from izmoweb_r1v2.idw_dealer_webpages where  page_type='SPEL' and curdate() and "
				+ "status='ACTV' and fk_dealer_id="+pagesdata.getString("DealerId");
	    					 
	    
	   		String contentpageurl = database.executeSQLQuery(regiondatabase,sqlQuery);
		//SCPages actual=
				pages.frontendUrl(pagesdata.getString("Dealers")+contentpageurl);
		//Assert.assertEquals(actual, true, "Page is not Loading  ");
				
				
    }

	
	
 }


