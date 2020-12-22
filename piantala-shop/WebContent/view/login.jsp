<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login - piantala.org</title>
<%@ include file="/view/component/css.html"%>
</head>
<body>

	<%@ include file="/view/component/navbar.jsp"%>
	
<form name="form" action="<%=request.getContextPath()%>/LoginServlet" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Indirizzo E-Mail</label>
    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Inserisci email">
    <small id="emailHelp" class="form-text text-muted">Non condivideremo la tua email con nessuno, forse...</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <button type="submit" class="btn btn-primary">Login</button>
</form>
<div style="color:red;text-align:center">${errorMessage}</div>
	
	<%@ include file="/view/component/footer.html"%>
</body>
</html>