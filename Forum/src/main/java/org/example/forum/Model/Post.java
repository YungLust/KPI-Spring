package org.example.forum.Model;

public class Post {
    private int id;
    private int topicId;
    private String author;
    private String text;

    public Post(int id, int topicId, String author, String text) {
        this.id = id;
        this.topicId = topicId;
        this.author = author;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
