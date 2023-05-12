package ESG.Spring.Boot.Project.Service;

import ESG.Spring.Boot.Project.Dto.OrganizationDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;

import java.util.List;

public interface OrganizationService {

    public ResponceDto<String> save(OrganizationDto organizationDto);
    public ResponceDto<String> update (OrganizationDto organizationDto);
    public ResponceDto<String> delete(Integer Id);
    public ResponceDto<List<OrganizationDto>> findAll();
    public ResponceDto<OrganizationDto> findById(Integer Id);




}
