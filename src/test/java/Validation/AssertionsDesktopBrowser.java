package Validation;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;

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
	
	public static void AssertFail()
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
	
	
	

	
	
}
