package edmsDesktopBrowser.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Testing {

		public static void main(String[] args) throws InterruptedException {
			WebDriver driver;
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\akmukhop\\Documents\\MobileAutomationTesting\\com.uiTestAutomationEDMS_v1.9.application\\src\\test\\Drivers\\chromedriver_v76.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			driver.get("https://edia-cstg.cloudapps.cisco.com/edia/home.do");
			
			//Entering the username
					driver.findElement(By.id("userInput")).sendKeys("kdfadmin.gen");
					driver.findElement(By.id("login-button")).click();
					Thread.sleep(3000);
					
					Thread.sleep(3000);
					
					//Enter Pwd
					driver.findElement(By.id("passwordInput")).sendKeys("KdfAlfoMahesh15");
					driver.findElement(By.id("login-button")).click();
					
					Thread.sleep(3000);
					
					//asserting the test present 
					String dispalyText = driver.findElement(By.xpath("//td[contains(text(),'EDMS Workspace')]")).getText();
					System.out.println(dispalyText);
					Assert.assertEquals(dispalyText, "EDMS Workspace");
					System.out.println("successful");
					
					Thread.sleep(3000);
					
					driver.findElement(By.xpath("//input[@kdfid = 'btn_706']")).click();
					String text = driver.findElement(By.xpath("//div[@class='icwModalTitle']")).getText();
					System.out.println(text);
					//driver.switchTo().frame("cross-domain-store-server-iframe");
					//driver.findElement(By.xpath("//input[@id='file']")).click();
					System.out.println(driver.findElement(By.xpath("//input[@id='file']")).getText());
					//driver.findElement(By.xpath("//input[@id='realChk']")).click();

		}

}

