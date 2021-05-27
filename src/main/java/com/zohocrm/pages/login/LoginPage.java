package com.zohocrm.pages.login;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.zohocrm.base.Page;
import com.zohocrm.utilities.Utilities;

public class LoginPage extends Page{
	
	
	  @Test(dataProviderClass =Utilities.class, dataProvider ="dp")
	  public  CRMDashboardPage doLogin(String username,String password) throws InterruptedException{
		  
		  type("userName_CSS",username); 
		  Thread.sleep(1000);
	  
		  click("nextButton_CSS");
	  //driver.findElement(By.cssSelector("#login_id")).sendKeys(username);
	  //driver.findElement(By.xpath("//button[@class='btn blue'and @id='nextbtn']")
	   Thread.sleep(1000); 
	   type("password_CSS",password);
	  //driver.findElement(By.cssSelector("#password")).sendKeys(password);
	  click("signin_CSS");
	  
	  //driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
	  
	  //driver.findElement(By.xpath("//button[@class='btn blue'and @id='nextbtn']")).click(); 
	  return new CRMDashboardPage();
	  }
	  
	
	
	public void gotoSalesandMarketing(){
		
		
	}
	
	public void gotoFinance(){
		
		
	}

}
