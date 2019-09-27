package Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class UtilitiesWebDriver {
	
	static WebDriver driver1;
	public static WebDriver OpenBrowser(String browser, WebDriver driver) throws Exception{
		if(browser.equalsIgnoreCase("firefox")){
		//Enable setProprty only if you are using Selenium 3.0/above and firefox 37 and above
			//System.setProperty("webdriver.firefox.marionette", ".\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver1=driver;
			return driver;
		}
		else if(browser.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\akmukhop\\Documents\\MobileAutomationTesting\\com.TestAutomationEDMS.application\\src\\test\\Drivers\\chromedriver_v76.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver1=driver;
			return driver;
		}
		else if(browser.equalsIgnoreCase("Edge")){
			System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver1=driver;
			return driver;
		}
		else{
			
			throw new Exception("Browser name is not correct");
		}
		
	}
	
	public static void GetApplicationURL(WebDriver driver) throws InterruptedException
	{
		driver.get("https://edia-cstg.cloudapps.cisco.com/edia/home.do");
		Thread.sleep(4000);
	}
	
	public static void KillDriverInstance(WebDriver driver)
	{
		driver.close();
		driver.quit();
	}
	
	public static void ExplicitWait(int seconds) throws InterruptedException
	{
		Thread.sleep(seconds*1000);
	}
	
	public String GetCurrentUrl(WebDriver driver)
    {
        return driver.getCurrentUrl();
    }


}
