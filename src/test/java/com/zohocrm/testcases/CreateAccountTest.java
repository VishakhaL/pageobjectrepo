package com.zohocrm.testcases;


import java.util.Hashtable;

import org.testng.annotations.Test;

import com.zohocrm.base.Page;
import com.zohocrm.pages.account.AccountsPage;
import com.zohocrm.pages.account.CreateAccountsPage;
import com.zohocrm.utilities.Utilities;

public class CreateAccountTest {
	@Test//(dataProviderClass = Utilities.class,dataProvider="dp")
  public void createAccountsTest(){//Hashtable<String,String> data) {
	 
	  AccountsPage accountsPage = Page.topMenu.goToAccounts();
	  CreateAccountsPage createAccountsPage = accountsPage.goToCreateAccounts();
	 // createAccountsPage.createAccount(data.get("accountsname"));
	    
  }
}
