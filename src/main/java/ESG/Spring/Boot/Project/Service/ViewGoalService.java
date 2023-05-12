package ESG.Spring.Boot.Project.Service;

import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Dto.ViewGoalDto;
import ESG.Spring.Boot.Project.Repository.ViewGoalRepo;

import java.util.List;

public interface ViewGoalService {


    public ResponceDto<String> save(ViewGoalDto viewGoalDto);

    public ResponceDto<String> update (ViewGoalDto viewGoalDto);

    public ResponceDto<String> delete(Integer id);

    public ResponceDto<ViewGoalDto> findOne(Integer id);

    public ResponceDto<List<ViewGoalDto>> findAll();




}
