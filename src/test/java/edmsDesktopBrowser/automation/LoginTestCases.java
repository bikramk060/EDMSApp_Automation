
package edmsDesktopBrowser.automation;



import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BusinessFunction.DesktopBrowserLoginBusiness;
import Utility.TestDataBase;
import Utility.UtilitiesWebDriver;

public class LoginTestCases{

	public static WebDriver driver;
	ArrayList<String> CredentialData = new ArrayList<String>();
	
	@BeforeMethod
	public void SetPropertyForWebDriver() throws Exception
	{
		LoginTestCases.driver = UtilitiesWebDriver.OpenBrowser(driver);
		UtilitiesWebDriver.GetApplicationURL(driver);
	}
	
	@Test(testName="TC001", description="Login with valid Username and password")
	public void LoginValidCredentials()
	{
		try {
			CredentialData = TestDataBase.FetchUsernameAndPassword("TC001");
			if(DesktopBrowserLoginBusiness.LoginInApplication(CredentialData.get(0).toString(),CredentialData.get(1).toString())) {
				System.out.println("TestCase Passed");}
		}
		catch(Exception ex){
 			System.out.println("Exception Caused: " + ex.getLocalizedMessage());
			Assert.fail("Exception Caused: " + ex.getLocalizedMessage());
			}
	}
	
	//@Test(testName="TC002", description="Login with Invalid Username")
	public void LoginInValidUserName()
	{
		System.out.println("Executing InValid Username");
		try {
			if(DesktopBrowserLoginBusiness.LoginInApplication("AKRAM","KdfAlfoMahesh15")) {
			System.out.println("TestCase Passed");}
			}
		catch(Exception ex){
			System.out.println("Exception Caused: " + ex.getLocalizedMessage());
			Assert.fail("Failing Invalid UserName");
			}
	}
	
	//@Test(testName="TC003", description="Login with valid Username but invalid password")
	public void LoginInValidPassword()
	{
		System.out.println("Executing InValid Password");
		try {
			if(DesktopBrowserLoginBusiness.LoginInApplication("kdfadmin.gen","Arbitrary")) {
				System.out.println("TestCase Passed");}	
			}
		catch(Exception ex){
			System.out.println("Exception Caused: " + ex.getLocalizedMessage());
			Assert.fail("Failing Invalid Password");
			}
	}

	
	@AfterMethod
	public void TerminateDriverInstance()
	{
		UtilitiesWebDriver.KillDriverInstance(LoginTestCases.driver);
		TestDataBase.KillDriverInstanceMySQL();
	}

}
