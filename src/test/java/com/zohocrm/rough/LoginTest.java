package com.zohocrm.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.w2a.pages.practicehome.HomePageOne;
import com.w2a.pages.practicehome.SignInPage;
import com.zohocrm.base.Page;
import com.zohocrm.pages.account.AccountsPage;
import com.zohocrm.pages.account.CreateAccountsPage;

import com.zohocrm.pages.login.HomePage;
import com.zohocrm.pages.login.LoginPage;

public class LoginTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		HomePageOne homePage = new HomePageOne();
		homePage.goToSignIn();
		//homePage.goToMarketingPlus();
		
		SignInPage signInPage = new SignInPage();
		signInPage.doSignIn("ridertest2018@gmail.com", "vtest2018@");
		
//		CRMHomePage crmHome = new CRMHomePage(driver);
//		crmHome.goToAccounts();
		
		//Page.topMenu.signOut();
		Page.topMenu.goToAccounts();
		//HomePage homePage = new HomePage();
		//homePage.goToLogin();
		
		//LoginPage lp=new LoginPage();
		//lp.doLogin("ridertest2018@gmail.com", "testpass2021@");
		//CRMHomePage crmHomePage=lp.doLogin("ridertest2018@gmail.com", "testpass2021@");
		//AccountsPage accountPage =Page.topMenu.goToAccounts();// Page.topMenu.signOut();
		
	//	AccountsPage accountPage = new AccountsPage();
		//CreateAccountsPage createAccountPage=accountPage.goToCreateAccounts();
		//CreateAccountsPage createAccountPage =new CreateAccountsPage();
		//createAccountPage.createAccount("Shriya");
		 
		
	}
}
