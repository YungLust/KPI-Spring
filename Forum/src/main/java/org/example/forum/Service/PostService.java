package org.example.forum.Service;

import org.example.forum.DTO.PostView;
import org.example.forum.Model.Post;
import org.example.forum.Model.User;
import org.example.forum.Model.UserStatus;
import org.example.forum.Repository.PostRepository;
import org.example.forum.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepo;
    private UserRepository userRepo;

    @Autowired
    public void setPostRepo(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Autowired
    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    //get all posts in topic and transform them to DTO (READ)
    public List<PostView> getPosts(int topicId) {
        return postRepo.findByTopicId(topicId).stream().map(post -> {
            User u = userRepo.findById(post.getUserId());

            if (u == null) {
                return new PostView(
                        post.getId(),
                        post.getUserId(),
                        post.getText(),
                        "unknown-user:" + post.getUserId(),
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

    // READ (single)
    public Post getPost(int id) {
        return postRepo.findById(id);
    }

    // CREATE
    public void createPost(Post post) {
        postRepo.save(post);
    }

    // PATCH with RFC7386 (Merge Patch)
    public Post patchPost(int id, String newText) {
        Post existing = postRepo.findById(id);
        if (existing == null) return null;
        existing.setText(newText);
        return existing;
    }



    // DELETE
    public boolean deletePost(int id) {
        return postRepo.delete(id);
    }


    // check for permission to edit
    public boolean canEdit(Post post, User user) {
        if (user == null) return false;

        // only author can edit
        return post.getUserId() == user.getId();
    }

    // check for permission to delete
    public boolean canDelete(Post post, User user) {
        if (user == null) return false;

        // author or admin can delete
        return post.getUserId() == user.getId()
                || UserStatus.ADMIN.name().equals(user.getStatus());
    }

}
