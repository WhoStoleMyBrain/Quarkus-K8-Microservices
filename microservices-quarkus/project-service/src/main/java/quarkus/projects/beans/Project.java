package quarkus.projects.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@Data
@Entity
@Table(name = "Project")
@NamedQuery(name = "Projects.findAll", query = "SELECT p from Project p ORDER BY p.projectId")
@NamedQuery(name = "Projects.findById", query = "SELECT p from Project p WHERE projectId = :projectId")
public class Project {
    private Long id;
    private Long projectId;
    private String projectName;
    private int durationInMonths;
    private int numberOfResources;
    private String projectStatus;
    private String clientName;
    public Project() {
    }
    public Project(Long projectId, String projectName, int durationInMonths, int numberOfResources,
            String projectStatus, String clientName) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.durationInMonths = durationInMonths;
        this.numberOfResources = numberOfResources;
        this.projectStatus = projectStatus;
        this.clientName = clientName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @SequenceGenerator(name="projectIdSequenceGenerator", sequenceName = "project_id_seq", allocationSize = 1, initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectIdSequenceGenerator")
    public Long getId() {
        return id;
    }
}
