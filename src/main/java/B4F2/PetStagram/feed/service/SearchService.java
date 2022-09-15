package B4F2.PetStagram.feed.service;

import B4F2.PetStagram.feed.model.MemberParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final MemberRepository memberRepository;
    private final TagRepository tagRepository;

    public void search(MemberParam parameter) {
        String type = parameter.searchType;
        String value = parameter.searchValue;

        if (type.equals("id")) {
            getById(value);
        } else if (type.equals("tag")) {
            getByTag(value);
        }
    }

    public void getById(Long id) {
        return memberRepository.findAllById(id);
    }

    public void getByTag(Long tag) {
        return tagRepository.findAllByTag(tag);
    }
}
