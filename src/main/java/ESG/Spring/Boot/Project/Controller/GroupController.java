package ESG.Spring.Boot.Project.Controller;

import ESG.Spring.Boot.Project.Dto.GroupDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/findall")
    public ResponceDto<List<GroupDto>> findAll(){
        ResponceDto<List<GroupDto>> responceDto=groupService.findAll();
        return responceDto;
    }
    @GetMapping("/{id}")
    public ResponceDto<GroupDto> findById(@PathVariable Integer id){
        ResponceDto<GroupDto>responceDto=groupService.findById(id);
        return responceDto;
    }
    @PutMapping("/update")
    public ResponceDto<String> update(@RequestBody GroupDto groupDto){
        ResponceDto<String> responceDto=groupService.update(groupDto);
        return responceDto;
    }
    @PostMapping("/create")
    public ResponceDto<String> save(@RequestBody GroupDto groupDto){
        ResponceDto<String> responceDto=groupService.save(groupDto);
        return responceDto;
    }
    @DeleteMapping("/delete/{id}")
    public ResponceDto<String> delete(@PathVariable Integer id){
        ResponceDto<String> responceDto=groupService.delete(id);
        return responceDto;
    }
}
