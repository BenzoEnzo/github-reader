package pl.bartus.jakub.client;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import pl.bartus.jakub.model.BranchInformation;
import pl.bartus.jakub.model.GitHubInformation;

import java.util.List;

@RegisterRestClient(configKey = "github-api")
public interface GitHubClient {
    @GET
    @Path("/users/{username}/repos")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<GitHubInformation>> getGithubRepositories(@PathParam("username") String username);

    @GET
    @Path("/repos/{owner}/{repository}/branches")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<BranchInformation>> getGithubRepositoryBranches(@PathParam("owner") String owner, @PathParam("repository") String repository);
}