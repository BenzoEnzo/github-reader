package pl.bartus.jakub;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import lombok.RequiredArgsConstructor;
import pl.bartus.jakub.logic.RepositoryService;
import pl.bartus.jakub.model.RepositoryInformation;

import java.util.List;

@Path("/api/repositories")
@RequiredArgsConstructor
public class RepositoryResource {
    private final RepositoryService repositoryService;

    @GET
    @Path("/{username}")
    public Uni<List<RepositoryInformation>> getRepositories(@PathParam("username") String username) {
        return repositoryService.getRepositories(username);
    }
}
