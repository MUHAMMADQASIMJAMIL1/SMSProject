package ESG.Spring.Boot.Project.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "activity_factor_calculation", schema = "Qasim")
public class ActivityFactorCalculationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "factor-detail", nullable = true, length = 255)
    private String factorDetail;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "gas_factor", nullable = true, length = 20)
    private String gasFactor;
    @Basic
    @Column(name = "consumption", nullable = true, length = 255)
    private String consumption;
    @Basic
    @Column(name = "consumption_unit", nullable = true, length = 255)
    private String consumptionUnit;
    @Basic
    @Column(name = "tco2", nullable = true, length = 255)
    private String tco2;
    @Basic
    @Column(name = "status", nullable = true, length = 255)
    private String status;
    @Basic
    @Column(name = "created_date", nullable = true)
    private Timestamp createdDate;
    @Basic
    @Column(name = "created_by", nullable = true, length = 255)
    private String created_by;
    @Basic
    @Column(name = "updated_date", nullable = true)
    private Timestamp updatedDate;
    @Basic
    @Column(name = "updated_by", nullable = true, length = 255)
    private String updatedBy;
//    @Basic
//    @Column(name = "standard_index", nullable = true)
//    private Integer standardIndex;
    @Basic
    @Column(name = "scope", nullable = true, length = 255)
    private String scope;
    @ManyToOne
    @JoinColumn(name = "category_index", referencedColumnName = "id")
    private AddEmissionCategoryEntity addEmissionCategoryByCategoryIndex;
    @ManyToOne
    @JoinColumn(name = "subcategory_index", referencedColumnName = "id")
    private EmmisionSubCategoryEntity emmisionSubCategoryBySubcategoryIndex;
    @ManyToOne
    @JoinColumn(name = "activity_index", referencedColumnName = "id")
    private ActivityEntity activityByActivityIndex;
    @ManyToOne
    @JoinColumn(name = "tag_index", referencedColumnName = "id")
    private AddTagsEntity addTagsByTagIndex;
    @ManyToOne
    @JoinColumn(name = "gas_index", referencedColumnName = "id")
    private GhgGasesEntity ghgGasesByGasIndex;
    @ManyToOne
    @JoinColumn(name = "gas_unit_index", referencedColumnName = "id")
    private GasUnitEntity gasUnitByGasUnitIndex;
    @ManyToOne
    @JoinColumn(name = "standard_index", referencedColumnName = "id")
    private AddStandardEntity addStandardByStandardIndex;

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

    public String getFactorDetail() {
        return factorDetail;
    }

    public void setFactorDetail(String factorDetail) {
        this.factorDetail = factorDetail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGasFactor() {
        return gasFactor;
    }

    public void setGasFactor(String gasFactor) {
        this.gasFactor = gasFactor;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public String getConsumptionUnit() {
        return consumptionUnit;
    }

    public void setConsumptionUnit(String consumptionUnit) {
        this.consumptionUnit = consumptionUnit;
    }

    public String getTco2() {
        return tco2;
    }

    public void setTco2(String tco2) {
        this.tco2 = tco2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return created_by;
    }

    public void setCreatedBy(String createdBy) {
        this.created_by = createdBy;
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

//    public Integer getStandardIndex() {
//        return standardIndex;
//    }

//    public void setStandardIndex(Integer standardIndex) {
//        this.standardIndex = standardIndex;
//    }

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
        ActivityFactorCalculationEntity that = (ActivityFactorCalculationEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(factorDetail, that.factorDetail) && Objects.equals(description, that.description) && Objects.equals(gasFactor, that.gasFactor) && Objects.equals(consumption, that.consumption) && Objects.equals(consumptionUnit, that.consumptionUnit) && Objects.equals(tco2, that.tco2) && Objects.equals(status, that.status) && Objects.equals(createdDate, that.createdDate) && Objects.equals(created_by, that.created_by) && Objects.equals(updatedDate, that.updatedDate) && Objects.equals(updatedBy, that.updatedBy)  && Objects.equals(scope, that.scope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, factorDetail, description, gasFactor, consumption, consumptionUnit, tco2, status, createdDate, created_by, updatedDate, updatedBy,  scope);
    }

    public AddEmissionCategoryEntity getAddEmissionCategoryByCategoryIndex() {
        return addEmissionCategoryByCategoryIndex;
    }

    public void setAddEmissionCategoryByCategoryIndex(AddEmissionCategoryEntity addEmissionCategoryByCategoryIndex) {
        this.addEmissionCategoryByCategoryIndex = addEmissionCategoryByCategoryIndex;
    }

    public EmmisionSubCategoryEntity getEmmisionSubCategoryBySubcategoryIndex() {
        return emmisionSubCategoryBySubcategoryIndex;
    }

    public void setEmmisionSubCategoryBySubcategoryIndex(EmmisionSubCategoryEntity emmisionSubCategoryBySubcategoryIndex) {
        this.emmisionSubCategoryBySubcategoryIndex = emmisionSubCategoryBySubcategoryIndex;
    }

    public ActivityEntity getActivityByActivityIndex() {
        return activityByActivityIndex;
    }

    public void setActivityByActivityIndex(ActivityEntity activityByActivityIndex) {
        this.activityByActivityIndex = activityByActivityIndex;
    }

    public AddTagsEntity getAddTagsByTagIndex() {
        return addTagsByTagIndex;
    }

    public void setAddTagsByTagIndex(AddTagsEntity addTagsByTagIndex) {
        this.addTagsByTagIndex = addTagsByTagIndex;
    }

    public GhgGasesEntity getGhgGasesByGasIndex() {
        return ghgGasesByGasIndex;
    }

    public void setGhgGasesByGasIndex(GhgGasesEntity ghgGasesByGasIndex) {
        this.ghgGasesByGasIndex = ghgGasesByGasIndex;
    }

    public GasUnitEntity getGasUnitByGasUnitIndex() {
        return gasUnitByGasUnitIndex;
    }

    public void setGasUnitByGasUnitIndex(GasUnitEntity gasUnitByGasUnitIndex) {
        this.gasUnitByGasUnitIndex = gasUnitByGasUnitIndex;
    }

    public AddStandardEntity getAddStandardByStandardIndex() {
        return addStandardByStandardIndex;
    }

    public void setAddStandardByStandardIndex(AddStandardEntity addStandardByStandardIndex) {
        this.addStandardByStandardIndex = addStandardByStandardIndex;
    }
}
