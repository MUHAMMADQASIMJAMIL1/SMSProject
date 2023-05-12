package ESG.Spring.Boot.Project.Service;

import ESG.Spring.Boot.Project.Dto.ActivityFactorCalculationDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;

import java.util.List;

public interface ActivityFactorCalculationService {


    ResponceDto<String> save(ActivityFactorCalculationDto createGoalDto);
    ResponceDto<String> update(ActivityFactorCalculationDto createGoalDto);
    ResponceDto<String> delete(Integer id);
    ResponceDto<ActivityFactorCalculationDto> findById(Integer id);
    ResponceDto<List<ActivityFactorCalculationDto>> findAll();


}
