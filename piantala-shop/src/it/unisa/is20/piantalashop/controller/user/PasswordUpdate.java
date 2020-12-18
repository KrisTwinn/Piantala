package it.unisa.is20.piantalashop.controller.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.is20.piantalashop.model.*;

/**
 * Servlet implementation class PasswordUpdate
 */
@WebServlet("/PasswordUpdate")
public class PasswordUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Connection con;
		//PreparedStatement ps;
		Statement st;
		//PrintWriter out = response.getWriter();
		String password = request.getParameter("password");
		String rpassword = request.getParameter("rpassword");
		int id = Integer.parseInt(request.getParameter("id"));
		 if(session.getAttribute("id")!=null) {
		try {
			con = DBconnection.createConnection();
		if(!password.equals("") && !rpassword.equals("")) {
			if(password.equals(rpassword)) {
			String qpass ="UPDATE user SET password ='"+password+"' WHERE id ='"+id+"'";
			 st = con.createStatement();
			 st.executeUpdate(qpass);
	         con.close();
	         System.out.println("Profilo "+id+" aggiornato!");
	         request.setAttribute("Message", "password aggiornata!");
			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/accounts/dashboard.jsp");
             dispatcher.forward(request, response);
			}
			else  {		
				request.setAttribute("Message", "riprova! errore sui dati!");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/accounts/dashboard.jsp");
	            dispatcher.forward(request, response);
			}
		}
		}
		catch(Exception er) {}}
	        else {
				request.setAttribute("errorMessage", "Sessione scaduta, rieffettua il login, grazie!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		
	}

}
