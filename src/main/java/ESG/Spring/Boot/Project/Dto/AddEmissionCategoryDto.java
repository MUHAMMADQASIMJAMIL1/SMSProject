package ESG.Spring.Boot.Project.Dto;

import ESG.Spring.Boot.Project.Entity.ActivityFactorCalculationEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddEmissionCategoryDto {

    private Integer id;

    private String emmisionName;

    private Integer status;

    private String createdBy;

    private Timestamp createdDate;

    private String details;

    private String scope;

    private Set<ActivityFactorCalculationDto> activityFactorCalculationsById;
}
