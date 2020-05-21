package mvcIntelliJIdea.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TopicRepository implements Repository {

    private Statement stmt;

    public TopicRepository() {
       stmt =  connect();
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

}
