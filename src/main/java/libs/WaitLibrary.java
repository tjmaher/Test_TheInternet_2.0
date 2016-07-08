package libs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by tmaher on 6/18/2016.
 */
public class WaitLibrary {
    private WebDriverWait webDriverWait;

    private WaitLibrary(WebDriver driver, final int timeInSeconds) {
        this.webDriverWait = new WebDriverWait(driver, timeInSeconds);
    }

    public static WaitLibrary wait(WebDriver driver, final int timeoutInSeconds) {
        return new WaitLibrary(driver, timeoutInSeconds);
    }

    public void waitUntilElementIsVisible(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementIsNotVisible(By selector) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }
}
