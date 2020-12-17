<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard Utente</title>
	<%@ include file="/component/css.html"%>
</head>
<body>
	<%@ include file="/component/navbar.jsp"%>

<div class="alert alert-success" role="alert">
  Modifica i tuoi dati personali qui!
</div>
	<%@ include file="/accounts/anagrafica.jsp"%>
	<hr>
<div class="alert alert-success" role="alert">
  Modifica la tua email qui!
</div>
	<%@ include file="/accounts/modificaEmail.jsp"%>
	<hr>
<div class="alert alert-success" role="alert">
  Modifica la tua password qui!
</div>
	<%@ include file="/accounts/modificaPassword.jsp"%>
	<hr>
<div class="alert alert-success" role="alert">
  Altre azioni:
</div>
	<div class="d-flex justify-content-center">
	<button type="button" class="btn btn-info">Visualizza i tuoi ordini</button>
	<button type="button" class="btn btn-warning">Candidati come agricoltore</button>
	<button type="button" class="btn btn-danger">Richiedi rimozione account</button>
	</div>
	<%@ include file="/component/footer.html"%>
</body>
</html>
<!--  <table class="table">
	<tr class="table-success"><td># Nome</td><td>#  Cognome</td><td># Data di nascita</td></tr>
	<tr><td><input name="nome"  type="text" placeholder="<%= session.getAttribute("username")%>" maxlength="45" > </td><td><%= session.getAttribute("cognome")%></td><td><%= session.getAttribute("dnascita")%></td>
	
	<tr class="table-success"><td># indirizzo</td><td># Città</td><td># CAP</td></tr>
	<tr><td><%= session.getAttribute("indirizzo")%></td><td><%= session.getAttribute("città")%></td><td><%= session.getAttribute("cap")%></td>
	
	<tr class="table-success"><td># Cellulare</td><td># email</td><td># ruolo</td></tr>
	<tr><td><%= session.getAttribute("cellulare")%></td><td><%= session.getAttribute("user")%></td><td><%= session.getAttribute("ruolo")%> <button type="button" class="btn btn-info">candidati agricoltore</button></td>
</table>	-->