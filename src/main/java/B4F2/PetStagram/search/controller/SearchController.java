package B4F2.PetStagram.search.controller;

import B4F2.PetStagram.feed.model.Hashtag;
import B4F2.PetStagram.search.domain.SearchParam;
import B4F2.PetStagram.search.service.SearchService;
import B4F2.PetStagram.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/autocomplete")
    public ResponseEntity<?> autocomplete(@RequestParam String keyword) {
        var result = this.searchService.autocomplete(keyword);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/search")
    public String list(Model model, SearchParam parameter) {

        String type = parameter.getSearchType();
        String value = parameter.getSearchValue();

        if (type.equals("id")) {
            List<Member> context = searchService.getByEmail(value);
            model.addAttribute("list", context);

        } else if (type.equals("tag")) {
            Optional<Hashtag> context = searchService.getByHashtagContext(value);
            model.addAttribute("list", context);

        }

        return "search";
    }
}
