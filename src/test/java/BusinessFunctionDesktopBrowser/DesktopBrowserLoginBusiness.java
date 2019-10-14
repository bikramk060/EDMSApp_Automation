package BusinessFunctionDesktopBrowser;

import java.io.IOException;

import HelperClass.ReadPropertyFile;
import PageClassDesktopBrowser.DesktopBrowserLoginPageClass;
import TestCaseDesktopBrowser.automation.LoginTestCases;
import Utility.UtilitiesWebDriver;
import Validation.AssertionsDesktopBrowser;

public class DesktopBrowserLoginBusiness {

	public static ReadPropertyFile readProprtyFile;
	public static Boolean LoginInApplication(String sUserName, String sPassword) throws InterruptedException, IOException
	{
		readProprtyFile=new ReadPropertyFile();
		DesktopBrowserLoginPageClass DesktopBrowserLoginPageObj = new DesktopBrowserLoginPageClass(LoginTestCases.driver);
		if(sUserName.equalsIgnoreCase(readProprtyFile.GetBrowserLoginValidUserName()) && sPassword.equals(readProprtyFile.GetBrowserLoginValidPassword()))
		{
			DesktopBrowserLoginPageObj.SetValueForUserNameTextbox(sUserName);
			UtilitiesWebDriver.ExplicitWait(2);
			DesktopBrowserLoginPageObj.ClickOnloginButton();
			UtilitiesWebDriver.ExplicitWait(2);
			DesktopBrowserLoginPageObj.SetValueForpasswordTextbox(sPassword);
			UtilitiesWebDriver.ExplicitWait(2);
			DesktopBrowserLoginPageObj.ClickOnloginButton();
			UtilitiesWebDriver.ExplicitWait(2);
			System.out.println("Actual value: "+ DesktopBrowserLoginPageObj.FetchLoggedUserName());
			AssertionsDesktopBrowser.ElementTextAssert(sUserName.toUpperCase(), DesktopBrowserLoginPageObj.FetchLoggedUserName() );
			return true;
		}
		
		else if (!sUserName.equalsIgnoreCase(readProprtyFile.GetBrowserLoginValidUserName()) && sPassword.equals(readProprtyFile.GetBrowserLoginValidPassword()))
		{
			DesktopBrowserLoginPageObj.SetValueForUserNameTextbox(sUserName);
			UtilitiesWebDriver.ExplicitWait(2);
			DesktopBrowserLoginPageObj.ClickOnloginButton();
			UtilitiesWebDriver.ExplicitWait(2);
			if(AssertionsDesktopBrowser.ElementTextAssert("We couldn't find that. Try again.", DesktopBrowserLoginPageObj.FetchInvalidUserErrorMessage()))
				return true;
			else 
				return false;
		}
		
		else if(sUserName.equalsIgnoreCase(readProprtyFile.GetBrowserLoginValidUserName()) && !sPassword.equals(readProprtyFile.GetBrowserLoginValidPassword()))
		{
			DesktopBrowserLoginPageObj.SetValueForUserNameTextbox(sUserName);
			UtilitiesWebDriver.ExplicitWait(2);
			DesktopBrowserLoginPageObj.ClickOnloginButton();
			UtilitiesWebDriver.ExplicitWait(2);
			DesktopBrowserLoginPageObj.SetValueForpasswordTextbox(sPassword);
			UtilitiesWebDriver.ExplicitWait(2);
			DesktopBrowserLoginPageObj.ClickOnloginButton();
			if(AssertionsDesktopBrowser.ElementTextAssert("That login didn't work:", DesktopBrowserLoginPageObj.FetchInvalidPasswordErrorMessage()))
				return true;
			else
				return false;
		}
		return false;
	}	
	
	public static Boolean LoginInApplication() throws InterruptedException, IOException
	{
		readProprtyFile = new ReadPropertyFile();
		DesktopBrowserLoginPageClass DesktopBrowserLoginPageObj = new DesktopBrowserLoginPageClass(LoginTestCases.driver);
		DesktopBrowserLoginPageObj.SetValueForUserNameTextbox(readProprtyFile.GetBrowserLoginValidUserName());
		UtilitiesWebDriver.ExplicitWait(2);
		DesktopBrowserLoginPageObj.ClickOnloginButton();
		UtilitiesWebDriver.ExplicitWait(2);
		DesktopBrowserLoginPageObj.SetValueForpasswordTextbox(readProprtyFile.GetBrowserLoginValidPassword());
		UtilitiesWebDriver.ExplicitWait(2);
		DesktopBrowserLoginPageObj.ClickOnloginButton();
		UtilitiesWebDriver.ExplicitWait(3);
		System.out.println("Actual value: "+ DesktopBrowserLoginPageObj.FetchLoggedUserName());
		if(AssertionsDesktopBrowser.ElementTextAssert(readProprtyFile.GetBrowserLoginValidUserName().toUpperCase(), DesktopBrowserLoginPageObj.FetchLoggedUserName()))
			return true;
		else
			return false;
	}

}
