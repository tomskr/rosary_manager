package pl.tomskr.rosary_manager.repository;

import org.springframework.data.repository.CrudRepository;
import pl.tomskr.rosary_manager.domain.RosarySecret;

public interface RosarySecretRepository extends CrudRepository<RosarySecret, Long> {
}
