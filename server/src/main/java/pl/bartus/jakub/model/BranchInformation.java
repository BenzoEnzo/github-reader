package pl.bartus.jakub.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
class BranchInformation {
    private String name;
    private String lastCommitSha;
}
