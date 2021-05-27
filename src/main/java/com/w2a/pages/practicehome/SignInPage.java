package com.w2a.pages.practicehome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zohocrm.base.Page;

public class SignInPage extends Page{
	
	
	public SignInPage() {
		this.driver = driver;
	}
	
	public void doSignIn(String userName,String password) throws InterruptedException {
		driver.findElement(By.id("login_id")).sendKeys(userName);
		driver.findElement(By.id("nextbtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("nextbtn")).click();
	}
	
	public void goToForgotPassword() {
		
	}

}
