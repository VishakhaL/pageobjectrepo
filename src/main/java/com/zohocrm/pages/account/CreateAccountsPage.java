package com.zohocrm.pages.account;

import org.openqa.selenium.By;

import com.zohocrm.base.Page;

public class CreateAccountsPage extends Page{
	
public void createAccount(String accountName) {
	driver.findElement(By.cssSelector("#Crm_Accounts_ACCOUNTNAME")).sendKeys(accountName);
		
	}

}
