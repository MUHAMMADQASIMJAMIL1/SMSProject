package ESG.Spring.Boot.Project.Controller;

import ESG.Spring.Boot.Project.Dto.ActivityFactorCalculationDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Service.ActivityFactorCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/creategoal")
public class ActivityFactorCalculationController {

    @Autowired
    private ActivityFactorCalculationService activityFactorCalculationService;

    @GetMapping("/findall")
    public ResponceDto<List<ActivityFactorCalculationDto>> findAll(){
        ResponceDto< List<ActivityFactorCalculationDto>> responceDto= activityFactorCalculationService.findAll();
        return responceDto;

    }
    @GetMapping("/{id}")
    public ResponceDto<ActivityFactorCalculationDto> findById(@PathVariable Integer id){
        ResponceDto<ActivityFactorCalculationDto> responceDto=activityFactorCalculationService.findById(id);
        return responceDto;
    }

    @PutMapping("/update")
    public ResponceDto<String> update(@RequestBody ActivityFactorCalculationDto activityFactorCalculationDto){
        ResponceDto<String> responceDto=activityFactorCalculationService.update(activityFactorCalculationDto);
        return responceDto;
    }

    @PostMapping("/create")
    public ResponceDto<String> create(@RequestBody ActivityFactorCalculationDto activityFactorCalculationDto){
        ResponceDto<String> responceDto=activityFactorCalculationService.save(activityFactorCalculationDto);
        return responceDto;

    }
    @DeleteMapping("/delete/{id}")
    public ResponceDto<String> delete(@PathVariable Integer id){
        ResponceDto<String> responceDto=activityFactorCalculationService.delete(id);
        return responceDto;
    }

}
