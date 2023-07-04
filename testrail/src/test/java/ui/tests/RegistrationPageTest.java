package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.models.User;
import ui.service.RegistrationPageService;

public class RegistrationPageTest extends BaseTest {

    private RegistrationPageService registrationPageService;

    @BeforeClass()
    public void setUp() {
        registrationPageService = new RegistrationPageService();
    }

    @Test
    public void createNewAccount() {
        User user = User.builder()
                .firstName("Thomas")
                .lastName("Clark")
                .email("rymsha.yana@mail.ru")
                .companyName("TY")
                .phone("3456789")
                .address("ty4")
                .country("Italy")
                .numberOfUsers("1")
                .build();
        registrationPageService.createNewAccount(user);
        Assert.assertTrue(registrationPageService.isAccountCreated());
    }
}
