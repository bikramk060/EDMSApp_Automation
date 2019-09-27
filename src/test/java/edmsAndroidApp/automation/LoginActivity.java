package edmsAndroidApp.automation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class LoginActivity {
	
	public static DesiredCapabilities SetDesiredCapabilities()
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("appPackage", "com.application.zomato");
		capabilities.setCapability("appActivity", "com.application.zomato.activities.Splash");
		//capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		return capabilities;
	}
	
	
	public static void OpenAppAndAssertInvalidUsernamePassword() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capabilities = SetDesiredCapabilities();
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		AndroidTouchAction touch = new AndroidTouchAction(driver);
		
		Thread.sleep(1000);
		  MobileElement deviceLocationAllowButton =driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
		  deviceLocationAllowButton.click(); 
		  System.out.println("Allowed Device Location");
		  Thread.sleep(1000);
		  MobileElement loginMethod =driver.findElement(By.id("com.application.zomato:id/layout_connect_using_google"));
		  loginMethod.click(); 
		  System.out.println("Selected Connect Using Google");
		  Thread.sleep(3000);
		  MobileElement emailIdSelect =driver.findElement(By.id("com.google.android.gms:id/account_display_name"));
		  Point point = emailIdSelect.getLocation();
	      System.out.println("Location of Email ID: " + point);
	      touch.tap(PointOption.point(point.x, point.y)).perform();
		  Thread.sleep(1000);
		  
	}

	
}
