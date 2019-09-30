package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Common {
	
	Properties prop = new Properties();
	FileInputStream propertyFile;
	Common() throws IOException
	{
		try {
			propertyFile=new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\Resources\\Config.properties");			
			prop.load(propertyFile);
		}
		catch (Exception ex)
		{
			System.out.println("Exception Caused: ");
			ex.printStackTrace();
		}
	}
	public String GetTS1BrowserURL() throws IOException
	{
		System.out.println("TS1_Login_URL: "+ prop.getProperty("TS1_LOGIN_URL"));
		return prop.getProperty("TS1_LOGIN_URL");
	}
	public String GetBrowserUserName() 
	{
		return prop.getProperty("USERNAME");
	}
	public String GetBrowserPassword() 
	{
		return prop.getProperty("PASSWORD");
	}
	public String GetTS3BrowserURL() 
	{
		return prop.getProperty("TS3_LOGIN_URL");
	}
	public String GetServiceBaseURI() 
	{
		return prop.getProperty("BASE_URI");
	}
	public String GetBrowserName()
	{
		return prop.getProperty("BROWSER");
	}
	public String GetExecutionEnvironment()
	{
		return prop.getProperty("EXECUTION_ENV");
	}
}
