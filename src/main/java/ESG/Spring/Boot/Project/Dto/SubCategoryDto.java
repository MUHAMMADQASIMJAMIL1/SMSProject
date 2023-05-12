package ESG.Spring.Boot.Project.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryDto {
    private Integer id;
    private String emmisionSubName;
    private String description;
    private String co2;
    private String co2Unit;
    private String ch4;
    private String ch4Unit;
    private String ch;
    private String chUnit;
    private String inputUnit;
    private Date emmisionDate;
    private String status;
    private Integer tid;
    private String n2O;
    private String n2OUnit;
    private String hfcs;
    private String hfcsUnit;
    private String pfcs;
    private String pfcsUnit;
    private String sf6;
    private String sf6Unit;
    private String nf3;
    private String nf3Unit;
    private String emmissionId;
    private String scope;
    private String level1;
    private String level2;
    private String level3;
    private String level4;
    private String columnText;
    private String uomS;
    private String uom;
    private String ghg;
    private String lookupValid;
    private Double ghgConversionFactor2021;
    private String source;
    private String country;
    private String vintage;
    private String emissionGroup;
    private String standardId;
    private String year;


}
