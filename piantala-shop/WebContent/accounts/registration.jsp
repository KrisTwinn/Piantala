<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione</title>
</head>
<body>
	<%@ include file="/base/header.jsp"%>
	
	
<form id=regvalidation name="form"action="<%=request.getContextPath()%>/Registration" method="post" onsubmit="">
  <div class="form-row">
    <div class="form-group col-md-4">
    	<label>Nome</label><label id="commentNamePrompt"></label>
      	<input name="nome" id="commentName" onkeyup="validateName()" type="text" class="form-control" id="" placeholder="Nome"  required="required" autocomplete="off">
    </div>
    	<div class="form-group col-md-4">
    	<label>Cognome</label><label id="commentCognomePrompt"></label>
    <input name="cognome" id ="commentCognome" onkeyup="validateCognome()" type="text" class="form-control" id="" placeholder="Cognome" required="required" autocomplete="off">
    </div>
    <div class="form-group col-md-4">
    	<label>Data di nascita</label><label id="commentDNascPrompt"></label>
    	<input name="dnascita" type="text" class="form-control" id="CommentDnascita" placeholder="Data di nascita" onkeyup="validateDnascita(), this.value=this.value.replace(/^(\d\d)(\d)$/g,'$1/$2').replace(/^(\d\d\/\d\d)(\d+)$/g,'$1/$2').replace(/[^\d\/]/g,'')" required="required" >
    </div>
  </div>
  
  <div class="form-row">
    <div class="form-group col-md-4">
      <label>Città</label><label id="commentCittaPrompt"></label>
      <input name="città" id="commentCitta" onkeyup="validateCitta()" type="text" class="form-control" id="" placeholder="Città" required="required" autocomplete="off" >
    </div>
  <div class="form-group col-md-4">
      <label>Indirizzo di residenza</label><label id="commentIndirizzoPrompt"></label>
      <input name="indirizzo" id="commentIndirizzo" onkeyup="validateIndirizzo()" type="text" type="text" class="form-control" id="" placeholder="Indirizzo" required="required" autocomplete="off">
  </div> 
        <div class="form-group col-md-4">
      <label>CAP</label><label id="commentCapPrompt"></label>
      <input name="cap" id="commentCap" onkeyup="validateCap()" type="text" class="form-control" id="" placeholder="CAP" required="required" autocomplete="off"  >
    </div>
  </div>
  <div class="form-row">

  </div>
   <div class="form-row">
    <div  class="form-group col-md-12">
      <label>Cellulare</label><label id="commentPhonePrompt"></label>
      <input name="cellulare" id="commentPhone" onkeyup="validatePhone()" type="text" class="form-control" id="" placeholder="Cellulare" required="required" autocomplete="off" >
    </div>

  </div>
	  <div class="form-row">
    <div class="form-group col-md-4">
      <label>Email</label><label id="commentEmailPrompt"></label>
      <input name="email" id="commentEmail" onkeyup="validateEmail()" type="email" class="form-control" id="" placeholder="Email" required="required" utocomplete="off" >
    </div>
    <div class="form-group col-md-4">
      <label>Password</label><label id="commentPassPrompt"></label>
      <input name="password" id="commentPass" onkeyup="validatePass()" type="password" class="form-control" id="" placeholder="Password" required="required" autocomplete="off">
    </div>
        <div class="form-group col-md-4">
      <label>Ripeti Password</label><label id="commentPass2Prompt"></label>
      <input name="rpassword" id="commentPass2" onkeyup="validatePass2()" type="password" class="form-control"  placeholder="Ripeti Password" required="required" autocomplete="off" >
    </div>
  </div>
  <button type="submit" class="btn btn-primary">Registrati</button><label style="color:red;text-align:center">${Message}</label>
  <label id="errorMessage"></label>
</form>
	
	
	<%@ include file="/base/footer.html"%>
</body>
</html>