<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="mvcIntelliJIdea.model.Post" %>
<%@ page import="mvcIntelliJIdea.model.Topic" %>
<%@ page import="mvcIntelliJIdea.controller.TopicController" %>

<%@ page import="mvcIntelliJIdea.model.User" %><%--
  Created by IntelliJ IDEA.
  User: tudorcovaci
  Date: 21/05/2020
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% Topic topic = (Topic) request.getAttribute("topic"); %>
    <title><%= topic.getTitle() %>
    </title>
</head>
<body>
<% Integer userId = ((User) request.getSession().getAttribute("user")).getId(); %>
<h2><%= topic.getTitle()%>
</h2>
<h3>Time: <%= topic.getTimestamp().toString() %>
</h3>
<h3>Content</h3>
<p><%= topic.getContent() %>
</p>

<%--<form action="/TopicController?topicid=<%=topic.getId()%>" method="post">--%>
<%--    Content : <input type="text" name="content"> <BR>--%>
<%--    <input type="submit" value="Post"/>--%>
<%--</form>--%>

<h3>Posts</h3>
<ul>
    <% List<Post> posts = (ArrayList<Post>) request.getAttribute("posts");
        for (Post p : posts) {%>
    <li>
        <div>Post <%= p.getId() %><br/>Content: <%=p.getContent()%>
            <% if(p.getUser_id().equals(userId))  {%>
            <button value="delete"></button>
            <% } %>
        </div>
    </li>
    <% } %>
</ul>
</body>
</html>
