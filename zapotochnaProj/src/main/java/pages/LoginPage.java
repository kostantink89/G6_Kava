package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void openLoginPage() {

        try {
            webDriver.get("https://qa-complexapp.onrender.com/");
            logger.info("LoginPage was opened");

        } catch (Exception e) {
            logger.error("Cannot open page " + e);  // generated to log report

            Assert.fail("Cannot open page" + e);  // generated to report
        }


    }


    public void enterUserNameIntoLogin(String username) {

        try {
            WebElement inputUserName =
                    webDriver.findElement(By.xpath(".//input[@name='username' and @placeholder='Username']"));

            inputUserName.clear();
            inputUserName.sendKeys(username);
            logger.info("login was inputted");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }



    }


    public void enterPasswordIntoInputPassword(String password) {
        try {
            WebElement inputPassword =
                    webDriver.findElement(By.xpath(".//input[@placeholder='Password']"));

            inputPassword.clear();
            inputPassword.sendKeys(password);
            logger.info("password was inputted");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }


    }

    public void clickOnButtonLogin() {

        try {
            WebElement buttonLogin = webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']"));
            buttonLogin.click();
            logger.info("button was clicked");
        }catch (Exception e){
            printErrorAndStopTest(e);

        }
    }
}
