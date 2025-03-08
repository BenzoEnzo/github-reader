package pl.bartus.jakub.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.bartus.jakub.model.RepositoryInformation;
import pl.bartus.jakub.model.external.GitHubRepositoryInformation;

@Mapper(componentModel = "cdi", uses = {BranchMapper.class})
public interface RepositoryMapper {

    @Mapping(target = "username", source = "owner.login")
    RepositoryInformation mapToRepositoryInformation(GitHubRepositoryInformation gitHubRepositoryInformation);
}