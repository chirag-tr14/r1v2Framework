package com.qa.frontend.pageobjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import com.qa.sc.pageobjects.SCLoginPage;
import com.r1v2.common.BaseTest;
import com.r1v2.common.DataBase;
import com.r1v2.common.PageFactory;

public class FrontEndPages extends  SCLoginPage {

	
	public FrontEndPages(WebDriver webDriver, PageFactory pgFactory) {
		super(webDriver, pgFactory);
		
	}
	
/*	public  FrontEndPages frontendUrl(String url){
		openHomepage(url);
		return getPageFactory().frontendPage();
	}*/
/*	
	public  FrontEndPages  frontendUrl(String url){
		getWebDriver().get(url);
		return this;
	}*/
	
	/*public void contentPageUrl() throws ClassNotFoundException, SQLException{
		String Query = "";
		ResultSet data = DataBase.getData(Query);
		boolean firstData = data.next();
		String ID = "";
		if (firstData) {
			ID = data.getString(1);
			// System.out.println(ID);
		}
	}
	
	public void campaignPageUrl() throws ClassNotFoundException, SQLException{
		String Query = "";
		ResultSet data = DataBase.getData(Query);
		boolean firstData = data.next();
		String ID = "";
		if (firstData) {
			ID = data.getString(1);
			// System.out.println(ID);
		}
	}
	public void specialPageUrl() throws ClassNotFoundException, SQLException{
		String Query = "";
		ResultSet data = DataBase.getData(Query);
		boolean firstData = data.next();
		String ID = "";
		if (firstData) {
			ID = data.getString(1);
			// System.out.println(ID);
		}
	}
	*/

}
