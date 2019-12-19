package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.LocalDateTime;

public class Subreddits extends BasePage {

    public Subreddits(WebDriver driver) {
        super(driver);
    }

    private By votes = By.xpath("//button [@class='voteButton ']/following-sibling::div");
    private By upVote = By.xpath("//button [@aria-label='upvote']");
    private By downVote = By.xpath("//button [@aria-label='downvote']");
    private By commentButton = By.xpath("//*[@data-click-id='comments']");
    private By textBox = By.xpath("//*[@role='textbox']");
    private By textBoxCommentButton = By.xpath("//button[text()='comment']");

    public Subreddits clickTextBoxCommentButton() {
        findElement(textBoxCommentButton).click();
        return this;
    }

    public void verifyTextBox(){
        boolean isTextBoxEmpty = findElement(textBox).getText().isEmpty();
        Assert.assertFalse(isTextBoxEmpty);
    }

    public Subreddits fillTextBox() {
        LocalDateTime dateTime = LocalDateTime.now();
        findElement(textBox).sendKeys(dateTime + " atqc_test");
        return this;
    }

    public Subreddits clickCommentButton() {
        findElement(commentButton).click();
        return this;
    }

    public void verifyDownVote(){
        String countBefore = findElement(votes).getText();
        int countBeforeNumber = Integer.parseInt(countBefore);
        findElement(downVote).click();
        String countAfter = findElement(votes).getText();
        int countAfterNumber = Integer.parseInt(countAfter);
        Assert.assertTrue(countBeforeNumber > countAfterNumber);
    }

    public void verifyUpVote(){
        String countBefore = findElement(votes).getText();
        int countBeforeNumber = Integer.parseInt(countBefore);
        findElement(upVote).click();
        String countAfter = findElement(votes).getText();
        int countAfterNumber = Integer.parseInt(countAfter);
        Assert.assertTrue(countBeforeNumber < countAfterNumber);
    }

    public void verifyMySubredditIsShown() {
        String Url = driver.getCurrentUrl();
        Assert.assertTrue(Url.equals("https://www.reddit.com/r/java/"));
    }


}
