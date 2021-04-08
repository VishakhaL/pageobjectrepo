package com.zohocrm.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.zohocrm.base.Page;
import com.zohocrm.pages.account.AccountsPage;
import com.zohocrm.pages.account.CreateAccountsPage;
import com.zohocrm.pages.crmhome.CRMHomePage;
import com.zohocrm.pages.main.HomePage;
import com.zohocrm.pages.main.LoginPage;

public class LoginTest {
	
	public static void main(String[] args) throws InterruptedException {
		HomePage homePage = new HomePage();
		LoginPage lp=homePage.goToLogin();
		
		//LoginPage loginPage=new LoginPage();
		CRMHomePage crmHomePage=lp.doLogin("ridertest2018@gmail.com", "testpass2021@");
		AccountsPage accountPage =Page.topMenu.goToAccounts();// Page.topMenu.signOut();
		
	//	AccountsPage accountPage = new AccountsPage();
		CreateAccountsPage createAccountPage=accountPage.goToCreateAccounts();
		//CreateAccountsPage createAccountPage =new CreateAccountsPage();
		createAccountPage.createAccount("Shriya");
		 
		
	}
}
