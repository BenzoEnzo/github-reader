package pl.bartus.jakub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class RepositoryInformation {
    private final String name;
    private final Owner owner;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private final boolean fork;
    private final List<BranchInformation> branchesInformation;

    @Getter
    public static class Owner {
        private String login;
    }
}