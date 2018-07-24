package com.r1v2.common;


import org.openqa.selenium.WebDriver;
import com.core.util.ExcelHandler;
import com.qa.pageobjects.SCPages;
import com.qa.pageobjects.SCLoginPage;




public class PageFactory {
	
	private WebDriver webDriver;
	
	public PageFactory(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public SCLoginPage adminLoginPage() {
		return new SCLoginPage(webDriver,this);
	}
	
	public SCPages scHomePage() {
		return new SCPages(webDriver,this);
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

