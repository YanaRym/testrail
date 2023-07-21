package api.tests;

import api.adapters.UserAdapter;
import api.models.User;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestDataGenerator;

import static api.constants.ProjectsInfo.DEFAULT_USER_EMAIL;
import static java.net.HttpURLConnection.HTTP_OK;

@Story("Users management")
public class UserApiTests {

    private UserAdapter userAdapter;

    @BeforeClass
    public void setUp() {
        userAdapter = new UserAdapter();
    }

    @Test(description = "This test adds new user")
    @Description(value = "Add new user")
    public void checkNewUserCanBeAddedTest() {
        User user = User.builder()
                .name(TestDataGenerator.getRandomFullName())
                .email(TestDataGenerator.getRandomEmail())
                .build();
        int statusCode = userAdapter.addUser(user).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK,
                "Failed to add new user.");
    }

    @Test(description = "This test gets all users")
    @Description(value = "Get all users")
    public void checkStatusCodeOfGettingUsersTest() {
        int statusCode = userAdapter.getUsers().statusCode();
        Assert.assertEquals(statusCode, HTTP_OK,
                "Failed to get users.");
    }

    @Test(description = "This test gets a specific user by email")
    @Description(value = "Get user by email")
    public void checkUsersCanBeReachedByEmailTest() {
        int statusCode = userAdapter.getUserByEmail(DEFAULT_USER_EMAIL).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK,
                "Failed to get user by email.");
    }
}
