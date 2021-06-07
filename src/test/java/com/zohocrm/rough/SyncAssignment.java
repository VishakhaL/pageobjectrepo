package com.zohocrm.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SyncAssignment {
  @Test
  public void syncAssignmentTest() {
	  WebDriver driver;
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\com\\zohocrm\\executables\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");
		
		driver.findElement(By.xpath("//a[contains(@href,'loadAjax')]")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("results")));
			System.out.println(driver.findElement(By.id("results")).getText());
  }
}
