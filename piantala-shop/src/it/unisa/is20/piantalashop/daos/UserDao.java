package it.unisa.is20.piantalashop.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.unisa.is20.piantalashop.model.beans.UserBean;
import it.unisa.is20.piantalashop.model.DBconnection;
 
public class UserDao {
     public String userRole(UserBean UserBean)
     {
         Connection con = null;
         Statement statement = null;
         ResultSet resultSet = null;
         
         String email = UserBean.getEmail();
         String password = UserBean.getPassword();
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
            	  UserBean.setId(id);
            	  UserBean.setRuolo(ruoloDB);
                  return "admin_user";
              }
                  else if(email.equals(emailDB) && password.equals(passwordDB) && ruoloDB.equals("user")) {
                	  UserBean.setId(id);
                	  UserBean.setNome(nome);
                	  UserBean.setCognome(cognome);
                	  UserBean.setDnascita(dnascita);
                	  UserBean.setIndirizzo(indirizzo);
                	  UserBean.setCittà(città);
                	  UserBean.setCap(cap);
                	  UserBean.setCellulare(cellulare);
                      UserBean.setEmail(email);
                      UserBean.setRuolo(ruoloDB);
                	  return "normal_user";
                  }else if(email.equals(emailDB) && password.equals(passwordDB) && ruoloDB.equals("agricoltore")) {
                	  UserBean.setId(id);
                	  UserBean.setNome(nome);
                	  UserBean.setCognome(cognome);
                	  UserBean.setDnascita(dnascita);
                	  UserBean.setIndirizzo(indirizzo);
                	  UserBean.setCittà(città);
                	  UserBean.setCap(cap);
                	  UserBean.setCellulare(cellulare);
                      UserBean.setEmail(email);
                      UserBean.setRuolo(ruoloDB);
                	  return "agricoltore_user";
                  }else if(email.equals(emailDB) && password.equals(passwordDB) && ruoloDB.equals("responsabile")) {
                	  UserBean.setId(id);
                      UserBean.setEmail(email);
                      UserBean.setRuolo(ruoloDB);
                	  return "responsabile_user";
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
     
     public String insertUser(UserBean UserBean) {
		return null;
     }
     public String deleteUser(UserBean UserBean) {
		return null;
     }
     public String updateUser(UserBean UserBean) {
		return null;
     }
     public String viewUser(UserBean UserBean) {
		return null;
     }
     }

