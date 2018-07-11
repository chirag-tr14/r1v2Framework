package com.r1v2.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.core.config.BrowserConfig;
import com.core.config.PropTestdataConfig;
import com.core.maindriver.DriverScript;
import com.core.reports.TestNGCustomReporter;
import com.core.settings.GlobalSettings;

public class BaseTest {

	private WebDriver driver;
	private DriverScript driverScript;
	private GlobalSettings globalSettings = new GlobalSettings();
	private HashMap<String, String> testDataProperties =new HashMap<String, String>();
	public static Connection conn;
	@BeforeClass
	public void beforeClass() {
		initWebDriver();
		TestNGCustomReporter.logbr("Browser launched successfully");
	}

	protected WebDriver initWebDriver() {
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
		
	public PageFactory getPageFactory() {
		return new PageFactory(driver);
	}


	private static Statement getStatements() throws SQLException, ClassNotFoundException {
		if (conn == null || conn.isClosed()) {
			// For credentials
			Class.forName("com.mysql.jdbc.Driver");
		
			String userName="rajesh.n";
			String passWord="Rak@34hC";
			// connection driver
		conn = DriverManager.getConnection("jdbc:mysql://idbw:3306/izmoweb_r1v2", userName, passWord);
		}
		return conn.createStatement();
	}

	public static ResultSet getData(String query) throws SQLException, ClassNotFoundException {
		ResultSet data = getStatements().executeQuery(query);
		return data;
	}

	public void closeConnection() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
						e.printStackTrace();
		}
	}
	
		
	
	private void closeBrowser(){
		driverScript.stopSelenium(driver);
	}
	
}
