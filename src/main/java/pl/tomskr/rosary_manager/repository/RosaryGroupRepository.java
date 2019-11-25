package pl.tomskr.rosary_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tomskr.rosary_manager.domain.RosaryGroup;

@Repository
public interface RosaryGroupRepository extends JpaRepository<RosaryGroup,Long> {
}
