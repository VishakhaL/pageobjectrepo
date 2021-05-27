package com.zohocrm.pages.login;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.zohocrm.base.Page;

public class CRMDashboardPage extends Page {
	
	public void verifyTitle() {
		
		Assert.assertEquals(driver.getTitle(),"Home Page - Zoho CRM","Title not matched");
	}

}
