package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionWithElements;
import pages.MyProfilePage;

public class HeaderElements extends CommonActionWithElements {
@FindBy(xpath = ".//*[@data-original-title='My Profile']")
private WebElement buttonMyProfile;

    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

public MyProfilePage clickOnMyProfileButton(){
        clickOnElement(buttonMyProfile);
        return new MyProfilePage(webDriver);
    }

}