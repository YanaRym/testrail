package ui.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.models.User;
import ui.service.LoginPageService;
import utilities.TestDataGenerator;

import static ui.constatns.DefaultUserInfo.DEFAULT_EMAIL;
import static ui.constatns.DefaultUserInfo.DEFAULT_PASSWORD;

public class LoginPageTest extends BaseTest {

    private LoginPageService loginPageService;

    @BeforeClass()
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    @Test(description = "This test logs user in with keeping logged in")
    @Description(value = "Log in user with 'Keep me logged'")
    public void loginWithKeepMeLoggedTest() {
        User user = User.builder()
                .email(DEFAULT_EMAIL)
                .password(DEFAULT_PASSWORD)
                .build();
        loginPageService.loginWithKeepMeLogged(user);
        Assert.assertTrue(loginPageService.isLoginComplete(),
                "Login failed.");
    }

    @Test(description = "This test logs user in without keeping logged in")
    @Description(value = "Log in user without 'Keep me logged'")
    public void loginWithoutKeepLoggedTest() {
        User user = User.builder()
                .email(DEFAULT_EMAIL)
                .password(DEFAULT_PASSWORD)
                .build();
        loginPageService.loginWithoutKeepMeLogged(user);
        Assert.assertTrue(loginPageService.isLoginComplete(),
                "Login failed.");
    }

    @Test(description = "This test logs user in without email")
    @Description(value = "Log in user without email")
    public void loginWithNoEmailTest() {
        User user = User.builder()
                .email("")
                .password(DEFAULT_PASSWORD)
                .build();
        loginPageService.loginWithKeepMeLogged(user);
        Assert.assertTrue(loginPageService.isNoEmailErrorDisplayed(),
                "Error isn't displayed.");
    }

    @Test(description = "This test logs user in without password")
    @Description(value = "Log in user without password")
    public void loginWithNoPasswordTest() {
        User user = User.builder()
                .email(DEFAULT_EMAIL)
                .password("")
                .build();
        loginPageService.loginWithKeepMeLogged(user);
        Assert.assertTrue(loginPageService.isNoPasswordErrorDisplayed(),
                "Error isn't displayed.");
    }

    @Test(description = "This test logs user in with incorrect email")
    @Description(value = "Log in user with wrong email")
    public void loginWithWrongEmailTest() {
        User user = User.builder()
                .email(TestDataGenerator.getRandomEmail())
                .password(DEFAULT_PASSWORD)
                .build();
        loginPageService.loginWithKeepMeLogged(user);
        Assert.assertTrue(loginPageService.isNoCredentialsErrorDisplayed(),
                "Error isn't displayed.");
    }

    @Test(description = "This test logs user in with incorrect password")
    @Description(value = "Log in user with wrong password")
    public void loginWithWrongPasswordTest() {
        User user = User.builder()
                .email(DEFAULT_EMAIL)
                .password(TestDataGenerator.getRandomPassword())
                .build();
        loginPageService.loginWithKeepMeLogged(user);
        Assert.assertTrue(loginPageService.isNoCredentialsErrorDisplayed(),
                "Error isn't displayed.");
    }
}
