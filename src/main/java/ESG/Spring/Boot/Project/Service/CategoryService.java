package ESG.Spring.Boot.Project.Service;

import ESG.Spring.Boot.Project.Dto.CategoryDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;

import java.util.List;

public interface CategoryService {

    public ResponceDto<String> save(CategoryDto categoryDto);

   public ResponceDto<String>  update(CategoryDto categoryDto);

    public ResponceDto<String> delete(Integer Id);

    public ResponceDto<CategoryDto> findById(Integer Id);

    public ResponceDto<List<CategoryDto>> findAll();


}
