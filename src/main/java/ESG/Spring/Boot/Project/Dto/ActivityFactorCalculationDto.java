package ESG.Spring.Boot.Project.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityFactorCalculationDto {

    private Integer id;
    private String name;
//    private Integer categoryIndex;
//    private Integer subcategoryIndex;
    private String factorDetail;
    private String description;
//    private Integer activityIndex;
//    private Integer tagIndex;
//    private Integer gasIndex;
//    private Integer gasUnitIndex;
    private String gasFactor;
    private String consumption;
    private String consumptionUnit;
    private String tco2;
    private String status;
    private Timestamp createdDate;
    private String created_by;
    private Timestamp updatedDate;
    private String updatedBy;
//    private Integer standardIndex;
    private String scope;
    private AddEmissionCategoryDto addEmissionCategoryByCategoryIndex;
    private EmmisionSubCategoryDto emmisionSubCategoryBySubcategoryIndex;
    private ActivityDto activityByActivityIndex;
    private AddTagsDto addTagsByTagIndex;
    private GhgGasesDto ghgGasesByGasIndex;
    private GasUnitDto gasUnitByGasUnitIndex;
    private AddStandardDto addStandardByStandardIndex;


}
