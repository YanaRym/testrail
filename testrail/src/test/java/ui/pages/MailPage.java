package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

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
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);
        return this;
    }

    @Step("Click 'Login' button")
    public MailPage clickLogin() {
        waitElementToBeClickable(loginButton).click();
        return this;
    }
    @Step("Fill in email field")
    public MailPage fillInUsernameField(String emailUsername) {
        driver.switchTo().frame(iframe);
        waitVisibilityOf(userNameInputField).sendKeys(emailUsername);
        return this;
    }
    @Step("Untick 'Remember me' checkbox")
    public MailPage uncheckRememberMe() {
        waitElementToBeClickable(rememberMeCheckbox).click();
        return this;
    }
    @Step("Click 'Enter password' button")
    public MailPage clickEnterPasswordButton() {
        waitElementToBeClickable(enterPasswordButton).click();
        return this;
    }
    @Step("Fill in password field")
    public MailPage fillInPasswordField(String emailPassword) {
        waitVisibilityOf(passwordInputField).sendKeys(emailPassword);
        return this;
    }
    @Step("Click 'Enter' button")
    public void clickEnter() {
        waitElementToBeClickable(enterButton).click();
    }
    @Step("Open confirmation message")
    public MailPage openMessage() {
        waitVisibilityOf(messageLink).click();
        return this;
    }
    @Step("Click confirmation link")
    public MailPage clickConfirm() {
        waitElementToBeClickable(confirmationLink).click();
        return this;
    }
}
