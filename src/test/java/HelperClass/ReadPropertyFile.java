package HelperClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public class ReadPropertyFile {
	
	Properties prop = new Properties();
	FileInputStream propertyFile;
	Base64.Decoder decoder = Base64.getDecoder();
	public ReadPropertyFile() throws IOException
	{
		try {
			propertyFile=new FileInputStream(System.getProperty("user.dir") + "\\Resources\\ConfigurationalFiles\\EnvConfig.properties");			
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
		return prop.getProperty("TS1_LOGIN_URL");
	}
	public String GetBrowserLoginValidUserName() 
	{
		String sUserName = new String(decoder.decode(prop.getProperty("VALID_USERNAME")));
		System.out.println("Username: " + sUserName);
		return sUserName;
	}
	public String GetBrowserLoginValidPassword() 
	{
		String sPassword = new String(decoder.decode(prop.getProperty("VALID_PASSWORD")));
		System.out.println("Password: " + sPassword);
		return sPassword;
	}
	public String GetBrowserLoginInvalidUserName() 
	{
		return prop.getProperty("INVALID_USERNAME");
	}
	public String GetBrowserLoginInvalidPassword() 
	{
		return prop.getProperty("INVALID_PASSWORD");
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
	public String GetDriverRegistrationJDBC()
	{
		return prop.getProperty("REGISTER_JDBC_DRIVER");
	}
	public String GetDBConnectionURL()
	{
		return prop.getProperty("DB_CONNECTION_URL");
	}
	public String GetUserNameDB()
	{
		String sUserName = new String(decoder.decode(prop.getProperty("DB_USERNAME")));
		return sUserName;
	}
	public String GetPasswordDB()
	{
		String sPassword = new String(decoder.decode(prop.getProperty("DB_PASSWORD")));
		return sPassword;
	}
}
