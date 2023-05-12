package ESG.Spring.Boot.Project.Repository;

import ESG.Spring.Boot.Project.Entity.AddStandardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StandardRepo extends JpaRepository<AddStandardEntity,Integer> {

    List<AddStandardEntity> findByStatusNot(String status);
    AddStandardEntity findByIdAndStatusNot(Integer id, String status);

}
