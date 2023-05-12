package ESG.Spring.Boot.Project.Dto;

import ESG.Spring.Boot.Project.Entity.ReductiongoalMasterEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewGoalDto {

    private Integer id;

    private Integer rgInitiativesId;

    private String items;

    private String period;

    private String carbon;

    private String reductionGoalPercentage;

    private String reductionGoal;

    private String reductionStatus;

    private Timestamp targetDateFinish;

    private Timestamp targetDateStart;

    private String categoryIndex;

    private Integer status;

    private Timestamp createdDate;

    private Timestamp updatedDate;

//    private String createdBy;

    private String updatedBy;

//    private Integer reductionGoalMasterId;

    private String reductionAchieved;

    private String reductionRemaining;

    private String description;

    private ReductiongoalMasterDto reductiongoalMasterByReductiongoalMasterId;
}
