package it.unisa.is20.piantalashop.controller;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
//import javax.management.relation.Role;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    { 
     HttpSession session = request.getSession(false); //Fetch session object
 
        if(session!=null) //If session is not null
         {
             session.invalidate(); //removes all session attributes bound to the session
        	 request.setAttribute("Message", "<div id=\"ServletMessage\" class=\"container center_div\" style=\" padding:15px;\">\n" + 
              		"	<div class=\"alert alert-success\" role=\"alert\">Log-out effettuato con successo! Per accedere nuovamente al tuo account rieffettua il log-in.</div>  </div>  "); 
           	 request.setAttribute("Messagemodal", "$('#ServletMessagem').modal('show');");
             RequestDispatcher requestDispatcher = request.getRequestDispatcher("accounts/login.jsp");
             requestDispatcher.forward(request, response);
             System.out.println("Logout effettuato con successo");
         }
    }
}