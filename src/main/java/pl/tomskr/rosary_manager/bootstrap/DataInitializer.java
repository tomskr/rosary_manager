package pl.tomskr.rosary_manager.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.tomskr.rosary_manager.domain.Event;
import pl.tomskr.rosary_manager.domain.RosaryGroup;
import pl.tomskr.rosary_manager.repository.RosaryGroupRepository;
import pl.tomskr.rosary_manager.service.RosaryGroupService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RosaryGroupService rosaryGroupService;
    private LocalDate date;

    public DataInitializer(RosaryGroupService rosaryGroupService) {
        this.rosaryGroupService = rosaryGroupService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<RosaryGroup> groups = Arrays.asList(
                new RosaryGroup(1, "Matki Bożej Fatimskiej", true),
                new RosaryGroup(2, "Św. Teresy od Dziec. Jezus", true),
                new RosaryGroup(3, "Matki Bożej Fatimskiej", true),
                new RosaryGroup(4, "Matki Bożej Nieust. Pomocy", true),
                new RosaryGroup(5, "Świętej Jadwigi Królowej", true),
                new RosaryGroup(6, "Miłosierdzia Bożego", true),
                new RosaryGroup(7, "Królowej Anielskiej", true),
                new RosaryGroup(8, "Św. Gertrudy", true),
                new RosaryGroup(9, "Św. Elżbiety Węgierskiej", true),
                new RosaryGroup(10, "Matki Bażej z Lourdes", false),
                new RosaryGroup(11, "Bł. Hiacynty i Franciszka", false),
                new RosaryGroup(12, "Św. Maksymiliana M.Kolbe", true),
                new RosaryGroup(13, "Matki Bożej Gromnicznej", true),
                new RosaryGroup(14, "O. Pio", true)
        );

    }
}
