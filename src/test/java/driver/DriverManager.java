package driver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {
	public static WebDriver driver=null;
	
	// Actions actionChain = new ActionChain(driver);
	
	public static WebDriver getDriver() {
		if(driver==null) {
			driver=new ChromeDriver();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		return driver;
		
	}
	public static void quitDriver() {
		if(driver!=null)
		{
			driver.quit();
			driver=null;
		}
	}
}


