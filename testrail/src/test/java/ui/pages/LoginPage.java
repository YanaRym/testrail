package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='name']")
    private WebElement emailInputField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInputField;
    @FindBy(xpath = "//button[@id='button_primary']")
    private WebElement loginButton;
    @FindBy(xpath = "//span[@class='loginpage-checkmark']")
    private WebElement keepMeLoggedInCheckmark;
    @FindBy(xpath = "//div[contains (text(), \"Email/Login is required\")]")
    private WebElement noEmailErrorMessage;
    @FindBy(xpath = "//div[contains (text(), \"Password is required\")]")
    private WebElement noPasswordErrorMessage;
    @FindBy(xpath = "//div[contains (text(), \"incorrect\")]")
    private WebElement wrongCredentialsErrorMessage;

    @Step("Open login page")
    public LoginPage openLoginPage(String url) {
        log.info("Open login page");
        driver.get(url);
        return this;
    }

    @Step("Fill in email field")
    public LoginPage fillInEmailField(String email) {
        log.info("Fill in email");
        waitVisibilityOf(emailInputField).sendKeys(email);
        return this;
    }

    @Step("Fill in password field")
    public LoginPage fillInPasswordField(String password) {
        log.info("Fill in password");
        waitVisibilityOf(passwordInputField).sendKeys(password);
        return this;
    }

    @Step("Click 'Login' button")
    public void clickLoginButton() {
        log.info("Click login");
        waitElementToBeClickable(loginButton).click();
    }

    @Step("Check if 'Keep me logged in' checkbox is ticked")
    public boolean isKeepMeLoggedInChecked() {
        log.info("Check 'Keep me logged' is ticked");
        return waitElementToBeClickable(keepMeLoggedInCheckmark).isSelected();
    }

    @Step("Tick 'Keep me logged in' checkbox")
    public void clickKeepMeLoggedIn() {
        log.info("Click keep me logged");
        waitElementToBeClickable(keepMeLoggedInCheckmark).click();
    }

    @Step("Check if no email message is displayed")
    public boolean isEmailErrorDisplayed() {
        log.info("Check error message is displayed");
        return waitVisibilityOf(noEmailErrorMessage).isDisplayed();
    }

    @Step("check if no password message is displayed")
    public boolean isPasswordErrorDisplayed() {
        log.info("Check error message is displayed");
        return waitVisibilityOf(noPasswordErrorMessage).isDisplayed();
    }

    @Step("Check if wrong credentials error message is displayed")
    public boolean isWrongCredentialsErrorDisplayed() {
        log.info("Check error message is displayed");
        return waitVisibilityOf(wrongCredentialsErrorMessage).isDisplayed();
    }
}
