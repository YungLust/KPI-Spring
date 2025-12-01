package org.example.forum.Repository;

import org.example.forum.Model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {

    private final List<Post> posts = new ArrayList<>();

    public PostRepository() {
        posts.add(new Post(1, 1, "Admin", "No crying"));
        posts.add(new Post(2, 1, "Admin", "No swearing"));
        posts.add(new Post(3, 1, "Guest", "Nah bro this too much"));
        posts.add(new Post(4, 1, "Admin", "Yeah man that is tough, anyway please register on the forum so i can ban you, thx"));
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

