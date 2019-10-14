package Utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import HelperClass.ReadPropertyFile;

public class Common{

	public static Connection connection=null; 
	public static Statement statement = null;
	static ReadPropertyFile readPropertyFile;
	public static Statement ConnectToTestDataBase()
	{
		try{
			readPropertyFile = new ReadPropertyFile();
			
			 Class.forName(readPropertyFile.GetDriverRegistrationJDBC().toString());
			 System.out.println("\n...Test DataBase Connected...");
			 connection = DriverManager.getConnection(readPropertyFile.GetDBConnectionURL().toString(),readPropertyFile.GetUserNameDB().toString(),readPropertyFile.GetPasswordDB().toString());
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
	    	statement1.close();
	    
	    if (Common.connection !=null)
	    	{
	    	Common.connection.close();
	    	System.out.println("Closed Connection");
	    	}
	}
	
	public static void TerminateDataBaseResultSetInstance(ResultSet resultSet) throws SQLException
	{
		if (resultSet!= null)
			resultSet.close();
	}
}
