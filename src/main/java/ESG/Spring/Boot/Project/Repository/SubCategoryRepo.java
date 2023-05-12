package ESG.Spring.Boot.Project.Repository;

import ESG.Spring.Boot.Project.Entity.EmmisionSubCategoryEntity;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Repository
public interface SubCategoryRepo extends JpaRepository<EmmisionSubCategoryEntity,Integer> {


    List<EmmisionSubCategoryEntity> findByStatusNot(String status);
    EmmisionSubCategoryEntity findByIdAndStatusNot(Integer id,String status);
}
