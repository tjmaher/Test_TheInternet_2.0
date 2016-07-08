package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tmaher on 6/18/2016.
 */
public class SecureAreaPage extends BasePage{

    private WebDriver driver;

    @FindBy(id = "h2")
    private WebElement header;

    @FindBy(css = "[href='/logout']")
    private WebElement logoutButton;

    private static final String urlSecureArea = "http://the-internet.herokuapp.com/secure";

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }
}
