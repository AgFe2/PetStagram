package B4F2.PetStagram.feed.controller;

import B4F2.PetStagram.feed.model.Hashtag;
import B4F2.PetStagram.feed.model.SearchParam;
import B4F2.PetStagram.feed.service.SearchService;
import B4F2.PetStagram.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/autocomplete")
    public ResponseEntity<?> autocomplete(@RequestParam String keyword) {
        var result = this.searchService.autocomplete(keyword);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public String list(Model model, SearchParam parameter) {

        String type = parameter.searchType;
        String value = parameter.searchValue;

        if (type.equals("id")) {
            Optional<Member> context = searchService.getByEmail(value);
            model.addAttribute("list", context);

        } else if (type.equals("tag")) {
            Optional<Hashtag> context = searchService.getByHashtagContext(value);
            model.addAttribute("list", context);

        }

        return "search";
    }
}
