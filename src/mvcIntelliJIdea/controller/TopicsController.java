package mvcIntelliJIdea.controller;

import static mvcIntelliJIdea.controller.LoginController.validateSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvcIntelliJIdea.model.Post;
import mvcIntelliJIdea.model.Topic;
import mvcIntelliJIdea.model.User;
import mvcIntelliJIdea.service.TopicService;

public class TopicsController extends HttpServlet {

    private TopicService topicService;


    public TopicsController() {
        super();
        this.topicService = new TopicService();
    }



    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;

        if(!validateSession(request)){
            return;
        }
        //this.topicService = new TopicService();

        List<Topic> result = topicService.getAllTopics();

        if(result != null){
            rd = request.getRequestDispatcher("/topics.jsp");
            request.setAttribute("topics", result);

        }else{
            rd = request.getRequestDispatcher("/error.jsp");
        }
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        if(!validateSession(req)){
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher("/topic.jsp");
        Integer userId = ((User) req.getSession().getAttribute("user")).getId();
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        Topic topic = topicService.addNewTopic(title, content,userId);
        // add confirmation message
        if(topic == null){
            return;
        }
        List<Post> posts = new ArrayList<>();
        req.setAttribute("topic", topic);
        req.setAttribute("posts", posts);
        rd.forward(req, resp);


    }

    @Override
    protected void doDelete(HttpServletRequest req,
                            HttpServletResponse resp) throws ServletException, IOException {
        if(!validateSession(req)){
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher("/topic.jsp");
        Integer postId = Integer.valueOf(req.getParameter("postid"));
        Post post = topicService.deletePostById(postId);
        Topic topic = topicService.findTopicById(post.getTopic_id());
        List<Post> posts = topicService.getAllPostsForTopicId(post.getTopic_id());
        if(posts == null){
            posts = new ArrayList<>();
        }
        if(topic != null){
            req.setAttribute("topic", topic);
            req.setAttribute("posts", posts);

        }
        else {
            rd = req.getRequestDispatcher("/error.jsp");
        }
        rd.forward(req,resp);
    }
}
