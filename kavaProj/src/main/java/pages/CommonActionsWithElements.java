package pages;

import io.qameta.allure.Step;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;


import java.util.List;

public class CommonActionsWithElements {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    WebDriverWait webDriverWait10, webDriverWait15;
    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);


    public CommonActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(configProperties.TIME_FOR_EXPLICIT_WAIT_HIGH()));
    }

    @Step
    protected void enterTextInToElement(WebElement webElement, String text) {
        try {
            webDriverWait15.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted in to element " + getElementName(webElement));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }

    @Step
    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            String name = getElementName(webElement);
            webElement.click();
            logger.info(name + " Element was clicked ");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }

    @Step
    protected void clickOnElement(String xpath) {
        try {
            clickOnElement(webDriver.findElement(By.xpath(xpath)));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    @Step
    public static boolean isElementPresented(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }


    }

    @Step
    protected boolean isElementDisplayed(String locator, String errorInfo) {
        try {
            WebElement requiredLocator = webDriver.findElement(By.xpath(String.format(locator, errorInfo)));
            return isElementDisplayed(requiredLocator);
        } catch (Exception e) {
            logger.info("Element is not displayed");
            return false;
        }
    }

    @Step
    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            String message;
            if (state) {
                message = getElementName(webElement) + " Element is displayed";
            } else {
                message = getElementName(webElement) + " Element is not displayed ";
            }
            logger.info(message);
            return state;
        } catch (Exception e) {
            logger.info("Element is not displayed");
            return false;
        }
    }

    @Step
    protected void selectTextInDropDown(WebElement dropDown, String visibleText) {
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(visibleText);
            logger.info(visibleText + " was selected in DropDown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    @Step
    protected void selectValueInDropDown(WebElement dropDownOptions, String value) {
        try {
            Select select = new Select(dropDownOptions);
            List<WebElement> allAvailableOptions = select.getOptions();
            for (WebElement option : allAvailableOptions) {
                logger.info("Available options: " + option.getText());
                if (option.getText().equals(value)) {
                    option.click();
                    logger.info(value + " was selected in DropDown");
                    break;
                }
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    @Step
    private String getElementName(WebElement webElement) {
        try {
            return webElement.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }


    protected void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);

    }

    public void usersPressesKeyEnterTime(int numberOfTimes) {
        Actions actions = new Actions(webDriver);
        for (int i = 0; i < numberOfTimes; i++) {
            actions.sendKeys(Keys.ENTER).build().perform();
        }
    }

    public void usersPressesKeyTabTime(int numberOfTimes) {
        Actions actions = new Actions(webDriver);
        for (int i = 0; i < numberOfTimes; i++) {
            actions.sendKeys(Keys.TAB).build().perform();
        }

    }

    public void usersPressesKeyTime(Keys keys, int numberOfTimes) {
        Actions actions = new Actions(webDriver);
        for (int i = 0; i < numberOfTimes; i++) {
            actions.sendKeys(keys).build().perform();
        }

    }

    public void userOpensNewTab() {
        ((JavascriptExecutor) webDriver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
    }
//
//    метод moveToElement (аналог скрола )
//
//    WebElement element = driver.findElement(By.id("my-id"));
//    Actions actions = new Actions(driver);
//actions.moveToElement(element);
//actions.perform();
//
//—————————-
//    метод скрола з використанням javaScript
//
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("javascript:window.scrollBy(250,350)");
//
//—————————-
//    Емуляція натискання PageDown
//
//WebElement.sendKeys(Keys.DOWN);
//
//—————————-
//    скрол до елемента з javaScript
//
//            webElement = driver.findElement(By.xpath("bla-bla-bla"));
//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);


}



