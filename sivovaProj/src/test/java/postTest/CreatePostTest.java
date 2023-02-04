package postTest;

import baseTest.BaseTest;
import org.junit.Test;

public class CreatePostTest extends BaseTest {

    final String POST_TITLE = "TC1_sivova";
    final String POST_BODY = "TC1_body";

    @Test
    public void TC1_createNewPost() {
        homePage
                .openHomePage()
                .clickOnCreatePostButton()
                .checkRedirectToCreatePostPage()
                .enterTextInInputTitle(POST_TITLE)
                .enterTextInInputBody(POST_BODY)
               .selectPostTypeInDropdown("Приватне повідомлення")
               // .selectValueInDropdownOptions("One Person")
                .clickSavePostButton()
                .checkIsRedirectToPostPage()
                .checkTextInSuccessMessage("New post successfully created.")
                .getHeaderElement().clickMyProfileButton()
                .checkIsRedirectToMyProfilePage()
        ;

    }
}
