package com.qa.sc.pageobjects;


import static com.r1v2.common.GlobalStaticInfo.HOMEPAGE_CHANGE_PASSWORD;
import static com.r1v2.common.GlobalStaticInfo.HOMEPAGE_LOGOUT_BUTTON;
import static com.r1v2.common.GlobalStaticInfo.HOMEPAGE_SELECT_ORGANIZATION;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER_CAMPAIGN_PAGEBTN;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER_COMMON_FORMCATEGORY_LABELS;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER_COMMON_MANDATORY_TEXT;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER_COMMON_RESPONSIVECONTENT;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER_COMMON_SAVEBUTTON;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER_COMMON_TITLE;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER_COMMON_URL;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER_CONTENT_PAGERBTN;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER_DEPARTMENT_DROPDOWN_LIST;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER_PAGEBUILDER_ADD_BTN;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER_PAGEBUILDER_MENU;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER_SITEBUILDER_MENU;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER_SITELIST_DLRSELECT;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER_SITELIST_MENU;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER_SITELIST_SEARCH;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER_SPECIAL_PAGE;
import static com.r1v2.common.GlobalStaticInfo.PAGEBUILDER__FORMCATEGORY_DROPDOWN_LIST;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.core.reports.TestNGCustomReporter;
import com.mysql.cj.api.mysqla.result.Resultset;
import com.r1v2.common.BaseTest;
import com.r1v2.common.DataBase;
import com.r1v2.common.PageFactory;

public class SCPages extends SCLoginPage {
	
		public String department_name;
		List<String> pdfData=new ArrayList<String>();
	
	public SCPages(WebDriver webDriver, PageFactory pgFactory) {
		super(webDriver, pgFactory);
	}
	
	
	public   SCPages frontendUrl(String url){
		openHomepage(url);;
		return this;
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
	
	public boolean verifyCampaignPageButton(){
 	 	
		boolean flag =verifyWebElement(PAGEBUILDER_CAMPAIGN_PAGEBTN);
			if (flag) {
		TestNGCustomReporter
				.logbr("CampaignPage Page RadioButton default is  selected on  PageBuilder page");
		
		clickElement(PAGEBUILDER_CAMPAIGN_PAGEBTN);
		TestNGCustomReporter
					.logbr("CampaignPage Page RadioButton  is  selected on  PageBuilder page");
		
	} else {
		TestNGCustomReporter
				.logbr("Content Page RadioButton default is not selected on  PageBuilder page");
	}
		return (flag);
 }
	
	public boolean verifySpecialPageButton(){
 	 	
		boolean flag =verifyWebElement(PAGEBUILDER_SPECIAL_PAGE);
			if (flag) {
		TestNGCustomReporter
				.logbr("CampaignPage Page RadioButton default is  selected on  PageBuilder page");
		
		clickElement(PAGEBUILDER_SPECIAL_PAGE);
		TestNGCustomReporter
					.logbr("CampaignPage Page RadioButton  is  selected on  PageBuilder page");
		
	} else {
		TestNGCustomReporter
				.logbr("Content Page RadioButton default is not selected on  PageBuilder page");
	}
		return (flag);
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
	
	
	public boolean selectformCategorydropdownitem(String option) throws InterruptedException  {
		boolean flag=false;
		clickElement(PAGEBUILDER__FORMCATEGORY_DROPDOWN_LIST);
	
		List<WebElement> elements = returnWebElements(PAGEBUILDER_COMMON_FORMCATEGORY_LABELS);
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



