package ESG.Spring.Boot.Project.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ghg_gases", schema = "Qasim", catalog = "")
public class GhgGasesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "gas_category", nullable = true)
    private Integer gasCategory;
    @Basic
    @Column(name = "gases_name", nullable = true, length = 255)
    private String gasesName;
    @Basic
    @Column(name = "unit_index", nullable = true)
    private Integer unitIndex;
    @Basic
    @Column(name = "status", nullable = true)
    private Integer status;
    @Basic
    @Column(name = "created_date", nullable = true)
    private Timestamp createdDate;
    @OneToMany(mappedBy = "ghgGasesByGasIndex")
    private Set<ActivityFactorCalculationEntity> activityFactorCalculationsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGasCategory() {
        return gasCategory;
    }

    public void setGasCategory(Integer gasCategory) {
        this.gasCategory = gasCategory;
    }

    public String getGasesName() {
        return gasesName;
    }

    public void setGasesName(String gasesName) {
        this.gasesName = gasesName;
    }

    public Integer getUnitIndex() {
        return unitIndex;
    }

    public void setUnitIndex(Integer unitIndex) {
        this.unitIndex = unitIndex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GhgGasesEntity that = (GhgGasesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(gasCategory, that.gasCategory) && Objects.equals(gasesName, that.gasesName) && Objects.equals(unitIndex, that.unitIndex) && Objects.equals(status, that.status) && Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gasCategory, gasesName, unitIndex, status, createdDate);
    }

    public Set<ActivityFactorCalculationEntity> getActivityFactorCalculationsById() {
        return activityFactorCalculationsById;
    }

    public void setActivityFactorCalculationsById(Set<ActivityFactorCalculationEntity> activityFactorCalculationsById) {
        this.activityFactorCalculationsById = activityFactorCalculationsById;
    }
}
