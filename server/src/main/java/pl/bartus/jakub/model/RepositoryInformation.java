package pl.bartus.jakub.model;

import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class RepositoryInformation {
    private String name;
    private Owner owner;
    private boolean fork;
    private List<BranchInformation> branchesInformation;

    @Getter
    public static class Owner {
        private String login;
    }
}