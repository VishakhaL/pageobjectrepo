package com.zohocrm.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zohocrm.pages.account.AccountsPage;

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
		driver.findElement(By.cssSelector("#crmpluscommonui_crm_Accounts > a")).click();
		return new AccountsPage();
		
	}
public void goToFeeds() {
		
	}

public void goToContacts() {
	
}

public void signOut() {
	
}

}
