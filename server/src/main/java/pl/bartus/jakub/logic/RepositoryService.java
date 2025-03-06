package pl.bartus.jakub.logic;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import pl.bartus.jakub.model.RepositoryInformation;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class RepositoryService {

    public Uni<List<RepositoryInformation>> getRepositories(String username){
        return null;
    }
}
