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
import com.r1v2.common.BaseTest;
import com.r1v2.common.DataBase;

public class ContentPage extends BaseTest{
	public static final Logger logger = LogManager.getLogger(ScenarioContentPage.class);
	DataBase database;
	SCPages pages;
	
	ScenarioContentPage cont= new ScenarioContentPage();
	
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
		
		String webpageId = cont.testPG_8();
		
		/*String query="select fk_webpage_id from page_dealer_map where  date_created= CURDATE() and "+pagesdata.getString("DealerId");
		
		String webpageId = database.executeSQLQuery(regiondatabase,query);*/
				
		//System.out.println(webpageId);
		
	    String sqlQuery = "select public_url from page_urls where  page_type='CONT'and webpageId="+webpageId+" "
	    		+ "and fk_dealer_id="
	    					 +pagesdata.getString("DealerId");
	  	String contentpageurl = database.executeSQLQuery(regiondatabase,sqlQuery);
		//SCPages actual=
	  	pages.frontendUrl(pagesdata.getString("Dealers")+contentpageurl);
		//Assert.assertEquals(actual, true, "Page is not Loading  ");
    }
	
	
 }
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

