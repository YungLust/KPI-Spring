package org.example.forum.Controller;

import org.example.forum.DTO.PostPatchDTO;
import org.example.forum.Model.Post;
import org.example.forum.Service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable int id) {
        Post post = postService.getPost(id);
        if (post == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(post);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Post> patchPost(
            @PathVariable int id,
            @RequestBody PostPatchDTO patch
    ) {
        Post updated = postService.patchPost(id, patch.getText());
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable int id) {
        boolean deleted = postService.deletePost(id);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
