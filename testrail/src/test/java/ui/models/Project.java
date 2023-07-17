package ui.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {

    private String projectName;
    private String milestoneName;
    private String milestoneReference;
    private String milestoneDescription;
    private String sectionName;
    private String sectionDescription;
    private String testCaseTitle;
    private String testCaseTemplate;
    private String testCaseType;
    private String testCasePriority;
}
