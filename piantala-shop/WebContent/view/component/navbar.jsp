<nav class="navbar navbar-expand-lg navbar-light bg-light">

<a class="navbar-brand" href="${pageContext.request.contextPath}/view/index.jsp">
	<img src="${pageContext.request.contextPath}/view/assets/images/logo.png" width="30" height="30" class="d-inline-block align-top" alt="logo-piantala">
    homepage
</a>

<div class="collapse navbar-collapse" id="navbarSupportedContent">
	<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
	
	<%if((session.getAttribute("user") != null) ){%>
		<li>
    	<a class="navbar-brand">
  		ruolo attuale: <%=session.getAttribute("ruolo")%></a>
		</li>	
	<%} %>
	
	
    <li class="nav-item">
    	<a class="navbar-brand" href="${pageContext.request.contextPath}/view/index.jsp">
		<img src="${pageContext.request.contextPath}/view/assets/images/product.png" width="30" height="30" class="d-inline-block align-top" alt="logo-piantala">
  		prodotti</a>
    </li>


	<li class="nav-item">
		<%if((session.getAttribute("user")== null) ){%>
		<%}else{%>
    	<a class="navbar-brand" href="${pageContext.request.contextPath}/view/index.jsp">
		<img src="${pageContext.request.contextPath}/view/assets/images/cart.png" width="30" height="30" class="d-inline-block align-top" alt="logo-piantala">
  		carrello</a>
    	<%}%>
	</li>


	<li class="nav-item">
    	<a class="navbar-brand" href="${pageContext.request.contextPath}/view/index.jsp">
		<img src="${pageContext.request.contextPath}/view/assets/images/about-us.png" width="30" height="30" class="d-inline-block align-top" alt="logo-piantala">
  		about us</a>
	</li>


    <li class="nav-item dropdown">
    	<a class="navbar-brand" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    	<img src="${pageContext.request.contextPath}/view/assets/images/profile.png" width="30" height="30" class="d-inline-block align-top" alt="logo-piantala">
    	account
    </a>
    	<div class="dropdown-menu" aria-labelledby="navbarDropdown">
    	
			<%if((session.getAttribute("user")== null)){%>	
        		<a class="dropdown-item" href="${pageContext.request.contextPath}/view/login.jsp">Login</a>
        		<div class="dropdown-divider"></div>
            	<a class="dropdown-item" href="${pageContext.request.contextPath}/view/registration.jsp">Registrati</a>
        		<%}
			
			else if ((session.getAttribute("ruolo").equals("admin")) || session.getAttribute("ruolo").equals("responsabile")) { %> 
          		<a class="dropdown-item" href="${pageContext.request.contextPath}/">Pannello admin</a>
          		<div class="dropdown-divider"></div>
          		<a class="dropdown-item" href="${pageContext.request.contextPath}/Logout">Logout</a>
          	<%}
			
			else if ((session.getAttribute("ruolo").equals("user")) || session.getAttribute("ruolo").equals("agricoltore")){ %> 
      			<a class="dropdown-item" href="${pageContext.request.contextPath}/view/accounts/dashboard.jsp">Dashboard</a>
      			<div class="dropdown-divider"></div>
      			<a class="dropdown-item" href="${pageContext.request.contextPath}/Logout">Logout</a>
      		<%}%>
	</div>
</li>
</ul>
    
<form class="form-inline my-2 my-lg-0">
	<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
</form>
</div>
</nav>

<!-- stile bootstrap -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>