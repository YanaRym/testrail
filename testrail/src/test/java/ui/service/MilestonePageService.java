package ui.service;

import io.qameta.allure.Step;
import ui.models.Project;
import ui.pages.MilestonePage;

public class MilestonePageService {

    @Step("Create milestone")
    public ProjectPageService fillInMilestoneInfo(Project project) {
        MilestonePage milestonePage = new MilestonePage();
        milestonePage.fillInMilestoneNameField(project.getMilestoneName())
                .fillInMilestoneReferenceField(project.getMilestoneReference())
                .fillInMilestoneDescriptionField(project.getMilestoneDescription())
                .clickAddMilestoneButton();
        return new ProjectPageService();
    }

}
