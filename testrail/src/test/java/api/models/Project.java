package api.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {

    private String name;
    @SerializedName("id")
    private int projectId;
    private String announcement;
    @SerializedName("show_announcement")
    private boolean showAnnouncement;
}
