package mvcIntelliJIdea.controller;

import static mvcIntelliJIdea.controller.LoginController.validateSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvcIntelliJIdea.model.Post;
import mvcIntelliJIdea.model.Topic;
import mvcIntelliJIdea.model.User;
import mvcIntelliJIdea.service.TopicService;

public class TopicController extends HttpServlet {

    private TopicService topicService;

    public TopicController() {
        super();
        this.topicService = new TopicService();
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        if (!validateSession(req)) {
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher("/topic.jsp");
        this.topicService = new TopicService();
        String param = req.getParameter("topicid");
        Integer id = Integer.parseInt(param);
        Topic topic = topicService.findTopicById(id);
        List<Post> posts = topicService.getAllPostsForTopicId(id);
        if(posts == null){
            posts = new ArrayList<>();
        }
        if (topic != null) {
            req.setAttribute("topic", topic);
            req.setAttribute("posts", posts);
        } else {
            rd = req.getRequestDispatcher("/error.jsp");
        }
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        if(!validateSession(req)){
            return;
        }
        Integer userId = ((User) req.getSession().getAttribute("user")).getId();
        RequestDispatcher rd = req.getRequestDispatcher("/topic.jsp");
        this.topicService = new TopicService();
        String content = req.getParameter("content");
        Integer topicId = Integer.parseInt(req.getParameter("topicid"));
        topicService.addNewPostToTopic(content,userId,topicId);
        Topic topic = topicService.findTopicById(topicId);
        List<Post> posts = topicService.getAllPostsForTopicId(topicId);
        req.setAttribute("topic", topic);
        req.setAttribute("posts", posts);
        rd.forward(req, resp);

    }
}

