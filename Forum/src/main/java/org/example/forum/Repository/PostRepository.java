package org.example.forum.Repository;

import org.example.forum.Model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {

    private final List<Post> posts = new ArrayList<>();

    public PostRepository() {
        posts.add(new Post(1, 1, 1, "Hello everyone. I`m philia, site manager."));
        posts.add(new Post(1, 1, 1, "The rule here is: ou have to love Lily. That`s all."));
        posts.add(new Post(2, 1, 1, " So feel free to write here anytime about your passion for Lily"));

        posts.add(new Post(1, 2, 3, "Hello everyone, I`m a blue cat. I never knew there was a site like this"));
        posts.add(new Post(2, 2, 3, "So you probably don`t think I`m a true fan. But I hope I`m welcome"));
        posts.add(new Post(3, 2, 1, "Hello, blue cat, we welcome you in our tight community. Please check the first topic on the site: 'What is the forum about' to get all the information you need."));

    }

    public List<Post> findByTopicId(int topicId) {
        return posts.stream()
                .filter(p -> p.getTopicId() == topicId)
                .toList();
    }

    public void save(Post post) {
        posts.add(post);
    }
}

