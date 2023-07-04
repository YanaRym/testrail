package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.models.User;
import ui.service.LoginPageService;
import utilities.TestDataGenerator;

public class LoginPageTest extends BaseTest {

    private LoginPageService loginPageService;

    @BeforeClass()
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    @Test
    public void loginWithKeepMeLoggedTest() {
        User user = User.builder()
                .email("yvukac@mailto.plus")
                .password("4444Jane!")
                .build();
        loginPageService.loginWithKeepMeLogged(user);
        Assert.assertTrue(loginPageService.isLoginComplete());
    }

    @Test
    public void loginWithoutKeepLoggedTest() {
        User user = User.builder()
                .email("yvukac@mailto.plus")
                .password("4444Jane!")
                .build();
        loginPageService.loginWithoutKeepMeLogged(user);
        Assert.assertTrue(loginPageService.isLoginComplete());
    }

    @Test
    public void loginWithNoEmailTest() {
        User user = User.builder()
                .email("")
                .password("4444Jane!")
                .build();
        loginPageService.loginWithKeepMeLogged(user);
        Assert.assertTrue(loginPageService.isNoEmailErrorDisplayed());
    }

    @Test
    public void loginWithNoPasswordTest() {
        User user = User.builder()
                .email("yvukac@mailto.plus")
                .password("")
                .build();
        loginPageService.loginWithKeepMeLogged(user);
        Assert.assertTrue(loginPageService.isNoPasswordErrorDisplayed());
    }

    @Test
    public void loginWithWrongEmailTest() {
        User user = User.builder()
                .email(TestDataGenerator.getRandomEmail())
                .password("4444Jane!")
                .build();
        loginPageService.loginWithKeepMeLogged(user);
        Assert.assertTrue(loginPageService.isNoCredentialsErrorDisplayed());
    }

    @Test
    public void loginWithWrongPasswordTest() {
        User user = User.builder()
                .email("yvukac@mailto.plus")
                .password(TestDataGenerator.getRandomPassword())
                .build();
        loginPageService.loginWithKeepMeLogged(user);
        Assert.assertTrue(loginPageService.isNoCredentialsErrorDisplayed());
    }
}
