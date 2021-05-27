package com.zohocrm.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.zohocrm.pages.account.AccountsPage;


//TopMenu is crm main menu
public class TopMenu {
	
	WebDriver driver;
	public TopMenu(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void goToHome() {
		
	}
	
	public void goToLeads() {
		
	}

	public AccountsPage goToAccounts() {

//
		//Assert.assertEquals(driver.getTitle(), "Accounts - Zoho CRM");
		Page.click("accountsMenu_CSS");
		return new AccountsPage();
	
	
		//driver.findElement(By.xpath("//div[@id='crmpluscommonuitopbar']/div[@id='crmpluscommonuitopbarservicemainview']/div[1]/ul[2]/li[4]/a")).click();
		//driver.findElement(By.cssSelector("#crmpluscommonui_crm_Accounts>a")).click();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//li[@id='crmpluscommonui_crm_Accounts']/a
	}
public void goToFeeds() {
		
	}

public void goToContacts() {
	
}

public void signOut() {
	driver.findElement(By.xpath("//div[@id='prfileicon']/img")).click();
}

}
