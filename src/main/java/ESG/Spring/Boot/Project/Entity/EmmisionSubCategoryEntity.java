package ESG.Spring.Boot.Project.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "emmision_sub_category", schema = "Qasim", catalog = "")
public class EmmisionSubCategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "emmision_sub_name", nullable = true, length = 255)
    private String emmisionSubName;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "co2", nullable = true, length = 255)
    private String co2;
    @Basic
    @Column(name = "co2_unit", nullable = true, length = 255)
    private String co2Unit;
    @Basic
    @Column(name = "ch4", nullable = true, length = 255)
    private String ch4;
    @Basic
    @Column(name = "ch4_unit", nullable = true, length = 255)
    private String ch4Unit;
    @Basic
    @Column(name = "ch", nullable = true, length = 255)
    private String ch;
    @Basic
    @Column(name = "ch_unit", nullable = true, length = 255)
    private String chUnit;
    @Basic
    @Column(name = "input_unit", nullable = true, length = 255)
    private String inputUnit;
    @Basic
    @Column(name = "emmision_date", nullable = true)
    private Date emmisionDate;
    @Basic
    @Column(name = "status", nullable = true, length = 255)
    private String status;
    @Basic
    @Column(name = "tid", nullable = true)
    private Integer tid;
    @Basic
    @Column(name = "n2o", nullable = true, length = 255)
    private String n2O;
    @Basic
    @Column(name = "n2o_unit", nullable = true, length = 255)
    private String n2OUnit;
    @Basic
    @Column(name = "hfcs", nullable = true, length = 255)
    private String hfcs;
    @Basic
    @Column(name = "hfcs_unit", nullable = true, length = 255)
    private String hfcsUnit;
    @Basic
    @Column(name = "pfcs", nullable = true, length = 255)
    private String pfcs;
    @Basic
    @Column(name = "pfcs_unit", nullable = true, length = 255)
    private String pfcsUnit;
    @Basic
    @Column(name = "sf6", nullable = true, length = 255)
    private String sf6;
    @Basic
    @Column(name = "sf6_unit", nullable = true, length = 255)
    private String sf6Unit;
    @Basic
    @Column(name = "nf3", nullable = true, length = 255)
    private String nf3;
    @Basic
    @Column(name = "nf3_unit", nullable = true, length = 255)
    private String nf3Unit;
    @Basic
    @Column(name = "emmission_id", nullable = true, length = 255)
    private String emmissionId;
    @Basic
    @Column(name = "scope", nullable = true, length = 255)
    private String scope;
    @Basic
    @Column(name = "level_1", nullable = true, length = 255)
    private String level1;
    @Basic
    @Column(name = "level_2", nullable = true, length = 255)
    private String level2;
    @Basic
    @Column(name = "level_3", nullable = true, length = 255)
    private String level3;
    @Basic
    @Column(name = "level_4", nullable = true, length = 255)
    private String level4;
    @Basic
    @Column(name = "column_text", nullable = true, length = 255)
    private String columnText;
    @Basic
    @Column(name = "uom_s", nullable = true, length = 255)
    private String uomS;
    @Basic
    @Column(name = "uom", nullable = true, length = 255)
    private String uom;
    @Basic
    @Column(name = "ghg", nullable = true, length = 255)
    private String ghg;
    @Basic
    @Column(name = "lookup_valid", nullable = true, length = 255)
    private String lookupValid;
    @Basic
    @Column(name = "ghg_conversion_factor_2021", nullable = true, precision = 0)
    private Double ghgConversionFactor2021;
    @Basic
    @Column(name = "source", nullable = true, length = 255)
    private String source;
    @Basic
    @Column(name = "country", nullable = true, length = 255)
    private String country;
    @Basic
    @Column(name = "vintage", nullable = true, length = 255)
    private String vintage;
    @Basic
    @Column(name = "emission_group", nullable = true, length = 255)
    private String emissionGroup;
    @Basic
    @Column(name = "standard_id", nullable = true, length = 255)
    private String standardId;
    @Basic
    @Column(name = "year", nullable = true, length = 255)
    private String year;
    @OneToMany(mappedBy = "emmisionSubCategoryBySubcategoryIndex")
    private Set<ActivityFactorCalculationEntity> activityFactorCalculationsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmmisionSubName() {
        return emmisionSubName;
    }

    public void setEmmisionSubName(String emmisionSubName) {
        this.emmisionSubName = emmisionSubName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCo2() {
        return co2;
    }

    public void setCo2(String co2) {
        this.co2 = co2;
    }

    public String getCo2Unit() {
        return co2Unit;
    }

    public void setCo2Unit(String co2Unit) {
        this.co2Unit = co2Unit;
    }

    public String getCh4() {
        return ch4;
    }

    public void setCh4(String ch4) {
        this.ch4 = ch4;
    }

    public String getCh4Unit() {
        return ch4Unit;
    }

    public void setCh4Unit(String ch4Unit) {
        this.ch4Unit = ch4Unit;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getChUnit() {
        return chUnit;
    }

    public void setChUnit(String chUnit) {
        this.chUnit = chUnit;
    }

    public String getInputUnit() {
        return inputUnit;
    }

    public void setInputUnit(String inputUnit) {
        this.inputUnit = inputUnit;
    }

    public Date getEmmisionDate() {
        return emmisionDate;
    }

    public void setEmmisionDate(Date emmisionDate) {
        this.emmisionDate = emmisionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getN2O() {
        return n2O;
    }

    public void setN2O(String n2O) {
        this.n2O = n2O;
    }

    public String getN2OUnit() {
        return n2OUnit;
    }

    public void setN2OUnit(String n2OUnit) {
        this.n2OUnit = n2OUnit;
    }

    public String getHfcs() {
        return hfcs;
    }

    public void setHfcs(String hfcs) {
        this.hfcs = hfcs;
    }

    public String getHfcsUnit() {
        return hfcsUnit;
    }

    public void setHfcsUnit(String hfcsUnit) {
        this.hfcsUnit = hfcsUnit;
    }

    public String getPfcs() {
        return pfcs;
    }

    public void setPfcs(String pfcs) {
        this.pfcs = pfcs;
    }

    public String getPfcsUnit() {
        return pfcsUnit;
    }

    public void setPfcsUnit(String pfcsUnit) {
        this.pfcsUnit = pfcsUnit;
    }

    public String getSf6() {
        return sf6;
    }

    public void setSf6(String sf6) {
        this.sf6 = sf6;
    }

    public String getSf6Unit() {
        return sf6Unit;
    }

    public void setSf6Unit(String sf6Unit) {
        this.sf6Unit = sf6Unit;
    }

    public String getNf3() {
        return nf3;
    }

    public void setNf3(String nf3) {
        this.nf3 = nf3;
    }

    public String getNf3Unit() {
        return nf3Unit;
    }

    public void setNf3Unit(String nf3Unit) {
        this.nf3Unit = nf3Unit;
    }

    public String getEmmissionId() {
        return emmissionId;
    }

    public void setEmmissionId(String emmissionId) {
        this.emmissionId = emmissionId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public String getLevel3() {
        return level3;
    }

    public void setLevel3(String level3) {
        this.level3 = level3;
    }

    public String getLevel4() {
        return level4;
    }

    public void setLevel4(String level4) {
        this.level4 = level4;
    }

    public String getColumnText() {
        return columnText;
    }

    public void setColumnText(String columnText) {
        this.columnText = columnText;
    }

    public String getUomS() {
        return uomS;
    }

    public void setUomS(String uomS) {
        this.uomS = uomS;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getGhg() {
        return ghg;
    }

    public void setGhg(String ghg) {
        this.ghg = ghg;
    }

    public String getLookupValid() {
        return lookupValid;
    }

    public void setLookupValid(String lookupValid) {
        this.lookupValid = lookupValid;
    }

    public Double getGhgConversionFactor2021() {
        return ghgConversionFactor2021;
    }

    public void setGhgConversionFactor2021(Double ghgConversionFactor2021) {
        this.ghgConversionFactor2021 = ghgConversionFactor2021;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVintage() {
        return vintage;
    }

    public void setVintage(String vintage) {
        this.vintage = vintage;
    }

    public String getEmissionGroup() {
        return emissionGroup;
    }

    public void setEmissionGroup(String emissionGroup) {
        this.emissionGroup = emissionGroup;
    }

    public String getStandardId() {
        return standardId;
    }

    public void setStandardId(String standardId) {
        this.standardId = standardId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmmisionSubCategoryEntity that = (EmmisionSubCategoryEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(emmisionSubName, that.emmisionSubName) && Objects.equals(description, that.description) && Objects.equals(co2, that.co2) && Objects.equals(co2Unit, that.co2Unit) && Objects.equals(ch4, that.ch4) && Objects.equals(ch4Unit, that.ch4Unit) && Objects.equals(ch, that.ch) && Objects.equals(chUnit, that.chUnit) && Objects.equals(inputUnit, that.inputUnit) && Objects.equals(emmisionDate, that.emmisionDate) && Objects.equals(status, that.status) && Objects.equals(tid, that.tid) && Objects.equals(n2O, that.n2O) && Objects.equals(n2OUnit, that.n2OUnit) && Objects.equals(hfcs, that.hfcs) && Objects.equals(hfcsUnit, that.hfcsUnit) && Objects.equals(pfcs, that.pfcs) && Objects.equals(pfcsUnit, that.pfcsUnit) && Objects.equals(sf6, that.sf6) && Objects.equals(sf6Unit, that.sf6Unit) && Objects.equals(nf3, that.nf3) && Objects.equals(nf3Unit, that.nf3Unit) && Objects.equals(emmissionId, that.emmissionId) && Objects.equals(scope, that.scope) && Objects.equals(level1, that.level1) && Objects.equals(level2, that.level2) && Objects.equals(level3, that.level3) && Objects.equals(level4, that.level4) && Objects.equals(columnText, that.columnText) && Objects.equals(uomS, that.uomS) && Objects.equals(uom, that.uom) && Objects.equals(ghg, that.ghg) && Objects.equals(lookupValid, that.lookupValid) && Objects.equals(ghgConversionFactor2021, that.ghgConversionFactor2021) && Objects.equals(source, that.source) && Objects.equals(country, that.country) && Objects.equals(vintage, that.vintage) && Objects.equals(emissionGroup, that.emissionGroup) && Objects.equals(standardId, that.standardId) && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emmisionSubName, description, co2, co2Unit, ch4, ch4Unit, ch, chUnit, inputUnit, emmisionDate, status, tid, n2O, n2OUnit, hfcs, hfcsUnit, pfcs, pfcsUnit, sf6, sf6Unit, nf3, nf3Unit, emmissionId, scope, level1, level2, level3, level4, columnText, uomS, uom, ghg, lookupValid, ghgConversionFactor2021, source, country, vintage, emissionGroup, standardId, year);
    }

    public Set<ActivityFactorCalculationEntity> getActivityFactorCalculationsById() {
        return activityFactorCalculationsById;
    }

    public void setActivityFactorCalculationsById(Set<ActivityFactorCalculationEntity> activityFactorCalculationsById) {
        this.activityFactorCalculationsById = activityFactorCalculationsById;
    }
}
