package HelperClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import Utility.Common;

public class SmartLogger {

	public static Logger logger;
	public static String logDefaultPath=null;
	public static String logDestinationPath=null;
	public static String logHTMLdefaultPath=null;
	public static String logHTMLdestinationPath=null;
	public static String extentLogHTMLdefaultPath=null;
	public static FileInputStream propertyFile;
	public static Properties prop = new Properties();
	public SmartLogger()
	{
		logger = Logger.getLogger(SmartLogger.class);
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\Resources\\ConfigurationalFiles\\log4j.properties");
		
	}

	public void PrintInfo(String sMessage)
	{
		logger.info(sMessage);
		SmartReporter.ExtentReportPrintInfo(sMessage);
	}
	
	public void PrintDebug(String sMessage)
	{
		logger.debug(sMessage);
		SmartReporter.ExtentReportPrintDebug(sMessage);
	}
	
	public void PrintError(String sMessage)
	{
		logger.error(sMessage);
		SmartReporter.ExtentReportPrintError(sMessage);
	}
	
	public static void MoveLogsToDestination() throws IOException
	{
		logDefaultPath = System.getProperty("user.dir") + "\\Resources\\BufferLogs\\Execution.log";
		logDestinationPath=Common.GetLogPath() + "\\Execution.log";
		logHTMLdefaultPath = System.getProperty("user.dir") + "\\Resources\\BufferLogs\\ExecutionLog.html";
		logHTMLdestinationPath=Common.GetLogPath() + "\\ExecutionLog.html";
		File srcLogFile = new File(logDefaultPath);
		File destLogFile = new File(logDestinationPath);
		File srcHTMLlogFile = new File(logHTMLdefaultPath);
		File destHTMLlogFile = new File(logHTMLdestinationPath);
		Files.copy(srcLogFile.toPath(), destLogFile.toPath());
		Files.copy(srcHTMLlogFile.toPath(), destHTMLlogFile.toPath());
		
	}
	
	public static void ClearExecutionLogsAndReports() throws IOException, InterruptedException
	{
		logDefaultPath = System.getProperty("user.dir") + "\\Resources\\BufferLogs\\Execution.log";
		logHTMLdefaultPath = System.getProperty("user.dir") + "\\Resources\\BufferLogs\\ExecutionLog.html";
		extentLogHTMLdefaultPath = System.getProperty("user.dir") + "\\Resources\\BufferLogs\\ExtentReport.html";
		FileWriter fileWriterObj = new FileWriter(logHTMLdefaultPath);
		PrintWriter printWriterObj = new PrintWriter(fileWriterObj);
		printWriterObj.write("");
		printWriterObj.flush(); 
		printWriterObj.close();
		FileWriter fileWriter = new FileWriter(logDefaultPath);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.write("");
		printWriter.flush(); 
		printWriter.close();
		FileWriter logFileWriter = new FileWriter(extentLogHTMLdefaultPath);
		PrintWriter logPrintWriter = new PrintWriter(logFileWriter);
		logPrintWriter.write("");
		logPrintWriter.flush(); 
		logPrintWriter.close();
	}
	

}
