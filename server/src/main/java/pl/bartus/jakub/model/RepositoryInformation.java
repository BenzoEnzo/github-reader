package pl.bartus.jakub.model;

import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class RepositoryInformation {
    private final String name;
    private final Owner owner;
    private final boolean fork;
    private final List<BranchInformation> branchesInformation;

    @Getter
    public static class Owner {
        private String login;
    }
}