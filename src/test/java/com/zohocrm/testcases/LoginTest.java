package com.zohocrm.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.zohocrm.pages.crmhome.CRMHomePage;
import com.zohocrm.pages.main.HomePage;
import com.zohocrm.pages.main.LoginPage;
import com.zohocrm.utilities.ExcelReader;
import com.zohocrm.utilities.Utilities;


public class LoginTest extends BaseTest{
	
	@Test(dataProviderClass = Utilities.class,dataProvider="dp")
	public void loginTest(Hashtable<String,String> data) throws InterruptedException {
		
		/*
		 * if(!(Utilities.isTestRunnable("loginTest",excel))) { throw new
		 * SkipException("Skipping the test "+"loginTest".toUpperCase()
		 * +" as the Run mode is NO"); }
		 */
			
			
		HomePage homePage = new HomePage();
		LoginPage lp=homePage.goToLogin();
		
		//LoginPage loginPage=new LoginPage();
		//CRMHomePage crmHomePage=lp.doLogin(data.get("username"),data.get("password"));
	}

}
