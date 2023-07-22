package ui.service;

import io.qameta.allure.Step;
import ui.pages.MailPage;

import static ui.constatns.DefaultRegistrationInfo.EMAIL_PASSWORD;
import static ui.constatns.DefaultRegistrationInfo.EMAIL_USERNAME;
import static ui.constatns.PageUrls.EMAIL_URL;

public class MailPageService {

    private final MailPage mailPage = new MailPage();

    @Step("Log in to email")
    public MailPageService login() {
        mailPage.open(EMAIL_URL)
                .clickLogin()
                .fillInUsernameField(EMAIL_USERNAME)
                .uncheckRememberMe()
                .clickEnterPasswordButton()
                .fillInPasswordField(EMAIL_PASSWORD)
                .clickEnter();
        return this;
    }

    @Step("Confirm email address")
    public void confirmEmail() {
        mailPage.openMessage()
                .clickConfirm();
    }
}
