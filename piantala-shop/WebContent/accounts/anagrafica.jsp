<form action="<%=request.getContextPath()%>/" method="post">
<input name="id" type="hidden" value="<%= session.getAttribute("id")%>">
<input name="nome_view" type="hidden" value="<%= session.getAttribute("username")%>">
<input name="cognome_view" type="hidden" value="<%= session.getAttribute("cognome")%>">
<input name="dnascita_view" type="hidden" value="<%= session.getAttribute("dnascita")%>">
<input name="città_view" type="hidden" value="<%= session.getAttribute("città")%>">
<input name="cap_view" type="hidden" value="<%= session.getAttribute("cap")%>">
<input name="cellulare_view" type="hidden" value="<%= session.getAttribute("cellulare")%>">

  <div class="form-row">
    <div class="form-group col-md-4">
      <label>Nome</label>
      <input name="nome"  type="text" class="form-control"  placeholder="<%= session.getAttribute("username")%>" maxlength="45" >
    </div>
    <div class="form-group col-md-4">
      <label>Cognome</label>
      <input name="cognome"   type="text" class="form-control"  placeholder="<%= session.getAttribute("cognome")%>" maxlength="45" >
    </div>
        <div class="form-group col-md-4">
      <label>Data di nascita</label>
      <input name="dnascita" type="text" class="form-control" id="CommentDnascita" placeholder="<%= session.getAttribute("dnascita")%>" onkeyup="validateDnascita(), this.value=this.value.replace(/^(\d\d)(\d)$/g,'$1/$2').replace(/^(\d\d\/\d\d)(\d+)$/g,'$1/$2').replace(/[^\d\/]/g,'')"  >
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-4">
      <label>Città</label>
      <input name="city"   type="text" class="form-control"  placeholder="<%= session.getAttribute("città")%>" maxlength="45" >
    </div>
 <div  class="form-group col-md-4">
      <label>Indirizzo di residenza</label><label id="commentIndirizzoPrompt"></label>
      <input name="indirizzo"  type="text"  class="form-control"  placeholder="<%= session.getAttribute("indirizzo")%>" >
  </div> 
        <div class="form-group col-md-4">
      <label>CAP</label>
      <input name="cap"  type="text" class="form-control"  placeholder="<%= session.getAttribute("cap")%>" maxlength="6" >
    </div>
  </div>
   <div class="form-row">
    <div  class="form-group col-md-12">
      <label>Cellulare</label>
      <input name="cellulare"   type="text" class="form-control"  placeholder="<%= session.getAttribute("cellulare")%>" maxlength="15" >
    </div>
  </div>
  <button type="submit" class="btn btn-success" value="Registrati">Aggiorna Profilo</button>
</form>