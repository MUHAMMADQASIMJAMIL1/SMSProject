package ESG.Spring.Boot.Project.Service;

import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Dto.SubCategoryDto;

import java.util.List;

public interface SubCategoryService {

    public ResponceDto<String> save(SubCategoryDto subCategoryDto);
    public ResponceDto<String> update(SubCategoryDto subCategoryDto);
    public ResponceDto<String> delete(Integer id);
    public ResponceDto<SubCategoryDto> findById(Integer id);
    public ResponceDto<List<SubCategoryDto>> findAll();

}
