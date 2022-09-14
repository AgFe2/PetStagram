package B4F2.PetStagram.feed.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final MemberRepository memberRepository;

    public List<Member> searchByName(String name) {

    }

    public void getById(Long id) {
        return memberRepository.findAllById(id);
    }
    public void getByTag(Long tag) {
        return memberRepository.findAllByTag(tag);
    }
}
