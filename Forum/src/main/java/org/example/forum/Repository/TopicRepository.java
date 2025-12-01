package org.example.forum.Repository;
import org.example.forum.Model.Topic;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TopicRepository {

    private final Map<Integer, Topic> topics = new HashMap<>();

    public TopicRepository() {
        topics.put(1, new Topic(1, "The Binding of Isaac", "Starter post. Purpose of forum and rules"));
        topics.put(2, new Topic(2, "The Binding of Isaac: Repentance", "Showcase of the newest Isaac DLC."));
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
