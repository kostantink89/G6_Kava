package pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//input[@name='username' and @placeholder='Username']")
    private WebElement inputUserName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@class='btn btn-primary btn-sm']")
    private WebElement buttonLogin;





    public LoginPage(WebDriver webDriver) {

        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/";
    }

    public void openLoginPage() {
        try {
            webDriver.get(base_URL+getRelativeURL());
            logger.info("Login page was open");
            logger.info(base_URL);
        } catch (Exception e) {
            logger.error("Can not open login page" + e);
            Assert.fail("Can not open login page" + e);
        }
    }


    public void enterUserNameIntoInputLogin(String userName) {

        enterTextIntiElement(inputUserName,userName);
    }


    public void enterPasswordIntoInputPassword(String password) {

        enterTextIntiElement(inputPassword,password);
    }

    public void clickOnButtonLogin() {

        clickOnElement(buttonLogin);
    }


    public HomePage fillingLoginFormWithValidCred() {
        enterUserNameIntoInputLogin(TestData.VALID_LOGIN);
        enterPasswordIntoInputPassword(TestData.VALID_PASSWORD);
        clickOnButtonLogin();
        return new HomePage(webDriver);
    }


}

