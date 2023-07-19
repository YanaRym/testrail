package api.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Milestone {

    private String name;
    private String description;
    @SerializedName("milestone_id")
    private int milestoneId;
    @SerializedName("start_on")
    private int startOn;


}
