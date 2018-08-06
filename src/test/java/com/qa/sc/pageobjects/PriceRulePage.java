package com.qa.sc.pageobjects;

import static com.r1v2.common.GlobalStaticInfo.*;


import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.core.util.CSVTable;
import com.core.util.CSVTableRow;
import com.core.util.PropertyFileUtil;
import com.r1v2.common.BaseTest;
import com.r1v2.common.DataBase;
import com.r1v2.common.PageFactory;

public class PriceRulePage extends SCLoginPage {

		
	public PriceRulePage(WebDriver webDriver, PageFactory pgFactory) {
		super(webDriver, pgFactory);
		
	}
	
	public boolean navigatePriceRulePage(){
		clickElement(INVTMGMT_INVTMANAGE_MENU);
			clickElement(INVTMGMT_PRICERULE_MENU);
		clickElement(INVTMGMT_PRICERULE_ADD_BTN);
		return true;
	}
	
	
	

	
}
