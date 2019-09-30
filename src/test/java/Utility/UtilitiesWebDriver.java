package Utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class UtilitiesWebDriver {
	
	static WebDriver driver1;
	static Common common;
	public static WebDriver OpenBrowser(WebDriver driver) throws Exception{
		common= new Common();
		String browser = common.GetBrowserName();
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
	
	public static void GetApplicationURL(WebDriver driver) throws InterruptedException, IOException
	{
		common= new Common();
		String environment = common.GetExecutionEnvironment();
		if(environment.equalsIgnoreCase("TS1"))
		{
			driver.get(common.GetTS1BrowserURL());
			Thread.sleep(1000);
		}
		else if (environment.equalsIgnoreCase("TS3"))
		{
			driver.get(common.GetTS3BrowserURL());
			Thread.sleep(2000);
		}
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
