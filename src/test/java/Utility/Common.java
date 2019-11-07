package Utility;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import HelperClass.ReadPropertyFile;

public class Common{

	public static Connection connection=null; 
	public static Statement statement = null;
	public static ReadPropertyFile readPropertyFile;
	public static String sReportPath=System.getProperty("user.dir") + "\\Results\\ExecutionReport(" + DateTimeExctract() +")";
	public static String sLogPath= sReportPath + "\\Logs";
	public static String sScreenshotPath= sReportPath + "\\FailedCasesScreenshots";
	
	public static Statement ConnectToTestDataBase(Statement statement)
	{
		try{
			readPropertyFile = new ReadPropertyFile();
			Class.forName(readPropertyFile.GetDriverRegistrationMySQL().toString());
			System.out.println("\n...Test DataBase Connected...");
			connection = DriverManager.getConnection(readPropertyFile.GetDBConnectionURL(),readPropertyFile.GetUserNameDB(),readPropertyFile.GetPasswordDB());
			statement = connection.createStatement();
			return statement;
			}
		catch (Exception e) {
			System.out.println("Exception caused: " + e);
			return statement;
		 	}
	}
	
	public static void TerminateDriverInstanceDB(Statement statement1) throws SQLException
	{
	    if (statement1 != null)
	    {
	    	statement1.close();
	    }
	    
	    if (connection !=null)
	    {
	    	connection.close();
	    	System.out.println("Closed Test Data Base Connection");
	    }
	}
	
	public static void TerminateDataBaseResultSetInstance(ResultSet resultSet) throws SQLException
	{
		if (resultSet!= null)
			resultSet.close();
	}
	
	public static void CreateReportingFolders() throws IOException
	{
		File file = new File(sReportPath);
		if(file.mkdir())
		{
			System.out.println("Report Folder Created");
			file = new File(sLogPath);
			if(file.mkdir())
			{
				System.out.println("Log Folder Created");
				file = new File(sScreenshotPath);	
				file.mkdir();
			}
			else
				System.out.println("Log Folder not created");
		}
		else
			System.out.println("Report Folder not created");
	}
	
	public static String GetLogPath()
	{
		return sLogPath;
	}
	
	public static String GetScreenshotPath()
	{
		return sScreenshotPath;
	}
	
	public static String DateTimeExctract()
	{
		Date date = new Date();
		return date.toString().replace(":","-");
	}
}
