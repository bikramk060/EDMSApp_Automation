package HelperClass;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SmartReporter {

	public static ExtentHtmlReporter report=null; 
	public static ExtentReports extent=null;
	public static ExtentTest logger=null;
	
	
	
	public static void ExtentReportHTML(String testDescription)
	{
		report=new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Resources\\BufferLogs\\ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(report);
		System.out.println("Smart LOgger, Create testReport (1)"+extent.toString());
		logger= extent.createTest(testDescription);
		System.out.println("Smart LOgger, Create testLogger (1)"+logger.toString());
	}
	
	public static void ExtentReportPrintInfo(String sMessage)
	{
		System.out.println("Logger (info): "+ logger);
		logger.log(Status.INFO, sMessage);
	}
	
	public static void ExtentReportPrintDebug(String sMessage)
	{
		logger.log(Status.DEBUG, sMessage);
	}
	
	public static void ExtentReportPrintError(String sMessage)
	{
		logger.log(Status.ERROR, sMessage);
	}
	
	public static void ExtentReportFlush()
	{
		extent.flush();
	}
	
}
