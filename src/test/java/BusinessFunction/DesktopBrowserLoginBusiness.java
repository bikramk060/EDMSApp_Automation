package BusinessFunction;

import PageClasses.DesktopBrowserLoginPageClass;
import Utility.UtilitiesWebDriver;
import Validation.AssertionsDesktopBrowser;
import edmsDesktopBrowser.automation.LoginTestCases;

public class DesktopBrowserLoginBusiness {
	
	public static Boolean LoginInApplication(String sUserName, String sPassword) throws InterruptedException
	{
		DesktopBrowserLoginPageClass DesktopBrowserLoginPageObj = new DesktopBrowserLoginPageClass(LoginTestCases.driver);
		if(sUserName.equalsIgnoreCase("KDFADMIN.GEN") && sPassword.equals("KdfAlfoMahesh15"))
		{
		
			DesktopBrowserLoginPageObj.SetValueForUserNameTextbox(sUserName);
			UtilitiesWebDriver.ExplicitWait(2);
			DesktopBrowserLoginPageObj.ClickOnloginButton();
			DesktopBrowserLoginPageObj.SetValueForpasswordTextbox(sPassword);
			DesktopBrowserLoginPageObj.ClickOnloginButton();
			UtilitiesWebDriver.ExplicitWait(1);
			AssertionsDesktopBrowser.ElementTextAssert(sUserName.toUpperCase(), DesktopBrowserLoginPageObj.FetchLoggedUserName() );
			return true;
		}
		
		else if (!sUserName.equalsIgnoreCase("KDFADMIN.GEN") && sPassword.equals("KdfAlfoMahesh15"))
		{
			DesktopBrowserLoginPageObj.SetValueForUserNameTextbox(sUserName);
			UtilitiesWebDriver.ExplicitWait(2);
			DesktopBrowserLoginPageObj.ClickOnloginButton();
			AssertionsDesktopBrowser.ElementTextAssert("We couldn't find that. Try again.", DesktopBrowserLoginPageObj.FetchInvalidUserErrorMessage());
			return true;
		}
		
		else if(sUserName.equalsIgnoreCase("KDFADMIN.GEN") && !sPassword.equals("KdfAlfoMahesh15"))
		{
			DesktopBrowserLoginPageObj.SetValueForUserNameTextbox(sUserName);
			UtilitiesWebDriver.ExplicitWait(1);
			DesktopBrowserLoginPageObj.ClickOnloginButton();
			UtilitiesWebDriver.ExplicitWait(2);
			DesktopBrowserLoginPageObj.SetValueForpasswordTextbox(sPassword);
			DesktopBrowserLoginPageObj.ClickOnloginButton();
			AssertionsDesktopBrowser.ElementTextAssert("That login didn't work:", DesktopBrowserLoginPageObj.FetchInvalidPasswordErrorMessage());
			return true;
		}
		return false;
	}	

}
