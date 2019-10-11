package TestCaseAndroidApp.automation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class DiscoverTestCases {
	
	static AndroidDriver<MobileElement> driver;
	
	
	@BeforeTest
	public static AndroidDriver<MobileElement> CreateAndReturnDriverInstance() throws MalformedURLException
	{
		DesiredCapabilities capabilities = SetDesiredCapabilities();
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		return driver;
	}
	
	
	
	public static DesiredCapabilities SetDesiredCapabilities()
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("deviceName", "emulator-5556");
		capabilities.setCapability("appPackage", "com.application.zomato");
		capabilities.setCapability("appActivity", "com.application.zomato.activities.Splash");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		return capabilities;
	}

	
	
	
	public static void SearchMyLocationFromSuggestion() throws MalformedURLException, InterruptedException
	{
		
		Thread.sleep(3000);
		MobileElement selectLocation =driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/com.application.zomato.tabbed.widget.HomeViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup[1]"));
		selectLocation.click(); 
		Thread.sleep(3000);
		MobileElement editLocationTextbox =driver.findElement(By.className("android.widget.EditText"));
		System.out.println(editLocationTextbox.getText());
		editLocationTextbox.sendKeys("Marathalli");
		Thread.sleep(2000);
		//Add select from suggestion list code
		List<MobileElement> suggestedLocations = driver.findElements(By.xpath("//android.widget.FrameLayout[@resource-id='com.application.zomato:id/location_item']//android.widget.TextView[@resource-id='com.application.zomato:id/titleText']"));
		for (int i=0;i<suggestedLocations.size();i++)
		{
			System.out.println(suggestedLocations.get(i).getText());
			if (suggestedLocations.get(i).getText().equals("Soul Space Arena Mall, Marathahalli, Bengaluru, India"))
			{
				suggestedLocations.get(i).click();
			}
		}
		Thread.sleep(2000);
		
	}
	
	
	public static void SeeAllRestaurantForYou() throws InterruptedException
	{
		Thread.sleep(5000);
		MobileElement seeAllLocation =driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.application.zomato:id/button_text']"));
		seeAllLocation.click(); 
		Thread.sleep(3000);
		
		MobileElement searchRestaurant =driver.findElement(By.id("com.application.zomato:id/et_final"));
		searchRestaurant.sendKeys("Barbeque");
		Thread.sleep(4000);
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Everett & Jones Barbeque, Downtown Oakland\"));"));
        MobileElement restaurantSelection = driver.findElementByXPath("//android.widget.TextView[@text='Everett & Jones Barbeque, Downtown Oakland']");
        restaurantSelection.click();
        Thread.sleep(4000);
        
        MobileElement restaurantName = driver.findElement(By.id("com.application.zomato:id/titleText"));
        Assert.assertEquals(restaurantName.getText(), "Everett & Jones Barbeque");
        
	}
	
	
	public static void PrintAllCollections() throws InterruptedException
	{
		Thread.sleep(5000);
		MobileElement collectionTab = driver.findElement(By.xpath("//android.support.v7.app.ActionBar.Tab/android.widget.TextView[@text='Collections']"));
		collectionTab.click();
		Thread.sleep(3000);

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Burrito mania\"));"));
		System.out.println("All Collections List: \n");
		List<MobileElement> allCollections = driver.findElementsByXPath("//android.widget.FrameLayout[@resource-id='com.application.zomato:id/container_image_card']/android.widget.LinearLayout/android.widget.TextView");
		for (MobileElement mobileElement : allCollections) {
			System.out.println(mobileElement.getText());
		}
		Thread.sleep(3000);
	}
	
	
	public static void ScrollAndSelectCollectionFromList() throws InterruptedException
	{
		Thread.sleep(5000);
		MobileElement collectionTab = driver.findElement(By.xpath("//android.support.v7.app.ActionBar.Tab/android.widget.TextView[@text='Collections']"));
		collectionTab.click();
		Thread.sleep(4000);

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"//android.widget.FrameLayout[@resource-id='com.application.zomato:id/container_image_card']/android.widget.LinearLayout/android.widget.TextView[@text='Stay & play']\"));"));
		MobileElement selectedCollection = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='com.application.zomato:id/container_image_card']/android.widget.LinearLayout/android.widget.TextView[@text='Stay & play']"));
		selectedCollection.click();
	}
	
	@Test
	public static void PrintAllCuisinesList() throws InterruptedException
	{
		Thread.sleep(5000);
		MobileElement cusinesTab = driver.findElement(By.xpath("//android.support.v7.app.ActionBar.Tab/android.widget.TextView[@text='Cuisines']"));
		cusinesTab.click();
		Thread.sleep(4000);
		
		System.out.println("List Of All Cuisines: \n");
	    List<MobileElement> allCusineList = driver.findElements(By.xpath("//android.widget.ImageView[@resource-id='com.application.zomato:id/res_image']//parent::android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView"));
	    for (MobileElement mobileElement : allCusineList) {
			System.out.println(mobileElement.getText());
		}
	    driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Cafe\"));"));
	    //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Afghan\"));"));
	    
	}
	
	
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}
}
