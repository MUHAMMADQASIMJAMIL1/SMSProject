package ESG.Spring.Boot.Project.Controller;

import ESG.Spring.Boot.Project.Dto.CityDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/findall")
    public ResponceDto<List<CityDto>> findAll(){
       ResponceDto< List<CityDto>> responceDto= cityService.findAll();
       return responceDto;

    }
    @GetMapping("/{id}")
    public ResponceDto<CityDto> findById(@PathVariable Integer id){
        ResponceDto<CityDto> responceDto=cityService.findById(id);
        return responceDto;
    }

    @PutMapping("/update")
    public ResponceDto<String> update(@RequestBody CityDto cityDto){
        ResponceDto<String> responceDto=cityService.update(cityDto);
        return responceDto;
    }

@PostMapping("/create")
    public ResponceDto<String> create(@RequestBody CityDto cityDto){
        ResponceDto<String> responceDto=cityService.save(cityDto);
        return responceDto;

}
@DeleteMapping("/delete/{id}")
    public ResponceDto<String> delete(@PathVariable Integer id){
        ResponceDto<String> responceDto=cityService.delete(id);
        return responceDto;
}

}
