package ESG.Spring.Boot.Project.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "reductiongoal_master", schema = "Qasim", catalog = "")
public class ReductiongoalMasterEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "GoalName", nullable = true, length = 255)
    private String goalName;
    @Basic
    @Column(name = "Organization_Id", nullable = true, length = 255)
    private String organizationId;
    @Basic
    @Column(name = "Division_Id", nullable = true, length = 255)
    private String divisionId;
    @Basic
    @Column(name = "Period_Id", nullable = true, length = 255)
    private String periodId;
    @Basic
    @Column(name = "Description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "CreatedDate", nullable = true)
    private Timestamp createdDate;
    @Basic
    @Column(name = "CreatedBy", nullable = true, length = 255)
    private String createdBy;
    @Basic
    @Column(name = "UpdatedDate", nullable = true)
    private Timestamp updatedDate;
    @Basic
    @Column(name = "UpdatedBy", nullable = true, length = 255)
    private String updatedBy;
    @Basic
    @Column(name = "Status", nullable = true)
    private Integer status;
    @OneToMany(mappedBy = "reductiongoalMasterByReductiongoalMasterId")
    private Set<ReductiongoalInitiativesEntity> reductiongoalInitiativesById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }

    public String getPeriodId() {
        return periodId;
    }

    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReductiongoalMasterEntity that = (ReductiongoalMasterEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(goalName, that.goalName) && Objects.equals(organizationId, that.organizationId) && Objects.equals(divisionId, that.divisionId) && Objects.equals(periodId, that.periodId) && Objects.equals(description, that.description) && Objects.equals(createdDate, that.createdDate) && Objects.equals(createdBy, that.createdBy) && Objects.equals(updatedDate, that.updatedDate) && Objects.equals(updatedBy, that.updatedBy) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goalName, organizationId, divisionId, periodId, description, createdDate, createdBy, updatedDate, updatedBy, status);
    }

    public Set<ReductiongoalInitiativesEntity> getReductiongoalInitiativesById() {
        return reductiongoalInitiativesById;
    }

    public void setReductiongoalInitiativesById(Set<ReductiongoalInitiativesEntity> reductiongoalInitiativesById) {
        this.reductiongoalInitiativesById = reductiongoalInitiativesById;
    }
}
