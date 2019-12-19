package tests;

import org.junit.Test;
import pages.LoginForm;

public class CommentTest extends BaseTest {

    @Test
    public void verifyUserCanCreateComment (){
        new LoginForm(driver)
                .login()
                .openCommunitiesMenu()
                .openOneOfMyCommunity()
                .clickCommentButton()
                .fillTextBox()
                .clickTextBoxCommentButton()
                .verifyTextBox();
    }
}
