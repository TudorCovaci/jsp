package mvcIntelliJIdea.model;

import java.sql.Timestamp;

public class Post {

    private Integer id;
    private String content;
    private Timestamp timestamp;
    private Integer user_id;
    private Integer topic_id;

    public Post(Integer id,
                String content,
                Timestamp timestamp,
                Integer user_id,
                Integer topic_id) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.user_id = user_id;
        this.topic_id = topic_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Integer topic_id) {
        this.topic_id = topic_id;
    }
}
