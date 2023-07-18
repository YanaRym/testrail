package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.models.User;
import ui.service.RegistrationPageService;

import static ui.constatns.DefaultRegistrationInfo.*;
import static ui.constatns.DefaultUserInfo.*;

@Story(value = "Registration page")
public class RegistrationPageTest extends BaseTest {

    private RegistrationPageService registrationPageService;

    @BeforeClass()
    public void setUp() {
        registrationPageService = new RegistrationPageService();
    }

    @Test(description = "This test signs user in")
    @Description(value = "Create new user account")
    public void createNewAccount() {
        User user = User.builder()
                .firstName(DEFAULT_FIRST_NAME)
                .lastName(DEFAULT_LAST_NAME)
                .email(DEFAULT_REGISTRATION_EMAIL)
                .companyName(DEFAULT_COMPANY_NAME)
                .phone(DEFAULT_PHONE_NUMBER)
                .address(DEFAULT_ADDRESS)
                .country(DEFAULT_COUNTRY)
                .numberOfUsers(DEFAULT_NUMBER_OF_USERS)
                .build();
        registrationPageService.createNewAccount(user);
        Assert.assertTrue(registrationPageService.isAccountCreated(),
                "Registration failed.");
    }
}
