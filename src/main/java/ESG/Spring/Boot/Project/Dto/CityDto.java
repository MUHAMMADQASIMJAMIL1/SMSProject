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

public class CityDto {
    private  Integer id;
    private String cityName;
    private String status;
    private Date createdDate;
}
