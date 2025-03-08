package pl.bartus.jakub.model;

import java.util.List;

public record RepositoryInformation(String name,
                                    Owner owner,
                                    List<BranchInformation> branchesInformation) {
}
