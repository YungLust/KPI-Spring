package org.example.forum.Repository;
import org.example.forum.Model.Topic;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TopicRepository {

    private final Map<Integer, Topic> topics = new HashMap<>();

    public TopicRepository() {
        topics.put(1, new Topic(1, "What is the forum about", "Starter post for the forum. Purpose of forum and rules", "philia"));
        topics.put(2, new Topic(2, "I`m new in your community", "A newbie in your community just found this site yesterday.", "blue cat"));
    }

    public List<Topic> findAll() {
        return new ArrayList<>(topics.values());
    }

    public Topic findById(int id) {
        return topics.get(id);
    }

    public void save(Topic topic) {
        topics.put(topic.getId(), topic);
    }

    public void delete(int id) {
        topics.remove(id);
    }
}
