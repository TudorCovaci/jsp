package mvcIntelliJIdea.controller;

import static mvcIntelliJIdea.controller.LoginController.validateSession;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

}
