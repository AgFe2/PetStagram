package B4F2.PetStagram.feed.controller;

import B4F2.PetStagram.feed.model.MemberParam;
import B4F2.PetStagram.feed.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/")
    public String list(Model model, MemberParam parameter) {
        List<MemberDTO> members = searchService.search(parameter);
        model.addAttribute("list",members);

        return "";
    }
}
