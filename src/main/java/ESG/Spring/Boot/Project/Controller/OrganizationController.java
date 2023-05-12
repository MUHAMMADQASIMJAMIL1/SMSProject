package ESG.Spring.Boot.Project.Controller;

import ESG.Spring.Boot.Project.Dto.OrganizationDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/organization")
public class OrganizationController {

@Autowired
    private OrganizationService organizationService;

@GetMapping("/findall")
    public ResponceDto<List<OrganizationDto>> findAll(){
    ResponceDto<List<OrganizationDto>> responceDto = organizationService.findAll();
    return responceDto;
}
@GetMapping("/{Id}")
    public ResponceDto<OrganizationDto> findById(@PathVariable Integer Id){
    ResponceDto<OrganizationDto> responceDto=organizationService.findById(Id);
    return responceDto;
}
@PutMapping("/update")
    public ResponceDto<String> update(@RequestBody OrganizationDto organizationDto){
    ResponceDto<String> responceDto=organizationService.update(organizationDto);
    return responceDto;
}
@DeleteMapping("/delete/{Id}")
    public ResponceDto<String> delete(@PathVariable Integer Id){
    ResponceDto<String> responceDto =organizationService.delete(Id);
    return responceDto;
}
@PostMapping("/create")
    public ResponceDto<String> save(@RequestBody OrganizationDto organizationDto){
    ResponceDto<String> responceDto=organizationService.save(organizationDto);
    return  responceDto;
}

}
