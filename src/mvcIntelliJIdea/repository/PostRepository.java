package mvcIntelliJIdea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class PostRepository implements Repository {

    private Statement stmt;

    public PostRepository() {
        stmt = connect();
    }

    public ResultSet getAllPostsByTopicId(Integer id) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("select * from posts where topic_id=" + id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    public void insertPostInTopic(String content,
                                  Timestamp timestamp,
                                  Integer userId,
                                  Integer topicId) throws SQLException {
        stmt.executeQuery(
                "insert into posts(content, timestamp, user_id, topic_id) values('" + content +
                "', '" + timestamp.toString() + "', " + userId + ", " + topicId + ");");
    }

}
