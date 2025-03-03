package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class LoginPage {
    private WebDriver driver;
 
    @FindBy(id = "username")
    private WebElement usernameField;
 
    @FindBy(id = "password")
    private WebElement passwordField;
 
    @FindBy(css = ".fa-sign-in")
    private WebElement loginButton;
 
    @FindBy(id = "flash")
    private WebElement message;
 
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
 
    public String getMessage() {
        return message.getText();
    }
}
 