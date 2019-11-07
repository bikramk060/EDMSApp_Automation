package Validation;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.Assert;

import Utility.UtilitiesWebDriver;

public class AssertionsDesktopBrowser {

	
	public static boolean ElementTextAssert(String expectedText, String actualText, String errorMessage)
	{
		
		if(expectedText.equalsIgnoreCase(actualText))
		{
			System.out.println("String Matched");
			return true;
		}
		else
		{
			System.out.println(errorMessage);
			return false;
		}
	}
	
	public static boolean ElementTextAssert(String expectedText, String actualText)
	{
		
		if(expectedText.equalsIgnoreCase(actualText))
		{
			System.out.println("String Matched");
			return true;
		}
		else
		{
			System.out.println("String Mismatched");
			return false;
		}
			
		
	}
	
	public static void AssertFail() throws IOException
	{
		Assert.fail();
	}
	
	public static void AssertFailMessage(String message)
	{
		Assert.fail(message);
	}
	
	public static void AssertBoolean(boolean statusActual, boolean statusExpected)
	{
		Assert.assertEquals(statusActual, statusExpected);
	}
	
	public static void AssertTrue(boolean condition)
	{
		Assert.assertTrue(condition);
	}
	
	public static boolean AssertValueFromArrayStringList(ArrayList<String> sDataList, String sSearchData)
	{
		if (sDataList.contains(sSearchData))
			return true;
		else
			return false;
	}
	
	/**
	 * Compare and Asserts the UI results and MasterData from Master data Base
	 * @param sMasterDBdata holds the List of data in String type, which is fetched from Master databse
	 * @param sResultUIdata holds the List of Data in String type, which is fetched from UI
	 * @return boolean if all values fetched from UI matches with Back end data
	 */
	public static boolean AssertValueFromMasterDataBase(ArrayList<String> sMasterDBdata, ArrayList<String> sResultUIdata, String sErrorMessage)
	{
		int iAssertCount=0;
		for(int i=0;i<sResultUIdata.size();i++)
		{
			if(sMasterDBdata.contains(sResultUIdata.get(i)) && sResultUIdata.get(i)!=null)
				iAssertCount++;
		}
		if(iAssertCount==sMasterDBdata.size())
			return true;
		else
		{
			System.out.println(sErrorMessage);
			return false;
		}	
	}
}
