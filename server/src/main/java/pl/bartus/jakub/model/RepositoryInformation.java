package pl.bartus.jakub.model;

import lombok.*;

import java.util.List;

@Data
@Builder
public class RepositoryInformation {
    private String name;
    private Owner owner;
    private boolean isFork;
    private List<BranchInformation> branchInformation;

    @Getter
    public static class Owner {
        private String login;
    }
}
