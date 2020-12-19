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
        LoginBean loginBean = new LoginBean(); 
        loginBean.setEmail(email);
        loginBean.setPassword(password);

        LoginDao loginDao = new LoginDao();

        String userValidate = loginDao.authenticateUser(loginBean); 

        if(userValidate.equals("normal_user"))
         {	

        	 String nome = loginBean.getNome();
        	 String mails = loginBean.getEmail();
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

             request.getRequestDispatcher("/index.jsp").forward(request, response); 
         } 
        	else if(userValidate.equals("admin_user")){
        		
        			HttpSession session = request.getSession(true);
        			session.setMaxInactiveInterval(240*60);
        			session.setAttribute("id", loginBean.getId());
        			session.setAttribute("ruolo", loginBean.getRuolo());
        			session.setAttribute("user", "admin");
        			session.setAttribute("username", "admin");
            
        			request.getRequestDispatcher("/index.jsp").forward(request, response);
        			System.out.println("Sessione per l'admin Ã¨ stata creata con successo.");
                        
        		}
        			else if(userValidate.equals("agricoltore_user")){
        				
        					String nome = loginBean.getNome();
        					String mails = loginBean.getEmail();
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
            
        					request.getRequestDispatcher("/index.jsp").forward(request, response);
        					System.out.println("Sessione per agricoltore stata creata con successo.");
            
            
        					}else if(userValidate.equals("responsabile_user")){
        						
        							HttpSession session = request.getSession(true);
        							session.setMaxInactiveInterval(240*60);
        							session.setAttribute("id", loginBean.getId());
        							session.setAttribute("ruolo", loginBean.getRuolo());
        							session.setAttribute("user", "responsabile");
        							session.setAttribute("username", "responsabile");
            
        							request.getRequestDispatcher("/index.jsp").forward(request, response);
        							System.out.println("Sessione per responsabile stata creata con successo.");
        				    }        
        					else
        					{
        						request.setAttribute("errorMessage", "Attenzione, credenziali errate. Riprova!"); 
        						request.getRequestDispatcher("/login.jsp").forward(request, response);
         }
    }
}
