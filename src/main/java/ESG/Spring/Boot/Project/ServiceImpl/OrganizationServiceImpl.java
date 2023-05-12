package ESG.Spring.Boot.Project.ServiceImpl;

import ESG.Spring.Boot.Project.Dto.OrganizationDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Entity.AddOrganizationEntity;
import ESG.Spring.Boot.Project.Repository.OrganizationRepo;
import ESG.Spring.Boot.Project.Service.OrganizationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
  @Autowired
  private OrganizationRepo organizationRepo;


    @Override
    public ResponceDto<String> save(OrganizationDto organizationDto) {
        ResponceDto<String> responceDto=new ResponceDto<>();
        try {
            AddOrganizationEntity organizationEntity=new AddOrganizationEntity();
            BeanUtils.copyProperties(organizationDto,organizationEntity);
           organizationEntity.setCreatedDate((Timestamp) new Date());
           organizationEntity.setstatus("1");
            organizationRepo.save(organizationEntity);
        responceDto.setStatusCode(HttpStatus.OK.toString());
        responceDto.setMessage(organizationEntity.getOrganizationName()+" created Successfully");

        }

        catch (Exception e){
            responceDto.setMessage("Organization Is Not Created");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());

        }

        return responceDto;
    }

    @Override
    public ResponceDto<String> update(OrganizationDto organizationDto) {
        ResponceDto<String> responceDto=new ResponceDto<>();
        try {
            AddOrganizationEntity organizationEntity=organizationRepo.findById(organizationDto.getId()).orElseThrow();
            BeanUtils.copyProperties(organizationDto,organizationEntity);
            organizationEntity.setUpdatedDate((Timestamp) new Date());
            organizationRepo.save(organizationEntity);
            responceDto.setMessage(organizationEntity.getOrganizationName()+" Updated Successfully");
            responceDto.setStatusCode(HttpStatus.OK.toString());
        }
        catch (Exception e){
            responceDto.setMessage("organization is not updated");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());

        }
        return responceDto;
    }

    @Override
    public ResponceDto<String> delete(Integer Id) {
        ResponceDto<String> responceDto =new ResponceDto<>();
        try {
            AddOrganizationEntity organizationEntity=organizationRepo.findByIdAndStatusNot(Id,"-1");
            if(organizationEntity==null){
                responceDto.setMessage("Not Exist");
                responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
                return responceDto;
            }
            organizationEntity.setstatus("-1");
            organizationRepo.save(organizationEntity);
            responceDto.setMessage(organizationEntity.getOrganizationName()+" Deleted Successfully");
            responceDto.setStatusCode(HttpStatus.OK.toString());
        }
        catch (Exception e){
            responceDto.setMessage("Organization is not deleted ");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());

        }
        return responceDto;
    }

    @Override
    public ResponceDto<List<OrganizationDto>> findAll() {
        ResponceDto<List<OrganizationDto>> responceDto=new ResponceDto<>();
        try {
            List<AddOrganizationEntity> organizationEntityList=organizationRepo.findByStatusNot("-1");

            List<OrganizationDto> organizationDtoList=new ArrayList<>();
            organizationEntityList.forEach(organizationEntity -> {
                OrganizationDto organizationDto=new OrganizationDto();
                BeanUtils.copyProperties(organizationEntity,organizationDto);
                organizationDtoList.add(organizationDto);
            });
            responceDto.setData(organizationDtoList);
            responceDto.setStatusCode(HttpStatus.OK.toString());
        }
        catch (Exception e){
            responceDto.setMessage("Organization List Not Found ");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }

        return responceDto;
    }

    @Override
    public ResponceDto<OrganizationDto> findById(Integer Id) {
        ResponceDto<OrganizationDto> responceDto=new ResponceDto<>();
        try {
            AddOrganizationEntity organizationEntity=organizationRepo.findByIdAndStatusNot(Id,"-1");
            if(organizationEntity==null){
                responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
                responceDto.setMessage("This Id Is Not Exist");
                return responceDto;
            }
            OrganizationDto organizationDto=new OrganizationDto();
            BeanUtils.copyProperties(organizationEntity,organizationDto);
            organizationRepo.save(organizationEntity);
            responceDto.setData(organizationDto);
            responceDto.setStatusCode(HttpStatus.OK.toString());

        }
        catch (Exception e){
            responceDto.setMessage("Organization not Found");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());

        }
        return responceDto;
    }
}
