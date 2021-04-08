package com.zohocrm.pages.account;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.zohocrm.base.Page;

public class AccountsPage extends Page {
	
	public CreateAccountsPage goToCreateAccounts() {
		//WebDriverWait wait=new WebDriverWait(driver,20);
		//WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submenu_Accounts")));
		//ele.click();
		//lyte-button[@id=
		//driver.findElement(By.id("submenu_Accounts")).click();
		//driver.findElement(By.cssSelector("#submenu_Accounts>.lyte-button.lytePrimaryBtn")).click();
	Assert.assertTrue(driver.findElement(By.cssSelector("div.fL.w50per>.bubble.f14px.pR.crm-font-bold")).isDisplayed(),"Other /business");
	//driver.findElement(By.cssSelector("div.fL.w50per>.bubble.f14px.pR.crm-font-bold")).isDisplayed();

//		driver.findElement(By.xpath("//div/div/div/div/div/div/link-to/lyte-button[@id='submenu_Accounts']")).click();
		return new CreateAccountsPage();
	}
	
public void goToImportAccounts() {
		
	}

}
