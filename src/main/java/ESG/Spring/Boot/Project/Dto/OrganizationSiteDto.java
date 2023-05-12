package ESG.Spring.Boot.Project.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationSiteDto {

    private Integer id;
    private String orgSiteName;
    private String status;
    private Integer groupId;
    private Integer regionId;
    private Integer organizationId;
    private String locationAddress;
//    private String createdBy;
//    private Date createdDate;
    private String description;
    private String contactNo;
//    private Date updatedDate;
//    private String updatedBy;

}
