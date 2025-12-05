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

    //get all posts in topic and transform them to DTO
    public List<PostView> getPosts(int topicId) {
        return postRepo.findByTopicId(topicId).stream().map(post -> {
            User u = userRepo.findById(post.getUserId()); // get post`s author by userId
            if (u == null) {
                return new PostView(
                        post.getText(),
                        "unknown-user:"+post.getUserId(),
                        UserStatus.UNKNOWN.name()
                );
            }
             else {
                return new PostView(
                        post.getText(),
                        u.getName(),
                        u.getStatus()
                );
            }

        }).toList();
    }

    public void createPost(Post post) {
        postRepo.save(post);
    }
}
