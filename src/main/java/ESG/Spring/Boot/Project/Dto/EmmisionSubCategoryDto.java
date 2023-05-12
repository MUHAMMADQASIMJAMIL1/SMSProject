package ESG.Spring.Boot.Project.Dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Member;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmmisionSubCategoryDto {
    private Integer id;
    private String emmisionSubName;


}
