package org.example.forum.Service;

import org.example.forum.Model.Topic;
import org.example.forum.Repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepo;

    public TopicService(TopicRepository topicRepo) {
        this.topicRepo = topicRepo;
    }

    // Pagination + filtration
    public List<Topic> getTopics(int page, int size, String search) {
        List<Topic> topics = topicRepo.findAll();

        // Get topics based on the search query of user, if provided
        if (search != null && !search.isBlank()) {
            topics = topics.stream()
                    .filter(t -> t.getTitle().toLowerCase().contains(search.toLowerCase()))
                    .collect(java.util.stream.Collectors.toList());

        }

        // pagination implementation
        int from = page * size;
        int to = Math.min(from + size, topics.size());

        if (from >= topics.size()) {
            return List.of();
        }

        return topics.subList(from, to);
    }

    // updated for pagination
    public int getTopicsCount(String search) {
        if (search == null || search.isBlank()) {
            return topicRepo.findAll().size();
        }

        return (int) topicRepo.findAll().stream()
                .filter(t -> t.getTitle().toLowerCase().contains(search.toLowerCase()))
                .count();
    }

    public List<Topic> getAllTopics() {
        return topicRepo.findAll();
    }

    public Topic getTopic(int id) {
        return topicRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found"));
    }

    public void createTopic(Topic topic) {
        topicRepo.save(topic);
    }

    public void deleteTopic(int id) {
        topicRepo.deleteById(id);
    }
}
