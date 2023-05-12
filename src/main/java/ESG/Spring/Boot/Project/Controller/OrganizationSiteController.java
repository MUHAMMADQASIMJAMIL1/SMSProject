package ESG.Spring.Boot.Project.Controller;

import ESG.Spring.Boot.Project.Dto.OrganizationSiteDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Service.OrganizationSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/organizationsite")
public class OrganizationSiteController {

    @Autowired
    private OrganizationSiteService organizationSiteService;

    @GetMapping("/findall")
    public ResponceDto<List<OrganizationSiteDto>> findAll() {
        ResponceDto<List<OrganizationSiteDto>> responceDto = organizationSiteService.findAll();
        return responceDto;

    }

    @GetMapping("/{id}")
    public ResponceDto<OrganizationSiteDto> findById(@PathVariable Integer id) {
        ResponceDto<OrganizationSiteDto> responceDto = organizationSiteService.findById(id);
        return responceDto;
    }

    @PutMapping("/update")
    public ResponceDto<String> update(@RequestBody OrganizationSiteDto organizationSiteDto) {
        ResponceDto<String> responceDto = organizationSiteService.update(organizationSiteDto);
        return responceDto;

    }

    @PostMapping("/create")
    public ResponceDto<String> save(@RequestBody OrganizationSiteDto organizationSiteDto) {
        ResponceDto<String> responceDto = organizationSiteService.save(organizationSiteDto);
        return responceDto;
    }
@DeleteMapping("/delete/{id}")
    public ResponceDto<String> delete(@PathVariable Integer id){
        ResponceDto<String> responceDto=organizationSiteService.delete(id);
        return responceDto;
}

}
