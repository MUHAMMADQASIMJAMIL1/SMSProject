package ESG.Spring.Boot.Project.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "activity", schema = "Qasim", catalog = "")
public class ActivityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "time_period", nullable = true)
    private Integer timePeriod;
    @Basic
    @Column(name = "division_index", nullable = true)
    private Integer divisionIndex;
    @Basic
    @Column(name = "category_index", nullable = true)
    private Integer categoryIndex;
    @Basic
    @Column(name = "subcategory_index", nullable = true)
    private Integer subcategoryIndex;
    @Basic
    @Column(name = "status", nullable = true)
    private Integer status;
    @Basic
    @Column(name = "created_date", nullable = true)
    private Timestamp createdDate;
    @Basic
    @Column(name = "created_by", nullable = true, length = 255)
    private String createdBy;
    @Basic
    @Column(name = "updated_date", nullable = true)
    private Timestamp updatedDate;
    @Basic
    @Column(name = "updated_by", nullable = true, length = 255)
    private String updatedBy;
    @Basic
    @Column(name = "input", nullable = true, length = 255)
    private String input;
    @Basic
    @Column(name = "input_unit", nullable = true, length = 255)
    private String inputUnit;
    @Basic
    @Column(name = "assesser_index", nullable = true)
    private Integer assesserIndex;
    @Basic
    @Column(name = "start_date", nullable = true)
    private Timestamp startDate;
    @Basic
    @Column(name = "finish_date", nullable = true)
    private Timestamp finishDate;
    @Basic
    @Column(name = "organization_index", nullable = true)
    private Integer organizationIndex;
    @OneToMany(mappedBy = "activityByActivityIndex")
    private Set<ActivityFactorCalculationEntity> activityFactorCalculationsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(Integer timePeriod) {
        this.timePeriod = timePeriod;
    }

    public Integer getDivisionIndex() {
        return divisionIndex;
    }

    public void setDivisionIndex(Integer divisionIndex) {
        this.divisionIndex = divisionIndex;
    }

    public Integer getCategoryIndex() {
        return categoryIndex;
    }

    public void setCategoryIndex(Integer categoryIndex) {
        this.categoryIndex = categoryIndex;
    }

    public Integer getSubcategoryIndex() {
        return subcategoryIndex;
    }

    public void setSubcategoryIndex(Integer subcategoryIndex) {
        this.subcategoryIndex = subcategoryIndex;
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

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getInputUnit() {
        return inputUnit;
    }

    public void setInputUnit(String inputUnit) {
        this.inputUnit = inputUnit;
    }

    public Integer getAssesserIndex() {
        return assesserIndex;
    }

    public void setAssesserIndex(Integer assesserIndex) {
        this.assesserIndex = assesserIndex;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Timestamp finishDate) {
        this.finishDate = finishDate;
    }

    public Integer getOrganizationIndex() {
        return organizationIndex;
    }

    public void setOrganizationIndex(Integer organizationIndex) {
        this.organizationIndex = organizationIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityEntity that = (ActivityEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(timePeriod, that.timePeriod) && Objects.equals(divisionIndex, that.divisionIndex) && Objects.equals(categoryIndex, that.categoryIndex) && Objects.equals(subcategoryIndex, that.subcategoryIndex) && Objects.equals(status, that.status) && Objects.equals(createdDate, that.createdDate) && Objects.equals(createdBy, that.createdBy) && Objects.equals(updatedDate, that.updatedDate) && Objects.equals(updatedBy, that.updatedBy) && Objects.equals(input, that.input) && Objects.equals(inputUnit, that.inputUnit) && Objects.equals(assesserIndex, that.assesserIndex) && Objects.equals(startDate, that.startDate) && Objects.equals(finishDate, that.finishDate) && Objects.equals(organizationIndex, that.organizationIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, timePeriod, divisionIndex, categoryIndex, subcategoryIndex, status, createdDate, createdBy, updatedDate, updatedBy, input, inputUnit, assesserIndex, startDate, finishDate, organizationIndex);
    }

    public Set<ActivityFactorCalculationEntity> getActivityFactorCalculationsById() {
        return activityFactorCalculationsById;
    }

    public void setActivityFactorCalculationsById(Set<ActivityFactorCalculationEntity> activityFactorCalculationsById) {
        this.activityFactorCalculationsById = activityFactorCalculationsById;
    }
}
