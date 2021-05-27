package com.zohocrm.base;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
//import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.zohocrm.utilities.ExcelReader;
import com.zohocrm.utilities.ExtentManagerReport;
import com.zohocrm.utilities.Utilities;

public class Page {
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public  ExtentReports rep=ExtentManagerReport.getInstance();
	public static ExtentTest test;//will define all logs inside extent test cases
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\com\\zohocrm\\excel\\testdata.xlsx");
	
	public static WebDriverWait wait;
	public static String browser;
	public static TopMenu topMenu;
	
	
	/* Logs
	 * Properties - OR,Config
	 * Excel
	 * Extentreports
	 * Implicit and explicitwait
	 */ 
	
	public Page() {
		if(driver==null) {
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\com\\zohocrm\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\zohocrm\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//'Jenkins filter browser configuration		
			if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()){
				
				browser = System.getenv("browser");
			}else{
				
				browser = config.getProperty("browser");
				
			}
			
			config.setProperty("browser", browser);
			
			if (config.getProperty("browser").equals("firefox")) {

				System.setProperty("webdriver.gecko.driver", "System.getProperty(\"user.dir\") + \"\\src\\test\\resources\\com\\zohocrm\\executables\\gecko.exe");
				
				 DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			        capabilities.setCapability("marionette", true);
			        driver = new FirefoxDriver(capabilities);
				//driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\com\\zohocrm\\executables\\chromedriver.exe");
	         
			
			
			  Map<String, Object> prefs = new HashMap<String, Object>();
			
			 prefs.put("profile.default_content_setting_values.notifications", 2);
			  prefs.put("credentials_enable_service", false);
			 prefs.put("profile.password_manager_enabled", false); 
			 ChromeOptions options = new ChromeOptions(); 
			 options.setExperimentalOption("prefs", prefs);
			 options.addArguments("--disable-extensions");
			  options.addArguments("--disable-infobars");
			  
			  options.addArguments("enable-automation");
			//  options.addArguments("--headless");
			//  options.addArguments("--window-size=1920,1080");
			 // options.addArguments("--no-sandbox");
			  options.addArguments("--disable-extensions");
			  options.addArguments("--dns-prefetch-disable");
			  options.addArguments("--disable-gpu");
			  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			    driver = new ChromeDriver(options);
			
			
			
			
			} else if (config.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.ie.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			}
	
			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to : " + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5);
		}
		topMenu=new TopMenu(driver);
		
		}
	
	public static void quit() {
		driver.quit();
	}
	
	//code to add test steps in test cases click and type 
	
	  public static void click(String locator) {
	  driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
	  log.debug("Clicking on Element "+ locator);
	  test.log(LogStatus.INFO, "Clicking on : "+locator); 
	  }
	  
	  public static void type(String locator,String value) {
		 if(locator.endsWith("_CSS"))
		 {
	  driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		 }
		 else if(locator.endsWith("_XPATH")) {
			 driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		 }
		 else if(locator.endsWith("_ID")) {
			 driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		 }
		 log.debug("Typing in : "+locator+"Entered value as: "+ value);
	  test.log(LogStatus.INFO,"Typing in:  "+locator+"Entered value as: "+ value);
	  }
	  static WebElement dropdown;
	  public void select(String locator,String value) {
			
			 if(locator.endsWith("_CSS")) {
				 dropdown= driver.findElement(By.cssSelector(OR.getProperty(locator))); 
				 }
			 else if(locator.endsWith("_XPATH")) { 
				 dropdown= driver.findElement(By.xpath(OR.getProperty(locator)));
				 } 
			 else if(locator.endsWith("_ID")) { 
			  dropdown=driver.findElement(By.id(OR.getProperty(locator))); 
			  }
			 
		 // dropdown=driver.findElement(By.cssSelector(OR.getProperty(locator))); 
		  Select select = new Select(dropdown);
		  select.selectByVisibleText(value);
		  log.debug("selecting from dropdown:  "+locator+"value as: "+ value);
		  test.log(LogStatus.INFO,"selecting from dropdown:  "+locator+"value as: "+ value);
	  }
	 
	public boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}
	
	public static void verifyEquals(String expected,String actual) throws IOException {
		try {
			Assert.assertEquals(actual,expected);
			
		}catch(Throwable t) {
			//ReportNg
			Utilities.captureScreenshot();
			Reporter.log("<br>"+"Verification failure "+t.getMessage()+"<br>");
			Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+"><img src="+Utilities.screenshotName+" height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			
			//Extent report
			test.log(LogStatus.FAIL,"Verification Failed with exception"+t.getMessage());
			test.log(LogStatus.FAIL,test.addScreenCapture(Utilities.screenshotName));
		}
				
	}
}

