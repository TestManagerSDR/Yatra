package com.yatra.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yatra.qa.base.TestBase;

public class HomePage extends TestBase{
	
	Actions action;
	JavascriptExecutor executor;

	//Locator for Departure Place
	@FindBy(id="BE_flight_origin_city")
	WebElement departFromPlace;
	
	//Locator for Going to Place
	@FindBy(id="BE_flight_arrival_city")
	WebElement goingToPlace;	
	
	//Locator for departure date
	@FindBy(id="BE_flight_origin_date")
	WebElement depatureDate;		
	
	//Locator for submit button
	@FindBy(id="BE_flight_flsearch_btn")
	WebElement submitButton;
	
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public SearchFlightResultsPage validateSearchFlight(String departureFrom, String goingTo,String depatureD) throws Exception{
		
		executor = (JavascriptExecutor)driver;
		action = new Actions(driver);		
	  
		departFromPlace.clear();
		departFromPlace.click();		
	  	departFromPlace.sendKeys(departureFrom);	  	
	  	Thread.sleep(4000);	    
	    action.sendKeys(Keys.DOWN).perform();
	    action.sendKeys(Keys.ENTER).perform();
	    Thread.sleep(2000);
	    //goingToPlace.clear();	   
	    goingToPlace.sendKeys(goingTo);
	    Thread.sleep(2000);
	    action.sendKeys(Keys.DOWN).perform();
	    action.sendKeys(Keys.ENTER).perform();
	    Thread.sleep(2000);	    
	    depatureDate.click();
	    
	    WebElement date= driver.findElement(By.id(depatureD));	    
	    executor.executeScript("arguments[0].click();", date);	   
	    Thread.sleep(2000);
	    
		submitButton.click();
		Thread.sleep(4000);
		
				
			
		return new SearchFlightResultsPage();
		
	}
	
	
	
	}
