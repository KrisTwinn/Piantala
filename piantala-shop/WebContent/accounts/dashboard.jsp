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

<label>${Message}</label>
<label>${errorMessage}</label>


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
	
	<p>Ruolo attuale: <%=session.getAttribute("ruolo")%></p> <button type="button" class="btn btn-warning">Candidati come agricoltore</button>
	
	<button type="button" class="btn btn-danger">Richiedi rimozione account</button>
	</div>

	<%@ include file="/component/footer.html"%>
</body>
</html>