package testScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import driver.DriverManager;
import pageObjects.LoginPage;
public class LoginPageTest {

	WebDriver driver=DriverManager.getDriver();
	LoginPage loginPage=new LoginPage(driver);

	@Test()
	public void login() {
		driver.get("https://oipa-qa.assurant.nonprod.manage.equisoft.com:8020/PASJava/");
		loginPage.login("AKumar","KumarAQA");
	}

}