package ESG.Spring.Boot.Project.ServiceImpl;

import ESG.Spring.Boot.Project.Dto.*;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Entity.ActivityFactorCalculationEntity;
import ESG.Spring.Boot.Project.Entity.AddEmissionCategoryEntity;
import ESG.Spring.Boot.Project.Entity.AddStandardEntity;
import ESG.Spring.Boot.Project.Entity.EmmisionSubCategoryEntity;
import ESG.Spring.Boot.Project.Repository.ActivityFactorCalculationRepo;

import ESG.Spring.Boot.Project.Repository.CategoryRepo;
import ESG.Spring.Boot.Project.Repository.StandardRepo;
import ESG.Spring.Boot.Project.Repository.SubCategoryRepo;
import ESG.Spring.Boot.Project.Service.ActivityFactorCalculationService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityFactorCalculationServiceImpl implements ActivityFactorCalculationService {

    @Autowired
    private ActivityFactorCalculationRepo activityFactorCalculationRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private SubCategoryRepo subCategoryRepo;
    @Autowired
    private StandardRepo standardRepo;

    @Transactional
    @Override
    public ResponceDto<String> save(ActivityFactorCalculationDto activityFactorCalculationDto) {
        ResponceDto<String> responceDto = new ResponceDto<>();
        try {
            ActivityFactorCalculationEntity activityFactorCalculationEntity = new ActivityFactorCalculationEntity();
            BeanUtils.copyProperties(activityFactorCalculationDto, activityFactorCalculationEntity);
            AddEmissionCategoryEntity addEmissionCategoryEntity = categoryRepo.
                    findByIdAndStatusNot(activityFactorCalculationDto.getAddEmissionCategoryByCategoryIndex().getId(), "-1");

            EmmisionSubCategoryEntity emmisionSubCategoryEntity = subCategoryRepo.
                    findByIdAndStatusNot(activityFactorCalculationDto.getEmmisionSubCategoryBySubcategoryIndex().getId(), "-1");

            AddStandardEntity addStandardEntity = standardRepo.
                    findByIdAndStatusNot(activityFactorCalculationDto.getAddStandardByStandardIndex().getId(), "-1");

            activityFactorCalculationEntity.setStatus("1");
            activityFactorCalculationEntity.setAddEmissionCategoryByCategoryIndex(addEmissionCategoryEntity);
            activityFactorCalculationEntity.setEmmisionSubCategoryBySubcategoryIndex(emmisionSubCategoryEntity);
            activityFactorCalculationEntity.setAddStandardByStandardIndex(addStandardEntity);
            activityFactorCalculationRepo.save(activityFactorCalculationEntity);
            responceDto.setStatusCode(HttpStatus.OK.toString());
            responceDto.setMessage(activityFactorCalculationEntity.getName() + " created Successfully");
        } catch (Exception e) {
            responceDto.setMessage("Goal is not created");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }

        return responceDto;
    }

    @Override
    public ResponceDto<String> update(ActivityFactorCalculationDto activityFactorCalculationDto) {
        ResponceDto<String> responceDto = new ResponceDto<>();
        try {
            ActivityFactorCalculationEntity activityFactorCalculationEntity = activityFactorCalculationRepo.findById(activityFactorCalculationDto.getId()).orElseThrow();
            BeanUtils.copyProperties(activityFactorCalculationDto, activityFactorCalculationEntity);

            activityFactorCalculationRepo.save(activityFactorCalculationEntity);
            responceDto.setMessage(activityFactorCalculationEntity.getName() + " updated Successfully");
            responceDto.setStatusCode(HttpStatus.OK.toString());
        } catch (Exception e) {
            responceDto.setMessage("Goal is not updated");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }
        return responceDto;
    }

    @Override
    public ResponceDto<String> delete(Integer id) {
        ResponceDto<String> responceDto = new ResponceDto<>();
        try {

            ActivityFactorCalculationEntity activityFactorCalculationEntity = activityFactorCalculationRepo.findByIdAndStatusNot(id, "-1");
            if (activityFactorCalculationEntity == null) {
                responceDto.setMessage("Not Exist");
                responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
                return responceDto;
            }
            activityFactorCalculationEntity.setStatus("-1");
            activityFactorCalculationRepo.save(activityFactorCalculationEntity);
            responceDto.setMessage(activityFactorCalculationEntity.getName() + " deleted Successfully");
            responceDto.setStatusCode(HttpStatus.OK.toString());
        } catch (Exception e) {
            responceDto.setMessage("Group is not deleted");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }
        return responceDto;
    }

    @Override
    public ResponceDto<ActivityFactorCalculationDto> findById(Integer id) {
        ResponceDto<ActivityFactorCalculationDto> responceDto = new ResponceDto<>();
        try {
            ActivityFactorCalculationEntity activityFactorCalculationEntity = activityFactorCalculationRepo.findByIdAndStatusNot(id, "-1");
            if (activityFactorCalculationEntity == null) {
                responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
                responceDto.setMessage("This Id Is Not Exist");
                return responceDto;
            }

            ActivityFactorCalculationDto activityFactorCalculationDto = new ActivityFactorCalculationDto();
            BeanUtils.copyProperties(activityFactorCalculationEntity, activityFactorCalculationDto);
            responceDto.setData(activityFactorCalculationDto);
            responceDto.setStatusCode(HttpStatus.OK.toString());

        } catch (Exception e) {
            responceDto.setMessage("Not find such Id");
        }
        return responceDto;
    }

    @Override
    public ResponceDto<List<ActivityFactorCalculationDto>> findAll() {
        ResponceDto<List<ActivityFactorCalculationDto>> responceDto = new ResponceDto<>();
        try {
            List<ActivityFactorCalculationEntity> activityFactorCalculationEntityList = activityFactorCalculationRepo.findByStatusNot("-1");
            List<ActivityFactorCalculationDto> activityFactorCalculationDtoList = new ArrayList<>(activityFactorCalculationEntityList.size());
            activityFactorCalculationEntityList.forEach(activityFactorCalculationEntity -> {
                ActivityFactorCalculationDto activityFactorCalculationDto = new ActivityFactorCalculationDto();
                BeanUtils.copyProperties(activityFactorCalculationEntity, activityFactorCalculationDto);
                activityFactorCalculationDtoList.add(activityFactorCalculationDto);
            });
            responceDto.setStatusCode(HttpStatus.OK.toString());
            responceDto.setData(activityFactorCalculationDtoList);
        } catch (Exception e) {
            responceDto.setMessage("Not find any group");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }
        return responceDto;
    }
}
