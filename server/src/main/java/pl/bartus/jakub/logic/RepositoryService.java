package pl.bartus.jakub.logic;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import pl.bartus.jakub.client.GitHubClient;
import pl.bartus.jakub.exception.UserNotFoundException;
import pl.bartus.jakub.model.ErrorResponse;
import pl.bartus.jakub.model.RepositoryInformation;
import java.util.List;

import static pl.bartus.jakub.mapper.RepositoryMapper.mapToRepositoryInformation;

@ApplicationScoped
public class RepositoryService {

    @RestClient GitHubClient gitHubClient;

    public Uni<List<RepositoryInformation>> getRepositories(String username) {
        return gitHubClient.getGithubRepositories(username)
                .onItem()
                .transformToUni(repositories -> {
                    if (repositories == null || repositories.isEmpty()) {
                        return Uni.createFrom().failure(new UserNotFoundException(new ErrorResponse(404,"User not found")));
                    }

                    List<RepositoryInformation> nonForkRepos = repositories.stream()
                            .filter(repo -> !repo.isFork())
                            .toList();

                    return Multi.createFrom()
                            .iterable(nonForkRepos)
                            .onItem()
                            .transformToUni(repo -> gitHubClient.getGithubRepositoryBranches(repo.getOwner().getLogin(), repo.getName())
                                    .onItem()
                                    .transform(branches -> mapToRepositoryInformation(repo, branches)))
                            .merge()
                            .collect()
                            .asList();
                });
    }
}