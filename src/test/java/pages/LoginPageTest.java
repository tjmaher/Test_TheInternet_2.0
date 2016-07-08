package pages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by tmaher on 6/18/2016.
 */
public class LoginPageTest {
    private RemoteWebDriver driver;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test_FirefoxNavigatesToLoginPage() throws Exception  {
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/login");
        LoginPage login = new LoginPage(driver);
        login.navigateToLoginPage(driver);
        assertThat(driver.getTitle(), is(equalTo("The Internet")));
    }

    @Test
    public void test_FirefoxLocalGridNavigatesToLoginPage() throws Exception  {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL("http://192.168.1.5:5555/wd/hub"), capabilities);
        driver.get("http://the-internet.herokuapp.com/login");
        assertThat(driver.getTitle(), is(equalTo("The Internet")));
    }

    @Test
    public void test_FirefoxDockerGridNavigatesToLoginPage() throws Exception  {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), capabilities);
        driver.get("http://the-internet.herokuapp.com/login");
        assertThat(driver.getTitle(), is(equalTo("The Internet")));
    }

    @Test
    public void test_ChromeDriverNavigatesToLoginPage()  throws Exception {
        driver = new ChromeDriver();
        LoginPage login = new LoginPage(driver);
        login.navigateToLoginPage(driver);
        assertThat(driver.getTitle(), is(equalTo("The Internet")));
    }

    @Test
    public void test_IE11DriverNavigatesToLoginPage()  throws Exception {
        driver = new InternetExplorerDriver();
        LoginPage login = new LoginPage(driver);
        login.navigateToLoginPage(driver);
        assertThat(driver.getTitle(), is(equalTo("The Internet")));
    }

    @After
    public void closeBrowsers() throws Exception {
        driver.quit();
    }
}
