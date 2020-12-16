package it.unisa.is20.piantalashop.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	public static Connection createConnection()
	 {
	     Connection con = null;
	     try 
	     {
	         try 
	         {
	            Class.forName("com.mysql.cj.jdbc.Driver"); 
	         } 
	         catch (ClassNotFoundException e)
	         {
	            e.printStackTrace();
	         } 
	         con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/piantalashop?user=root&password=ddpxbox96&serverTimezone=Europe/Rome");
	         System.out.println("Printing connection object "+con);
	     } 
	     catch (Exception e) 
	     {
	        e.printStackTrace();
	     }
	     return con; 
	 }
}
