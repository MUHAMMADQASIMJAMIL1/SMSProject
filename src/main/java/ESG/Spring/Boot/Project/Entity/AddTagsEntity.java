package ESG.Spring.Boot.Project.Entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "add_tags", schema = "Qasim", catalog = "")
public class AddTagsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "tag_name", nullable = true, length = 255)
    private String tagName;
    @Basic
    @Column(name = "status", nullable = true, length = 255)
    private String status;
    @OneToMany(mappedBy = "addTagsByTagIndex")
    private Collection<ActivityFactorCalculationEntity> activityFactorCalculationsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
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
        AddTagsEntity that = (AddTagsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(tagName, that.tagName) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tagName, status);
    }

    public Collection<ActivityFactorCalculationEntity> getActivityFactorCalculationsById() {
        return activityFactorCalculationsById;
    }

    public void setActivityFactorCalculationsById(Collection<ActivityFactorCalculationEntity> activityFactorCalculationsById) {
        this.activityFactorCalculationsById = activityFactorCalculationsById;
    }
}
