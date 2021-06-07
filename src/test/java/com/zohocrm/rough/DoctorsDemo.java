package com.zohocrm.rough;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DoctorsDemo {
	WebDriver driver;
  @Test
  public void doctorsDemoTest() {
	  
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\com\\zohocrm\\executables\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.apollo247.com/specialties/general-physician-internal-medicine");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		String[] doctorsNeeded = {"Dr. Anish Anand","Dr. Deven Shah"};
		List<WebElement> doctorsName =driver.findElements(By.xpath("//div[contains(@class, '-MuiGrid-grid-lg-6')]/div/a/div/div[2]/div[contains(text(),'Dr')]"));
														
		
		for(int i=0;i<doctorsName.size();i++) {
			
			String dNameList=doctorsName.get(i).getText();
			
			//String formattedDoctorName = dNameList[0].trim();
			List doctorsNeededList =Arrays.asList(doctorsNeeded);
			
			if(doctorsNeededList.contains(dNameList)) {
				driver.findElements(By.xpath("//button/span[text()='Book Appointment']")).get(i).click();
				break;
				
				
			}
		}
  }
}
