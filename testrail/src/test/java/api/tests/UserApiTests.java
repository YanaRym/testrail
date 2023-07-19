package api.tests;

import api.adapters.UserAdapter;
import api.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestDataGenerator;

import static api.constants.ProjectsInfo.DEFAULT_USER_EMAIL;
import static java.net.HttpURLConnection.HTTP_OK;

public class UserApiTests {

    @Test
    public void addNewUserTest() {
        User user = User.builder()
                .name(TestDataGenerator.getRandomFullName())
                .email(TestDataGenerator.getRandomEmail())
                .build();
        int statusCode = new UserAdapter().addUser(user).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test
    public void getUsersTest() {
        int statusCode = new UserAdapter().getUsers().statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test
    public void getUserByEmailTest() {
        int statusCode = new UserAdapter().getUserByEmail(DEFAULT_USER_EMAIL).statusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }
}
