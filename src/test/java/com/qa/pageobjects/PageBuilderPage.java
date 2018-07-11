package com.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import com.core.reports.TestNGCustomReporter;
import com.r1v2.common.PageFactory;
import static com.r1v2.common.GlobalStaticInfo.*;

public class PageBuilderPage extends SCHomePage {
	
	public PageBuilderPage(WebDriver webDriver, PageFactory pgFactory) {
		super(webDriver, pgFactory);
		
	}
	
	public boolean verifyContentPageButton(){
	 	   boolean flag = verifyWebElement(PAGEBUILDER_CONTENT_PAGERBTN);
		if (flag) {
			TestNGCustomReporter
					.logbr("Content Page RadioButton is displayed on PageBuilder page");
		} else {
			TestNGCustomReporter
					.logbr("Content Page RadioButton is displayed on PageBuilder page");
		}
			return flag;
	}

}