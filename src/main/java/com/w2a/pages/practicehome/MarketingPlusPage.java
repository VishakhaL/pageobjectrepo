package com.w2a.pages.practicehome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketingPlusPage {
	
	WebDriver driver;
	
	public MarketingPlusPage(WebDriver driver) {
		this.driver =driver;
	}
	public void goToSignUpPage() {
		driver.findElement(By.cssSelector("span.cta_inner")).click();;
		
	}
	
	public void goToPricing() {
		
	}
	
	public void goToResources() {
	
	}

}
