package ESG.Spring.Boot.Project.Service;

import ESG.Spring.Boot.Project.Dto.GroupDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;

import java.util.List;

public interface GroupService {

    ResponceDto<String> save(GroupDto groupDto);
    ResponceDto<String> update(GroupDto groupDto);
    ResponceDto<String> delete(Integer id);
    ResponceDto<GroupDto> findById(Integer id);
    ResponceDto<List<GroupDto>> findAll();


}
