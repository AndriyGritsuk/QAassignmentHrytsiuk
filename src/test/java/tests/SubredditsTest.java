package tests;

import org.junit.Test;
import pages.LoginForm;

public class SubredditsTest extends BaseTest{

    @Test
    public void verifyUserCanSeeSubscribedSubreddits (){
        new LoginForm(driver)
                .login()
                .openCommunitiesMenu()
                .verifyMySubscribedCommunities();
    }

    @Test
    public void verifyUserCanSeeOneSubscribedSubreddit (){
        new LoginForm(driver)
                .login()
                .openCommunitiesMenu()
                .openOneOfMyCommunity()
                .verifyMySubredditIsShown();
    }
}
