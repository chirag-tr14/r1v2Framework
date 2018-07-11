package com.r1v2.common;


import org.openqa.selenium.WebDriver;
import com.core.util.ExcelHandler;
import com.qa.pageobjects.PageBuilderPage;
import com.qa.pageobjects.SCHomePage;
import com.qa.pageobjects.SCLoginPage;




public class PageFactory {
	
	private WebDriver webDriver;
	
	public PageFactory(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public ExcelHandler getExcel(){
		ExcelHandler excel = new ExcelHandler("./ScPages.xlsx");
		return excel;
			
	}
	
	public SCLoginPage euroLoginPage() {
		return new SCLoginPage(webDriver,this);
	}
	
	public SCHomePage scHomePage() {
		return new SCHomePage(webDriver,this);
	}
	
	
	public PageBuilderPage pagebuilderpage() {
		return new PageBuilderPage(webDriver,this);
	}
	/*
	public StatementCreditPage statementCreditPage() {
		return new StatementCreditPage(webDriver,this);
	}
	
	public CouponRewardsPage couponRewardsPage() {
		return new CouponRewardsPage(webDriver,this);
	}
	
	public PrepaidGiftCardPage prepaidGiftCardPage() {
		return new PrepaidGiftCardPage(webDriver,this);
	}
	
	public WeeklyStatementCreditPerformancePage weeklyStatementCreditPerformancePage() {
		return new WeeklyStatementCreditPerformancePage(webDriver,this);
	
	}
	
	public EmailSettingsPage  emailSettingsPage () {
		return new EmailSettingsPage (webDriver,this);
	
	}
	
	public TagCampaignMappingPage  tagCampaignMappingPage () {
		return new TagCampaignMappingPage (webDriver,this);
	
	}	
	*/
}

