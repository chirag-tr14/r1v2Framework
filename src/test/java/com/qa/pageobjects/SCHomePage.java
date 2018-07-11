package com.qa.pageobjects;


import org.openqa.selenium.WebDriver;
import com.core.reports.TestNGCustomReporter;
import com.r1v2.common.PageFactory;
import static com.r1v2.common.GlobalStaticInfo.*;

public class SCHomePage extends SCLoginPage {
	
	public SCHomePage(WebDriver webDriver, PageFactory pgFactory) {
		super(webDriver, pgFactory);
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
	
	public SCHomePage  selectOrganization(){
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
	
	
	

	
}
