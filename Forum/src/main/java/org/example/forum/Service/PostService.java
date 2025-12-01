package org.example.forum.Service;

import org.example.forum.Model.Post;
import org.example.forum.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepo;

    @Autowired
    public void setPostRepo(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    public List<Post> getPosts(int topicId) {
        return postRepo.findByTopicId(topicId);
    }

    public void createPost(Post post) {
        postRepo.save(post);
    }
}
