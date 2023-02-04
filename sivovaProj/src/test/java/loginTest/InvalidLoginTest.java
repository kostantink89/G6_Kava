package loginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InvalidLoginTest {
    private WebDriver webDriver;

    @Test
    public void invalidLogin(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        System.out.println("browser was opened");

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://qa-complexapp.onrender.com/");

        System.out.println("Site was opened");
        WebElement inputUserName =
                webDriver.findElement(By.xpath(".//input[@name='username' and @placeholder='Username']"));

        inputUserName.clear();
        inputUserName.sendKeys("qaauto");
        System.out.println("Login was inputted");

        WebElement inputPassword =
                webDriver.findElement(By.xpath(".//input[@name='password' and @placeholder='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("123456asdfgh");
        System.out.println("Password was inputted");

        WebElement buttonSignIn = webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']"));
        buttonSignIn.click();
        System.out.println("Button clicked");


        Assert.assertTrue("User is logged in!", isErrorMessageDisplayed());

        webDriver.quit();

        System.out.println("browser was closed");

    }

    private boolean isErrorMessageDisplayed () {
        try {
            return webDriver.findElement(By.xpath(".//div[@class='alert alert-danger text-center']")).isDisplayed();
        } catch (Exception e){
            return false;
        }

    }

}
