package it.unisa.is20.piantalashop.controller.user;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;

//import javax.management.relation.Role;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.is20.piantalashop.model.beans.*;
import it.unisa.is20.piantalashop.daos.*;

/*import it.cartcontroll.CartGenerator;
import it.cartcontroll.CartMigration; */

@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
 
    public LoginServlet() // default constructor
    {
    }
 
    	//@SuppressWarnings("null")
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        /* String migrationstatus = ""; */
        //PrintWriter out = response.getWriter();
        LoginBean loginBean = new LoginBean(); 
        /* OrdiniUser ordiniget = new OrdiniUser(); */
        loginBean.setEmail(email);
        loginBean.setPassword(password);
        //Role role = null ;
        LoginDao loginDao = new LoginDao();
        //CartMigration migration = new CartMigration();
        //UsermethodsControll controllmethods = new UsermethodsControll();
        String userValidate = loginDao.authenticateUser(loginBean); 
        //boolean check = false;
        if(userValidate.equals("normal_user"))
         {	
        	 //CartGenerator cart = new CartGenerator();
        	 String nome = loginBean.getNome();
        	 String mails = loginBean.getEmail();
        	 //int id = loginBean.getId();
             HttpSession session = request.getSession(true);
             session.setMaxInactiveInterval(10*60);
             session.setAttribute("id", loginBean.getId());
             session.setAttribute("username", nome);
             session.setAttribute("cognome", loginBean.getCognome());
             session.setAttribute("dnascita", loginBean.getDnascita());
             session.setAttribute("indirizzo", loginBean.getIndirizzo());
             session.setAttribute("città", loginBean.getCittà());
             session.setAttribute("cap", loginBean.getCap());
             session.setAttribute("cellulare", loginBean.getCellulare());
             session.setAttribute("user", mails);
             session.setAttribute("ruolo", loginBean.getRuolo());
             
            /* String cartstatus = cart.generateCart(loginBean);
             int setidcart = cart.setidcart();
             String methodstatus = controllmethods.MethodsControll(id);
             if(methodstatus.equals("nometodi")) {
            	 request.setAttribute("Message", "<div id=\"ServletMessage\" class=\"container center_div\" style=\" padding:15px;\">\n" + 
                 		"	<div class=\"alert alert-warning\" role=\"alert\">Per effettuare acquisti dovresti aggiungere almeno un metodo di pagamento e un indirizzo spedizione dal tuo <form id=\"showp\" action=\"<%=request.getContextPath()%>/showp\" method=\"post\">	<a class=\"dropdown-item\" href=\"javascript:{}\" onclick=\"document.getElementById('showp').submit();\"><strong>Pannello utente</strong></a></form></div>  </div>  "); 
              	 request.setAttribute("Messagemodal", "$('#ServletMessagem').modal('show');");
              	request.setAttribute("Messaget", "Attenzione!");
             }else if(methodstatus.equals("noindirizzo")) {
            	 request.setAttribute("Message", "<div id=\"ServletMessage\" class=\"container center_div\" style=\" padding:15px;\">\n" + 
                  		"	<div class=\"alert alert-warning\" role=\"alert\">Per effettuare acquisti dovresti aggiungere almeno un indirizzo spedizione dal tuo <form id=\"showp\" action=\"<%=request.getContextPath()%>/showp\" method=\"post\">	<a class=\"dropdown-item\" href=\"javascript:{}\" onclick=\"document.getElementById('showp').submit();\"><strong>Pannello utente</strong></a></form></div>  </div>  "); 
              	 request.setAttribute("Messagemodal", "$('#ServletMessagem').modal('show');");
              	request.setAttribute("Messaget", "Attenzione!");
             }else if(methodstatus.equals("nopagamento")) {
            	 request.setAttribute("Message", "<div id=\"ServletMessage\" class=\"container center_div\" style=\" padding:15px;\">\n" + 
                  		"	<div class=\"alert alert-warning\" role=\"alert\">Per effettuare acquisti dovresti aggiungere almeno un metodo di pagamento dal tuo <form id=\"showp\" action=\"<%=request.getContextPath()%>/showp\" method=\"post\">	<a class=\"dropdown-item\" href=\"javascript:{}\" onclick=\"document.getElementById('showp').submit();\"><strong>Pannello utente</strong></a></form></div>  </div>  "); 
              	 request.setAttribute("Messagemodal", "$('#ServletMessagem').modal('show');");
              	request.setAttribute("Messaget", "Attenzione!");
             }
             if(session.getAttribute("ospitecartid")!=null) {
             ArrayList al = (ArrayList) session.getAttribute("ospitecart");
             System.out.println("ospitecart prima di migrazione: " +al);
             migrationstatus = migration.Cartmigrate(setidcart,al);
             }
             //role.setRoleName(loginBean.getRuolo());
             System.out.println("Sessione per l'utente con ruolo "+loginBean.getRuolo()+": "+mails+" con id: "+id+" ï¿½ stata creata con successo.");
             if (migrationstatus.equals("Migrazione_completata")) {
            	 System.out.println("Migrazione carrello completata");
	        		session.removeAttribute("ospitecartid");
	        		session.removeAttribute("ospitecart");
             }else if (migrationstatus.equals("Niente da migrare")) {
            	 System.out.println("Carrello non logged vuoto, niente da migrare");
             }
             try {
             System.out.println("Controllo e inizio generazione carrello.");
             if(cartstatus.equals("carrello_generato")) {
            	 System.out.println("Carrello non presente");
            	 System.out.println("Carrello generato");
            	 System.out.println("Carrello vuoto");
            	 session.setAttribute("idcart",setidcart);
            	 System.out.println("id carrello: "+session.getAttribute("idcart")+"");
            	 check = true;
            	 
             }else if(cartstatus.equals("carrello_caricato")) {
            	 System.out.println("Carrello con status 0 presente.");
            	 System.out.println("Caricamento carrello");
            	 session.setAttribute("idcart",setidcart);
            	 System.out.println("id carrello: "+session.getAttribute("idcart")+"");
            	 check = true;
             }}catch(Exception e) {e.printStackTrace();}
             if (check == true) {
             System.out.println("Check carrello.......");
             System.out.println("Check carrello.......");
             System.out.println("ok");
             RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CartShow");
             dispatcher.include(request, response);
             } */
             request.setAttribute("pagepoint", "1");
             request.getRequestDispatcher("/index.jsp").forward(request, response); 
         } 
        else if(userValidate.equals("admin_user"))
        {
        	HttpSession session = request.getSession(true);
        	session.setMaxInactiveInterval(240*60);
        	session.setAttribute("id", loginBean.getId());
            session.setAttribute("ruolo", loginBean.getRuolo());
            session.setAttribute("user", "admin");
            session.setAttribute("username", "admin");
            
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            System.out.println("Sessione per l'admin Ã¨ stata creata con successo.");
        }
         else
         {
             request.setAttribute("errorMessage", "Attenzione, credenziali errate. Riprova!"); 
             request.getRequestDispatcher("/login.jsp").forward(request, response);
         }
    }
}
