package ESG.Spring.Boot.Project.Controller;

import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Dto.ViewGoalDto;
import ESG.Spring.Boot.Project.Service.ViewGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viewgoal")
public class ViewGoalController {
    @Autowired
    private ViewGoalService viewGoalService;


    @GetMapping("/findall")
    public ResponceDto<List<ViewGoalDto>> findAll(){
        ResponceDto<List<ViewGoalDto>> responceDto=viewGoalService.findAll();
        return responceDto;
    }
    @GetMapping("/{id}")
    public ResponceDto<ViewGoalDto> findById(@PathVariable Integer id){

        ResponceDto<ViewGoalDto> responceDto=viewGoalService.findOne(id);
        return responceDto;
    }

    @PutMapping("/update")
    public ResponceDto<String> update(@RequestBody ViewGoalDto viewGoalDto){
        ResponceDto<String> responceDto=viewGoalService.update(viewGoalDto);
        return responceDto;
    }
    @DeleteMapping("/delete/{id}")
    public ResponceDto<String> delete(@PathVariable Integer id){
        ResponceDto<String> responceDto= viewGoalService.delete(id);
        return responceDto;

    }
    @PostMapping("/create")
    public ResponceDto<String> save(@RequestBody ViewGoalDto viewGoalDto){
        ResponceDto<String> responceDto=viewGoalService.save(viewGoalDto);
        return responceDto;
    }

}
