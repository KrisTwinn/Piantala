<form action="<%=request.getContextPath()%>/EmailUpdate" method="post">
<input name="id" type="hidden" value="<%= session.getAttribute("id")%>">
  <div class="form-group">
    <label>Modifica email:</label>
    <div class="input-group mb-3">
    <input name="email" type="email" class="form-control" aria-describedby="basic-addon1" placeholder="<%= session.getAttribute("user")%>" maxlength="45" required="required">
  </div>
  </div>
  <button type="submit" class="btn btn-success">Modifica email </button>
</form>