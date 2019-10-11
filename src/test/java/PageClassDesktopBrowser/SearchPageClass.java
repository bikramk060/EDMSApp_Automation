package PageClassDesktopBrowser;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.ActionDesktopBrowser;
import Utility.UtilitiesWebDriver;


public class SearchPageClass {
	
	WebDriver driver;
	ActionDesktopBrowser actionBrowserObj = new ActionDesktopBrowser(driver);
	public SearchPageClass(WebDriver Idriver)
	{
			this.driver=Idriver;
			PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how=How.ID, using =  "srchTyp")
	public WebElement selectCustomerSearchBy;
	
	@FindBy(how=How.ID, using =  "srchTrm")
	public WebElement searchTextbox;
	
	@FindBy(how=How.XPATH, using =  "//input[@kdfid='btn_basicSearchButton']")
	public WebElement searchButton;
	
	@FindBy(how=How.XPATH, using =  "//span[@kdfid='tpTgglBtn2']")
	public WebElement searchTab;
	
	public void SelectCustomerSearchBy(Utility.Enums.SearchCustomers searchBy) throws InterruptedException
	{
		Select selectShowTypeDropDown = new Select(selectCustomerSearchBy);
		UtilitiesWebDriver.ExplicitWait(1);
		switch (searchBy) 
		{
			case PARTY_ID:
				selectShowTypeDropDown.selectByVisibleText("Party ID (Site ID)");
					break;
			case ACCOUNT_NAME:
				selectShowTypeDropDown.selectByVisibleText("Account Name");
				    break;
			case BUSINESS_ENTITY_ID:
				selectShowTypeDropDown.selectByVisibleText("Business Entity ID (BE ID)");
					break;
			case CUSTOMER_ACCOUNT_NUMBER:
				selectShowTypeDropDown.selectByVisibleText("Customer Account Number");
				    break;	 
			default:
					System.out.println("INVALID SEARCH BY VALUE SELECTED");
					break;
		}
	}
	
	public void SetValueSearchTextbox(String searchKeyword)
	{
		actionBrowserObj.SendTextinTextbox(searchTextbox, searchKeyword);
	}
	
	public void ClickOnSearchButton()
	{
		actionBrowserObj.clickOnElement(searchButton);
	}
	
	public Boolean SearchGridValueExist(String searchValue)
	{
		if(actionBrowserObj.IsElementAvailable(driver.findElement(By.xpath("//td[contains(text(),'" + searchValue + "')]"))))
			return true;
		else
			return false;
	}
	
	public void ClickOnSearchTabOnHomePage()
	{
		actionBrowserObj.clickOnElement(searchTab);
	}

		
//	public ArrayList<String> FetchAllRequestIDVisibleOnScreen(String requestStatus)
//	{
//		List<WebElement> allRequestOnScreen = AllRequestVisibleOnScreen(requestStatus);
//		ArrayList<String> requestID = new ArrayList<String>();
//		if(allRequestOnScreen.size()!=0)
//			{
//			for (WebElement element : allRequestOnScreen) {
//				requestID.add(element.getText());
//				}
//			return requestID;
//			}
//		else
//			return requestID=null;
//	}
	
	
		
	
	
	
}
