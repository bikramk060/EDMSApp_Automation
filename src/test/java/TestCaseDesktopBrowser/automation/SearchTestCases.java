package TestCaseDesktopBrowser.automation;

import java.sql.Statement;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BusinessFunctionDesktopBrowser.DesktopBrowserLoginBusiness;
import BusinessFunctionDesktopBrowser.SearchBusinessDesktopBrowser;
import Utility.TestDataBase;
import Utility.UtilitiesWebDriver;

public class SearchTestCases{

	public static WebDriver driver;
	public static Statement statement;
	public static String sPartyID = null;
	public static String sAccountName = null;
	public static String sBusinessEntityID = null;
	public static String sCustomerAccountNumber = null;
	public static String sPriceLists = null;
	public static String sEndCustomerCountry = null;
	public static String sIntendedUse = null;
	public static String sMultipleProductSku = null;
	public static String[] sTestID=null;
	ArrayList<String> CredentialData = new ArrayList<String>();
	
	public void SetTestDataValue(ArrayList<String> dbFetchedTestData)
	{
		String[] miscellaneousData=null;
		if(dbFetchedTestData.get(1)!=null)
		{
			miscellaneousData = dbFetchedTestData.get(1).toString().split("\\|");
			sPartyID = dbFetchedTestData.get(0);
			sAccountName = dbFetchedTestData.get(0);
			sBusinessEntityID = dbFetchedTestData.get(0);
			sCustomerAccountNumber = dbFetchedTestData.get(0);
			sPriceLists = miscellaneousData[0];
			sEndCustomerCountry = miscellaneousData[1];
			sIntendedUse = miscellaneousData[2];
			sMultipleProductSku = miscellaneousData[3];
		}
		else
		{
			sPartyID = dbFetchedTestData.get(0);
			sAccountName = dbFetchedTestData.get(0);
			sBusinessEntityID = dbFetchedTestData.get(0);
			sCustomerAccountNumber = dbFetchedTestData.get(0);
		}
			
	}
	
	@BeforeClass
	public void DataSetup()
	{
		TestDataBase.ConnectToDB();
	}
	
	@BeforeMethod
	public void SetPropertyForWebDriver(ITestResult result) throws Exception
	{	
		String description = result.getMethod().getDescription();
		SearchTestCases.driver = UtilitiesWebDriver.OpenBrowser(driver);
		LoginTestCases.driver = SearchTestCases.driver;
		UtilitiesWebDriver.GetApplicationURL(SearchTestCases.driver);
		sTestID = description.trim().split(":");
		CredentialData = TestDataBase.FetchSearchCustomerData(sTestID[0]);
		SetTestDataValue(CredentialData);
	}
	
	@Test(testName ="TC008", description="TC008: Search Customer by Party ID")
	public void SearchCustomerPartyID()
	{
		try {
			if(DesktopBrowserLoginBusiness.LoginInApplication()) 
			{
				if(SearchBusinessDesktopBrowser.SearchCustomerDetails(Utility.Enums.SearchCustomers.PARTY_ID, sPartyID, sPriceLists, sEndCustomerCountry, sIntendedUse, sMultipleProductSku)) 
				{
					System.out.println("TestCase Passed");
				}
			}
		}
		catch(Exception ex){
 			System.out.println("Exception Caused: " + ex.getLocalizedMessage());
 			Validation.AssertionsDesktopBrowser.AssertFailMessage("Exception Caused: " + ex.getLocalizedMessage());
			}
	}
	
	@Test(testName ="TC009", description="TC009: Search Customer by Account Number")
	public void SearchCustomerAccountNumber()
	{

		try {
			if(DesktopBrowserLoginBusiness.LoginInApplication()) 
			{
				if(SearchBusinessDesktopBrowser.SearchCustomerDetails(Utility.Enums.SearchCustomers.CUSTOMER_ACCOUNT_NUMBER, sCustomerAccountNumber, sPriceLists, sEndCustomerCountry, sIntendedUse, sMultipleProductSku)) 
				{
					System.out.println("TestCase Passed");
				}
			}
		}
		catch(Exception ex){
 			System.out.println("Exception Caused: " + ex.getLocalizedMessage());
 			Validation.AssertionsDesktopBrowser.AssertFailMessage("Exception Caused: " + ex.getLocalizedMessage());
			}
	}
	
	@Test(testName ="TC010", description="TC010: Search Customer by Business Entity ID (BE ID)")
	public void SearchCustomerBusinessEntityID()
	{

		try {
			if(DesktopBrowserLoginBusiness.LoginInApplication()) 
			{
				if(SearchBusinessDesktopBrowser.SearchCustomerDetails(Utility.Enums.SearchCustomers.BUSINESS_ENTITY_ID, sBusinessEntityID, sPriceLists, sEndCustomerCountry, sIntendedUse, sMultipleProductSku)) 
				{
					System.out.println("TestCase Passed");
				}
			}
		}
		catch(Exception ex){
 			System.out.println("Exception Caused: " + ex.getLocalizedMessage());
 			Validation.AssertionsDesktopBrowser.AssertFailMessage("Exception Caused: " + ex.getLocalizedMessage());
			}
	}
	
	@Test(testName ="TC011", description="TC011: Search Customer by Account Name")
	public void SearchCustomerAccountName()
	{

		try {
			if(DesktopBrowserLoginBusiness.LoginInApplication()) 
			{
				if(SearchBusinessDesktopBrowser.SearchCustomerDetails(Utility.Enums.SearchCustomers.ACCOUNT_NAME, sAccountName, sPriceLists, sEndCustomerCountry, sIntendedUse, sMultipleProductSku)) 
				{
					System.out.println("TestCase Passed");
				}
			}
		}
		catch(Exception ex){
 			System.out.println("Exception Caused: " + ex.getLocalizedMessage());
 			Validation.AssertionsDesktopBrowser.AssertFailMessage("Exception Caused: " + ex.getLocalizedMessage());
			}
	}
	
	
	@AfterMethod
	public void TerminateDriverInstance()
	{
		UtilitiesWebDriver.KillWebDriverInstance(SearchTestCases.driver);	
	}
	
	@AfterClass
	public void DataCleanUp()
	{
		TestDataBase.KillMySQLDriverInstance();
	}

}
