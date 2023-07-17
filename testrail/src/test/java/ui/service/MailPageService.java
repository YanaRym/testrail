package ui.service;

import io.qameta.allure.Step;
import ui.pages.MailPage;

import static ui.constatns.DefaultRegistrationInfo.EMAIL_PASSWORD;
import static ui.constatns.DefaultRegistrationInfo.EMAIL_USERNAME;
import static ui.constatns.PageUrls.EMAIL_URL;

public class MailPageService {


    @Step("Log in to email")
    public MailPageService login() {
        MailPage mailPage = new MailPage();
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
        MailPage mailPage = new MailPage();
        mailPage.openMessage()
                .clickConfirm();
    }
}
