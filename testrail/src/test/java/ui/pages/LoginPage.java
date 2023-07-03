package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy (xpath = "//input[@id='name']")
    private WebElement emailField;

    @FindBy (xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy (xpath = "//button[@id='button_primary']")
    private WebElement loginButton;

    public LoginPage openLoginPage (String url) {
        driver.get(url);
        return this;
    }

    public LoginPage fillInEmailField(String email) {
        waitVisibilityOf(emailField).sendKeys(email);
        return this;
    }

    public LoginPage fillInPasswordField(String password) {
        waitVisibilityOf(passwordField).sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        waitElementToBeClickable(loginButton).click();
    }
}
