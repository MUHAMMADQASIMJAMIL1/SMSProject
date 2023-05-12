package ESG.Spring.Boot.Project.ServiceImpl;

import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Dto.ViewGoalDto;
import ESG.Spring.Boot.Project.Entity.ReductiongoalInitiativesEntity;
import ESG.Spring.Boot.Project.Repository.ViewGoalRepo;
import ESG.Spring.Boot.Project.Service.ViewGoalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViewGoalServiceImpl implements ViewGoalService {

   @Autowired
   private ViewGoalRepo viewGoalRepo;
   @Override
    public ResponceDto<String> save(ViewGoalDto viewGoalDto) {
        ResponceDto<String> responceDto=new ResponceDto<>();
        try{
            ReductiongoalInitiativesEntity reductiongoalInitiativesEntity=new ReductiongoalInitiativesEntity();
            BeanUtils.copyProperties(viewGoalDto, reductiongoalInitiativesEntity);
           reductiongoalInitiativesEntity.setStatus(Integer.valueOf("1"));
//           reductiongoalInitiativesEntity.setCreatedDate(new Date());
           viewGoalRepo.save(reductiongoalInitiativesEntity);
           responceDto.setMessage(reductiongoalInitiativesEntity.getReductionAchieved()+"IS Created ");
           responceDto.setStatusCode(HttpStatus.OK.toString());
        }
        catch (Exception e){
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }


        return responceDto;
    }

    @Override
    public ResponceDto<String> update(ViewGoalDto viewGoalDto) {
       ResponceDto<String> responceDto=new ResponceDto<>();
       try {
           ReductiongoalInitiativesEntity reductiongoalInitiativesEntity=viewGoalRepo.findById(viewGoalDto.getId()).orElseThrow();
           BeanUtils.copyProperties(viewGoalDto, reductiongoalInitiativesEntity);
//           reductiongoalInitiativesEntity.setCreatedDate(new Date());
           viewGoalRepo.save(reductiongoalInitiativesEntity);
           responceDto.setMessage(reductiongoalInitiativesEntity.getReductionAchieved()+"IS updated ");
           responceDto.setStatusCode(HttpStatus.OK.toString());
       }
       catch (Exception e){
           responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
       }
        return responceDto;
    }

    @Override
    public ResponceDto<String> delete(Integer id) {
       ResponceDto<String> responceDto=new ResponceDto<>();
       try {
           ReductiongoalInitiativesEntity reductiongoalInitiativesEntity=viewGoalRepo.findByIdAndStatusNot(id, "-1");
         if (reductiongoalInitiativesEntity==null){
             responceDto.setMessage("Not Deleted Such Data It is NOt Exist or Already Deleted ");
             responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
             return responceDto;
         }
           reductiongoalInitiativesEntity.setStatus(Integer.valueOf("-1"));
           viewGoalRepo.save(reductiongoalInitiativesEntity);
           responceDto.setMessage(reductiongoalInitiativesEntity.getReductionAchieved()+" Is Deleted Successfully ");
           responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
       }
       catch (Exception e){
           responceDto.setMessage("Not Deleted Such Data It is NOt Exist or Already Deleted ");
           responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
       }

        return responceDto;
    }

    @Override
    public ResponceDto<ViewGoalDto> findOne(Integer id) {
        ResponceDto<ViewGoalDto> responceDto=new ResponceDto<>();
    try {
        ReductiongoalInitiativesEntity reductiongoalInitiativesEntity=viewGoalRepo.findByIdAndStatusNot(id,"-1");
     if (reductiongoalInitiativesEntity==null){
         responceDto.setMessage("ID Not Exist ");

         responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
         return responceDto;
     }

        ViewGoalDto viewGoalDto=new ViewGoalDto();
        BeanUtils.copyProperties(reductiongoalInitiativesEntity,viewGoalDto);
        responceDto.setData(viewGoalDto);
        responceDto.setStatusCode(HttpStatus.OK.toString());
    }
    catch (Exception e){
        responceDto.setMessage("ID Not Exist ");

        responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());

    }

        return responceDto;
    }

    @Override
    public ResponceDto<List<ViewGoalDto>> findAll() {
       ResponceDto<List<ViewGoalDto>> responceDto=new ResponceDto<>();
       try
       {
           List<ReductiongoalInitiativesEntity> reductiongoalInitiativesEntityList=viewGoalRepo.findByStatusNot("-1");
           List<ViewGoalDto> viewGoalDtoList=new ArrayList<>(reductiongoalInitiativesEntityList.size());
           reductiongoalInitiativesEntityList.forEach(reductiongoalInitiativesEntity -> {
               ViewGoalDto viewGoalDto=new ViewGoalDto();
               BeanUtils.copyProperties(reductiongoalInitiativesEntity,viewGoalDto);
               viewGoalDtoList.add(viewGoalDto);
           });
            responceDto.setData(viewGoalDtoList);
           responceDto.setStatusCode(HttpStatus.OK.toString());
       }
       catch (Exception e){
           responceDto.setMessage("Data not exist in the table ");
           responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
       }

        return responceDto;
    }
}
