package it.unisa.is20.piantalashop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.is20.piantalashop.model.DBconnection;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection con = null;
		PreparedStatement ps = null;
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String dnascita = request.getParameter("dnascita");
		String indirizzo = request.getParameter("indirizzo");
		String città = request.getParameter("città");
		String cap = request.getParameter("cap");
		String cellulare = request.getParameter("cellulare");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//String rpassword = request.getParameter("rpassword");
		String ruolo="user";
		String tempcheck= "";
		
		
		try {
			int caps = Integer.parseInt(cap);
			con = DBconnection.createConnection();
			String checkquery = "select * from user where email ='"+email+"';";
			int flag = 0;
			
			ps = con.prepareStatement(checkquery);
			ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
				 tempcheck=rs.getString(2);
				 flag++;
			 }
			 if (flag < 1) {
			String query = "insert into user values (?,?,?,?,?,?,?,?,?,?,?);";
			ps = con.prepareStatement(query);
			ps.setString(1, null);
			ps.setString(2, nome);
			ps.setString(3, cognome);
			ps.setString(4, dnascita);
			ps.setString(5, indirizzo);
			ps.setString(6, città);
			ps.setInt(7, caps);
			ps.setString(8, cellulare);
			ps.setString(9, email);
			ps.setString(10, password);
			ps.setString(11, ruolo);
			
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("Registrazione effettuata");
				request.setAttribute("errMessage", "Registrazione completata! Effettua il login!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);//metodo per post per cambiare pagina
				con.close();
				System.out.println("Connessione chiusa");
			}
		}else {   
		out.print("Errore registrazione");
		request.setAttribute("Message", "Attenzione, la mail che hai inserito &egrave; gi&agrave; esistente!");
		request.getRequestDispatcher("/registration.jsp").forward(request, response);//metodo per post per cambiare pagina
		con.close();
		out.print("Connessione chiusa");  }
		}
		catch (Exception ee) { ee.printStackTrace();}	
		}
}
