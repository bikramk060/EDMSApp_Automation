package BusinessFunctionDesktopBrowser;

import PageClassDesktopBrowser.SearchPageClass;
import TestCaseDesktopBrowser.automation.SearchTestCases;
import Utility.ReadPropertyFile;
import Utility.UtilitiesWebDriver;
import Validation.AssertionsDesktopBrowser;


public class SearchBusinessDesktopBrowser {
	
	public static ReadPropertyFile readPropertyFileObject; 
	
	public static boolean SearchCustomerDetails(Utility.Enums.SearchCustomers searchType, String searchData ) throws InterruptedException 
	{
		boolean status=false;
		SearchPageClass SearchCustomerPageClassObj = new SearchPageClass(SearchTestCases.driver);
		UtilitiesWebDriver.ExplicitWait(1);
		SearchCustomerPageClassObj.ClickOnSearchTabOnHomePage();
		UtilitiesWebDriver.ExplicitWait(2);
		SearchCustomerPageClassObj.SelectCustomerSearchBy(searchType);
		UtilitiesWebDriver.ExplicitWait(1);
		switch (searchType) {
		case PARTY_ID:
			SearchCustomerPageClassObj.SetValueSearchTextbox(searchData);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.ClickOnSearchButton();
			UtilitiesWebDriver.ExplicitWait(3);
			if(SearchCustomerPageClassObj.SearchGridValueExist(searchData))
				status=true;
			break;
		case ACCOUNT_NAME:
			SearchCustomerPageClassObj.SetValueSearchTextbox(searchData);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.ClickOnSearchButton();
			status=true;
			break;
		case BUSINESS_ENTITY_ID:
			SearchCustomerPageClassObj.SetValueSearchTextbox(searchData);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.ClickOnSearchButton();
			status=true;
			break;
		case CUSTOMER_ACCOUNT_NUMBER:
			SearchCustomerPageClassObj.SetValueSearchTextbox(searchData);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.ClickOnSearchButton();
			status=true;
			break;
		case BEGEO_ID:
			SearchCustomerPageClassObj.SetValueSearchTextbox(searchData);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.ClickOnSearchButton();
			status=true;
			break;
		default:
			AssertionsDesktopBrowser.AssertFailMessage("INVALID SEARCH BY SELECTED");
			break;
		}	
		return status;
	}
	
	
	
	
}
