package mvcIntelliJIdea.model;


import java.sql.Timestamp;

public class Topic {

    private Integer id;
    private String title;
    private String content;
    private Timestamp timestamp;
    private Integer user_id;

    public Topic(Integer id,
                 String title,
                 String content,
                 Timestamp timestamp,
                 Integer user_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
