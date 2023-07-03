package ui.service;

import ui.models.User;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;

import static ui.constatns.PageUrls.TESTRAIL_LOGIN_PAGE;

public class LoginPageService {

    public DashboardPage login(User user) {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage(TESTRAIL_LOGIN_PAGE);
        loginPage.fillInEmailField(user.getEmail())
                .fillInPasswordField(user.getPassword())
                .clickLoginButton();
        return new DashboardPage();
    }

    public boolean isLoginComplete() {
        DashboardPage dashboardPage = new DashboardPage();
        return dashboardPage.isUsernameDisplayed();
    }
}
