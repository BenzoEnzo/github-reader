package pl.bartus.jakub;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.Test;
import pl.bartus.jakub.model.*;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@QuarkusTest
public class RepositoryServiceIT {

    @Test
    void getRepositories_happyPath() {
        String username = "octocat";
        String apiPath = "/api/repositories/{username}";

        List<RepositoryInformation> repositories = given()
                .when().get(apiPath, username)
                .then()
                .statusCode(200)
                .extract().as(new TypeRef<>() {
                });

        assertThat(repositories)
                .isNotEmpty()
                .allSatisfy(repo -> {
                    assertThat(repo.name()).isNotBlank();
                    assertThat(repo.username()).isNotBlank();
                    assertThat(repo.branchesInformation()).isNotEmpty();
                    assertThat(repo.branchesInformation()).allSatisfy(branch -> {
                        assertThat(branch.name()).isNotBlank();
                        assertThat(branch.lastCommitSha()).isNotBlank();
                    });
                });
    }
}
