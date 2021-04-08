package com.zohocrm.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
//code for extend report
public class ExtentManagerReport {
	private static ExtentReports extent;
	public static ExtentReports getInstance(){
		if(extent==null){
			extent=new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extents.html",true,DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
		}
		return extent;
	}

}
