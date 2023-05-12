package ESG.Spring.Boot.Project.Repository;

import ESG.Spring.Boot.Project.Entity.ActivityFactorCalculationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityFactorCalculationRepo extends JpaRepository<ActivityFactorCalculationEntity,Integer> {


    List<ActivityFactorCalculationEntity> findByStatusNot(String status);

    ActivityFactorCalculationEntity findByIdAndStatusNot(Integer id, String status);


}
