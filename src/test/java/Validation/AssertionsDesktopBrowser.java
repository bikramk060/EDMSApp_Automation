package Validation;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertionsDesktopBrowser {

	public static void ElementTextAssert(String expectedText, String actualText)
	{
		Assert.assertEquals(actualText, expectedText);
	}
	
	

	
	
}
