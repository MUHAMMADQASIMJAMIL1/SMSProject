package ESG.Spring.Boot.Project.Repository;


import ESG.Spring.Boot.Project.Entity.OrganizationSiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationSiteRepo extends JpaRepository<OrganizationSiteEntity,Integer> {

    List<OrganizationSiteEntity> findByStatusNot(String id);
    OrganizationSiteEntity findByIdAndStatusNot(Integer id,String status);
}
