package com.zohocrm.testcases;


import java.util.Hashtable;

import org.testng.annotations.Test;

import com.zohocrm.base.Page;

import com.zohocrm.pages.login.CRMDashboardPage;
import com.zohocrm.pages.login.HomePage;
import com.zohocrm.pages.login.LoginPage;

import com.zohocrm.utilities.Utilities;


public class LoginTest extends BaseTest{
	
	@Test(dataProviderClass = Utilities.class,dataProvider="dp")
	//public void loginTest(Hashtable<String,String> data) throws InterruptedException {//Hashtable<String,String> data
		
		/*
		 * if(!(Utilities.isTestRunnable("loginTest",excel))) { throw new
		 * SkipException("Skipping the test "+"loginTest".toUpperCase()
		 * +" as the Run mode is NO"); }
		 */
	//public void loginTest(String userName,String password) throws InterruptedException {	
	public void loginTest(Hashtable<String,String> data) throws InterruptedException{	
		HomePage homePage = new HomePage();
		LoginPage lp = homePage.goToLogin();
		CRMDashboardPage crmDashboard =	lp.doLogin(data.get("username"),data.get("password"));
		//CRMDashboardPage crmDashboard =	lp.doLogin(userName, password);
		
		//crmDashboard.verifyTitle();
		
		
		Page.topMenu.goToAccounts();
		
	}

}
