package pl.bartus.jakub.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RepositoryInformation {
    private String name;
    private String owner;
    private BranchInformation branchInformation;
}
