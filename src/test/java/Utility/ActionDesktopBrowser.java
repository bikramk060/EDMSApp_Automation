package Utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionDesktopBrowser {

	WebDriver driver;
	
	public ActionDesktopBrowser(WebDriver Idriver)
	{
			this.driver=Idriver;
	}
	public void clickOnElement(WebElement element)
	{
		if(element.isDisplayed())
		    {
			element.click();
		    }
		else
		{
			WaitTillElementAppears(element);
			if(element.isDisplayed())
		    {
			element.click();
		    }
		}
	}
	
	
	public void SendTextinTextbox(WebElement element, String text)
	{
		if(IsElementAvailable(element))
		{
			ClearTextBox(element);
			element.sendKeys(text);
		}
		else 
		{
			WaitTillElementAppears(element);
			if(IsElementAvailable(element))
			{
				ClearTextBox(element);
				element.sendKeys(text);
			}
		}
	}
	
	public String GetTextOfElement(WebElement element)
	{
		if(IsElementAvailable(element))
		{
			return element.getText();
		}
		else {
			WaitTillElementAppears(element);
			if(IsElementAvailable(element))
			{
				return element.getText();
			}
			System.out.println("Element not found");
			return "XXXX-----JUNK -----XXXX";
		}
	}
	
	public boolean IsElementAvailable(WebElement element)
    {
        try
        {
            if (element.isDisplayed() && element.isEnabled())
                return true;
        }
        catch (Exception e)
        {
        	System.out.println("Exception caused: " + e);
            return false;
        }
        return false;
    }
	
	public boolean ElementEnabled(WebElement element)
    {
        try
        {
            if (element.isEnabled())
                return true;
        }
        catch (Exception e)
        {
            return false;
        }
        return false;
    }
	
	public String getAttributeValue(WebElement element, String attribute)
    {
        return element.getAttribute(attribute);
    }
	
	 public String GetCssValue(WebElement element, String attribute)
     {
         return element.getCssValue(attribute);
     }
	 
	 public void ClearTextBox(WebElement element)
     {
         element.sendKeys(Keys.CONTROL + "a");
         element.sendKeys(Keys.DELETE);
         element.clear();
     }
	 
	  public String GetSelectedValueFromDropDown(WebElement element)
      {
          Select selectedValue = new Select(element);
          String SelectedText = selectedValue.getAllSelectedOptions().toString();
          return SelectedText;
      }
	  
	  public void HardWait(int seconds) throws InterruptedException
	  {
		  Thread.sleep(seconds*1000);
	  }
	  
	  public void MoveToElementIfElementAvailable(WebElement element)
      {
                  Actions actions = new Actions(driver);
                  actions.moveToElement(element);
                  actions.perform();
      }
	  
	  public void WaitTillElementAppears(WebElement element)
	  {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  wait.until(ExpectedConditions.or(
		  ExpectedConditions.visibilityOf(element)));
	  }
	  
	  public void DragAndDropElement(WebElement sourceElement, WebElement destinationElement)
	  {
		  Actions action = new Actions(driver);
		  if(sourceElement.isDisplayed() && destinationElement.isDisplayed())
		    {
			  action.dragAndDrop(sourceElement, destinationElement).perform();
		    }
		else
		{
			WaitTillElementAppears(sourceElement);
			 if(sourceElement.isDisplayed() && destinationElement.isDisplayed())
			    {
				  action.dragAndDrop(sourceElement, destinationElement).perform();
			    }

		}
		  
	  }
	  
	 
	 
}