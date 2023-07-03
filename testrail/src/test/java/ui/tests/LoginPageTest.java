package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.models.User;
import ui.service.LoginPageService;

public class LoginPageTest extends BaseTest {

    private LoginPageService loginPageService;

    @BeforeClass()
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    @Test
    public void loginTest() {
        User user = User.builder()
                        .email("rymsha.yana@mail.ru")
                                .password("3333Yana!")
                                        .build();
        loginPageService.login(user);
        Assert.assertTrue(loginPageService.isLoginComplete());
    }
}
