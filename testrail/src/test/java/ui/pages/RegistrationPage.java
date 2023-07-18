package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static ui.constatns.PageUrls.TESTRAIL_CREATE_ACCOUNT_PAGE;

public class RegistrationPage extends BasePage {

    private final static Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(120);

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
    @FindBy(xpath = "//a[contains(text(), 'No, Thanks')]")
    private WebElement noCookiesButton;
    @FindBy(xpath = "//label[contains(text(), \"I'm new to TestRail\")]")
    private WebElement newToTestRailChoice;
    @FindBy(xpath = "//label[contains(text(), 'Software QA Engineer')]")
    private WebElement softwareQAChoice;
    @FindBy(xpath = "//label[contains(text(), 'Selenium')]")
    private WebElement seleniumChoice;
    @FindBy(xpath = "//button[contains(text(), 'Next')]")
    private WebElement nextButton;
    @FindBy(xpath = "//button[contains(text(), 'Done')]")
    private WebElement doneButton;


    @Step("Open registration page")
    public RegistrationPage openRegistrationPage() {
        driver.get(TESTRAIL_CREATE_ACCOUNT_PAGE);
        return this;
    }

    @Step("Fill in first name field")
    public RegistrationPage fillInFirstName(String firstName) {
        waitVisibilityOf(firstNameInputField).sendKeys(firstName);
        return this;
    }

    @Step("Fill in last name field")
    public RegistrationPage fillInLastName(String lastName) {
        waitVisibilityOf(lastNameInputField).sendKeys(lastName);
        return this;
    }

    @Step("Fill in email field")
    public RegistrationPage fillInEmail(String email) {
        waitVisibilityOf(emailInputField).sendKeys(email);
        return this;
    }

    @Step("Fill in phone number field")
    public RegistrationPage fillInPhone(String phone) {
        waitVisibilityOf(phoneInputField).sendKeys(phone);
        return this;
    }

    @Step("Fill in company name field")
    public RegistrationPage fillInCompanyName(String companyName) {
        waitVisibilityOf(companyNameInputField).sendKeys(companyName);
        return this;
    }

    @Step("Fill in country field")
    public RegistrationPage fillInCountry(String country) {
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText(country);
        return this;
    }

    @Step("Choose number of workers")
    public RegistrationPage fillInNumberOfWorkers(String numberOfUsers) {
        Select selectNumberOfUsers = new Select(numberOfUsersDropdown);
        selectNumberOfUsers.selectByVisibleText(numberOfUsers);
        return this;
    }

    @Step("Fill in web address field")
    public RegistrationPage fillInWebAddress(String address) {
        waitVisibilityOf(webAddressInputField).sendKeys(address);
        return this;
    }

    @Step("Agree to the terms of service")
    public RegistrationPage checkIAgreeCheckbox() {
        waitVisibilityOf(iAgreeCheckbox).click();
        return this;
    }

    @Step("Do not accept cookies")
    public RegistrationPage clickNoCookiesButton() {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.visibilityOf(noCookiesButton)).click();
        return this;
    }

    @Step("Click 'Create account'")
    public void clickCreateAccountButton() {
        waitElementToBeClickable(successButton).click();
    }

    @Step("Choose 'New to TestRail' option")
    public RegistrationPage clickNewToTestRailButton() {
        Set handles = driver.getWindowHandles();
        Object[] lastHandle = handles.toArray();
        driver.switchTo().window(lastHandle[lastHandle.length - 1].toString());
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        wait.until(ExpectedConditions.visibilityOf(newToTestRailChoice)).click();
        return this;
    }

    @Step("Choose 'Software QA Engineer' option")
    public RegistrationPage clickSoftwareQAButton() {
        waitElementToBeClickable(softwareQAChoice).click();
        return this;
    }

    @Step("Choose 'Selenium' option")
    public RegistrationPage clickSeleniumButton() {
        waitElementToBeClickable(seleniumChoice).click();
        return this;
    }

    @Step("Click 'Next' button")
    public RegistrationPage clickNextButton() {
        waitElementToBeClickable(nextButton).click();
        return this;
    }

    @Step("Click 'Done' button")
    public void clickDoneButton() {
        waitElementToBeClickable(doneButton).click();
    }

}
