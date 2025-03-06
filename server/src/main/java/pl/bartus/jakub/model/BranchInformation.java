package pl.bartus.jakub.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BranchInformation {
    private final String name;
    private final Commit commit;

    @Getter
    public static class Commit {
        private String sha;
    }
}