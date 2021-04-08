package com.zohocrm.pages.main;

import com.zohocrm.base.Page;
import com.zohocrm.pages.crmhome.CRMHomePage;

public class LoginPage extends Page{
	
	public CRMHomePage doLogin(String username,String password) throws InterruptedException{
		type("userName_CSS",username);
		Thread.sleep(1000);
		click("nextButton_CSS");
		//driver.findElement(By.cssSelector("#login_id")).sendKeys(username);
		//driver.findElement(By.xpath("//button[@class='btn blue'and @id='nextbtn']")).click();
		Thread.sleep(1000);
		type("password_CSS",password);
		//driver.findElement(By.cssSelector("#password")).sendKeys(password);
		click("signin_XPATH");

		//driver.findElement(By.xpath("//button[@class='btn blue'and @id='nextbtn']")).click();
		return new CRMHomePage();
	}
	
	
	public void gotoSalesandMarketing(){
		
		
	}
	
	public void gotoFinance(){
		
		
	}

}
