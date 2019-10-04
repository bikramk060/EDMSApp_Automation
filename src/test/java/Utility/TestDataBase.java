package Utility;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestDataBase extends Common{
	 

	 public static Statement statement=null;
	 public static ResultSet resultSet =null;
	 
	 
	 public static void KillDriverInstanceMySQL()
	 {
		 try {
			Common.TerminateDriverInstanceDB(statement);
			Common.TerminateDataBaseResultSetInstance(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }

	public static ArrayList<String> FetchUsernameAndPassword(String testCaseName) throws SQLException
	{
		ArrayList<String> dataList = new ArrayList<String>();
		try {
			statement = Common.ConnectToTestDataBase();
			resultSet = statement.executeQuery("SELECT Username,Password FROM automationtestingdbedms.edms_login_data_table where TestCaseNumber='" + testCaseName + "'");
			while(resultSet.next())
			 {
				
				System.out.println(resultSet.getString("Password"));
				dataList.add(resultSet.getString("Username"));
				dataList.add(resultSet.getString("Password"));
			 }
			return dataList;
			}
		catch (Exception ex)
		{
			System.out.println("Exception: " + ex);
			return dataList;
		}
	}
	
	/*
	public static String[] FetchSearchCustomerData(String testCaseName) throws SQLException
	{		
			resultSet = statement.executeQuery("SELECT Username,Password FROM automationtestingdbedms.edms_login_data_table where TestCaseNumber='" + testCaseName + "'");
			while(resultSet.next())
			 {
				 data[0] = resultSet.getString("Username");
				 data[1] = resultSet.getString("Password");
			 }
			return data;
	}
	*/

	

}
