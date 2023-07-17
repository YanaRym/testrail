package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestRunPage extends BasePage{

    @FindBy (xpath = "//div[@id='milestone_id_chzn']")
    private WebElement milestoneListField;
    @FindBy (xpath = "//li[contains(text(), '%s')]")
    private WebElement milestone;


}
