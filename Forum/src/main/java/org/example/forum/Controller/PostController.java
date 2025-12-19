package org.example.forum.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.example.forum.DTO.PostCreateDTO;
import org.example.forum.DTO.PostPatchDTO;
import org.example.forum.Model.Post;
import org.example.forum.Service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    // READ
    @Operation(
            summary = "Get post by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Post found",
                            content = @Content(schema = @Schema(implementation = Post.class))),
                    @ApiResponse(responseCode = "404", description = "Post not found")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable int id) {
        Post post = postService.getPost(id);
        return post != null
                ? ResponseEntity.ok(post)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // CREATE
    @Operation(
            summary = "Create a new post",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Post created",
                            content = @Content(schema = @Schema(implementation = Post.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid request")
            }
    )
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostCreateDTO dto) {

        if (dto.getText() == null || dto.getText().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        Post post = new Post(
                new java.util.Random().nextInt(),
                dto.getTopicId(),
                dto.getUserId(),
                dto.getText()
        );

        postService.createPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }


    // PATCH
    @Operation(
            summary = "Update post text",
            description = "RFC 7386 JSON Merge Patch (text only)",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Post updated",
                            content = @Content(schema = @Schema(implementation = Post.class))),
                    @ApiResponse(responseCode = "404", description = "Post not found")
            }
    )
    @PatchMapping("/{id}")
    public ResponseEntity<Post> patchPost(
            @PathVariable int id,
            @RequestBody PostPatchDTO patch
    ) {
        Post updated = postService.patchPost(id, patch.getText());
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @Operation(
            summary = "Delete post",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Post deleted"),
                    @ApiResponse(responseCode = "404", description = "Post not found")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable int id) {
        boolean deleted = postService.deletePost(id);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
