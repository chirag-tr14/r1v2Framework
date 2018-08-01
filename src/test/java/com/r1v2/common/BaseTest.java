package com.r1v2.common;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import com.core.config.BrowserConfig;
import com.core.config.PropTestdataConfig;
import com.core.maindriver.DriverScript;
import com.core.reports.TestNGCustomReporter;
import com.core.settings.GlobalSettings;

public class BaseTest  {

	private WebDriver driver;
	private DriverScript driverScript;
	private GlobalSettings globalSettings = new GlobalSettings();
	private static HashMap<String, String> testDataProperties =new HashMap<String, String>();
	private static HashMap<String, String> testDatabaseProperties =new HashMap<String, String>();
	
	
	@BeforeClass
	public void beforeClass() {
		initWebDriver();
		TestNGCustomReporter.logbr("Browser launched successfully");
	}
	
	public WebDriver initWebDriver() {
		try {
			String browser = globalSettings.getBrowser();
			driverScript = new DriverScript(new BrowserConfig(browser));
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver = driverScript.getDriverObject();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public PageFactory getPageFactory() {
		return new PageFactory(driver);
	}

	public void closeBrowser(){
		driverScript.stopSelenium(driver);
	}

	
	public HashMap<String, String> getTestDataProperties() {
		if(testDataProperties.size()<=0){
			setTestDataProperties();
		}
		return testDataProperties;
	}

	private void setTestDataProperties() {
		try {
			testDataProperties = new PropTestdataConfig()
			.getWebElementMapping();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

	
