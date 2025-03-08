package pl.bartus.jakub.logic;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import pl.bartus.jakub.client.GitHubClient;
import pl.bartus.jakub.exception.UserNotFoundException;
import pl.bartus.jakub.mapper.RepositoryMapper;
import pl.bartus.jakub.model.ErrorResponse;
import pl.bartus.jakub.model.GitHubInformation;
import pl.bartus.jakub.model.RepositoryInformation;

import java.util.List;

@ApplicationScoped
public class RepositoryService {

    @RestClient
    GitHubClient gitHubClient;

    @Inject
    RepositoryMapper repositoryMapper;

    public Uni<List<RepositoryInformation>> getRepositories(String username) {
        return fetchGitHubRepositories(username)
                .onItem().transformToUni(repos ->
                        Multi.createFrom().iterable(repos)
                                .onItem().transformToUni(this::enrichRepository)
                                .merge()
                                .collect().asList()
                );
    }

    private Uni<List<GitHubInformation>> fetchGitHubRepositories(String username) {
        return gitHubClient.getGithubRepositories(username)
                .onItem().transform(repositories -> {
                    if (repositories == null || repositories.isEmpty()) {
                        throw new UserNotFoundException(new ErrorResponse(404, "User not found"));
                    }
                    return repositories.stream()
                            .filter(repo -> !repo.fork())
                            .toList();
                });
    }

    private Uni<RepositoryInformation> enrichRepository(GitHubInformation repo) {
        return gitHubClient.getGithubRepositoryBranches(repo.owner().login(), repo.name())
                .onItem().transform(branches -> {
                    GitHubInformation updatedRepo = new GitHubInformation(
                            repo.name(),
                            repo.owner(),
                            repo.fork(),
                            branches
                    );
                    return repositoryMapper.mapToRepositoryInformation(updatedRepo);
                });
    }
}