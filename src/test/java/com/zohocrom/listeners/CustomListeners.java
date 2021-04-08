package com.zohocrom.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.zohocrm.base.Page;
import com.zohocrm.utilities.Utilities;

public class CustomListeners extends Page implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		//System.out.println(Utilities.isTestRunnable(arg0.getName(), excel));
		test=rep.startTest(arg0.getName().toUpperCase());
		/*
		 * if(!Utilities.isTestRunnable(arg0.getName(), excel)) { throw new
		 * SkipException("Skipping the test "+arg0.getName().toUpperCase()+
		 * " as the Run mode is NO");
		
		}*/
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(LogStatus.FAIL,arg0.getName().toUpperCase()+"FAILed with exception"+arg0.getThrowable());
		test.log(LogStatus.FAIL,test.addScreenCapture(Utilities.screenshotName));
		rep.endTest(test);
		rep.flush();
		/*Reporter.log("Click on screenshot");
		Reporter.log("<a target=\"_blank \" href="+TestUtil.screenshotName+">ScreenShot</a>");
		Reporter.log("<br>");
		//show image as thumnail
		Reporter.log("<a target=\"_blank \" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+">ScreenShot</img></a>");*/

		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+"><img src="+Utilities.screenshotName+" height=200 width=200></img></a>");
	}

	public void onTestSkipped(ITestResult arg0) {
		test.log(LogStatus.SKIP, arg0.getName().toUpperCase()+" as the Run mode is NO");
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		test.log(LogStatus.PASS,arg0.getName().toUpperCase()+"PASS");
		rep.endTest(test);
		rep.flush();
		
	}

}
