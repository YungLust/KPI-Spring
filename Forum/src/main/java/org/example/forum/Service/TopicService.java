package org.example.forum.Service;

import org.example.forum.Model.Topic;
import org.example.forum.Repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepo;

    public TopicService(TopicRepository topicRepo) {
        this.topicRepo = topicRepo;  // Constructor injection
    }

    public List<Topic> getAllTopics() {
        return topicRepo.findAll();
    }

    public Topic getTopic(int id) {
        return topicRepo.findById(id);
    }

    public void createTopic(Topic topic) {
        topicRepo.save(topic);
    }

    public void deleteTopic(int id) {
        topicRepo.delete(id);
    }
}
