package com.zohocrm.pages.login;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.zohocrm.base.Page;
//import com.zohocrm.rough.LoginPage;

public class HomePage extends Page {

	
	public void goToSupport(){
		
		driver.findElement(By.cssSelector(".zh-support")).click();
		
	}
	
	public void goToSignUp(){
		
		//driver.findElement(By.cssSelector(".zh-signup")).click();
		click("signup_CSS");
	}
	
	
	public LoginPage goToLogin(){
		//driver.findElement(By.xpath("//section[@id='block-block-3']/div/div/div/div/a[@class='zgh-login']")).click();
		Assert.assertEquals(driver.getTitle(),"Unified Customer Experience Platform | Zoho CRM Plus","Test case failed");
		click("loginlink_CSS");
		
		return new LoginPage();
	}
	
	
	
	public void goToZohoEdu(){
		
		
		
	}
	
	public void goToLearnMore(){
		
		
		
	}
	
	
	public void validateFooterLinks(){
		
		
	}

}
