package testScript;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import driver.DriverManager;
import pageObjects.LoginPage;
import reports.ExtentReportManager;
public class LoginPageTest {

	WebDriver driver=DriverManager.getDriver();
	LoginPage loginPage=new LoginPage(driver);
	@Test(priority=1)
	public void getURL() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		ExtentReportManager.testReport(Status.PASS,"url fetched");
	}

	@Test(dependsOnMethods="getURL")
	public void login() {
		loginPage.login("Admin","admin123");
		ExtentReportManager.testReport(Status.PASS,"login triggered");
		WebElement ele=driver.findElement(By.cssSelector(".oxd-grid-item"));
		//By passwordLocator = RelativeLocator.with(By.tagName("input")).below(By.id("email"));
	}

}