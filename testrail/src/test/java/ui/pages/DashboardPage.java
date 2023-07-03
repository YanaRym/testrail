package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy (xpath = "//span[@class=\"navigation-username\"]")
    private WebElement username;


    public boolean isUsernameDisplayed() {
        return waitVisibilityOf(username).isDisplayed();
    }
}
