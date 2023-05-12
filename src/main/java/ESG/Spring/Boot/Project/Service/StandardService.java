package ESG.Spring.Boot.Project.Service;

import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Dto.StandardDto;

import java.util.List;

public interface StandardService {

    ResponceDto<String> save(StandardDto standardDto);
    ResponceDto<String> update(StandardDto standardDto);
    ResponceDto<String> delete(Integer id);
    ResponceDto<StandardDto> findById(Integer id);
    ResponceDto<List<StandardDto>> findAll();

}
