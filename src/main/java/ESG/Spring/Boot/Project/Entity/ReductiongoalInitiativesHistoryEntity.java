package ESG.Spring.Boot.Project.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "reductiongoal_initiatives_history", schema = "Qasim", catalog = "")
public class ReductiongoalInitiativesHistoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "RG_InitiativesId", nullable = true)
    private Integer rgInitiativesId;
    @Basic
    @Column(name = "Items", nullable = true, length = 255)
    private String items;
    @Basic
    @Column(name = "Period", nullable = true, length = 255)
    private String period;
    @Basic
    @Column(name = "Carbon", nullable = true, length = 255)
    private String carbon;
    @Basic
    @Column(name = "ReductionGoal_Percentage", nullable = true, length = 255)
    private String reductionGoalPercentage;
    @Basic
    @Column(name = "ReductionGoal", nullable = true, length = 255)
    private String reductionGoal;
    @Basic
    @Column(name = "Reduction_Status", nullable = true, length = 255)
    private String reductionStatus;
    @Basic
    @Column(name = "TargetDateFinish", nullable = true)
    private Timestamp targetDateFinish;
    @Basic
    @Column(name = "TargetDateStart", nullable = true)
    private Timestamp targetDateStart;
    @Basic
    @Column(name = "CategoryIndex", nullable = true, length = 255)
    private String categoryIndex;
    @Basic
    @Column(name = "Status", nullable = true)
    private Integer status;
    @Basic
    @Column(name = "CreatedDate", nullable = true)
    private Timestamp createdDate;
    @Basic
    @Column(name = "UpdatedDate", nullable = true)
    private Timestamp updatedDate;
    @Basic
    @Column(name = "CreatedBy", nullable = true, length = 255)
    private String createdBy;
    @Basic
    @Column(name = "UpdatedBy", nullable = true, length = 255)
    private String updatedBy;
    @Basic
    @Column(name = "ReductionGoal_MasterID", nullable = true)
    private Integer reductionGoalMasterId;
    @Basic
    @Column(name = "ReductionAchieved", nullable = true, length = 255)
    private String reductionAchieved;
    @Basic
    @Column(name = "ReductionRemaining", nullable = true, length = 255)
    private String reductionRemaining;
    @Basic
    @Column(name = "Description", nullable = true, length = 1000)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRgInitiativesId() {
        return rgInitiativesId;
    }

    public void setRgInitiativesId(Integer rgInitiativesId) {
        this.rgInitiativesId = rgInitiativesId;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCarbon() {
        return carbon;
    }

    public void setCarbon(String carbon) {
        this.carbon = carbon;
    }

    public String getReductionGoalPercentage() {
        return reductionGoalPercentage;
    }

    public void setReductionGoalPercentage(String reductionGoalPercentage) {
        this.reductionGoalPercentage = reductionGoalPercentage;
    }

    public String getReductionGoal() {
        return reductionGoal;
    }

    public void setReductionGoal(String reductionGoal) {
        this.reductionGoal = reductionGoal;
    }

    public String getReductionStatus() {
        return reductionStatus;
    }

    public void setReductionStatus(String reductionStatus) {
        this.reductionStatus = reductionStatus;
    }

    public Timestamp getTargetDateFinish() {
        return targetDateFinish;
    }

    public void setTargetDateFinish(Timestamp targetDateFinish) {
        this.targetDateFinish = targetDateFinish;
    }

    public Timestamp getTargetDateStart() {
        return targetDateStart;
    }

    public void setTargetDateStart(Timestamp targetDateStart) {
        this.targetDateStart = targetDateStart;
    }

    public String getCategoryIndex() {
        return categoryIndex;
    }

    public void setCategoryIndex(String categoryIndex) {
        this.categoryIndex = categoryIndex;
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

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getReductionGoalMasterId() {
        return reductionGoalMasterId;
    }

    public void setReductionGoalMasterId(Integer reductionGoalMasterId) {
        this.reductionGoalMasterId = reductionGoalMasterId;
    }

    public String getReductionAchieved() {
        return reductionAchieved;
    }

    public void setReductionAchieved(String reductionAchieved) {
        this.reductionAchieved = reductionAchieved;
    }

    public String getReductionRemaining() {
        return reductionRemaining;
    }

    public void setReductionRemaining(String reductionRemaining) {
        this.reductionRemaining = reductionRemaining;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReductiongoalInitiativesHistoryEntity that = (ReductiongoalInitiativesHistoryEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(rgInitiativesId, that.rgInitiativesId) && Objects.equals(items, that.items) && Objects.equals(period, that.period) && Objects.equals(carbon, that.carbon) && Objects.equals(reductionGoalPercentage, that.reductionGoalPercentage) && Objects.equals(reductionGoal, that.reductionGoal) && Objects.equals(reductionStatus, that.reductionStatus) && Objects.equals(targetDateFinish, that.targetDateFinish) && Objects.equals(targetDateStart, that.targetDateStart) && Objects.equals(categoryIndex, that.categoryIndex) && Objects.equals(status, that.status) && Objects.equals(createdDate, that.createdDate) && Objects.equals(updatedDate, that.updatedDate) && Objects.equals(createdBy, that.createdBy) && Objects.equals(updatedBy, that.updatedBy) && Objects.equals(reductionGoalMasterId, that.reductionGoalMasterId) && Objects.equals(reductionAchieved, that.reductionAchieved) && Objects.equals(reductionRemaining, that.reductionRemaining) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rgInitiativesId, items, period, carbon, reductionGoalPercentage, reductionGoal, reductionStatus, targetDateFinish, targetDateStart, categoryIndex, status, createdDate, updatedDate, createdBy, updatedBy, reductionGoalMasterId, reductionAchieved, reductionRemaining, description);
    }
}
