package com.zohocrm.rough;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
		int j=0;
		String[] itemsNeeded = {"Brocolli","Cauliflower","Cucumber","Beetroot"};
		List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));
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

	}
	
	public void tearDown() {
		driver.quit();
		
	}

}
