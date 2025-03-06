package pl.bartus.jakub.client;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import pl.bartus.jakub.model.BranchInformation;
import pl.bartus.jakub.model.RepositoryInformation;
import java.util.List;

@RegisterRestClient(configKey = "github-api")
public interface GitHubClient {
    @GET
    @Path("/users/{username}/repos")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<RepositoryInformation>> getUserGithubRepositories(@PathParam("username") String username);

    @GET
    @Path("/repos/{owner}/{repository}/branches")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<BranchInformation>> getBranches(@PathParam("owner") String owner, @PathParam("repository") String repository);
}
