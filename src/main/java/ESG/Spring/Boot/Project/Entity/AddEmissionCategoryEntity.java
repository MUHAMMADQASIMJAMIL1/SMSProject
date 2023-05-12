package ESG.Spring.Boot.Project.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "add_emission_category", schema = "Qasim", catalog = "")
public class AddEmissionCategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "emmision_name", nullable = true, length = -1)
    private String emmisionName;
    @Basic
    @Column(name = "status", nullable = true)
    private Integer status;
    @Basic
    @Column(name = "created_by", nullable = true, length = 255)
    private String createdBy;
    @Basic
    @Column(name = "created_date", nullable = true)
    private Timestamp createdDate;
    @Basic
    @Column(name = "details", nullable = true, length = 255)
    private String details;
    @Basic
    @Column(name = "scope", nullable = true, length = 255)
    private String scope;
    @OneToMany(mappedBy = "addEmissionCategoryByCategoryIndex")
    private Set<ActivityFactorCalculationEntity> activityFactorCalculationsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmmisionName() {
        return emmisionName;
    }

    public void setEmmisionName(String emmisionName) {
        this.emmisionName = emmisionName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddEmissionCategoryEntity that = (AddEmissionCategoryEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(emmisionName, that.emmisionName) && Objects.equals(status, that.status) && Objects.equals(createdBy, that.createdBy) && Objects.equals(createdDate, that.createdDate) && Objects.equals(details, that.details) && Objects.equals(scope, that.scope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emmisionName, status, createdBy, createdDate, details, scope);
    }

    public Set<ActivityFactorCalculationEntity> getActivityFactorCalculationsById() {
        return activityFactorCalculationsById;
    }

    public void setActivityFactorCalculationsById(Set<ActivityFactorCalculationEntity> activityFactorCalculationsById) {
        this.activityFactorCalculationsById = activityFactorCalculationsById;
    }
}
