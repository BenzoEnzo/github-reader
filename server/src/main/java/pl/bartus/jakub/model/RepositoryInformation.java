package pl.bartus.jakub.model;

import java.util.List;

public record RepositoryInformation(String name,
                                    String username,
                                    List<BranchInformation> branchesInformation) {
}
