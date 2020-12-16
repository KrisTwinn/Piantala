<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOMEPAGE</title>
</head>
<body>

	<%@ include file="/base/header.jsp"%>

<h1>LOGIN SUCCESS</h1>
<h2>Complimenti,</h2>

<%if((session.getAttribute("user")== null)){%>
<p>non loggato</p>
<%} %>
<%if ((session.getAttribute("user")!= null)){%>
<p>loggato</p>
<%} %>

<img class="img-thumbnail" src="${pageContext.request.contextPath}/static/pug.jpg" width="100" height="100" />

<a  href="accounts/login.jsp">Login</a>
<a  href="Logout">Logout</a>

	<%@ include file="/base/footer.html"%>
</body>
</html>