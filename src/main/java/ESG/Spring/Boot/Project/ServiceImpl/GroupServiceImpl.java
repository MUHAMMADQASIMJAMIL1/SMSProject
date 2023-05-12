package ESG.Spring.Boot.Project.ServiceImpl;

import ESG.Spring.Boot.Project.Dto.GroupDto;
import ESG.Spring.Boot.Project.Dto.ResponceDto.ResponceDto;
import ESG.Spring.Boot.Project.Entity.AddGroupEntity;
import ESG.Spring.Boot.Project.Repository.GroupRepo;
import ESG.Spring.Boot.Project.Service.GroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepo groupRepo;

    @Override
    public ResponceDto<String> save(GroupDto groupDto) {
        ResponceDto<String> responceDto = new ResponceDto<>();
        try {
            AddGroupEntity groupEntity = new AddGroupEntity();
            BeanUtils.copyProperties(groupDto, groupEntity);
            groupEntity.setStatus("1");
            groupEntity.setCreatedDate((Timestamp) new Date());
            groupRepo.save(groupEntity);
            responceDto.setStatusCode(HttpStatus.OK.toString());
            responceDto.setMessage(groupEntity.getGroupName() + " created Successfully");
        } catch (Exception e) {
            responceDto.setMessage("Group is not created");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }

        return responceDto;
    }

    @Override
    public ResponceDto<String> update(GroupDto groupDto) {
        ResponceDto<String> responceDto = new ResponceDto<>();
        try {
            AddGroupEntity groupEntity = groupRepo.findById(groupDto.getId()).orElseThrow();
            BeanUtils.copyProperties(groupDto, groupEntity);

            groupRepo.save(groupEntity);
            responceDto.setMessage(groupEntity.getGroupName() + " updated Successfully");
            responceDto.setStatusCode(HttpStatus.OK.toString());
        } catch (Exception e) {
            responceDto.setMessage("Group is not updated");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }
        return responceDto;
    }

    @Override
    public ResponceDto<String> delete(Integer id) {
        ResponceDto<String> responceDto = new ResponceDto<>();
        try {
            AddGroupEntity groupEntity = groupRepo.findByIdAndStatusNot(id,"-1");
            if(groupEntity==null){
                responceDto.setMessage("Not Exist");
                responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
                return responceDto;
            }
            groupEntity.setStatus("-1");
            groupRepo.save(groupEntity);
            responceDto.setMessage(groupEntity.getGroupName() + " deleted Successfully");
            responceDto.setStatusCode(HttpStatus.OK.toString());
        } catch (Exception e) {
            responceDto.setMessage("Group is not deleted");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }
        return responceDto;
    }

    @Override
    public ResponceDto<GroupDto> findById(Integer id) {
        ResponceDto<GroupDto> responceDto = new ResponceDto<>();
        try {
            AddGroupEntity groupEntity = groupRepo.findByIdAndStatusNot(id,"-1");
            if(groupEntity==null){
                responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
                responceDto.setMessage("This Id Is Not Exist");
                return responceDto;
            }
            GroupDto groupDto = new GroupDto();
            BeanUtils.copyProperties(groupEntity, groupDto);
            groupRepo.save(groupEntity);
            responceDto.setData(groupDto);
            responceDto.setStatusCode(HttpStatus.OK.toString());

        } catch (Exception e) {
            responceDto.setMessage("Not such id found");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }
        return responceDto;
    }

    @Override
    public ResponceDto<List<GroupDto>> findAll() {
        ResponceDto<List<GroupDto>> responceDto = new ResponceDto<>();
        try {
            List<AddGroupEntity> groupEntityList = groupRepo.findByStatusNot("-1");
            List<GroupDto> groupDtoList = new ArrayList<>(groupEntityList.size());
            groupEntityList.forEach(groupEntity -> {
                GroupDto groupDto = new GroupDto();
                BeanUtils.copyProperties(groupEntity, groupDto);
                groupDtoList.add(groupDto);
            });
            responceDto.setStatusCode(HttpStatus.OK.toString());
            responceDto.setData(groupDtoList);
        } catch (Exception e) {
            responceDto.setMessage("Not find any group");
            responceDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        }
        return responceDto;
    }
}
