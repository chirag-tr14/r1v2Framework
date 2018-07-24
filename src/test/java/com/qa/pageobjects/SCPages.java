package com.qa.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.core.config.BasicConfig.selectSite;
import com.core.maindriver.DriverScript;
import com.core.reports.TestNGCustomReporter;
import com.core.settings.GlobalSettings;
import com.r1v2.common.BaseTest;
import com.r1v2.common.PageFactory;
import static com.r1v2.common.GlobalStaticInfo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SCPages extends SCLoginPage {
	BaseTest bt=new BaseTest();
	public String department_name;
	List<String> pdfData=new ArrayList<String>();
	//private Map<String, String> td = bt.getTestDataProperties();
	
	public SCPages(WebDriver webDriver, PageFactory pgFactory) {
		super(webDriver, pgFactory);
	}
	
		public String  frontendSite(String Url){
			getWebDriver().get("");	
			return Url;
		}
	
		public boolean  processqueUrl(String Url){
			getWebDriver().get("");	
			return true;
		}
	
		public boolean  verifyMandatoryField() {
			 boolean flag = verifyWebElement(PAGEBUILDER_COMMON_MANDATORY_TEXT);
			if (flag) {
				TestNGCustomReporter
						.logbr("Field is mandatory");
				clickElement(PAGEBUILDER_COMMON_SAVEBUTTON);
				TestNGCustomReporter
				.logbr("Alert Popup is Display");
								alertAccept();
			} else {
				TestNGCustomReporter
						.logbr("Field is not mandatory");
				clickElement(PAGEBUILDER_COMMON_SAVEBUTTON);
				TestNGCustomReporter
				.logbr("Alert Popup is  not Display");	
			}
			return flag;
		}

	public boolean verifyLogOutAndChangePasswordLinks() {
		boolean flag1 = verifyWebElement(HOMEPAGE_LOGOUT_BUTTON);
		if (flag1) {
			TestNGCustomReporter
					.logbr("logout link is displayed on Home page");
		} else {
			TestNGCustomReporter
					.logbr("logout link is not displayed on Home page");
		}
		boolean flag2 = verifyWebElement(HOMEPAGE_CHANGE_PASSWORD);
		
		if (flag2) {
			TestNGCustomReporter.logbr("change password is displayed on Home page");
		} else {
			TestNGCustomReporter
					.logbr("change password  is not displayed on Home page");
		}
		return (flag1 && flag2);
	}
	
	public boolean verifyContentPageButton(){
 	 	
		boolean flag =verifyElementSelected(PAGEBUILDER_CONTENT_PAGERBTN);
			if (flag) {
		TestNGCustomReporter
				.logbr("Content Page RadioButton default is  selected on  PageBuilder page");
	} else {
		TestNGCustomReporter
				.logbr("Content Page RadioButton default is not selected on  PageBuilder page");
	}
		return (flag);
 }
	
	public SCPages  selectOrganization(){
			clickElement(HOMEPAGE_SELECT_ORGANIZATION);
		return this;
	}
	
	public boolean selectSiteList(String dealer){
			clickElement(PAGEBUILDER_SITELIST_MENU);
				enterValue(PAGEBUILDER_SITELIST_SEARCH, dealer);
			clickElement(PAGEBUILDER_SITELIST_DLRSELECT);
		return true;
	}
	
	public boolean navigatePageBuilder(){
		clickElement(PAGEBUILDER_SITEBUILDER_MENU);
			clickElement(PAGEBUILDER_PAGEBUILDER_MENU);
		clickElement(PAGEBUILDER_PAGEBUILDER_ADD_BTN);
		return true;
	}
	
	public boolean pageTitle(String title){
		enterValue(PAGEBUILDER_COMMON_TITLE,title);
		return true;
	}
	
	public boolean pageUrl(String url){
		enterValue(PAGEBUILDER_COMMON_URL, url);
		return true;
	}
	
	

	public boolean selectDepartmentdropdownitem(String option)  {
		boolean flag=false;
		//clickElement(PAGEBUILDER_DEPARTMENT_DROPDOWN);
	
		List<WebElement> elements = returnWebElements(PAGEBUILDER_DEPARTMENT_DROPDOWN_LIST);
		 for(WebElement el:elements)
         {
			 if(el.getText().equalsIgnoreCase(option))
			 {
				 el.click();
				 flag=true;
				 this.department_name=el.getText();
				 break;
			 }
             else{
                 flag=false;
             }
         }
     return flag;
		
	}
	
	public boolean resposniveContent(String content){
		enterValue(PAGEBUILDER_COMMON_RESPONSIVECONTENT,content);
		return true;
	}
	
	
	public boolean savePage(){
		 clickElement(PAGEBUILDER_COMMON_SAVEBUTTON);
		 return true;
	}

	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	public boolean verifylogoutButtonFunctionality() {
	       boolean flag=false;
			clickElement(HOMEPAGE_LOGOUT_BUTTON);
			String title = getWebDriver().getTitle();

			if (title.equalsIgnoreCase("admin_page_title")) {
				flag=true;
				TestNGCustomReporter
						.logbr(" logout sucessfull and Application bring back to login page");
			} else {
				flag=false;
				TestNGCustomReporter.logbr(" logout is Unsuccessfull");
			}
			return flag;
	}

	
	
	
	
	
	
}
