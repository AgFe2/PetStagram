package B4F2.PetStagram.search.service;

import B4F2.PetStagram.member.entity.Member;
import B4F2.PetStagram.member.repository.MemberRepository;
import B4F2.PetStagram.tag.entity.TagEntity;
import B4F2.PetStagram.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.Trie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final Trie trie;
    private final MemberRepository memberRepository;
    private final TagRepository hashtagRepository;

    public List<Member> searchByEmail(String email) {
        return memberRepository.searchByEmail(email);
    }

    public List<TagEntity> getByTagTitle(String hashtagContext) {
        return hashtagRepository.findAllByTagTitleContains(hashtagContext);
    }

    public void addAutocompleteKeyword(String keyword) {
        this.trie.put(keyword, null);
    }

    public List<String> autocomplete(String keyword) {
        return (List<String>) this.trie.prefixMap(keyword).keySet()
                .stream()
                .limit(10)
                .collect(Collectors.toList());
    }

    public void deleteAutocompleteKeyword(String keyword) {
        this.trie.remove(keyword);
    }

}
