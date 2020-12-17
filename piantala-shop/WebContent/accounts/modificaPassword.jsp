<form action="<%=request.getContextPath()%>/" method="post" onsubmit="return stopsubmit2(this);">
<input name="id" type="hidden" value="<%= session.getAttribute("id")%>">
  <div class="form-group">
    <label>Password</label>
    <div class="input-group mb-3">
    <input  name="password"  type="password" class="form-control" aria-describedby="inputGroup-sizing-default" placeholder="Password" maxlength="45" required="required">
    </div>
  </div>
    <div class="form-group">
    <label>Ripeti password</label>
    <div class="input-group mb-3">
    <input name="rpassword"  type="password" class="form-control"  placeholder="Ripeti Password" required="required">
    </div>
  </div>
  <button type="submit" class="btn btn-success">Modifica password</button>
</form>