package ESG.Spring.Boot.Project.Repository;

import ESG.Spring.Boot.Project.Entity.AddOrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepo extends JpaRepository<AddOrganizationEntity,Integer> {

    List<AddOrganizationEntity> findByStatusNot(String status);
    AddOrganizationEntity findByIdAndStatusNot(Integer Id, String status);

}
