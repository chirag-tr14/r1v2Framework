package com.core.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.map.StaticBucketMap;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.r1v2.common.DataBase;

/**
 * Name : Utility
 * 
 * Description : It is an Utility class which will hold all independent utility
 * functions that are used for automation
 * 
 * 

 * 
 **/
public class Utility {
	DataBase database;
	public static final Logger logger = LogManager.getLogger(Utility.class);

		
	public  static void processQue(String query) throws InterruptedException{
		Boolean isProcessing = true;
		while (isProcessing) {
		//String proceesque = database.executeSQLQuery(regiondatabase, processqueQuery);
		System.out.println(query);
		if (query == null || query.isEmpty()) {
			break;
		}
		TimeUnit.SECONDS.sleep(10);
		} 
		System.out.println("Job done getting out!!!!");
	} 
	//This Method return Current Date 
	public static String getTodaysDate(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}
	
	
		//public static DateFormat dateformat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		public static String captureScreenshot(WebDriver driver, String screenshotName) {

			String datename = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

			TakesScreenshot ts = (TakesScreenshot) driver;

			File src = ts.getScreenshotAs(OutputType.FILE);

			String destination = "F:\\IZMO FrameWork\\com.r1v2.com\\ScreenShots\\PageBuilder\\" +screenshotName  + 
					datename+  ".png";
		
			try {
				FileUtils.copyFile(src, new File(destination));
			} catch (IOException e) {
				System.out.println("Failed to capture screenshots" + e.getMessage());
			}

			return destination;
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String generateRandomEmailAddress(String domain) {
		String emailAddress = "";
		// Generate random email address
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		while (emailAddress.length() < 5) {
			int character = (int) (Math.random() * 26);
			emailAddress += alphabet.substring(character, character + 1);
		}
		emailAddress += Integer.valueOf((int) (Math.random() * 99)).toString();
		emailAddress += "@" + domain;
		return emailAddress;
	}

	

	public static String stripNonDigits(final CharSequence input) {
		final StringBuilder sb = new StringBuilder(input.length());
		for (int i = 0; i < input.length(); i++) {
			final char c = input.charAt(i);
			if (c > 47 && c < 58) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static String getRandomString(int len) {
		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
	
	public static String getRandomAlphabet(int len) {
		final String AB = "qwertyuiopasdfghjklzxcvbnmABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	
	
	
	
	
	
	
	
	
	
}
