package ui.service;

import ui.models.User;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;

import static ui.constatns.PageUrls.TESTRAIL_LOGIN_PAGE;

public class LoginPageService {

    public void loginWithKeepMeLogged(User user) {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage(TESTRAIL_LOGIN_PAGE)
                .fillInEmailField(user.getEmail())
                .fillInPasswordField(user.getPassword())
                .clickLoginButton();
    }

    public void loginWithoutKeepMeLogged(User user) {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage(TESTRAIL_LOGIN_PAGE);
        if (!loginPage.isKeepMeLoggedInChecked()) {
            loginPage.keepMeLoggedInClick();
        }
        loginPage.fillInEmailField(user.getEmail())
                .fillInPasswordField(user.getPassword())
                .clickLoginButton();
    }

    public boolean isLoginComplete() {
        DashboardPage dashboardPage = new DashboardPage();
        return dashboardPage.isUsernameDisplayed();
    }

    public boolean isNoEmailErrorDisplayed() {
        LoginPage loginPage = new LoginPage();
        return loginPage.isEmailErrorDisplayed();
    }

    public boolean isNoPasswordErrorDisplayed() {
        LoginPage loginPage = new LoginPage();
        return loginPage.isPasswordErrorDisplayed();
    }

    public boolean isNoCredentialsErrorDisplayed() {
        LoginPage loginPage = new LoginPage();
        return loginPage.isWrongCredentialsErrorDisplayed();
    }
}
