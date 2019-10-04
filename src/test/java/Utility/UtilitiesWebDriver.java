package Utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class UtilitiesWebDriver {
	
	static WebDriver driver1;
	static ReadPropertyFile readPropertyFile;
	public static WebDriver OpenBrowser(WebDriver driver) throws Exception{
		readPropertyFile= new ReadPropertyFile();
		if(readPropertyFile.GetBrowserName().equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "\\src\\test\\Drivers\\geckodriver.exe"); //Enable setProprty only if you are using Selenium 3.0/above and firefox 37 and above
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver1=driver;
			return driver;
		}
		else if(readPropertyFile.GetBrowserName().equalsIgnoreCase("chrome")){
			System.out.println(System.getProperty("user.dir") +"//src");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\Drivers\\chromedriver_v76.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver1=driver;
			return driver;
		}
		else if(readPropertyFile.GetBrowserName().equalsIgnoreCase("Edge")){
			
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") + "\\src\\test\\Drivers\\MicrosoftWebDriver.exe");
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
		readPropertyFile= new ReadPropertyFile();
		String environment = readPropertyFile.GetExecutionEnvironment();
		if(environment.equalsIgnoreCase("TS1"))
		{
			driver.get(readPropertyFile.GetTS1BrowserURL());
			Thread.sleep(1000);
		}
		else if (environment.equalsIgnoreCase("TS3"))
		{
			driver.get(readPropertyFile.GetTS3BrowserURL());
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
