package ui.service;

import io.qameta.allure.Step;
import ui.pages.AddExampleProjectFieldsPage;

public class AddExampleProjectFieldsPageService {

    @Step("Add example project")
    public void addExampleProject(String projectName) {
        AddExampleProjectFieldsPage addExampleProjectFieldsPage = new AddExampleProjectFieldsPage();
        addExampleProjectFieldsPage.inputExampleProjectName(projectName).exampleProjectConfirmationButtonClick();
    }
}
