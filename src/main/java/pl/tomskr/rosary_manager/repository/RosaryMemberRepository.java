package pl.tomskr.rosary_manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tomskr.rosary_manager.domain.RosaryMember;

@Repository
public interface RosaryMemberRepository extends CrudRepository<RosaryMember, Long> {
}
