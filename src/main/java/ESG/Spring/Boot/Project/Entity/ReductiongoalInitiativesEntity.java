package ESG.Spring.Boot.Project.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "reductiongoal_initiatives", schema = "Qasim")
public class ReductiongoalInitiativesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "items", nullable = true, length = 255)
    private String items;
    @Basic
    @Column(name = "period", nullable = true, length = 255)
    private String period;
    @Basic
    @Column(name = "carbon", nullable = true, length = 255)
    private String carbon;
    @Basic
    @Column(name = "reductiongoal_percentage", nullable = true, length = 255)
    private String reductiongoalPercentage;
    @Basic
    @Column(name = "reductiongoal", nullable = true, length = 255)
    private String reductiongoal;
    @Basic
    @Column(name = "reduction_status", nullable = true, length = 255)
    private String reductionStatus;
    @Basic
    @Column(name = "target_date_finish", nullable = true)
    private Timestamp targetDateFinish;
    @Basic
    @Column(name = "target_date_start", nullable = true)
    private Timestamp targetDateStart;
    @Basic
    @Column(name = "category_index", nullable = true, length = 255)
    private String categoryIndex;
    @Basic
    @Column(name = "status", nullable = true)
    private Integer status;
    @Basic
    @Column(name = "created_date", nullable = true)
    private Timestamp createdDate;
    @Basic
    @Column(name = "updated_date", nullable = true)
    private Timestamp updatedDate;
    @Basic
    @Column(name = "created_by", nullable = true, length = 255)
    private String createdBy;
    @Basic
    @Column(name = "updated_by", nullable = true, length = 255)
    private String updatedBy;
    @Basic
    @Column(name = "reduction_achieved", nullable = true, length = 255)
    private String reductionAchieved;
    @Basic
    @Column(name = "reduction_remaining", nullable = true, length = 255)
    private String reductionRemaining;
    @Basic
    @Column(name = "description", nullable = true, length = 1000)
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reductiongoal_master_id", referencedColumnName = "Id")
    private ReductiongoalMasterEntity reductiongoalMasterByReductiongoalMasterId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getReductiongoalPercentage() {
        return reductiongoalPercentage;
    }

    public void setReductiongoalPercentage(String reductiongoalPercentage) {
        this.reductiongoalPercentage = reductiongoalPercentage;
    }

    public String getReductiongoal() {
        return reductiongoal;
    }

    public void setReductiongoal(String reductiongoal) {
        this.reductiongoal = reductiongoal;
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
        ReductiongoalInitiativesEntity that = (ReductiongoalInitiativesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(items, that.items) && Objects.equals(period, that.period) && Objects.equals(carbon, that.carbon) && Objects.equals(reductiongoalPercentage, that.reductiongoalPercentage) && Objects.equals(reductiongoal, that.reductiongoal) && Objects.equals(reductionStatus, that.reductionStatus) && Objects.equals(targetDateFinish, that.targetDateFinish) && Objects.equals(targetDateStart, that.targetDateStart) && Objects.equals(categoryIndex, that.categoryIndex) && Objects.equals(status, that.status) && Objects.equals(createdDate, that.createdDate) && Objects.equals(updatedDate, that.updatedDate) && Objects.equals(createdBy, that.createdBy) && Objects.equals(updatedBy, that.updatedBy) && Objects.equals(reductionAchieved, that.reductionAchieved) && Objects.equals(reductionRemaining, that.reductionRemaining) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, items, period, carbon, reductiongoalPercentage, reductiongoal, reductionStatus, targetDateFinish, targetDateStart, categoryIndex, status, createdDate, updatedDate, createdBy, updatedBy, reductionAchieved, reductionRemaining, description);
    }

    public ReductiongoalMasterEntity getReductiongoalMasterByReductiongoalMasterId() {
        return reductiongoalMasterByReductiongoalMasterId;
    }

    public void setReductiongoalMasterByReductiongoalMasterId(ReductiongoalMasterEntity reductiongoalMasterByReductiongoalMasterId) {
        this.reductiongoalMasterByReductiongoalMasterId = reductiongoalMasterByReductiongoalMasterId;
    }
}
