package com.r1v2.frontend.pagebuilder.module;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.core.util.CSVTable;
import com.core.util.CSVTableRow;
import com.core.util.PropertyFileUtil;
import com.core.util.Utility;
import com.qa.sc.pageobjects.SCPages;
import com.r1v2.backend.pagebuilder.module.ScenarioContentPage;
import com.r1v2.common.BaseTest;
import com.r1v2.common.DataBase;

public class ContentPage extends BaseTest{
	public static final Logger logger = LogManager.getLogger(ScenarioContentPage.class);
	DataBase database;
	SCPages pages;
		
	private Map<String, String> td = getTestDataProperties();
	private PropertyFileUtil propUtil = new PropertyFileUtil("config");

	CSVTable loginpage = new CSVTable(td.get(propUtil.getString("region")+".loginDataFilePath"));
	List<CSVTableRow> login = loginpage.getRecords();

	CSVTable pagebuilderpage = new CSVTable(td.get(propUtil.getString("region")+".PageBuilderFilePath"));
	List<CSVTableRow> page = pagebuilderpage.getRecords();
	CSVTableRow pagesdata = page.get(0);
	
	String regiondatabase=td.get(propUtil.getString("region")+".env");

	 
	@BeforeClass
	public void setUpOnce1() throws InterruptedException {
		extentTest = report.createTest(getClass().getName());
			 database=getPageFactory().databse();
			 pages=getPageFactory().scHomePage();

			 String processqueQuery="select  module_id  from  process_que where  page_type='CONT' "
						+ "and change_flag=1 and  curdate()and fk_dealer_id="+pagesdata.getString("DealerId");
				
				//String proceesque=database.executeSQLQuery(regiondatabase,processqueQuery);
				//Utility.processQue(proceesque);
			 
				 Boolean isProcessing = true;
				   while (isProcessing) { 
					 String proceesque =database.executeSQLQuery(regiondatabase, processqueQuery);
					 	System.out.println(proceesque); 
				  		if (proceesque == null || proceesque.isEmpty()) { 
					  break; 
					  }
				  TimeUnit.SECONDS.sleep(10);
				  //Thread.sleep(10000);
				  
				  } System.out.println("Job done getting out!!!!"); 
	}
	
	@Test(priority=1)
	public void testCOPG_1() {
		CSVTableRow pagesdata = page.get(3);

		String query = "select page_url from izmoweb_r1v2.idw_dealer_webpages where  page_type='CONT' and curdate() and "
				+ "status='ACTV' and fk_dealer_id=" + pagesdata.getString("DealerId");

		
		
		String webpageId = database.executeSQLQuery(regiondatabase, query);
		System.out.println(webpageId);
		pages.frontendUrl(pagesdata.getString("Dealers") + webpageId);
		Utility.captureScreenshot(driver, "Front end ContentPage");
	 }	
	}















		/*
		 String queri1="select module_id  from process_que where change_flag=1 and page_type='CONT'";
		// TODO : fetch webpage id from csv
		// TODO : get process queue entry for given web page id and module name
		 
		 
		try {
			String webpageId1 = database.executeSQLQuery(regiondatabase, queri1);
		   Boolean isProcessing = true;
			// TODO : check if process queue is finished or not.
			do {
				 isProcessing = true;// fetch it from DB
				TimeUnit.SECONDS.sleep(10);
				// TODO : if not finished, sleep this thread for some time and repeat
				// previous step again
			} while (isProcessing);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO : if finished, execute front end code.

		pages.frontendUrl(pagesdata.getString("Dealers") + webpageId);
		// Assert.assertEquals(actual, true, "Page is not Loading ");
	}*/


    /*//Test to verify Employee table has a record with employee name 'Jack'
    @Test(priority = 3)
    public void tesVerifyListOfRecords() {
        boolean flag = false ;
        List<String> listOfDBValues = new ArrayList<String>();
       String  Moduleid = "9060";
        String sqlQuery = "select module_id  from process_que where change_flag=1 and page_type='CONT'";
        //Getting list of employee names from employee table
         listOfDBValues = database.executeSQLQuery_List(sqlQuery);
        
         Iterator<String> itr = listOfDBValues.iterator();
         while(itr.hasNext()){
             System.out.println(itr.next());
         }
           
         //for(int i=0;i<=listOfDBValues.size();i++)
        for (String strName : listOfDBValues) {
        	
            if (strName.equalsIgnoreCase(Moduleid)) {
                flag = true;
                break;
            }
        	 System.out.println("present value"+strName);
        	
        	
         for (int i = 0; i < listOfDBValues.size(); i++) {
 			System.out.println(listOfDBValues.get(i));
 		}	
            
        }
        //Assert.assertEquals(flag, "Retrieved values are not matching with Expected values");
  }
*/

