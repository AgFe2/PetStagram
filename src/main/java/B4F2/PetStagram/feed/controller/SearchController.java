package B4F2.PetStagram.feed.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class SearchController {

    private final MemberService memberService;

    @GetMapping("/")
    public String list(Model model) {
        List<MemberDTO> members = memberService.list();
        moel.addAttribute("list",members);

        return "";
    }
}
