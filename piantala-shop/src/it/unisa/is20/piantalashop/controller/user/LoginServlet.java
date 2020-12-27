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
        UserBean UserBean = new UserBean(); 
        UserBean.setEmail(email);
        UserBean.setPassword(password);

        UserDao UserDao = new UserDao();

        String userValidateRole = UserDao.userRole(UserBean); 

        if(userValidateRole.equals("normal_user"))
         {	

        	 String nome = UserBean.getNome();
        	 String mails = UserBean.getEmail();
             HttpSession session = request.getSession(true);
             session.setMaxInactiveInterval(10*60);
             session.setAttribute("id", UserBean.getId());
             session.setAttribute("nome", nome);
             session.setAttribute("cognome", UserBean.getCognome());
             session.setAttribute("dnascita", UserBean.getDnascita());
             session.setAttribute("indirizzo", UserBean.getIndirizzo());
             session.setAttribute("città", UserBean.getCittà());
             session.setAttribute("cap", UserBean.getCap());
             session.setAttribute("cellulare", UserBean.getCellulare());
             session.setAttribute("email", mails);
             session.setAttribute("ruolo", UserBean.getRuolo());

             request.getRequestDispatcher("view/index.jsp").forward(request, response); 
         } 
        	else if(userValidateRole.equals("admin_user")){
        		
        			HttpSession session = request.getSession(true);
        			session.setMaxInactiveInterval(240*60);
        			session.setAttribute("id", UserBean.getId());
        			session.setAttribute("ruolo", UserBean.getRuolo());
        			session.setAttribute("email", "admin");
        			session.setAttribute("nome", "admin");
            
        			request.getRequestDispatcher("/view/index.jsp").forward(request, response);
        			System.out.println("Sessione per l'admin Ã¨ stata creata con successo.");
                        
        		}
        			else if(userValidateRole.equals("agricoltore_user")){
        				
        					String nome = UserBean.getNome();
        					String mails = UserBean.getEmail();
        					HttpSession session = request.getSession(true);
        					session.setMaxInactiveInterval(10*60);
        					session.setAttribute("id", UserBean.getId());
        					session.setAttribute("nome", nome);
        					session.setAttribute("cognome", UserBean.getCognome());
        					session.setAttribute("dnascita", UserBean.getDnascita());
        					session.setAttribute("indirizzo", UserBean.getIndirizzo());
        					session.setAttribute("città", UserBean.getCittà());
        					session.setAttribute("cap", UserBean.getCap());
        					session.setAttribute("cellulare", UserBean.getCellulare());
        					session.setAttribute("email", mails);
        					session.setAttribute("ruolo", UserBean.getRuolo());
            
        					request.getRequestDispatcher("/view/index.jsp").forward(request, response);
        					System.out.println("Sessione per agricoltore stata creata con successo.");
            
            
        					}else if(userValidateRole.equals("responsabile_user")){
        						
        							HttpSession session = request.getSession(true);
        							session.setMaxInactiveInterval(240*60);
        							session.setAttribute("id", UserBean.getId());
        							session.setAttribute("ruolo", UserBean.getRuolo());
        							session.setAttribute("email", "responsabile");
        							session.setAttribute("nome", "responsabile");
            
        							request.getRequestDispatcher("/view/index.jsp").forward(request, response);
        							System.out.println("Sessione per responsabile stata creata con successo.");
        				    }        
        					else
        					{
        						request.setAttribute("errorMessage", "Attenzione, credenziali errate. Riprova!"); 
        						request.getRequestDispatcher("/view/login.jsp").forward(request, response);
         }
    }
}
