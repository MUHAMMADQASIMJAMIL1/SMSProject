package ESG.Spring.Boot.Project.ServiceImpl;


import ESG.Spring.Boot.Project.Dto.CategoryDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Entity.AddEmissionCategoryEntity;
import ESG.Spring.Boot.Project.Repository.CategoryRepo;
import ESG.Spring.Boot.Project.Service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

   @Autowired
   private CategoryRepo categoryRepo;

    @Override
    public ResponceDto<String> save(CategoryDto categoryDto) {
        ResponceDto<String> responceDto=new ResponceDto<>();
       try {
           AddEmissionCategoryEntity categoryEntity=new AddEmissionCategoryEntity();
           BeanUtils.copyProperties(categoryDto,categoryEntity);
           categoryEntity.setStatus(Integer.valueOf("1"));
           categoryEntity.setCreatedDate((Timestamp) new Date());
           categoryRepo.save(categoryEntity);
//        responceDto.setData("");
           responceDto.setMessage(categoryEntity.getEmmisionName()+" Created Successfully");
           responceDto.setStatusCode(HttpStatus.OK.toString());
       }
       catch (Exception e){
           responceDto.setMessage("Category is not Created");
           responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());


       }

        return responceDto;
    }

    @Override
    public ResponceDto<String> update(CategoryDto categoryDto) {
        ResponceDto<String> responceDto=new ResponceDto<>();
       try {
           AddEmissionCategoryEntity categoryEntity=categoryRepo.findById(categoryDto.getId()).orElseThrow();
           BeanUtils.copyProperties(categoryDto,categoryEntity);
           categoryRepo.save(categoryEntity);
//        responceDto.setData("");
           responceDto.setMessage(categoryEntity.getEmmisionName()+" Updated Successfully");
           responceDto.setStatusCode(HttpStatus.OK.toString());
       }
       catch (Exception e){
           responceDto.setMessage("Category is not Updated");
           responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());


       }

        return responceDto;
    }

    @Override
    public ResponceDto<String> delete(Integer Id) {
        ResponceDto<String> responceDto=new ResponceDto<>();
       try {
           AddEmissionCategoryEntity categoryEntity=categoryRepo.findByIdAndStatusNot(Id,"-1");
           if(categoryEntity==null){
               responceDto.setMessage("Not Exist");
               responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
               return responceDto;
           }
           categoryEntity.setStatus(Integer.valueOf("-1"));
           categoryRepo.save(categoryEntity);
           responceDto.setStatusCode(HttpStatus.OK.toString());
//        responceDto.setData("");
           responceDto.setMessage(categoryEntity.getEmmisionName()+" deleted Successfully");

       }
       catch (Exception e){
           responceDto.setMessage(" Category not deleted");
           responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());


       }
       return responceDto;
    }

    @Override
    public ResponceDto<CategoryDto> findById(Integer Id) {
        ResponceDto<CategoryDto> responceDto=new ResponceDto<>();
      try {
          AddEmissionCategoryEntity categoryEntity=categoryRepo.findByIdAndStatusNot(Id,"-1");
          if(categoryEntity==null){
              responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
              responceDto.setMessage("This Id Is Not Exist");
              return responceDto;
          }
          CategoryDto categoryDto=new CategoryDto();
          BeanUtils.copyProperties(categoryEntity,categoryDto);
          responceDto.setData(categoryDto);
          responceDto.setStatusCode(HttpStatus.OK.toString());
      }
      catch (Exception e){
          responceDto.setMessage("Not find such Id");
          responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());

      }

        return responceDto;
    }

    @Override
    public ResponceDto<List<CategoryDto>> findAll() {
        ResponceDto<List<CategoryDto>> responceDto=new ResponceDto<>();
      try {
          List<AddEmissionCategoryEntity> categoryEntityList=categoryRepo.findByStatusNot("-1");
          List<CategoryDto> categoryDtoList=new ArrayList<>(categoryEntityList.size());
          categoryEntityList.forEach(categoryEntity -> {
              CategoryDto categoryDto=new CategoryDto();
              BeanUtils.copyProperties(categoryEntity,categoryDto);
              categoryDtoList.add(categoryDto);
          });
          responceDto.setData(categoryDtoList);
          responceDto.setStatusCode(HttpStatus.OK.toString());
      }
      catch (Exception e){
          responceDto.setMessage("Not find such Category");
          responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());


      }

        return responceDto;
    }

}




