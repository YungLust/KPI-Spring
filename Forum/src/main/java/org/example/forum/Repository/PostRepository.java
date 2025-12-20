package org.example.forum.Repository;

import org.example.forum.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByTopicId(int topicId);
}
