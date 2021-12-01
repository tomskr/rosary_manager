package pl.tomskr.rosary_manager.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.tomskr.rosary_manager.domain.RosaryGroup;
import pl.tomskr.rosary_manager.repository.RosaryGroupRepository;
import pl.tomskr.rosary_manager.service.RosaryGroupService;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RosaryGroupService rosaryGroupService;

    public DataInitializer(RosaryGroupService rosaryGroupService) {
        this.rosaryGroupService = rosaryGroupService;
    }

    @Override
    public void run(String... args) throws Exception {
        RosaryGroup group000 = new RosaryGroup(1, "Matki Bożej Fatimskiej");
        rosaryGroupService.save(group000);

        RosaryGroup group001 = new RosaryGroup(2, "Św. Teresy od Dziec. Jezus");
        rosaryGroupService.save(group001);

        RosaryGroup group002 = new RosaryGroup(3, "Matki Bożej Fatimskiej");
        rosaryGroupService.save(group002);


    }
}
