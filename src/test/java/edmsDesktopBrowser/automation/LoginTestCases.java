
package edmsDesktopBrowser.automation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import BusinessFunction.DesktopBrowserLoginBusiness;
import Utility.UtilitiesWebDriver;

public class LoginTestCases {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void SetPropertyForWebDriver() throws Exception
	{
		LoginTestCases.driver = UtilitiesWebDriver.OpenBrowser(driver);
		UtilitiesWebDriver.GetApplicationURL(driver);
	}
	
	@Test
	public void LoginValidCredentials() throws InterruptedException
	{
		System.out.println("Executing Valid Credentials");
		try {
			if(DesktopBrowserLoginBusiness.LoginInApplication("kdfadmin.gen","KdfAlfoMahesh15")) {
				System.out.println("TestCase Passed");}
			}
		catch(Exception ex){
			System.out.println("Exception Caused: " + ex.getLocalizedMessage());
			Assert.fail("Failing valid Credentails");
			}
	}
	
	@Test
	public void LoginInValidUserName() throws InterruptedException
	{
		System.out.println("Executing InValid Username");
		try {
			if(DesktopBrowserLoginBusiness.LoginInApplication("AKRAM","KdfAlfoMahesh15")) {
			System.out.println("TestCase Passed");}
			}
		catch(Exception ex){
			System.out.println("Exception Caused: " + ex.getMessage());
			Assert.fail("Failing Invalid UserName");
			}
	}
	
	@Test
	public void LoginInValidPassword() throws InterruptedException
	{
		System.out.println("Executing InValid Password");
		try {
			if(DesktopBrowserLoginBusiness.LoginInApplication("kdfadmin.gen","Arbitrary")) {
				System.out.println("TestCase Passed");}	
			}
		catch(Exception ex){
			System.out.println("Exception Caused: " + ex.getMessage());
			Assert.fail("Failing Invalid Password");
			}
	}
	
	@AfterMethod
	public void TerminateDriverInstance()
	{
		
		UtilitiesWebDriver.KillDriverInstance(LoginTestCases.driver);
	}

}
