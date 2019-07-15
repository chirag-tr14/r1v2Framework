package com.r1v2.backend.pagebuilder.module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sample {
	
	@Test
	public void login() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Rajesh.n2\\Desktop\\Driver\\chrome\\chromedriver.exe");
	      	driver=new ChromeDriver();
		
	}

}
