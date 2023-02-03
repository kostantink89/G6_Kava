package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePostPage extends ParentPage {
    //  .//*[@name='title']
    @FindBy (name = "title")
    private WebElement inputTitle;

    @FindBy (id = "post-body")
    private WebElement inputBody;

    @FindBy (xpath = ".//button[@class='btn btn-primary']")
    private WebElement buttonSavePost;

    //          .//select
    @FindBy (tagName = "select")
    private WebElement dropDownOptions;

    public CreatePostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CreatePostPage checkIsRedirectToCreatePostPage() {
        Assert.assertTrue("CreatePostPage is not loaded", isElementDisplayed(inputTitle));

        return this;
    }

    public CreatePostPage enterTextInInputTitle(String postTitle) {
        enterTextIntoElement(inputTitle, postTitle);
        return this;
    }

    public CreatePostPage enterTextInBodyContent(String postBody) {
        enterTextIntoElement(inputBody, postBody);
        return this;
    }


    public PostPage clickOnSavePostButton() {
        clickOnElement(buttonSavePost);
        return new PostPage(webDriver);
    }

    public CreatePostPage selectTextInDropDownOption(String textInDD) {
        selectTextInDropDown(dropDownOptions, textInDD);

        return this;
    }

    public CreatePostPage selectValueInDropDownOption(String valueInDD) {
        selectValueInDropDown(dropDownOptions, valueInDD);
        return this;
    }

}
