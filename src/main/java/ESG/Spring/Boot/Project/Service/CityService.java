package ESG.Spring.Boot.Project.Service;

import ESG.Spring.Boot.Project.Dto.CityDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;

import java.util.List;

public interface CityService {

    public ResponceDto<String> save(CityDto cityDto);
    public ResponceDto<String>update(CityDto cityDto);
    public ResponceDto<String>delete(Integer id);
    public ResponceDto<CityDto> findById(Integer id);
    public ResponceDto<List<CityDto>> findAll();

}
