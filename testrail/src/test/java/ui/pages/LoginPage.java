package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public LoginPage openLoginPage(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage fillInEmailField(String email) {
        waitVisibilityOf(emailInputField).sendKeys(email);
        return this;
    }

    public LoginPage fillInPasswordField(String password) {
        waitVisibilityOf(passwordInputField).sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        waitElementToBeClickable(loginButton).click();
    }

    public boolean isKeepMeLoggedInChecked() {
        return waitElementToBeClickable(keepMeLoggedInCheckmark).isSelected();
    }

    public void keepMeLoggedInClick() {
        waitElementToBeClickable(keepMeLoggedInCheckmark).click();
    }

    public boolean isEmailErrorDisplayed() {
        return waitVisibilityOf(noEmailErrorMessage).isDisplayed();
    }

    public boolean isPasswordErrorDisplayed() {
        return waitVisibilityOf(noPasswordErrorMessage).isDisplayed();
    }

    public boolean isWrongCredentialsErrorDisplayed() {
        return waitVisibilityOf(wrongCredentialsErrorMessage).isDisplayed();
    }
}
