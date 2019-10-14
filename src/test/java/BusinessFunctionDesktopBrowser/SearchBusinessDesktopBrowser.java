package BusinessFunctionDesktopBrowser;

import java.util.ArrayList;

import PageClassDesktopBrowser.SearchPageClass;
import TestCaseDesktopBrowser.automation.SearchTestCases;
import Utility.ReadPropertyFile;
import Utility.UtilitiesWebDriver;
import Validation.AssertionsDesktopBrowser;


public class SearchBusinessDesktopBrowser {
	
	public static ReadPropertyFile readPropertyFileObject; 
	public static boolean SearchCustomerDetails(Utility.Enums.SearchCustomers searchType, String sSearchData, String priceList, String endCustomerCountry, String intendedUse, String multipleProductSku ) throws InterruptedException 
	{
		boolean status=false;
		SearchPageClass SearchCustomerPageClassObj = new SearchPageClass(SearchTestCases.driver);
		ArrayList<String> sResultData = new ArrayList<String>();
		UtilitiesWebDriver.ExplicitWait(1);
		SearchCustomerPageClassObj.ClickOnSearchTabOnHomePage();
		UtilitiesWebDriver.ExplicitWait(2);
		SearchCustomerPageClassObj.SelectCustomerSearchBy(searchType);
		UtilitiesWebDriver.ExplicitWait(1);
		switch (searchType) {
		case PARTY_ID:
			SearchCustomerPageClassObj.SetValueSearchTextbox(sSearchData);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.ClickOnSearchButton();
			UtilitiesWebDriver.ExplicitWait(3);
			sResultData = SearchCustomerPageClassObj.FetchAllVisibleSearchResult();
			if(AssertionsDesktopBrowser.AssertValueFromArrayStringList(sResultData, sSearchData))
				status=true;
			else
				status=false;
			break;
		case ACCOUNT_NAME:
			SearchCustomerPageClassObj.SelectCustomerSearchBy(searchType);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.SelectCountrySearchForAccountName(endCustomerCountry);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.SetValueSearchTextbox(sSearchData);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.ClickOnSearchButton();
			UtilitiesWebDriver.ExplicitWait(3);
			sResultData = SearchCustomerPageClassObj.FetchAllVisibleSearchResult();
			if(AssertionsDesktopBrowser.AssertValueFromArrayStringList(sResultData, sSearchData))
				status=true;
			else
				status=false;
			break;
		case BUSINESS_ENTITY_ID:
			SearchCustomerPageClassObj.SelectCustomerSearchBy(searchType);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.SetValueSearchTextbox(sSearchData);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.ClickOnSearchButton();
			UtilitiesWebDriver.ExplicitWait(8);
			sResultData = SearchCustomerPageClassObj.FetchAllVisibleSearchResult();
			if(AssertionsDesktopBrowser.AssertValueFromArrayStringList(sResultData, "45932817"))
				status=true;
			else
				status=false;
			break;
		case CUSTOMER_ACCOUNT_NUMBER:
			SearchCustomerPageClassObj.SelectCustomerSearchBy(searchType);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.SetValueSearchTextbox(sSearchData);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.SelectPriceList(priceList);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.SelectEndCustomerCountry(endCustomerCountry);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.SelectIntendedUse(intendedUse);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.SetValueMultipleProductSku(multipleProductSku);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.ClickOnSearchButton();
			UtilitiesWebDriver.ExplicitWait(3);
			sResultData = SearchCustomerPageClassObj.FetchAllVisibleSearchResult();
			if(AssertionsDesktopBrowser.AssertValueFromArrayStringList(sResultData, "111045541"))
				status=true;
			else
				status=false;
			break;
		case BEGEO_ID:
			SearchCustomerPageClassObj.SelectCustomerSearchBy(searchType);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.SetValueSearchTextbox(sSearchData);
			UtilitiesWebDriver.ExplicitWait(1);
			SearchCustomerPageClassObj.ClickOnSearchButton();
			UtilitiesWebDriver.ExplicitWait(3);
			sResultData = SearchCustomerPageClassObj.FetchAllVisibleSearchResult();
			if(AssertionsDesktopBrowser.AssertValueFromArrayStringList(sResultData, sSearchData))
				status=true;
			else
				status=false;
			break;
		default:
			AssertionsDesktopBrowser.AssertFailMessage("INVALID SEARCH BY SELECTED");
			break;
		}	
		return status;
	}	
}
