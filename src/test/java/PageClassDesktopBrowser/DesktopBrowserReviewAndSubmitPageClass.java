package PageClassDesktopBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Utility.ActionDesktopBrowser;


public class DesktopBrowserReviewAndSubmitPageClass {
	
	WebDriver driver;
	ActionDesktopBrowser actionBrowserObj = new ActionDesktopBrowser(driver);
	public DesktopBrowserReviewAndSubmitPageClass(WebDriver Idriver)
	{
			this.driver=Idriver;
			PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using =  "sumRenButtId")
	public WebElement renewButton;
	
	@FindBy(how=How.XPATH, using =  "//input[@kdfid='txt_sumModButtId']")
	public WebElement modifyButton;
	
	@FindBy(how=How.XPATH, using =  "//div[@kdfid='errmsg_summary1']//p")
	public WebElement submissionErrorMessage;
	
	public boolean CheckRenewButtonExists()
	{
		
		if(actionBrowserObj.IsElementAvailable(modifyButton))
			return true;
		else
			return false;
	}
	
	public boolean CheckModifyButtonExists()
	{
		if(actionBrowserObj.IsElementAvailable(renewButton))
			return true;
		else
			return false;
	}
	
	public String GetTextsubmissionErrorMessage()
	{
		return submissionErrorMessage.getText();
	}
		
	
	
	
}
