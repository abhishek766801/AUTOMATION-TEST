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
		driver.get("https://oipa-qa.assurant.nonprod.manage.equisoft.com:8020/PASJava/");
		
	}

	@Test(priority=2)
	public void login() {
		loginPage.login("AKumar","KumarAQA");
	}

}