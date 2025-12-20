package org.example.forum.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "topic_seq"
    )
    @SequenceGenerator(
            name = "topic_seq",
            sequenceName = "topic_seq",
            allocationSize = 1
    )
    private int id;

    @Column(name = "user_id")
    private int userId;

    private String title;
    private String description;

    public Topic() {}

    public Topic(int id, int userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }

    public void setId(int id) { this.id = id; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
}
