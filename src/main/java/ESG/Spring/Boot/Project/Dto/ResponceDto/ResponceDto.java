package ESG.Spring.Boot.Project.Dto.ResponceDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponceDto <T>{
    private T data;
    private String message;
    private String statusCode;



}
