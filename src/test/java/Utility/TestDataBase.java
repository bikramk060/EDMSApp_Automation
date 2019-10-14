package Utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestDataBase extends Common{
	 

	 public static Statement statement=null;
	 public static ResultSet resultSet =null;
	 
	 
	 public static void KillMySQLDriverInstance()
	 {
		 try {
			Common.TerminateDriverInstanceDB(statement);
			Common.TerminateDataBaseResultSetInstance(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	 
	 public static void ConnectToDB()
	 {
		 statement = Common.ConnectToTestDataBase();
	 }

	public static ArrayList<String> FetchUsernameAndPassword(String testCaseName) throws SQLException
	{
		ArrayList<String> dataList = new ArrayList<String>();
		resultSet = statement.executeQuery("SELECT Username,Password FROM automationtestingdbedms.edms_login_data_table where TestCaseNumber='" + testCaseName + "'");
		while(resultSet.next())
		 {
			dataList.add(resultSet.getString("Username"));
			dataList.add(resultSet.getString("Password"));
		 }
		return dataList;
	}
	
	public static ArrayList<String> FetchSearchCustomerData(String testCaseNumber) throws SQLException 
	{
		ArrayList<String> dataList = new ArrayList<String>();
		resultSet = statement.executeQuery("SELECT SearchBy,SearchData,MiscellaneousData FROM automationtestingdbedms.edms_search_customer_data where TestCaseNumber='" + testCaseNumber + "'");
		while(resultSet.next())
		 {
			//dataList.add(resultSet.getString("SearchBy"));
			dataList.add(resultSet.getString("SearchData"));
			dataList.add(resultSet.getString("MiscellaneousData"));
		 }
		for(int i=0;i<dataList.size();i++)
		{
			System.out.println(dataList.get(i));
		}
		return dataList;
	}
	
	
}
