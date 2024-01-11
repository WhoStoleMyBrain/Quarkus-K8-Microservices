package quarkus.projects;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import quarkus.projects.beans.Project;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class ProjectResourceTest {

    @Test
    public void testGetAllProjects() {
        // Response response = given()
        //   .when().get("/projects")
        //   .then()
        //      .statusCode(200)
        //      .body(
        //         containsString("Sample Project 1"),
        //         containsString("Sample Project 4"),
        //         containsString("IN_PROGRESS")
        //      ).extract().response();
        //      List<Project> receivedResponseList = response.jsonPath().getList("$");
        //      assertThat(receivedResponseList, not(empty()));
        //      assertThat(receivedResponseList, hasSize(4));
    }

    @Test
    public void testGetProjectById() {
        // Project returnedProject = given()
        //     .when().get("/projects/{projectdId}", 12345)
        //     .then()
        //     .statusCode(200)
        //     .extract().as(Project.class);
        // assertThat(returnedProject.getProjectId(), equalTo(12345L));
        // assertThat(returnedProject.getProjectName(), equalTo("Sample Project 1"));
        // assertThat(returnedProject.getProjectStatus(), equalTo("NEW"));

    }

}