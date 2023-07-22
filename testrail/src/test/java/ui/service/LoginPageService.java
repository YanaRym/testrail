package ui.service;

import io.qameta.allure.Step;
import ui.models.User;
import ui.pages.DashboardPage;
import ui.pages.LoginPage;

import static ui.constatns.PageUrls.LOGIN_PAGE;

public class LoginPageService {

    private final LoginPage loginPage = new LoginPage();

    @Step("Login with 'Keep me logged in' button ticked")
    public void loginWithKeepMeLogged(User user) {
        loginPage.openLoginPage(LOGIN_PAGE)
                .fillInEmailField(user.getEmail())
                .fillInPasswordField(user.getPassword())
                .clickLoginButton();
    }

    @Step("Login with 'Keep me logged in' button unticked")
    public void loginWithoutKeepMeLogged(User user) {
        loginPage.openLoginPage(LOGIN_PAGE);
        if (!loginPage.isKeepMeLoggedInChecked()) {
            loginPage.keepMeLoggedInClick();
        }
        loginPage.fillInEmailField(user.getEmail())
                .fillInPasswordField(user.getPassword())
                .clickLoginButton();
    }

    @Step("Check if login is complete")
    public boolean isLoginComplete() {
        DashboardPage dashboardPage = new DashboardPage();
        return dashboardPage.isUsernameDisplayed();
    }

    @Step("Check if no email message is displayed")
    public boolean isNoEmailErrorDisplayed() {
        return loginPage.isEmailErrorDisplayed();
    }

    @Step("Check if no password message is displayed")
    public boolean isNoPasswordErrorDisplayed() {
        return loginPage.isPasswordErrorDisplayed();
    }

    @Step("Check if no credentials message is displayed")
    public boolean isNoCredentialsErrorDisplayed() {
        return loginPage.isWrongCredentialsErrorDisplayed();
    }
}
