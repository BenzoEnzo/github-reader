package pl.bartus.jakub.model.external;

import java.util.List;

public record GitHubRepositoryInformation(String name,
                                          Owner owner,
                                          boolean fork,
                                          List<GitHubBranchInformation> branchesInformation) {
}