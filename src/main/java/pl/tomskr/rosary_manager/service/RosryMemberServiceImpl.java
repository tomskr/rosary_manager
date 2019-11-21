package pl.tomskr.rosary_manager.service;

import org.springframework.stereotype.Service;
import pl.tomskr.rosary_manager.domain.RosaryMember;
import pl.tomskr.rosary_manager.repository.RosaryMemberRepository;

import java.util.Optional;

@Service
public class RosryMemberServiceImpl implements RosaryMemberService {
    private final RosaryMemberRepository rosaryMemberRepository;

    public RosryMemberServiceImpl(RosaryMemberRepository rosaryMemberRepository) {
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
    public void deleteById(Long id) {
        rosaryMemberRepository.deleteById(id);
    }

    @Override
    public void save(RosaryMember rosaryMember) {
        rosaryMemberRepository.save(rosaryMember);
    }
}
