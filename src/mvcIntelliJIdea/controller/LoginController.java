package mvcIntelliJIdea.controller;

/**
 * Created by forest on 16.12.2014.
 */


import java.io.IOException;
import java.security.InvalidParameterException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvcIntelliJIdea.model.Authenticator;
import mvcIntelliJIdea.model.User;
import mvcIntelliJIdea.validator.TypeValidator;


public class LoginController extends HttpServlet {

    public LoginController() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher rd = null;

        try {
            TypeValidator.validateString(username);
            TypeValidator.validateString(password);
        } catch (InvalidParameterException ex) {
            rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
            return;
        }

        Authenticator authenticator = new Authenticator();
        User result = authenticator.authenticate(username, password);
        if (result != null) {
            rd = request.getRequestDispatcher("/index.html");
            request.setAttribute("user", result);

            HttpSession session = request.getSession();
            session.setAttribute("user", result);
        } else {
            rd = request.getRequestDispatcher("/error.jsp");
        }
        rd.forward(request, response);
    }

    public static boolean validateSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return user != null;
    }

}
