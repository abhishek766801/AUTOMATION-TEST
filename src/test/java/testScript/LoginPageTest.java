package testScript;

import org.openqa.selenium.WebDriver;
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
	}

}