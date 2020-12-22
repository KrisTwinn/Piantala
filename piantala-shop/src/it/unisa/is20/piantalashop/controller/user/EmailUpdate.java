package it.unisa.is20.piantalashop.controller.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * Servlet implementation class emailUpdate
 */
@WebServlet("/EmailUpdate")
public class EmailUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		int id = Integer.parseInt(request.getParameter("id"));
		String tempmail= "";
		HttpSession session = request.getSession(true);
		Connection con;
		PreparedStatement ps;
		Statement st;
		if(session.getAttribute("id")!=null) {
		try {
			con = DBconnection.createConnection();
		if(!email.equals("")) {
			String checkemail = "SELECT * FROM user where email ='"+email+"';";
			int flag = 0;				
			ps = con.prepareStatement(checkemail);
			ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
				 tempmail=rs.getString(10);
				 if(email.equals(tempmail)) {
				 flag++;
				 }
			 }
			 if (flag < 1) {
				 String qmail ="UPDATE user SET email ='"+email+"' WHERE id ='"+id+"'";
				 st = con.createStatement();
				 st.executeUpdate(qmail);
				 session.setAttribute("user", email);
		         con.close();
				 System.out.println("Mail profilo "+id+" aggiornata!");
				 request.setAttribute("Message", "Email aggiornata");
				 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/accounts/dashboard.jsp");
		            dispatcher.forward(request, response);
			 }
			 else {
				 	System.out.println("la mail già esiste");
				 	request.setAttribute("Message", "la mail che hai inserito esiste già");
				 	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/accounts/dashboard.jsp");
	            dispatcher.forward(request, response);
				}
		}
		}
		catch(Exception e) {}
		}
        else {
			request.setAttribute("errorMessage", "Sessione scaduta, rieffettua il login, grazie!");
			request.getRequestDispatcher("/view/login.jsp").forward(request, response);
		}
	}
	}
		