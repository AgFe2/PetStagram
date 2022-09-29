package B4F2.PetStagram.tag.service;

import B4F2.PetStagram.feed.domain.FeedDto;
import B4F2.PetStagram.feed.entity.FeedEntity;
import B4F2.PetStagram.tag.domain.TagDto;
import B4F2.PetStagram.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    private final Character tagChar = '#';

    public void regisTag(FeedDto feedDto) {

        String[] tagList = feedDto.getMainText().split(" ");

        for(String a : tagList) {
            if (a.charAt(0) == tagChar) {
                tagRepository.save(new TagDto.regisTagDto().toEntity(a.substring(1), feedDto.getFeedId()));
            }
        }

    }

}
