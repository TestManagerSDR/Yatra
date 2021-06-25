package com.yatra.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties property;	
	
	//used constructor to define and initialize the properties file
	public TestBase(){
		try {
			property = new Properties();
			FileInputStream fs = new FileInputStream("E:\\EclipseNewForFramework\\Workspace\\Yatra\\src\\main\\java\\com\\yatra\\qa\\config\\config.properties");
			property.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\selenium-java-3.141.59\\chromedriver_win32 - Copy\\chromedriver.exe");
		driver = new ChromeDriver(); 		
		//to maximize the window size		
		driver.manage().window().maximize();
		//to delete all the cookies before running the test scripts
		driver.manage().deleteAllCookies();		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//getting URL from the properties file
		driver.get(property.getProperty("URL"));
		
		
	}
	
}
