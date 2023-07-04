package ui.service;

import ui.models.User;
import ui.pages.DashboardPage;
import ui.pages.RegistrationPage;

public class RegistrationPageService {

    public void createNewAccount(User user) {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openRegistrationPage();
        registrationPage.fillInFirstName(user.getFirstName())
                .fillInLastName(user.getLastName())
                .fillInEmail(user.getEmail())
                .fillInPhone(user.getPhone())
                .fillInCompanyName(user.getCompanyName())
                .fillInCountry(user.getCountry())
                .fillInNumberOfWorkers(user.getNumberOfUsers())
                .fillInWebAddress(user.getAddress())
                .checkIAgreeCheckbox()
                .clickCreateAccountButton();
    }

    public boolean isAccountCreated() {
        DashboardPage dashboardPage = new DashboardPage();
        return dashboardPage.isUsernameDisplayed();
    }
}
