package pl.tomskr.rosary_manager.service;

import org.springframework.stereotype.Service;
import pl.tomskr.rosary_manager.domain.RosaryMember;
import pl.tomskr.rosary_manager.repository.RosaryMemberRepository;

import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

@Service
public class RosaryMemberServiceImpl implements RosaryMemberService {
    private final RosaryMemberRepository rosaryMemberRepository;

    public RosaryMemberServiceImpl(RosaryMemberRepository rosaryMemberRepository) {
        this.rosaryMemberRepository = rosaryMemberRepository;
    }

    @Override
    public RosaryMember findById(Long id) {
        Optional<RosaryMember> optionalRosaryMember = rosaryMemberRepository.findById(id);
        if(!optionalRosaryMember.isPresent()){
            throw new RuntimeException("Member not found");
        }
        return optionalRosaryMember.get();
    }

    @Override
    public List<RosaryMember> sortMembers(List<RosaryMember> rosaryMemberList) {

        Collator collatorPL = Collator.getInstance(new Locale("pl","PL"));

        Comparator primaryComparator = Comparator.comparing(RosaryMember::getLastName);
        return rosaryMemberList
                  .stream()
                  .sorted(Comparator
                          .comparing(RosaryMember::getLastName, nullsLast(collatorPL))
                          .thenComparing(RosaryMember::getFirstName)
                  ).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        rosaryMemberRepository.deleteById(id);
    }

    @Override
    public void save(RosaryMember rosaryMember) {
        rosaryMemberRepository.save(rosaryMember);
    }
}
