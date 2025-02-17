package testScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import driver.DriverManager;
import pageObjects.LoginPage;
public class LoginPageTest {

	WebDriver driver=DriverManager.getDriver();
	LoginPage loginPage=new LoginPage(driver);
	@Test(priority=1)
	public void getURL() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}

	@Test(priority=2)
	public void login() {
		loginPage.login("Admin","admin123");
	}

}