package quarkus.projects;

import java.util.List;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import quarkus.projects.beans.Project;

@Path("/projects")
@Produces(MediaType.APPLICATION_JSON)
public class ProjectResource {

    @Inject
    EntityManager entityManager;

    @GET
    public List<Project> getAllProjects() {
        return entityManager.createNamedQuery("Projects.findAll", Project.class).getResultList();
    }

    @GET
    @Path("/{projectId}")
    public Project getProjectById(@PathParam("projectId") Long projectId) {
        try {
            return entityManager.createNamedQuery("Projects.findById", Project.class).setParameter("projectId", projectId).getSingleResult();
        } catch (NoResultException nre) {
            throw new WebApplicationException("Project with id: " + projectId + " not found");
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createProject(Project project) {
        if (null == project.getProjectId())
            throw new WebApplicationException("A project with no Id cannot be created", 400);
        entityManager.persist(project);
        return Response.status(201).entity(project).build();
    }

    @PUT
    @Path("/{projectId}/changeStatus")
    @Transactional
    public Project changeStatusOfProject(@PathParam("projectId") Long projectId, String status) {
        Project searchedProject = getProjectById(projectId);
        searchedProject.setProjectStatus(status);
        entityManager.merge(searchedProject);
        return searchedProject;
    }

    @DELETE
    @Path("/{projectId}")
    public Response deleteProject(@PathParam("projectId") Long projectId) {
        try {
            Project searchedProject = getProjectById(projectId);
            searchedProject.setProjectStatus("CLOSED/DELETED");
            // entityManager.remove(searchedProject); // actual deletion
        } catch (NoResultException nre) {
            throw new WebApplicationException("Project with id: " + projectId + " not found");
        }
        return Response.noContent().build();
        // return Response.status(204).entity(searchedProject).build();
    }

}
