package ESG.Spring.Boot.Project.Controller;

import ESG.Spring.Boot.Project.Dto.CategoryDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @PostMapping("/create")
    private ResponceDto<String> create(@RequestBody CategoryDto categoryDto) {

        ResponceDto<String> messege = categoryService.save(categoryDto);
        return messege;
    }

    @GetMapping("/findall")
    public ResponceDto<List<CategoryDto>> findAll() {
      ResponceDto<List<CategoryDto>> categoryDtoList = categoryService.findAll();
        return categoryDtoList;

    }

    @GetMapping("/{Id}")
    public ResponceDto<CategoryDto> findById(@PathVariable Integer Id) {

        ResponceDto<CategoryDto> categoryDto = categoryService.findById(Id);
        return categoryDto;
    }

    @PutMapping("/update")
    public ResponceDto<String> update(@RequestBody CategoryDto categoryDto) {
        ResponceDto<String> messege = categoryService.update(categoryDto);
        return messege;
    }

    @DeleteMapping("/delete/{Id}")
    public ResponceDto<String> delete(@PathVariable Integer Id) {
        ResponceDto<String> messege= categoryService.delete(Id);
      return  messege;
    }

}


