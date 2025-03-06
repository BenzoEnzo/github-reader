package pl.bartus.jakub.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class BranchInformation {
    private String name;
    private Commit commit;

    @Getter
    public static class Commit {
        String sha;
    }
}
