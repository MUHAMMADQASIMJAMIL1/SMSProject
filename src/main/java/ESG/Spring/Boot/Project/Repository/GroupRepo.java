package ESG.Spring.Boot.Project.Repository;

import ESG.Spring.Boot.Project.Entity.AddGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepo extends JpaRepository<AddGroupEntity,Integer> {

    List<AddGroupEntity> findByStatusNot(String status);
    AddGroupEntity findByIdAndStatusNot(Integer id,String status);

}
