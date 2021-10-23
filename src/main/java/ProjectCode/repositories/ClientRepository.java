package ProjectCode.repositories;

import ProjectCode.Entities.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findByUsername(String username);
}
