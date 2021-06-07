package com.zohocrm.rough;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDemo {
	WebDriver driver;
	@Test
	public void produtDemoTest() {
		
		// TODO Auto-generated method stub

		
		 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\com\\zohocrm\\executables\\chromedriver.exe");
			driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		String[] itemsNeeded = {"Brocolli","Cauliflower","Cucumber","Beetroot"};
		
		addItems(driver,itemsNeeded );
	
		
	}
	
	
	
	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));
		int j=0;
		for(int i=0;i<productNames.size();i++) {
			String[] pName = productNames.get(i).getText().split("-");
			String formattedPName = pName[0].trim();
			//convert array into arraylist as arraylist has contains method
			
			List itemNeededList = Arrays.asList(itemsNeeded);
			
			if(itemNeededList.contains(formattedPName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if(j==itemsNeeded.length)
					break;
			}
		}
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//div[@class='promoWrapper']/input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement((By.cssSelector("button.promoBtn"))).click();
		String actualText = driver.findElement(By.cssSelector("span.promoInfo")).getText();
		
		Assert.assertEquals(actualText, "Code applied ..!","Not Matched");
		
		WebDriverWait wait = new WebDriverWait(driver,5);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.promoInfo")));
		
		
	}

}
