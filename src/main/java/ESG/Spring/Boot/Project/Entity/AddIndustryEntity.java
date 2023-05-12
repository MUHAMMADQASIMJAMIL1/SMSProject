package ESG.Spring.Boot.Project.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "add_industry", schema = "Qasim", catalog = "")
public class AddIndustryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "industry_name", nullable = true, length = 30)
    private String industryName;
    @Basic
    @Column(name = "city", nullable = true, length = 30)
    private String city;
    @Basic
    @Column(name = "state", nullable = true, length = 30)
    private String state;
    @Basic
    @Column(name = "address1", nullable = true, length = 60)
    private String address1;
    @Basic
    @Column(name = "zip", nullable = true, length = 30)
    private String zip;
    @Basic
    @Column(name = "country", nullable = true, length = 30)
    private String country;
    @Basic
    @Column(name = "address2", nullable = true, length = 60)
    private String address2;
    @Basic
    @Column(name = "month", nullable = true, length = 30)
    private String month;
    @Basic
    @Column(name = "day", nullable = true)
    private Integer day;
    @Basic
    @Column(name = "status", nullable = true, length = 30)
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddIndustryEntity that = (AddIndustryEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(industryName, that.industryName) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(address1, that.address1) && Objects.equals(zip, that.zip) && Objects.equals(country, that.country) && Objects.equals(address2, that.address2) && Objects.equals(month, that.month) && Objects.equals(day, that.day) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, industryName, city, state, address1, zip, country, address2, month, day, status);
    }
}
