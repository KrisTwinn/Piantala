<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOMEPAGE</title>
<%@ include file="/component/css.html"%>
</head>
<body>

	<%@ include file="/component/navbar.jsp"%>

<h1>HOME PAGE PIANTALA</h1>

<%if((session.getAttribute("user")== null)){%>
<p>non loggato</p>
<%} %>
<%if ((session.getAttribute("user")!= null)){%>
<p>loggato</p>
<%} %>

<img class="img-thumbnail" src="${pageContext.request.contextPath}/assets/pug.jpg" width="100" height="100" />

<a  href="${pageContext.request.contextPath}/accounts/login.jsp">Login</a>
<a  href="${pageContext.request.contextPath}/Logout">Logout</a>

	<%@ include file="/component/footer.html"%>
</body>
</html>