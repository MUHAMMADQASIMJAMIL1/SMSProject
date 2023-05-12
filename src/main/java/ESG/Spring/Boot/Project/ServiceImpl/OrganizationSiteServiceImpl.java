package ESG.Spring.Boot.Project.ServiceImpl;

import ESG.Spring.Boot.Project.Dto.OrganizationSiteDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Entity.OrganizationSiteEntity;
import ESG.Spring.Boot.Project.Repository.OrganizationSiteRepo;
import ESG.Spring.Boot.Project.Service.OrganizationSiteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrganizationSiteServiceImpl implements OrganizationSiteService {
    @Autowired
  private OrganizationSiteRepo organizationSiteRepo;

    @Override
    public ResponceDto<String> save(OrganizationSiteDto organizationSiteDto) {
        ResponceDto<String> responceDto = new ResponceDto<>();
        try {
            OrganizationSiteEntity organizationSiteEntity=new OrganizationSiteEntity();
            BeanUtils.copyProperties(organizationSiteDto, organizationSiteEntity);
            organizationSiteEntity.setStatus("1");
            organizationSiteEntity.setCreatedDate(String.valueOf(new Date()));
            organizationSiteRepo.save(organizationSiteEntity);
            responceDto.setStatusCode(HttpStatus.OK.toString());
            responceDto.setMessage(organizationSiteEntity.getOrgSiteName() + " is Created successfully");
        } catch (Exception e) {
            responceDto.setMessage("Site Is not created");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }
        return responceDto;
    }

    @Override
    public ResponceDto<String> update(OrganizationSiteDto organizationSiteDto) {
        ResponceDto<String> responceDto = new ResponceDto<>();
        try {
            OrganizationSiteEntity organizationSiteEntity = organizationSiteRepo.findById(organizationSiteDto.getId()).orElseThrow();
            BeanUtils.copyProperties(organizationSiteDto, organizationSiteEntity);
            organizationSiteRepo.save(organizationSiteEntity);
            responceDto.setMessage(organizationSiteEntity.getOrgSiteName() + " updated successfully");
            responceDto.setStatusCode(HttpStatus.OK.toString());
        } catch (Exception e) {
            responceDto.setMessage("Site is not updated successfully");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());

        }
        return responceDto;
    }

    @Override
    public ResponceDto<String> delete(Integer id) {
        ResponceDto<String> responceDto = new ResponceDto<>();
        try {
            OrganizationSiteEntity organizationSiteEntity = organizationSiteRepo.findByIdAndStatusNot(id,"-1");
            if (organizationSiteEntity == null) {
                responceDto.setMessage("Not Exist");
                responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
                return responceDto;
            }
            organizationSiteEntity.setStatus("-1");
            organizationSiteRepo.save(organizationSiteEntity);
            responceDto.setMessage(organizationSiteEntity.getOrgSiteName() + " deleted successfully");
            responceDto.setStatusCode(HttpStatus.OK.toString());
        } catch (Exception e) {
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
            responceDto.setMessage("Site is not Deleted");
        }

        return responceDto;
    }

    @Override
    public ResponceDto<OrganizationSiteDto> findById(Integer id) {
        ResponceDto<OrganizationSiteDto> responceDto = new ResponceDto<>();
        try {

            OrganizationSiteEntity organizationSiteEntity = organizationSiteRepo.findByIdAndStatusNot(id,"-1");
           if(organizationSiteEntity==null){
               responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
               responceDto.setMessage("This id is not present");
           return responceDto;
           }
            OrganizationSiteDto organizationSiteDto = new OrganizationSiteDto();
            BeanUtils.copyProperties(organizationSiteEntity, organizationSiteDto);
            responceDto.setData(organizationSiteDto);
            responceDto.setStatusCode(HttpStatus.OK.toString());
        } catch (Exception e) {
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
            responceDto.setMessage("Not find such id");
        }
        return responceDto;
    }

    @Override
    public ResponceDto<List<OrganizationSiteDto>> findAll() {
        ResponceDto<List<OrganizationSiteDto>> responceDto = new ResponceDto<>();
        try {
            List<OrganizationSiteEntity> organizationSiteEntitylist = organizationSiteRepo.findByStatusNot("-1");
            List<OrganizationSiteDto> organizationSiteDtoList = new ArrayList<>(organizationSiteEntitylist.size());
            organizationSiteEntitylist.forEach(organizationSiteEntity -> {
                OrganizationSiteDto organizationSiteDto = new OrganizationSiteDto();
                BeanUtils.copyProperties(organizationSiteEntity, organizationSiteDto);
                organizationSiteDtoList.add(organizationSiteDto);
            });
            responceDto.setStatusCode(HttpStatus.OK.toString());
            responceDto.setData(organizationSiteDtoList);
        } catch (Exception e) {
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
            responceDto.setMessage("Not found  site");
        }


        return responceDto;
    }
}
