package pl.bartus.jakub.model;

import java.util.List;

public record GitHubInformation(String name,
                                Owner owner,
                                boolean fork,
                                List<BranchInformation> branchesInformation) {}