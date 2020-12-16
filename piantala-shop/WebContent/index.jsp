<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login success</title>
</head>
<body>

	<%@ include file="/base/header.jsp"%>

<h1>LOGIN SUCCESS</h1>
<h2>Complimenti,</h2>
<h3><%=session.getAttribute("user")%>, ti sei loggato hihihi</h3>
<h3><%=session.getAttribute("username")%></h3>

<%if ((session.getAttribute("ruolo").equals("user"))){%>
	<p>vedo che sei un utente normale</p>
		<%}else if ((session.getAttribute("ruolo").equals("admin"))){ %>
			<p>vedo che sei un admin :) </p>
<%} %>

<img class="img-thumbnail" src="${pageContext.request.contextPath}/static/pug.jpg" width="100" height="100" />

<a  href="LoginServlet">Login</a>
<a  href="Logout">Logout</a>

	<%@ include file="/base/footer.html"%>
</body>
</html>