package ESG.Spring.Boot.Project.Controller;

import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Dto.SubCategoryDto;
import ESG.Spring.Boot.Project.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/subcategory")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("/findall")
    public ResponceDto<List<SubCategoryDto>> findAll() {
        ResponceDto<List<SubCategoryDto>> responceDto = subCategoryService.findAll();
        return responceDto;
    }

    @GetMapping("/{id}")
    public ResponceDto<SubCategoryDto> findById(@PathVariable Integer id) {
        ResponceDto<SubCategoryDto> responceDto = subCategoryService.findById(id);
        return responceDto;
    }

    @PutMapping("/update")
    public ResponceDto<String> update(@RequestBody SubCategoryDto subCategoryDto){
        ResponceDto<String> responceDto=subCategoryService.update(subCategoryDto);
        return responceDto;
    }
    @DeleteMapping("/delete/{id}")
    public ResponceDto<String> delete(@PathVariable Integer id){
        ResponceDto<String> responceDto=subCategoryService.delete(id);
        return responceDto;
    }
    @PostMapping("/create")
    public ResponceDto<String> save(@RequestBody SubCategoryDto subCategoryDto){
        ResponceDto<String> responceDto=subCategoryService.save(subCategoryDto);
        return responceDto;
    }
}

