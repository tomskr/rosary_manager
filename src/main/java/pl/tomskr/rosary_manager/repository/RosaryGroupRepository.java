package pl.tomskr.rosary_manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tomskr.rosary_manager.domain.RosaryGroup;

@Repository
public interface RosaryGroupRepository extends CrudRepository<RosaryGroup,Long> {
}
