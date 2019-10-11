package BusinessFunctionDesktopBrowser;

import java.io.IOException;

import PageClassDesktopBrowser.DesktopBrowserLoginPageClass;
import TestCaseDesktopBrowser.automation.LoginTestCases;
import Utility.ReadPropertyFile;
import Utility.UtilitiesWebDriver;
import Validation.AssertionsDesktopBrowser;

public class DesktopBrowserLoginBusiness {
	
	
	public static Boolean LoginInApplication(String sUserName, String sPassword) throws InterruptedException
	{
		DesktopBrowserLoginPageClass DesktopBrowserLoginPageObj = new DesktopBrowserLoginPageClass(LoginTestCases.driver);
		if(sUserName.equalsIgnoreCase("KDFADMIN.GEN") && sPassword.equals("KdfAlfoMahesh15"))
		{
		
			DesktopBrowserLoginPageObj.SetValueForUserNameTextbox(sUserName);
			UtilitiesWebDriver.ExplicitWait(2);
			DesktopBrowserLoginPageObj.ClickOnloginButton();
			UtilitiesWebDriver.ExplicitWait(5);
			DesktopBrowserLoginPageObj.SetValueForpasswordTextbox(sPassword);
			UtilitiesWebDriver.ExplicitWait(5);
			DesktopBrowserLoginPageObj.ClickOnloginButton();
			UtilitiesWebDriver.ExplicitWait(5);
			System.out.println("Actual value: "+ DesktopBrowserLoginPageObj.FetchLoggedUserName());
			AssertionsDesktopBrowser.ElementTextAssert(sUserName.toUpperCase(), DesktopBrowserLoginPageObj.FetchLoggedUserName() );
			return true;
		}
		
		else if (!sUserName.equalsIgnoreCase("KDFADMIN.GEN") && sPassword.equals("KdfAlfoMahesh15"))
		{
			DesktopBrowserLoginPageObj.SetValueForUserNameTextbox(sUserName);
			UtilitiesWebDriver.ExplicitWait(4);
			DesktopBrowserLoginPageObj.ClickOnloginButton();
			UtilitiesWebDriver.ExplicitWait(4);
			if(AssertionsDesktopBrowser.ElementTextAssert("We couldn't find that. Try again.", DesktopBrowserLoginPageObj.FetchInvalidUserErrorMessage()))
				return true;
			else 
				return false;
		}
		
		else if(sUserName.equalsIgnoreCase("KDFADMIN.GEN") && !sPassword.equals("KdfAlfoMahesh15"))
		{
			DesktopBrowserLoginPageObj.SetValueForUserNameTextbox(sUserName);
			UtilitiesWebDriver.ExplicitWait(4);
			DesktopBrowserLoginPageObj.ClickOnloginButton();
			UtilitiesWebDriver.ExplicitWait(4);
			DesktopBrowserLoginPageObj.SetValueForpasswordTextbox(sPassword);
			UtilitiesWebDriver.ExplicitWait(4);
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
		ReadPropertyFile readPropertyFile = new ReadPropertyFile();
		DesktopBrowserLoginPageClass DesktopBrowserLoginPageObj = new DesktopBrowserLoginPageClass(LoginTestCases.driver);
			DesktopBrowserLoginPageObj.SetValueForUserNameTextbox(readPropertyFile.GetBrowserLoginValidUserName());
			UtilitiesWebDriver.ExplicitWait(2);
			DesktopBrowserLoginPageObj.ClickOnloginButton();
			UtilitiesWebDriver.ExplicitWait(5);
			DesktopBrowserLoginPageObj.SetValueForpasswordTextbox(readPropertyFile.GetBrowserLoginValidPassword());
			UtilitiesWebDriver.ExplicitWait(5);
			DesktopBrowserLoginPageObj.ClickOnloginButton();
			UtilitiesWebDriver.ExplicitWait(4);
			System.out.println("Actual value: "+ DesktopBrowserLoginPageObj.FetchLoggedUserName());
			if(AssertionsDesktopBrowser.ElementTextAssert(readPropertyFile.GetBrowserLoginValidUserName().toUpperCase(), DesktopBrowserLoginPageObj.FetchLoggedUserName()))
				return true;
			else
				return false;
	}

}
