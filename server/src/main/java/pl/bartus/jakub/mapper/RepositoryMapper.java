package pl.bartus.jakub.mapper;

import pl.bartus.jakub.model.BranchInformation;
import pl.bartus.jakub.model.RepositoryInformation;
import java.util.List;

public class RepositoryMapper {

    public static RepositoryInformation mapToRepositoryInformation(RepositoryInformation repositoryInformation, List<BranchInformation> branches) {
        List<BranchInformation> branchesInfo = branches.stream()
                .map(branch -> BranchInformation.builder()
                        .name(branch.getName())
                        .commit(branch.getCommit())
                        .build())
                .toList();

        return RepositoryInformation.builder()
                .name(repositoryInformation.getName())
                .owner(repositoryInformation.getOwner())
                .branchesInformation(branchesInfo)
                .build();
    }
}