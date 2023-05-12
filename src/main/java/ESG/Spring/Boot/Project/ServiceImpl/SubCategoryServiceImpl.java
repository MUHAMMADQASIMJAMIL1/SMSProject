package ESG.Spring.Boot.Project.ServiceImpl;

import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Dto.SubCategoryDto;
import ESG.Spring.Boot.Project.Entity.EmmisionSubCategoryEntity;
import ESG.Spring.Boot.Project.Repository.SubCategoryRepo;
import ESG.Spring.Boot.Project.Service.SubCategoryService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
   @Autowired
   private SubCategoryRepo subCategoryRepo;
    @Override
    public ResponceDto<String> save(SubCategoryDto subCategoryDto) {
        ResponceDto<String> responceDto=new ResponceDto<>();
        try {
            System.out.println("there in save");
            EmmisionSubCategoryEntity emmisionSubCategoryEntity=new EmmisionSubCategoryEntity();
            BeanUtils.copyProperties(subCategoryDto,emmisionSubCategoryEntity);
            emmisionSubCategoryEntity.setStatus("1");
            subCategoryRepo.save(emmisionSubCategoryEntity);
            responceDto.setStatusCode(HttpStatus.OK.toString());
            responceDto.setMessage(emmisionSubCategoryEntity.getEmmisionSubName()+" created Successfully");
        }
        catch (Exception e){
            responceDto.setMessage("Standard is not created");
        }
        return responceDto;
    }



    @Override
    public ResponceDto<String> update(SubCategoryDto subCategoryDto) {
        ResponceDto<String> responceDto=new ResponceDto<>();
        try {
            EmmisionSubCategoryEntity emmisionSubCategoryEntity=subCategoryRepo.findById(subCategoryDto.getId()).orElseThrow();
            BeanUtils.copyProperties(subCategoryDto,emmisionSubCategoryEntity);
            subCategoryRepo.save(emmisionSubCategoryEntity);
            responceDto.setStatusCode(HttpStatus.OK.toString());
            responceDto.setMessage(emmisionSubCategoryEntity.getEmmisionSubName()+" updated Successfully");
        }
        catch (Exception e){
            responceDto.setMessage("Standard is not updated");
        }
        return responceDto;
    }
    @Override
    public ResponceDto<String> delete(Integer id) {
        ResponceDto<String> responceDto=new ResponceDto<>();
        try {
            EmmisionSubCategoryEntity emmisionSubCategoryEntity=subCategoryRepo.findByIdAndStatusNot(id,"-1");
            if(emmisionSubCategoryEntity==null){
                responceDto.setMessage("Not Exist");
                responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
                return responceDto;
            }
            emmisionSubCategoryEntity.setStatus("-1");
            subCategoryRepo.save(emmisionSubCategoryEntity);
            responceDto.setStatusCode(HttpStatus.OK.toString());
            responceDto.setMessage(emmisionSubCategoryEntity.getEmmisionSubName()+" deleted Successfully");
        }
        catch (Exception e){
            responceDto.setMessage("Standard is not deleted");
        }
        return responceDto;
    }

    @Override
    public ResponceDto<SubCategoryDto> findById(Integer id) {
       ResponceDto<SubCategoryDto> responceDto=new ResponceDto<>();
        try {
            EmmisionSubCategoryEntity emmisionSubCategoryEntity=subCategoryRepo.findByIdAndStatusNot(id,"-1");
            if(emmisionSubCategoryEntity==null){
                responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
                responceDto.setMessage("This Id Is Not Exist");
                return responceDto;
            }

            SubCategoryDto subCategoryDto=new SubCategoryDto();
            BeanUtils.copyProperties(emmisionSubCategoryEntity,subCategoryDto);
            responceDto.setData(subCategoryDto);
            responceDto.setStatusCode(HttpStatus.OK.toString());

        }
        catch (Exception e){
            responceDto.setMessage("Not find such Id");
        }
        return responceDto;
    }
    @Override
    public ResponceDto<List<SubCategoryDto>> findAll() {
        ResponceDto<List<SubCategoryDto>> responceDto=new ResponceDto<>();
        try {
            List<EmmisionSubCategoryEntity> emmisionSubCategoryEntityList=subCategoryRepo.findByStatusNot("-1");
            List<SubCategoryDto> subCategoryDtoList=new ArrayList<>(emmisionSubCategoryEntityList.size());
            emmisionSubCategoryEntityList.forEach(standardEntity -> {
                SubCategoryDto subCategoryDto=new SubCategoryDto();
                BeanUtils.copyProperties(standardEntity,subCategoryDto);
                subCategoryDtoList.add(subCategoryDto);

            });
            responceDto.setStatusCode(HttpStatus.OK.toString());
            responceDto.setData(subCategoryDtoList);
        }
        catch (Exception e){
            responceDto.setMessage("Not find any subCategory");
        }
        return responceDto;
    }

}
