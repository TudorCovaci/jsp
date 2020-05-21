package mvcIntelliJIdea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class TopicRepository implements Repository {

    private Statement stmt;

    public TopicRepository() {
        stmt = connect();
    }

    public ResultSet getAllTopics() {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("select * from topics");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    public ResultSet getTopicById(Integer id) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("select * from topics where id=" + id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    public ResultSet insertTopic(String title,
                                 String content,
                                 Timestamp timestamp,
                                 Integer userId) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(
                    "insert into topics(title,content,timestamp,user_id) values ('" + title +
                    "', '" + content + "', '" + timestamp.toString() + "', " + userId +") " +
                    "RETURNING *;");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

}
