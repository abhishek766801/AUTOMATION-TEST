package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.DriverManager;
public class LoginPage extends DriverManager{
	DriverManager driverManager;
    WebDriver driver;
 
    // Locators using @FindBy annotation
    @FindBy(id = "userName")
    private WebElement usernameField;
 
    @FindBy(id = "passwordt")
    private WebElement passwordField;
 
    @FindBy(id = "submit")
    private WebElement loginButton;
 
    // Constructor
   
    public LoginPage(WebDriver driver) {this.driver = driver;
    
    PageFactory.initElements(driver, this);// TODO Auto-generated constructor stub
	}

	// Actions
    public void enterUsername(String username) {
    	waitForElement(usernameField).sendKeys(username);
    }
 
    public void enterPassword(String password) {
    	waitForElement(passwordField).sendKeys(password);
    }
 
    public void clickLogin() {
    		waitForElementToBeClickable(loginButton).click();
    }
 
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}