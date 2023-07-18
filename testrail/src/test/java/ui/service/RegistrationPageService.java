package ui.service;

import io.qameta.allure.Step;
import ui.models.User;
import ui.pages.DashboardPage;
import ui.pages.RegistrationPage;

public class RegistrationPageService {

    @Step("Sign in")
    public void createNewAccount(User user) {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openRegistrationPage()
                .fillInFirstName(user.getFirstName())
                .fillInLastName(user.getLastName())
                .fillInEmail(user.getEmail())
                .fillInPhone(user.getPhone())
                .fillInCompanyName(user.getCompanyName())
                .fillInCountry(user.getCountry())
                .fillInNumberOfWorkers(user.getNumberOfUsers())
                .fillInWebAddress(user.getAddress())
                .checkIAgreeCheckbox()
                .clickNoCookiesButton()
                .clickCreateAccountButton();
        MailPageService mailLoginPageService = new MailPageService();
        mailLoginPageService.login()
                .confirmEmail();
        registrationPage.clickNewToTestRailButton().clickNextButton()
                .clickSoftwareQAButton().clickNextButton()
                .clickSeleniumButton().clickDoneButton();
    }

    @Step("Check if account is created")
    public boolean isAccountCreated() {
        DashboardPage dashboardPage = new DashboardPage();
        return dashboardPage.isUsernameDisplayed();
    }
}
