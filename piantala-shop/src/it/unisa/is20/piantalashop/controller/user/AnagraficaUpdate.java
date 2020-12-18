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
 * Servlet implementation class anagraficaUpdate
 */
@WebServlet("/AnagraficaUpdate")
public class AnagraficaUpdate extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String dnascita = request.getParameter("dnascita");
		String indirizzo = request.getParameter("indirizzo");
		String città = request.getParameter("città");
		String cap = request.getParameter("cap");
		String cellulare = request.getParameter("cellulare");
		
		String nome_view = request.getParameter("nome_view");
		String cognome_view = request.getParameter("cognome_view");
		String dnascita_view = request.getParameter("dnascita_view");
		String indirizzo_view = request.getParameter("indirizzo_view");
		String città_view = request.getParameter("città_view");
		String cap_view = request.getParameter("cap_view");
		String cellulare_view = request.getParameter("cellulare_view");
		HttpSession session = request.getSession(true);
		Connection con;
		Statement st;
		//PrintWriter out = response.getWriter();
		
		if(session.getAttribute("id")!=null) {
		if(nome.equals("")) nome = nome_view;
		if(cognome.equals("")) cognome = cognome_view;
		if(dnascita.equals("")) dnascita = dnascita_view;
		if(indirizzo.equals("")) indirizzo = indirizzo_view;
		if(città.equals("")) città = città_view;
		if(cap.equals("")) cap = cap_view;
		if(cellulare.equals("")) cellulare = cellulare_view;
		
		try {
			con = DBconnection.createConnection();
			int caps = Integer.parseInt(cap);
			String query ="UPDATE user SET nome = '"+nome+"', cognome = '"+cognome+"', indirizzo = '"+indirizzo+"', dnascita = '"+dnascita+"' , città = '"+città+"' , cap = '"+caps+"' , cellulare = '"+cellulare+"' where id = '"+id+"'";
			System.out.println("Connesso, procedo ad aggiornare!");
			st = con.createStatement();
	        st.executeUpdate(query);
	        con.close();
	        System.out.println("Chiudo la connessione, l'utente con id: "+id+" ï¿½ stato aggiornato correttamente");
	        session.setAttribute("username", nome);
            session.setAttribute("cognome", cognome);
            session.setAttribute("indirizzo", indirizzo);
            session.setAttribute("cap", cap);
            session.setAttribute("città", città);
            session.setAttribute("dnascita", dnascita);
            session.setAttribute("cellulare", cellulare);
            request.setAttribute("Message", "profilo aggiornato"); 
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/accounts/dashboard.jsp");
            dispatcher.forward(request, response);
			}
		catch(Exception er) {er.printStackTrace();}}
        else {
			request.setAttribute("errorMessage", "Sessione scaduta, rieffettua il login, grazie!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
