package com.qa.sc.pageobjects;


import static com.r1v2.common.GlobalStaticInfo.*;
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
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.core.reports.TestNGCustomReporter;
import com.core.util.CSVTable;
import com.core.util.CSVTableRow;
import com.core.util.PropertyFileUtil;
import com.r1v2.common.BaseTest;
import com.r1v2.common.DataBase;
import com.r1v2.common.PageFactory;

public class SCPages extends SCLoginPage {
	
	DataBase database=getPageFactory().databse();
		public String department_name;
	
		BaseTest t= new BaseTest();
		private PropertyFileUtil propUtil = new PropertyFileUtil("config");
		private Map<String, String> td = t.getTestDataProperties();
		String regiondatabase=td.get(propUtil.getString("region")+".env");
		
		CSVTable pagebuilderpage = new CSVTable(td.get(propUtil.getString("region")+".PageBuilderFilePath"));
		List<CSVTableRow> page = pagebuilderpage.getRecords();
		CSVTableRow pagesdata = page.get(0);
		
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
	//	clickElement(PAGEBUILDER_DEPARTMENT_DROPDOWN);PAGEBUILDER_DEPARTMENT_DROPDOWN_LIST
			List<WebElement> elements = returnWebElements(PAGEBUILDER_DEPARTMENT_DROPDOWN_LIST);
		 for(WebElement el:elements)
         {
			 if(el.getText().trim().equalsIgnoreCase(option))
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

	public boolean selectformCategorydropdownitem(String option)    {
		boolean flag=false;
		clickElement(PAGEBUILDER__FORMCATEGORY_DROPDOWN_LIST);
	
		List<WebElement> elements = returnWebElements(PAGEBUILDER_COMMON_FORMCATEGORY_LABELS);
		 for(WebElement el:elements)
         {
			 if(el.getText().trim().equalsIgnoreCase(option))
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
		
		/*getWebDriver().switchTo().frame("idContent_editorobj1");
			ell.click();
			ell.sendKeys(content);*/
				//WebElement ell=getWebDriver().findElement(By.xpath("//html/body[1]"));
		//switchToFrame(PAGEBUILDER_COMMON_RESPONSIVEFRAME1);
				//clickElement(ell);
				
		switchToFrame(PAGEBUILDER_COMMON_RESPONSIVEFRAME1);
		clickElement(PAGEBUILDER_COMMON_RESPONSIVEBODY);
		enterValue(PAGEBUILDER_COMMON_RESPONSIVEBODY, content);
		 getWebDriver().switchTo().defaultContent();
 		return true;
	}

	
	
	
	public SCPages savePage(){
		 clickElement(PAGEBUILDER_COMMON_SAVEBUTTON);
		 waitforPageTolaod(10);
		 //System.out.println(getWebDriver().getTitle());
		 return this;
	}

	public boolean veirfyPageTitle(String title) {
		boolean flag=getWebDriver().getTitle().equalsIgnoreCase(title);
		//System.out.println(getWebDriver().getTitle());
		return flag;
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

	
/*	public SCPages webPage_id(  ){
		String query="select fk_webpage_id from page_dealer_map where  date_created= CURDATE() and "
	       		+ ""+pagesdata.getString("DealerId");
			String webpageId = database.executeSQLQuery(regiondatabase,query);
			System.out.println(webpageId);
			return this;
		
	}*/
	

	
}



