package com.w2a.pages.practicehome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zohocrm.base.Page;

public class HomePageOne extends Page{
	
	
	public void goToMarketingPlus() {
		driver.findElement(By.xpath("//div[@class='zgh-nav active']/ul/li[2]/a[contains(text(),'Marketing Plus')]")).click();
	}
	
	
public void goToFinancePlus() {
		
	}

public void goToITManagement() {
	
}

public void goToLearnMore() {
	
}

public void goToSignIn() {
	driver.findElement(By.xpath("//div[@class='zgh-utilities']/div[@class='zgh-accounts']/a[@class='zgh-login']")).click();
	
	
}

public void goToSignUpForFree() {
	
}

public void goToFeatures() {
	
}

public void goToPricing() {
	
}

public void goToCustomers() {
	
}
	
	

}
