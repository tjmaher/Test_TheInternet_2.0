package pages;

import libs.DriverLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginPage {

    private String password;

    @FindBy(id = "h2")
    private WebElement header;

    @FindBy(css = "[name='username']")
    private WebElement usernameTextbox;

    @FindBy(css = "[name='password']")
    private WebElement passwordTextbox;

    @FindBy(css = "[type='submit'][class='radius']")
    private WebElement loginButton;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static final String urlLoginPage = "http://the-internet.herokuapp.com/login";

    public void navigateToLoginPage(WebDriver driver){
        DriverLibrary.getDriver(driver).navigateToURL(urlLoginPage);
    }

    public void loginAs(String username) {
        usernameTextbox.sendKeys(username);
        password = getPassword(username);
        passwordTextbox.sendKeys(this.password);
        loginButton.click();
    }

    private String getPassword(String username) {
        String resourceName = "config.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties password = new Properties();

        try{
            InputStream resourceStream = loader.getResourceAsStream(resourceName);
            password.load(resourceStream);
        } catch (IOException e){
            System.out.println("Exception thrown  : " + e);
        }
        return password.getProperty("user.tomsmith.password");
    }
}
