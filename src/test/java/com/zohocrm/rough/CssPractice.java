package com.zohocrm.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CssPractice {
	WebDriver driver;
  @Test
  public void cssPracticeTest() {
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\com\\zohocrm\\executables\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.salesforce.com/in/?ir=1");
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		String expectedMessage ="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		driver.findElement(By.cssSelector("a.dropdown-toggle.disabled")).click();
		driver.findElement(By.cssSelector("input#username")).sendKeys("username");
		driver.findElement(By.cssSelector("input#password")).sendKeys("password");
		driver.findElement(By.cssSelector("input#Login")).click();
		Assert.assertEquals(expectedMessage, driver.findElement(By.cssSelector("div#error")).getText(),"Test Case Faile");
  }
}
