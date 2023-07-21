package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class MailPage extends BasePage {

    @FindBy(xpath = "//button[@data-testid='enter-mail-primary']")
    private WebElement loginButton;
    @FindBy(xpath = "//iframe[@class='ag-popup__frame__layout__iframe']")
    private WebElement iframe;
    @FindBy(xpath = "//input[@name='username']")
    private WebElement userNameInputField;
    @FindBy(xpath = "//div[@class='box-0-2-111 activeBox-0-2-116']")
    private WebElement rememberMeCheckbox;
    @FindBy(xpath = "//button[@data-test-id='next-button']")
    private WebElement enterPasswordButton;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInputField;
    @FindBy(xpath = "//button[@data-test-id='submit-button']")
    private WebElement enterButton;
    @FindBy(xpath = "//span[@title='TestRail Team <contact@testrail.com>']/../..")
    private WebElement messageLink;
    @FindBy(xpath = "//a[contains(text(), 'Confirm Trial Registration')]")
    private WebElement confirmationLink;

    @Step("Open email")
    public MailPage open(String url) {
        log.info("Open mail page");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);
        return this;
    }

    @Step("Click 'Login' button")
    public MailPage clickLogin() {
        log.info("Click login");
        waitElementToBeClickable(loginButton).click();
        return this;
    }

    @Step("Fill in email field")
    public MailPage fillInUsernameField(String emailUsername) {
        log.info("Fill in username");
        driver.switchTo().frame(iframe);
        waitVisibilityOf(userNameInputField).sendKeys(emailUsername);
        return this;
    }

    @Step("Untick 'Remember me' checkbox")
    public MailPage uncheckRememberMe() {
        log.info("Untick 'Remember me'");
        waitElementToBeClickable(rememberMeCheckbox).click();
        return this;
    }

    @Step("Click 'Enter password' button")
    public MailPage clickEnterPasswordButton() {
        log.info("Click enter password");
        waitElementToBeClickable(enterPasswordButton).click();
        return this;
    }

    @Step("Fill in password field")
    public MailPage fillInPasswordField(String emailPassword) {
        log.info("Fill in password");
        waitVisibilityOf(passwordInputField).sendKeys(emailPassword);
        return this;
    }

    @Step("Click 'Enter' button")
    public void clickEnter() {
        log.info("Click enter");
        waitElementToBeClickable(enterButton).click();
    }

    @Step("Open confirmation message")
    public MailPage openMessage() {
        log.info("Open registration message");
        waitVisibilityOf(messageLink).click();
        return this;
    }

    @Step("Click confirmation link")
    public MailPage clickConfirm() {
        log.info("Confirm email address");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", confirmationLink);
        return this;
    }
}
