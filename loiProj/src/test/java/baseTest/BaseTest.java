package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.MyProfilePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected MyProfilePage myProfilePage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        myProfilePage = new MyProfilePage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
    }
}
