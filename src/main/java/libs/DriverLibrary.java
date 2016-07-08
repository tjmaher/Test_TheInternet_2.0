package libs;

import org.openqa.selenium.WebDriver;

/**
 * Created by tmaher on 6/18/2016.
 */
public class DriverLibrary {
    private WebDriver driver;

    private DriverLibrary(WebDriver driver) {
        this.driver = driver;
    }

    public static DriverLibrary getDriver(WebDriver driver) {
        return new DriverLibrary(driver);
    }

    public void navigateToURL(String url) {
        driver.navigate().to(url);
    }
}
