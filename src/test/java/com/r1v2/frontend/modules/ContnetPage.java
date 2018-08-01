package com.r1v2.frontend.modules;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.core.util.CSVTable;
import com.core.util.CSVTableRow;
import com.core.util.PropertyFileUtil;
import com.mysql.cj.api.mysqla.result.Resultset;
import com.qa.frontend.pageobjects.FrontEndPages;
import com.qa.sc.pageobjects.SCLoginPage;
import com.qa.sc.pageobjects.SCPages;
import com.r1v2.backend.modules.ScenarioContentPage;
import com.r1v2.common.BaseTest;
import com.r1v2.common.DataBase;

public class ContnetPage extends BaseTest{
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
	 
	@BeforeClass
	public void setUpOnce1() {
			 pages=getPageFactory().scHomePage();
			 database=getPageFactory().databse();
	}
	
	@Test(priority = 1)
	    public void login(){
		CSVTableRow pagesdata = page.get(3);
	    pages.frontendUrl(pagesdata.getString("Dealers"));
	
    }

	@Test(priority = 2)
    public void testVerifySpecificRecord() throws SQLException, ClassNotFoundException {
		
		
		System.out.println("Actalu value "+td.get("username"));
		System.out.println("Actalu value "+td.get("password"));
		
		String sqlQuery = "select module_id  from process_que where change_flag=1 and page_type='CONT'";
        String expectedEmpName = "23748";
        //Getting employee name by Id
               //ResultSet data = database.getData(sqlQuery);
       
        
        String actual = database.executeSQLQuery(sqlQuery);
        System.out.println("Actalu value "+actual);
   
         //Assert.assertEquals(expectedEmpName, actual);
    }

    //Test to verify Employee table has a record with employee name 'Jack'
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
      /*  for (String strName : listOfDBValues) {
        	
            if (strName.equalsIgnoreCase(Moduleid)) {
                flag = true;
                break;
            }
        	 System.out.println("present value"+strName);
        	
        	
         for (int i = 0; i < listOfDBValues.size(); i++) {
 			System.out.println(listOfDBValues.get(i));
 		}*/	
            
        }
        //Assert.assertEquals(flag, "Retrieved values are not matching with Expected values");
    }


