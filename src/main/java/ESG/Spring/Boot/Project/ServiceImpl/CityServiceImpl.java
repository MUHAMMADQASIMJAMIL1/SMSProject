package ESG.Spring.Boot.Project.ServiceImpl;

import ESG.Spring.Boot.Project.Dto.CityDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Entity.AddCityEntity;
import ESG.Spring.Boot.Project.Repository.CityRepo;
import ESG.Spring.Boot.Project.Service.CityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepo cityRepo;
    @Override
    public ResponceDto<String> save(CityDto cityDto) {
        ResponceDto<String> responceDto=new ResponceDto<>();
       try {
           AddCityEntity cityEntity=new AddCityEntity();
           BeanUtils.copyProperties(cityDto,cityEntity);
           cityEntity.setStatus("1");
           Date date = new Date();
           cityEntity.setCreatedDate((Timestamp) new Date());
           cityRepo.save(cityEntity);
           responceDto.setMessage(cityEntity.getCityName()+" Created Successfully");
           responceDto.setStatusCode(HttpStatus.OK.toString());
       }
        catch (Exception e){
            responceDto.setMessage("City is not Created ");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }
        return responceDto;
    }

    @Override
    public ResponceDto<String> update(CityDto cityDto) {
        ResponceDto<String> responceDto=new ResponceDto<>();
       try {
           AddCityEntity cityEntity=cityRepo.findById(cityDto.getId()).orElseThrow();
           BeanUtils.copyProperties(cityDto,cityEntity);
           cityRepo.save(cityEntity);
           responceDto.setMessage(cityEntity.getCityName()+" Updated Successfully");
           responceDto.setStatusCode(HttpStatus.OK.toString());
       }
       catch (Exception e){
           responceDto.setMessage("City is not Updated ");
           responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());

       }

        return responceDto;
    }

    @Override
    public ResponceDto<String> delete(Integer id) {
        ResponceDto<String> responceDto=new ResponceDto<>();
       try {
           AddCityEntity cityEntity=cityRepo.findByIdAndStatusNot(id,"-1");
           if(cityEntity==null){
               responceDto.setMessage("Not Exist");
               responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
               return responceDto;
           }
           cityEntity.setStatus("-1");
           cityRepo.save(cityEntity);
           responceDto.setMessage(cityEntity.getCityName()+" Deleted Successfully");
//        responceDto.setData("");
           responceDto.setStatusCode(HttpStatus.OK.toString());
       }
     catch (Exception e){
         responceDto.setMessage("City is not Deleted ");
         responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());

     }
        return responceDto;
    }

    @Override
    public ResponceDto<CityDto> findById(Integer id) {
        ResponceDto<CityDto> responceDto=new ResponceDto<>();
       try {
           AddCityEntity cityEntity=cityRepo.findByIdAndStatusNot(id,"-1");
           if(cityEntity==null){
               responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
               responceDto.setMessage("This Id Is Not Exist");
               return responceDto;
           }
           CityDto cityDto=new CityDto();
           BeanUtils.copyProperties(cityEntity,cityDto);
           responceDto.setData(cityDto);
           responceDto.setStatusCode(HttpStatus.OK.toString());

       }
       catch (Exception e){
           responceDto.setMessage("Not find any Id ");
           responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
       }

        return responceDto;
    }

    @Override
    public ResponceDto<List<CityDto>> findAll() {
        ResponceDto<List<CityDto>> responceDto=new ResponceDto<>();
       try {
           List<AddCityEntity> cityEntityList =cityRepo.findByStatusNot("-1");
           List<CityDto> cityDtoList=new ArrayList<>(cityEntityList.size());
           cityEntityList.forEach(cityEntity -> {
               CityDto cityDto=new CityDto();
               BeanUtils.copyProperties(cityEntity,cityDto);
               cityDtoList.add(cityDto);
           });
           responceDto.setData(cityDtoList);
           responceDto.setStatusCode(HttpStatus.OK.toString());
       }
       catch (Exception e){
           responceDto.setMessage("Not find any city ");
           responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());

       }

        return responceDto;
    }
}
