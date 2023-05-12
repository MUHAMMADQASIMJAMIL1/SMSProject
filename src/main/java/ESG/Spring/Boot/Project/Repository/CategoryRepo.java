package ESG.Spring.Boot.Project.Repository;

import ESG.Spring.Boot.Project.Entity.AddEmissionCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<AddEmissionCategoryEntity,Integer> {
List<AddEmissionCategoryEntity>findByStatusNot(String status);
AddEmissionCategoryEntity findByIdAndStatusNot(Integer Id,String status);

}
