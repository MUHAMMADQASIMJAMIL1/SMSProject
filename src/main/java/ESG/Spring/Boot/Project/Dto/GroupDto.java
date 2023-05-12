package ESG.Spring.Boot.Project.Dto;

import ch.qos.logback.core.model.INamedModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {
    private Integer id;
    private String groupName;
    private String status;
    private Date createdDate;
    private String createdBy;
}
