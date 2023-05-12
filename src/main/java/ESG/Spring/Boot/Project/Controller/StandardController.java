package ESG.Spring.Boot.Project.Controller;

import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Dto.StandardDto;
import ESG.Spring.Boot.Project.Service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/standard")
public class StandardController {

    @Autowired
    private StandardService standardService;

    @GetMapping("/findall")
    public ResponceDto<List<StandardDto>> findAll() {
        ResponceDto<List<StandardDto>> responceDto = standardService.findAll();
        return responceDto;
    }

    @GetMapping("/{id}")
    public ResponceDto<StandardDto> findById(@PathVariable Integer id) {
        ResponceDto<StandardDto> responceDto = standardService.findById(id);
        return responceDto;
    }

    @PutMapping("/update")
    public ResponceDto<String> update(@RequestBody StandardDto standardDto){
        ResponceDto<String> responceDto=standardService.update(standardDto);
        return responceDto;
    }
    @DeleteMapping("/delete/{id}")
    public ResponceDto<String> delete(@PathVariable Integer id){
        ResponceDto<String> responceDto=standardService.delete(id);
        return responceDto;
    }
    @PostMapping("/create")
    public ResponceDto<String> save(@RequestBody StandardDto standardDto){
        ResponceDto<String> responceDto=standardService.save(standardDto);
        return responceDto;
    }
}
