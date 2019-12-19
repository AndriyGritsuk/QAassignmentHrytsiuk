package tests;

import org.junit.Test;
import pages.LoginForm;

public class VoteTest extends BaseTest{

    @Test
    public void verifyUserCanUpvotePost (){
        new LoginForm(driver)
                .login()
                .openCommunitiesMenu()
                .openOneOfMyCommunity()
                .verifyUpVote();
    }

    @Test
    public void verifyUserCanDownPost (){
        new LoginForm(driver)
                .login()
                .clickBrowsePopularPosts()
                .openCommunitiesMenu()
                .openOneOfMyCommunity()
                .verifyDownVote();
    }

}
