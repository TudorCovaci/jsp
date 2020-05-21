package mvcIntelliJIdea.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import mvcIntelliJIdea.model.Post;
import mvcIntelliJIdea.model.Topic;
import mvcIntelliJIdea.repository.PostRepository;
import mvcIntelliJIdea.repository.TopicRepository;

public class TopicService {

    private final TopicRepository topicRepository;
    private final PostRepository postRepository;

    public TopicService() {
        this.topicRepository = new TopicRepository();
        this.postRepository = new PostRepository();
    }

    public List<Topic> getAllTopics() {

        ResultSet rs = topicRepository.getAllTopics();
        String result = "error";
        List<Topic> topics = null;
        try {
            if (rs.next()) {
                topics = new ArrayList<>();
                do {
                    topics.add(new Topic(rs.getInt("id"), rs.getString("title"),
                                         rs.getString("content"), rs.getTimestamp("timestamp"),
                                         rs.getInt("user_id")));
                } while (rs.next());
            }
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return topics;

    }

    public Topic findTopicById(Integer id) {

        ResultSet rs = topicRepository.getTopicById(id);
        try {
            if (rs.next()) {
                return new Topic(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
                                 rs.getTimestamp("timestamp"), rs.getInt("user_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Post> getAllPostsForTopicId(Integer id) {
        ResultSet rs = postRepository.getAllPostsByTopicId(id);
        List<Post> posts = null;
        try {
            if (rs.next()) {
                posts = new ArrayList<>();
                do {
                    posts.add(new Post(rs.getInt("id"), rs.getString("content"),
                                       rs.getTimestamp("timestamp"), rs.getInt("user_id"),
                                       rs.getInt("topic_id")));
                } while (rs.next());
            }
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return posts;
    }

    public boolean addNewPostToTopic(
                                     String content,
                                     Integer userId,
                                     Integer topicId) {
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        try {
            postRepository.insertPostInTopic(content, timestamp, userId, topicId);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }

}
