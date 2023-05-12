package ESG.Spring.Boot.Project.Service;

import ESG.Spring.Boot.Project.Dto.OrganizationSiteDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;

import java.util.List;

public interface OrganizationSiteService {

    public ResponceDto<String> save(OrganizationSiteDto organizationSiteDto);
    public ResponceDto<String> update(OrganizationSiteDto organizationSiteDto);
    public ResponceDto<String> delete(Integer id);
    public ResponceDto<OrganizationSiteDto> findById(Integer id);
    public ResponceDto<List<OrganizationSiteDto>> findAll();

}
