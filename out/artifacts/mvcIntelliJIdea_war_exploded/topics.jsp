<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="mvcIntelliJIdea.model.Topic" %>
<%--
  Created by IntelliJ IDEA.
  User: tudorcovaci
  Date: 21/05/2020
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Topics</title>
</head>
<body>

    <%
        List<Topic> topics = (ArrayList<Topic>) request.getAttribute("topics");
        for (Topic t : topics) {
    %>
    <a href="/TopicController?topicid=<%= t.getId() %>"><%= t.getTitle() %></a>
    <% } %>
<hr/>
</body>
</html>
