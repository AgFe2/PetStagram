package B4F2.PetStagram.feed.controller;

import B4F2.PetStagram.feed.model.Hashtag;
import B4F2.PetStagram.feed.model.Member;
import B4F2.PetStagram.feed.model.SearchParam;
import B4F2.PetStagram.feed.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class SearchController {

    private final SearchService searchService;

    //this.searchService.addAutocompleteKeyword(Member.memberId);

    @GetMapping("/autocomplete")
    public ResponseEntity<?> autocomplete(@RequestParam Long keyword) {
        var result = this.searchService.getMemberIdByKeyword(keyword);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/")
    public String list(Model model, SearchParam parameter) {

        String type = parameter.searchType;
        String value = parameter.searchValue;

        if (type.equals("id")) {
            Optional<Member> context = searchService.getByMemberId(Long.valueOf(value));
            model.addAttribute("list", context);

        } else if (type.equals("tag")) {
            Optional<Hashtag> context = searchService.getByHashtagContext(value);
            model.addAttribute("list", context);

        }

        return "";
    }
}
