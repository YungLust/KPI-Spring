package org.example.forum.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_seq"
    )
    @SequenceGenerator(
            name = "post_seq",
            sequenceName = "post_seq",
            allocationSize = 1
    )
    private int id;

    @Column(name = "topic_id")
    private int topicId;

    @Column(name = "user_id")
    private int userId;

    @Column(columnDefinition = "TEXT")
    private String text;

    public Post() {}

    public Post(int id, int topicId, int userId, String text) {
        this.id = id;
        this.topicId = topicId;
        this.userId = userId;
        this.text = text;
    }

    public int getId() { return id; }
    public int getTopicId() { return topicId; }
    public int getUserId() { return userId; }
    public String getText() { return text; }

    public void setId(int id) { this.id = id; }
    public void setTopicId(int topicId) { this.topicId = topicId; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setText(String text) { this.text = text; }
}
