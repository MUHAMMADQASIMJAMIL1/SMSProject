package ESG.Spring.Boot.Project.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {

    private Integer Id;
    private String  organizationName;
    private String address;
    private String contact;
    private String email;
    private String industry;
    private String country;
    private String status;
    private String city;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;

}
