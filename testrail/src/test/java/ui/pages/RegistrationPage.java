package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static ui.constatns.PageUrls.TESTRAIL_CREATE_ACCOUNT_PAGE;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstNameInputField;

    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastNameInputField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneInputField;

    @FindBy(xpath = "//input[@id='organization']")
    private WebElement companyNameInputField;

    @FindBy(xpath = "//select[@class='addressCountry form-control']")
    private WebElement countryDropdown;

    @FindBy(xpath = "//select[@id='users']")
    private WebElement numberOfUsersDropdown;

    @FindBy(xpath = "//input[@id='hostname']")
    private WebElement webAddressInputField;

    @FindBy(xpath = "//input[@id='tos']")
    private WebElement iAgreeCheckbox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement successButton;


    public RegistrationPage openRegistrationPage() {
        driver.get(TESTRAIL_CREATE_ACCOUNT_PAGE);
        return this;
    }

    public RegistrationPage fillInFirstName(String firstName) {
        waitVisibilityOf(firstNameInputField).sendKeys(firstName);
        return this;
    }

    public RegistrationPage fillInLastName(String lastName) {
        waitVisibilityOf(lastNameInputField).sendKeys(lastName);
        return this;
    }

    public RegistrationPage fillInEmail(String email) {
        waitVisibilityOf(emailInputField).sendKeys(email);
        return this;
    }

    public RegistrationPage fillInPhone(String phone) {
        waitVisibilityOf(phoneInputField).sendKeys(phone);
        return this;
    }

    public RegistrationPage fillInCompanyName(String companyName) {
        waitVisibilityOf(companyNameInputField).sendKeys(companyName);
        return this;
    }

    public RegistrationPage fillInCountry(String country) {
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText(country);
        return this;
    }

    public RegistrationPage fillInNumberOfWorkers(String numberOfUsers) {
        Select selectNumberOfUsers = new Select(numberOfUsersDropdown);
        selectNumberOfUsers.selectByVisibleText(numberOfUsers);
        return this;
    }

    public RegistrationPage fillInWebAddress(String address) {
        waitVisibilityOf(webAddressInputField).sendKeys(address);
        return this;
    }

    public RegistrationPage checkIAgreeCheckbox() {

        waitVisibilityOf(iAgreeCheckbox).click();
        return this;
    }

    public void clickCreateAccountButton() {
        waitElementToBeClickable(successButton).click();
    }
}
