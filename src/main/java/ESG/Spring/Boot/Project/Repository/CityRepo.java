package ESG.Spring.Boot.Project.Repository;

import ESG.Spring.Boot.Project.Entity.AddCityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepo extends JpaRepository<AddCityEntity, Integer> {
    List<AddCityEntity> findByStatusNot(String status);
    AddCityEntity findByIdAndStatusNot(Integer id,String status);


}
