package org.example.forum.Repository;
import org.example.forum.Model.Topic;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TopicRepository {

    private final Map<Integer, Topic> topics = new HashMap<>();

    public TopicRepository() {
        topics.put(1, new Topic(1,1, "What is the forum about", "Starter post for the forum. Purpose of forum and rules"));
        topics.put(2, new Topic(2, 3, "I'm new in your community", null ));
        topics.put(3, new Topic(3, 2, "I'm Kaiser", null ));
        topics.put(4, new Topic(4, 2, "I'm Kaiser", null ));
        topics.put(5, new Topic(5, 2, "I'm Kaiser", null ));
        topics.put(6, new Topic(6, 2, "I'm Kaiser", null ));
        topics.put(7, new Topic(7, 2, "I'm Kaiser", null ));
        topics.put(8, new Topic(8, 2, "I'm Kaiser", null ));
        topics.put(9, new Topic(9, 2, "I'm Kaiser", null ));
        topics.put(10, new Topic(10, 2, "I'm not a Kaiser", null ));
        topics.put(11, new Topic(11, 2, "I'm a Monster", null ));
        topics.put(12, new Topic(12, 2, "How am i?", null ));
        topics.put(13, new Topic(13, 2, "How am i?", null ));
        topics.put(14, new Topic(14, 2, "I'm Kaiser", null ));
        topics.put(15, new Topic(15, 2, "I'm Kaiser", null ));
        topics.put(16, new Topic(16, 2, "I'm Kaiser", null ));
        topics.put(17, new Topic(17, 2, "I'm Kaiser", null ));
        topics.put(18, new Topic(18, 2, "I'm Kaiser", null ));
        topics.put(19, new Topic(19, 2, "I'm Kaiser", null ));
        topics.put(20, new Topic(20, 2, "I'm Kaiser", null ));
        topics.put(21, new Topic(21, 2, "I'm Kaiser", null ));
        topics.put(22, new Topic(22, 2, "I'm Kaiser", null ));

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
