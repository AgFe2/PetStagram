package B4F2.PetStagram.feed.controller;

import org.springframework.web.bind.annotation.GetMapping;


public class FeedController {

    @GetMapping("/feed/myList")
    public String myList() {

        return "myList";
    }

    @GetMapping("/feed/followList")
    public String followList() {

        return "followList";
    }

    @GetMapping("/feed/bestList")
    public String bestList() {

        return "bestList";
    }


}
