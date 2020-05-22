<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="mvcIntelliJIdea.model.Post" %>
<%@ page import="mvcIntelliJIdea.model.Topic" %>
<%@ page import="mvcIntelliJIdea.model.User" %>

<%--
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
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">

</head>
<body>
<%
    Integer userId = ((User) request.getSession().getAttribute("user")).getId();
%>


<h2><%= topic.getTitle()%>
</h2>
<h3>Time: <%= topic.getTimestamp().toString() %>
</h3>
<h3>Content</h3>
<p><%= topic.getContent() %>
</p>
<h3>Create new post</h3>
<form action="/TopicController?topicid=<%=topic.getId()%>" method="post">
    <%--    Content : <input type="text" name="content"> <BR>--%>
    <div class="form-group">
        <label for="contentTextArea">Content</label>
        <textarea name="content" class="form-control" rows="3" cols="5"
                  id="contentTextArea"></textarea> <br>
    </div>
    <input type="submit" class="btn btn-primary" value="Post"/>
</form>

<h3>Posts</h3>
<ul>
    <% List<Post> posts = (ArrayList<Post>) request.getAttribute("posts");
        for (Post p : posts) {%>
    <li>
        <div>Post <%= posts.indexOf(p) + 1 %><br/>
            <label for="content">Content</label>
            <textarea rows="5" readonly id="content"><%=p.getContent()%></textarea>
            <% if (p.getUser_id().equals(userId)) {%>
            <button onclick="document.getElementById('id01').style.display='block'; let id =<%=p.getId()%>">
                Delete
            </button>
            <% } %>
        </div>
    </li>
    <% } %>
    <div id="id01" class="modal">
        <span onclick="document.getElementById('id01').style.display='none'" class="close"
              title="Close">&times;</span>
        <form class="modal-content" action="TopicsController?postid=<%=posts.size()-1%>"
              method="delete">
            <div class="container">
                <h1>Delete post</h1>
                <p>Are you sure you want to delete this post?</p>

                <div class="clearfix">
                    <button type="button" class="cancelbtn">Cancel</button>
                    <button type="button" class="deletebtn">Delete</button>
                </div>
            </div>
        </form>
    </div>
</ul>
</body>
</html>
