/*------------------Script Author: Akash Mukhopadhyay--------------------*/
package edmsDesktopBrowser.automation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import BusinessFunction.DesktopBrowserLoginBusiness;
import Utility.UtilitiesWebDriver;

public class LoginTestCases {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void SetPropertyForWebDriver() throws Exception
	{
		LoginTestCases.driver = UtilitiesWebDriver.OpenBrowser("CHROME", driver);
		UtilitiesWebDriver.GetApplicationURL(driver);
	}
	
	@Test
	public void LoginValidCredentials() throws InterruptedException
	{
		try {
			if(DesktopBrowserLoginBusiness.LoginInApplication("kdfadmin.gen","KdfAlfoMahesh15")) {
				System.out.println("TestCase Passed");}
			}
		catch(Exception ex){
			System.out.println("Exception Caused: " + ex);
			}
	}
	
	@Test
	public void LoginInValidUserName() throws InterruptedException
	{
		try {
			if(DesktopBrowserLoginBusiness.LoginInApplication("AKRAM","KdfAlfoMahesh15")) {
			System.out.println("TestCase Passed");}
			}
		catch(Exception ex){
			System.out.println("Exception Caused: " + ex);
			}
	}
	
	@Test
	public void LoginInValidPassword() throws InterruptedException
	{
		try {
			if(DesktopBrowserLoginBusiness.LoginInApplication("kdfadmin.gen","Arbitrary")) {
				System.out.println("TestCase Passed");}	
			}
		catch(Exception ex){
			System.out.println("Exception Caused: " + ex);
			}
	}
	
	@AfterTest
	public void TerminateDriverInstance()
	{
		UtilitiesWebDriver.KillDriverInstance(LoginTestCases.driver);
	}

}
