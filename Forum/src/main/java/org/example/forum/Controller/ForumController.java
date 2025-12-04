package org.example.forum.Controller;

import org.example.forum.Model.Post;
import org.example.forum.Service.PostService;
import org.example.forum.Service.TopicService;
import org.example.forum.Service.PrototypeHelper;
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

    @Autowired
    private PrototypeHelper prototypeHelper;




/*
    // Home → list of topics
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("topics", topicService.getAllTopics());
        model.addAttribute("protoId", prototypeHelper.getCreatedAt());
        return "topics";
    }
*/

    // /topics → also list of topics
    @GetMapping("/topics")
    public String topics(Model model) {
        model.addAttribute("topics", topicService.getAllTopics());
        return "topics";
    }

    // Show one topic
    @GetMapping("/topic/{id}")
    public String topic(@PathVariable int id, Model model) {
        model.addAttribute("topic", topicService.getTopic(id));
        model.addAttribute("posts", postService.getPosts(id));
        model.addAttribute("users", userService.getAllUsers());   // ← ДОДАВ
        return "topic";  // show topic.html
    }

    // Add post
    @PostMapping("/topic/{id}/post")
    public String addPost(@PathVariable int id, @RequestParam int userId, @RequestParam String text) {
        postService.createPost(new Post(random.nextInt(), id, userId, text));
        return "redirect:/topic/" + id;
    }
}
