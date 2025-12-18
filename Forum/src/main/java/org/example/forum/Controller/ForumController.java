package org.example.forum.Controller;

import org.example.forum.Model.Post;
import org.example.forum.Service.PostService;
import org.example.forum.Service.TopicService;
import org.example.forum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class ForumController {

    Random random = new Random();

    @Autowired
    private UserService userService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private PostService postService;

    // /topics → list of topics + pagination + search
    @GetMapping("/topics")
    public String topics(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) String search,
            Model model
    ) {
        var topics = topicService.getTopics(page, size, search);
        int total = topicService.getTopicsCount(search);
        int totalPages = (int) Math.ceil((double) total / size);

        model.addAttribute("topics", topics);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("search", search);

        return "topics";
    }

    // Show one topic
    @GetMapping("/topic/{id}")
    public String topic(@PathVariable int id, Model model) {
        int currentUserId = 1; // administrator just for testing
        model.addAttribute("topic", topicService.getTopic(id));
        model.addAttribute("posts", postService.getPosts(id));
        model.addAttribute("currentUserId", currentUserId);
        return "topic";
    }

    // Add post
    @PostMapping("/topic/{id}/post")
    public String addPost(@PathVariable int id,
                          @RequestParam int userId,
                          @RequestParam String text) {
        postService.createPost(new Post(random.nextInt(), id, userId, text));
        return "redirect:/topic/" + id;
    }
}
