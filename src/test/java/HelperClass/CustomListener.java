package HelperClass;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Utility.Common;
import Utility.UtilitiesWebDriver;

public class CustomListener implements ITestListener{

	
	public void onTestStart(ITestResult result) {
		
		SmartReporter.ExtentReportHTML(result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		SmartReporter.ExtentReportFlush();
	}

	public void onTestFailure(ITestResult result) {
		String[] testID=null;
		String description = result.getMethod().getDescription();
		testID = description.trim().split(":");
		try {
			UtilitiesWebDriver.TakeScreenshot(testID[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SmartReporter.ExtentReportFlush();
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {

		try {
			SmartLogger.ClearExecutionLogsAndReports();
			SmartReporter.ExtentReportHTML("Initiating TestBase");
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			Common.CreateReportingFolders();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void onFinish(ITestContext context) {
		
		try {
			
			SmartLogger.MoveLogsToDestination();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//write your testngfailed.xml code here
	}

	

	

}
