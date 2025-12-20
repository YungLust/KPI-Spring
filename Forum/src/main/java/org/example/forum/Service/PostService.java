package org.example.forum.Service;

import jakarta.transaction.Transactional;
import org.example.forum.DTO.PostView;
import org.example.forum.Model.Post;
import org.example.forum.Model.User;
import org.example.forum.Model.UserStatus;
import org.example.forum.Repository.PostRepository;
import org.example.forum.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public PostService(PostRepository postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    public List<PostView> getPosts(int topicId) {
        return postRepo.findByTopicId(topicId).stream().map(post -> {
            User u = userRepo.findById(post.getUserId()).orElse(null);

            if (u == null) {
                return new PostView(
                        post.getId(),
                        post.getUserId(),
                        post.getText(),
                        "unknown",
                        UserStatus.UNKNOWN.name()
                );
            }
            return new PostView(
                    post.getId(),
                    post.getUserId(),
                    post.getText(),
                    u.getName(),
                    u.getStatus()
            );
        }).toList();
    }

    public Post getPost(int id) {
        return postRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional
    public Post createPost(Post post) {
        return postRepo.save(post);
    }

    @Transactional
    public Post patchPost(int id, String newText) {
        Post p = postRepo.findById(id).orElse(null);
        if (p == null) return null;
        p.setText(newText);
        return p;
    }

    @Transactional
    public boolean deletePost(int id) {
        if (!postRepo.existsById(id)) return false;
        postRepo.deleteById(id);
        return true;
    }
}
