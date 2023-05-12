package ESG.Spring.Boot.Project.ServiceImpl;

import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Dto.StandardDto;
import ESG.Spring.Boot.Project.Entity.AddStandardEntity;
import ESG.Spring.Boot.Project.Repository.StandardRepo;
import ESG.Spring.Boot.Project.Service.StandardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StandardServiceImpl  implements StandardService {

@Autowired
private StandardRepo standardRepo;

    @Override
    public ResponceDto<String> save(StandardDto standardDto) {
        ResponceDto<String> responceDto=new ResponceDto<>();
        try {
            AddStandardEntity standardEntity=new AddStandardEntity();
            BeanUtils.copyProperties(standardDto,standardEntity);
            standardEntity.setStatus("1");
            standardEntity.setCreatedDate((Timestamp) new Date());
            standardRepo.save(standardEntity);
            responceDto.setStatusCode(HttpStatus.OK.toString());
            responceDto.setMessage(standardEntity.getStandardName()+" created Successfully");
        }
        catch (Exception e){
            responceDto.setMessage("Standard is not created");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }
        return responceDto;
    }

    @Override
    public ResponceDto<String> update(StandardDto standardDto) {
        ResponceDto<String> responceDto=new ResponceDto<>();
        try {
            AddStandardEntity standardEntity=standardRepo.findById(standardDto.getId()).orElseThrow();
            BeanUtils.copyProperties(standardDto,standardEntity);
           standardEntity.setUpdatedDate((Timestamp) new Date());
            standardRepo.save(standardEntity);
            responceDto.setStatusCode(HttpStatus.OK.toString());
            responceDto.setMessage(standardEntity.getStandardName()+" updated Successfully");
        }
        catch (Exception e){
            responceDto.setMessage("Standard is not updated");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }
        return responceDto;
    }

    @Override
    public ResponceDto<String> delete(Integer id) {
        ResponceDto<String> responceDto=new ResponceDto<>();
        try {
            AddStandardEntity standardEntity=standardRepo.findByIdAndStatusNot(id,"-1");
            if(standardEntity==null){
                responceDto.setMessage("Not Exist");
                responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
                return responceDto;
            }
            standardEntity.setStatus("-1");
            standardRepo.save(standardEntity);
            responceDto.setStatusCode(HttpStatus.OK.toString());
            responceDto.setMessage(standardEntity.getStandardName()+" deleted Successfully");
        }
        catch (Exception e){
            responceDto.setMessage("Standard is not deleted");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }
        return responceDto;
    }

    @Override
    public ResponceDto<StandardDto> findById(Integer id) {
        ResponceDto<StandardDto> responceDto=new ResponceDto<>();
        try {
            AddStandardEntity standardEntity=standardRepo.findByIdAndStatusNot(id,"-1");
            if(standardEntity==null){
                responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
                responceDto.setMessage("This Id Is Not Exist");
                return responceDto;
            }

            StandardDto standardDto=new StandardDto();
            BeanUtils.copyProperties(standardEntity,standardDto);
            responceDto.setData(standardDto);
            responceDto.setStatusCode(HttpStatus.OK.toString());

        }
        catch (Exception e){
            responceDto.setMessage("Not find such id");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }
        return responceDto;
    }

    @Override
    public ResponceDto<List<StandardDto>> findAll() {
       ResponceDto<List<StandardDto>> responceDto=new ResponceDto<>();
       try {
           List<AddStandardEntity> standardEntityList=standardRepo.findByStatusNot("-1");
           List<StandardDto> standardDtoList=new ArrayList<>(standardEntityList.size());
           standardEntityList.forEach(standardEntity -> {
               StandardDto standardDto=new StandardDto();
               BeanUtils.copyProperties(standardEntity,standardDto);
               standardDtoList.add(standardDto);

           });
           responceDto.setStatusCode(HttpStatus.OK.toString());
           responceDto.setData(standardDtoList);
       }
       catch (Exception e){
           responceDto.setMessage("Not find any Standard");
           responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
       }
        return responceDto;
    }
}
