package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By loginButton = By.xpath("//*[text()='log in']");
    private By userAccountMenu = By.xpath("//*[text()='User account menu']");
    private By myCommunities = By.xpath("//*[@role='heading' and contains(.,'my communities')]");
    private By communitiesMenu = By.xpath("//*[contains(@aria-label, 'communities' )]");
    private By oneOfMyCommunity = By.xpath("//span[contains(., 'r/java' )]");

    public Subreddits openOneOfMyCommunity() {
        findElement(oneOfMyCommunity).click();
        return new Subreddits(driver);
    }

    public HomePage openCommunitiesMenu() {
        findElement(communitiesMenu).click();
        return this;
    }

    public void verifyMySubscribedCommunities(){
        boolean isAccountMenuDisplayed = findElement(myCommunities).isDisplayed();
        Assert.assertTrue(isAccountMenuDisplayed);
    }

    public LoginForm clickLogInButton() {
        findElement(loginButton).click();
        return new LoginForm(driver);
    }

    public void verifyUserLoggedIn(){
        boolean isAccountMenuDisplayed = findElement(userAccountMenu).isDisplayed();
        Assert.assertTrue(isAccountMenuDisplayed);
    }
}
