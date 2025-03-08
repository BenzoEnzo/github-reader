package pl.bartus.jakub.mapper;

import org.mapstruct.Mapper;
import pl.bartus.jakub.model.GitHubInformation;
import pl.bartus.jakub.model.RepositoryInformation;

@Mapper(componentModel = "cdi")
public interface RepositoryMapper {
    RepositoryInformation mapToRepositoryInformation(GitHubInformation gitHubInformation);
}