package ESG.Spring.Boot.Project.Repository;

import ESG.Spring.Boot.Project.Entity.ReductiongoalInitiativesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ViewGoalRepo extends JpaRepository<ReductiongoalInitiativesEntity ,Integer> {


    List<ReductiongoalInitiativesEntity> findByStatusNot(String status);
    ReductiongoalInitiativesEntity findByIdAndStatusNot(Integer id, String Status);


}
