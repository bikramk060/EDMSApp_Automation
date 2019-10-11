package PageClassDesktopBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Utility.ActionDesktopBrowser;


public class DesktopBrowserLoginPageClass {
	
	WebDriver driver;
	public DesktopBrowserLoginPageClass(WebDriver Idriver)
	{
			this.driver=Idriver;
			PageFactory.initElements(driver, this);
	}
	ActionDesktopBrowser actionBrowserObj = new ActionDesktopBrowser(driver);
	
	@FindBy(how=How.ID, using =  "userInput")
	public WebElement userNameTextbox;
	
	@FindBy(how=How.ID, using =  "passwordInput")
	public WebElement passwordTextbox;
	
	@FindBy(how=How.ID, using =  "login-button")
	public WebElement loginButton;
	
	@FindBy(how=How.XPATH, using =  "//span[@class='loggedin']")
	public WebElement loggedInUser;
	
	@FindBy(how=How.XPATH, using =  "//p[@class='msg idNull']")
	public WebElement InvalidUserErrorMessage;
	
	@FindBy(how=How.XPATH, using =  "//h3[contains(text(),\"That login didn't work:\")]")
	public WebElement InvalidPasswordErrorMessage;
	
	public void SetValueForUserNameTextbox(String sUserName)
	{
		actionBrowserObj.SendTextinTextbox(userNameTextbox, sUserName);
		System.out.println("Added UserName in textbox");
	}
		
	public void SetValueForpasswordTextbox(String sPassword)
	{
		actionBrowserObj.SendTextinTextbox(passwordTextbox, sPassword);
		System.out.println("Added Password in textbox");
	}
		
	public void ClickOnloginButton()
	{
		actionBrowserObj.clickOnElement(loginButton);
		System.out.println("Clicked on Login Button");
	}
	
	public String FetchLoggedUserName()
	{
		return actionBrowserObj.GetTextOfElement(loggedInUser);	
	}
	
	public String FetchInvalidUserErrorMessage()
	{
		return actionBrowserObj.GetTextOfElement(InvalidUserErrorMessage);	
	}
	
	public String FetchInvalidPasswordErrorMessage()
	{
		return actionBrowserObj.GetTextOfElement(InvalidPasswordErrorMessage);
	}
	
	
	
}
