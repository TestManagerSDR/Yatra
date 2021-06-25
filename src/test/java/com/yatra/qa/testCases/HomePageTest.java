package com.yatra.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.yatra.qa.base.TestBase;
import com.yatra.qa.pages.HomePage;
import com.yatra.qa.pages.SearchFlightResultsPage;
import com.yatra.qa.utils.TestUtil;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	SearchFlightResultsPage searchFlightResultsPage;
	String sheetName = "TestData";
	
	//called the parent class constructor
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		searchFlightResultsPage = new SearchFlightResultsPage();
		
	}
	
	@DataProvider
	public Object[][] getYatraTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, enabled=true, dataProvider="getYatraTestData")
	public void validateSearchFlightTest(String departureFrom,String goingTo,String departure) throws Exception{
		
		searchFlightResultsPage = homePage.validateSearchFlight(departureFrom, goingTo, departure);
		
	}
	
		
	@AfterMethod
	public void closeWindow() {
		driver.quit();
		
	}
	
	
	
}
