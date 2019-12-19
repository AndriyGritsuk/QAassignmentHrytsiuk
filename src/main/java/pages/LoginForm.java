package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginForm extends BasePage {

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    private By loginUsernameField = By.xpath("//input[@id='loginUsername']");
    private By loginPasswordField = By.xpath("//input[@id='loginPassword']");
    private By signInButton = By.xpath("//button[@class='AnimatedForm__submitButton']");
    private By loginUsernameClick = By.xpath("//fieldset[contains(@class,'login')]");
    private By frameName = By.xpath("//iframe[@src='https://www.reddit.com/login/']");

    public LoginForm switchIntoLoginFrame(){
        driver.switchTo().frame(findElement(frameName));
        return this;
    }

    public LoginForm clickLogIntoLoginField() {
        findElement(loginUsernameClick).click();
        return this;
    }

    public LoginForm fillUsernameField(String username) {
        findElement(loginUsernameField).sendKeys(username);
        return this;
    }

    public LoginForm fillPasswordField(String password) {
        findElement(loginPasswordField).sendKeys(password);
        return this;
    }

    public HomePage clickLogIn() {
        findElement(signInButton).click();
        return new HomePage(driver);
    }

    public HomePage login (){
        new HomePage(driver)
                .clickLogInButton()
                .switchIntoLoginFrame()
                .clickLogIntoLoginField()
                .fillUsernameField("atqc_test")
                .fillPasswordField("atqc_test")
                .clickLogIn();
        return new HomePage(driver);
    }

}
