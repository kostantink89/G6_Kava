package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;
import pages.MyProfilePage;

public class HeaderElements extends CommonActionsWithElements {
    @FindBy(xpath = ".//a[@href='/profile/qaauto' and @class='mr-2']")
    private WebElement buttonMyProfile;

    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

    public MyProfilePage clickMyProfileButton() {
        clickElement(buttonMyProfile);
        return new MyProfilePage(webDriver);
    }

}