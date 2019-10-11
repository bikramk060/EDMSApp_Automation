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
import Utility.TestDataBase;
import Utility.UtilitiesWebDriver;

public class SearchTestCases{

	public static WebDriver driver;
	public static Statement statement;
	public static String partyID = null;
	public static String accountName = null;
	public static String businessEntityID = null;
	public static String customerAccountNumber = null;
	public static String priceLists = null;
	public static String endCustomerCountry = null;
	public static String intendedUse = null;
	public static String multipleProductSku = null;
	public static String[] testID=null;
	ArrayList<String> CredentialData = new ArrayList<String>();
	
	public void SetTestDataValue(ArrayList<String> dbFetchedTestData)
	{
	
			String[] miscellaneousData=null;
			System.out.println("DB Fetched Data: " + dbFetchedTestData.get(1));
			System.out.println();
			miscellaneousData = dbFetchedTestData.get(1).toString().split("\\||");
			partyID = dbFetchedTestData.get(0);
			accountName = dbFetchedTestData.get(0);
			businessEntityID = dbFetchedTestData.get(0);
			customerAccountNumber = dbFetchedTestData.get(0);
			priceLists = miscellaneousData[0];
			endCustomerCountry = miscellaneousData[1];
			intendedUse = miscellaneousData[2];
			multipleProductSku = miscellaneousData[3];
	}
	
	@BeforeClass
	public void DataSetup()
	{
		TestDataBase.ConnectToDB();
	}
	
	@BeforeMethod
	public void SetPropertyForWebDriver(ITestResult result) throws Exception
	{	
		//SearchTestCases.driver = UtilitiesWebDriver.OpenBrowser(driver);
		//UtilitiesWebDriver.GetApplicationURL(driver);
		//LoginTestCases.driver = SearchTestCases.driver;
		testID = result.getMethod().getDescription().trim().split(":");
		System.out.println("TestID: " + testID[0]);
		CredentialData = TestDataBase.FetchSearchCustomerData(testID[0]);
		SetTestDataValue(CredentialData);
	}
	
	//@Test(testName ="TC008", description="TC008: Search Customer by Party ID")
	public void SearchCustomerPartyID()
	{
		//test1 editing it again
		System.out.println(partyID);
		System.out.println(accountName);
		System.out.println(businessEntityID);
		System.out.println(customerAccountNumber);
		System.out.println(endCustomerCountry);
		System.out.println(intendedUse);
		System.out.println(multipleProductSku);
		System.out.println(priceLists);

//		try {
//			if(DesktopBrowserLoginBusiness.LoginInApplication()) 
//			{
//				if(SearchBusinessDesktopBrowser.SearchCustomerDetails(Utility.Enums.SearchCustomers.PARTY_ID, CredentialData.get(2))) 
//				{
//					System.out.println("TestCase Passed");
//				}
//			}
//		}
//		catch(Exception ex){
// 			System.out.println("Exception Caused: " + ex.getLocalizedMessage());
// 			Validation.AssertionsDesktopBrowser.AssertFailMessage("Exception Caused: " + ex.getLocalizedMessage());
//			}
	}
	
	@Test(testName ="TC009", description="TC009: Search Customer by Account Number")
	public void SearchCustomerAccountNumber()
	{
		System.out.println("partyid: " + partyID);
		System.out.println("accountname: " + accountName);
		System.out.println("businessID: " + businessEntityID);
		System.out.println("CustAccount number: " + customerAccountNumber);
		System.out.println("PriceList: " + priceLists);
		System.out.println("EndCustomerCountry: " + endCustomerCountry);
		System.out.println("Intended USe: " + intendedUse);
		System.out.println("Multiple prodsku: " + multipleProductSku);
	}
	
	
	@AfterMethod
	public void TerminateDriverInstance()
	{
		//UtilitiesWebDriver.KillDriverInstance(SearchTestCases.driver);	
	}
	
	@AfterClass
	public void DataCleanUp()
	{
		TestDataBase.KillDriverInstanceMySQL();
	}

}
