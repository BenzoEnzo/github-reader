package pl.bartus.jakub.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.bartus.jakub.model.BranchInformation;
import pl.bartus.jakub.model.external.GitHubBranchInformation;

@Mapper(componentModel = "jakarta-cdi")
public interface BranchMapper {
    @Mapping(target = "lastCommitSha", source = "commit.sha")
    BranchInformation mapToBranchInformation(GitHubBranchInformation gitHubBranchInformation);
}
