package org.example.forum.Repository;

import org.example.forum.Model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {

    private final List<Post> posts = new ArrayList<>();

    public PostRepository() {
        posts.add(new Post(1, 1, 1, "Hello everyone. I'm philia, site manager."));
        posts.add(new Post(2, 1, 1, "The rule here is: ou have to love Lily. That's all."));
        posts.add(new Post(3, 1, 1, " So feel free to write here anytime about your passion for Lily"));

        posts.add(new Post(4, 2, 3, "Hello everyone, I'm a blue cat. I never knew there was a site like this"));
        posts.add(new Post(5, 2, 3, "So you probably don't think I'm a true fan. But I hope I'm welcome"));
        posts.add(new Post(6, 2, 1, "Hello, blue cat, we welcome you in our tight community. Please check the first topic on the site: 'What is the forum about' to get all the information you need."));
        posts.add(new Post(7, 2, 2, "Welcome to our community, blue cat"));
        posts.add(new Post(8, 2, 3, "Welcome to our community, blue cat"));
        posts.add(new Post(9, 2, 3, "I am Kaiser"));
        posts.add(new Post(10, 2, 2, "Nice to meet you Kaiser"));
        posts.add(new Post(11, 2, 3, "I hope we can become friends"));
        posts.add(new Post(10, 2, 2, "Yeah hope so"));
        posts.add(new Post(10, 2, 2, "Thanks for your hospitality"));

    }

    public List<Post> findByTopicId(int topicId) {
        return posts.stream()
                .filter(p -> p.getTopicId() == topicId)
                .toList();
    }

    public Post findById(int id) {
        return posts.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void save(Post post) {
        posts.add(post);
    }

    public boolean delete(int id) {
        return posts.removeIf(p -> p.getId() == id);
    }
}
