package pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{
    @FindBy(xpath = "//input[@name='username' and @placeholder='Username']")
    private WebElement inputUserName;
    @FindBy(xpath = ".//input[@placeholder='Password']")
    private WebElement inputPassword;
    @FindBy (xpath = ".//button[@class='btn btn-primary btn-sm']")
    private WebElement buttonLogin;
    @FindBy (xpath = ".//div[@class='alert alert-danger text-center']")
    private WebElement errorLoginMessage;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void openLoginPage(){
        try{
            webDriver.get("https://qa-complexapp.onrender.com/");
            logger.info("Page was opened");
        }catch(Exception e){
            logger.error("Can't open Login Page" + e);
            Assert.fail("Can't open Login Page" + e);
        }
    }

    public void enterUserNameIntoInputLogin(String userName) {
        /*try {
            //WebElement inputUserName =
            //        webDriver.findElement(By.xpath("//input[@name='username' and @placeholder='Username']"));
            inputUserName.clear();
            inputUserName.sendKeys(userName);
            logger.info("login was inputted");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }*/
        enterTextInToElement(inputUserName, userName);
    }

    public void enterPasswordIntoInputPassword(String password) {
        enterTextInToElement(inputPassword, password);
    }

    public void clickOnButtonLogin() {
        clickOnElement(buttonLogin);
    }

    public boolean isSignInButtonDisplayed(){
        return isElementDisplayed(buttonLogin);
    }
    public LoginPage checkTextInLoginErrorMessage(String expectedMessage){
        Assert.assertEquals("Text in success message element"
                , expectedMessage, errorLoginMessage.getText());
        return this;
    }

    public HomePage fillingLoginFormWithValidCred() {
        openLoginPage();
        enterUserNameIntoInputLogin(TestData.VALID_LOGIN);
        enterPasswordIntoInputPassword(TestData.VALID_PASSWORD);
        clickOnButtonLogin();
        return new HomePage(webDriver);
    }

    public LoginPage fillingLoginFormWithInvalidCred() {
        openLoginPage();
        enterUserNameIntoInputLogin(TestData.INVALID_LOGIN);
        enterPasswordIntoInputPassword(TestData.INVALID_PASSWORD);
        clickOnButtonLogin();
        return this;
    }
}
