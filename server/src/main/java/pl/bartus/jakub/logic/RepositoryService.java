package pl.bartus.jakub.logic;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import pl.bartus.jakub.client.GitHubClient;
import pl.bartus.jakub.model.RepositoryInformation;
import java.util.List;

@ApplicationScoped
public class RepositoryService {

    @RestClient GitHubClient gitHubClient;

    public Uni<List<RepositoryInformation>> getRepositories(String username){
        return gitHubClient.getUserGithubRepositories(username);
    }
}
