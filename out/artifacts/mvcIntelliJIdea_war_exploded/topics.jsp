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
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body>
    <header>
        <form action="/newTopic.html">
            <input type="submit" value="new" />
        </form>
    </header>
    <div class="list-group">
    <%
        List<Topic> topics = (ArrayList<Topic>) request.getAttribute("topics");
        for (Topic t : topics) {
    %>
    <a href="/TopicController?topicid=<%= t.getId() %>" class="list-group-item list-group-item-action active"><%= t.getTitle() %></a>
    <% } %>
    </div>
<hr/>
</body>
</html>
