package it.unisa.is20.piantalashop.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.unisa.is20.piantalashop.model.beans.LoginBean;
import it.unisa.is20.piantalashop.model.DBconnection;
 
public class LoginDao {
     public String authenticateUser(LoginBean loginBean)
     {
         String email = loginBean.getEmail();
         String password = loginBean.getPassword();

         Connection con = null;
         Statement statement = null;
         ResultSet resultSet = null;
         
         int id = 0;
         String nome = "";
         String cognome = "";
         String dnascita = "";
         String indirizzo ="";
         String città = "";
         int cap = 0;
         String cellulare = "";
         
         String emailDB = "";
         String passwordDB = "";
         String ruoloDB = "";
         
         try
         {
             con = DBconnection.createConnection(); 
             statement = con.createStatement(); 
             resultSet = statement.executeQuery("select * from user where email='"+email+"'");  
             while(resultSet.next()) { 
            	 id=resultSet.getInt("id");
            	 nome=resultSet.getString("nome");
            	 cognome=resultSet.getString("cognome");
            	 dnascita=resultSet.getString("dnascita");
            	 indirizzo=resultSet.getString("indirizzo");
            	 città=resultSet.getString("città");
            	 cap=resultSet.getInt("cap");
            	 cellulare=resultSet.getString("cellulare");
            	 emailDB = resultSet.getString("email"); 
            	 passwordDB = resultSet.getString("password");
            	 ruoloDB = resultSet.getString("ruolo");
            	
              if(email.equals(emailDB) && password.equals(passwordDB) && ruoloDB.equals("admin")) {
            	  loginBean.setId(id);
            	  loginBean.setRuolo(ruoloDB);
                  return "admin_user";
              }
                  else if(email.equals(emailDB) && password.equals(passwordDB) && ruoloDB.equals("user")) {
                	  loginBean.setId(id);
                	  loginBean.setNome(nome);
                	  loginBean.setCognome(cognome);
                	  loginBean.setDnascita(dnascita);
                	  loginBean.setIndirizzo(indirizzo);
                	  loginBean.setCittà(città);
                	  loginBean.setCap(cap);
                	  loginBean.setCellulare(cellulare);
                      loginBean.setEmail(email);
                      loginBean.setRuolo(ruoloDB);
                	  return "normal_user";
                  }else return "wrong_login";
             }
             con.close();
         }
             catch(SQLException e)
             {
                e.printStackTrace();
             }
             return "Credenziali errate";
         }
     }

