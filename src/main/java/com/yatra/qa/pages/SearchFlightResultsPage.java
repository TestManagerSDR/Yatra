package com.yatra.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yatra.qa.base.TestBase;

public class SearchFlightResultsPage extends TestBase {

	@FindBy(xpath="//*[@id=\"Flight-APP\"]/section/section[2]/section[1]/div[2]/div[1]/div/div/div[1]")
	WebElement searchLoad;
	
	// Initializing the Page Objects:
	public SearchFlightResultsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySearchResultPageLoad() {
		boolean loadResult = false;		
		WebDriverWait wait = new WebDriverWait(driver, 30);	
		wait.until(ExpectedConditions.elementToBeClickable(searchLoad));
		String loadText = searchLoad.getText();
		if(loadText!="") {
		loadResult = true;
		}else{
			loadResult=false;
		}
		
		return loadResult;
	}
	
	
}
