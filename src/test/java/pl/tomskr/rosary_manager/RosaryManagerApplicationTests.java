package pl.tomskr.rosary_manager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tomskr.rosary_manager.repository.RosaryGroupRepository;
import pl.tomskr.rosary_manager.service.RosaryGroupService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class RosaryManagerApplicationTests {

    @Autowired
    RosaryGroupRepository rosaryGroupRepository;

    @Test
    void testRosaryRepository(){
        long count = rosaryGroupRepository.count();
        assertThat(count).isGreaterThan(0);

    }

    @Test
    void contextLoads() {
    }

}
