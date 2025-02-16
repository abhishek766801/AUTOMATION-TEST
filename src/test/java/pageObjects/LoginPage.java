package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class LoginPage {
 
    WebDriver driver;
 
    // Locators using @FindBy annotation
    @FindBy(id = "userName")
    private WebElement usernameField;
 
    @FindBy(id = "password")
    private WebElement passwordField;
 
    @FindBy(id = "submit")
    private WebElement loginButton;
 
    // Constructor
   
    public LoginPage(WebDriver driver2) {this.driver = driver;
    PageFactory.initElements(driver, this);// TODO Auto-generated constructor stub
	}

	// Actions
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }
 
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
 
    public void clickLogin() {
loginButton.click();
    }
 
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}