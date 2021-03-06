import java.sql.*;
import java.util.List;

public class Connection 
{

   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/Wolf?zeroDateTimeBehavior=convertToNull";

   static final String USER = "root";
   static final String PASS = "root";
   
   public static ResultSet getResultset(Statement stmt , String query)
   {
	   try 
	   {
		   ResultSet rs = stmt.executeQuery(query);
		   return rs;
	   }
	   catch(SQLException se)
	   {
		   System.out.println("Exception @getResultset"+se.getMessage());
	   }
	   return null;
   }
   
   public static void prepareInsertUpdate(String query , List<String> values)
   {
	   try
	   {
		   Class.forName("com.mysql.jdbc.Driver").newInstance();
		   java.sql.Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
		   
		   PreparedStatement pstmt = con.prepareStatement(query);
		   
		   Integer count = 1;
		   for(String s : values)
		   {
			   pstmt.setString(count, s);
			   count++;
		   }
		   
		   int rowAffected = pstmt.executeUpdate();
	       if(rowAffected == 1)
	       {
	           // get candidate id
	           ResultSet rs = pstmt.getGeneratedKeys();
	           if(rs.next())
	           {
	               String ID  = rs.getString(1);
	               System.out.println("Patient Id returned: "+ID);
	           }

	       }
	   }
	   catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e)
	   {
		   System.out.println("SQL Exception thwon @Prepapredstamt"+e.getMessage());
	   }
	   
   }
   
   public static void insertUpdate(Statement stmt, String query)
   {
	   try
	   {
		   stmt.executeUpdate(query);
		   
		   System.out.println("Transaction Success!");
	   }
	   catch(SQLException se)
	   {
		   System.out.println("Exception @insertUpdate"+se.getMessage());
	   } 
   }
   
   public static Statement getInstance()
   {
	   java.sql.Connection conn = null;
	   Statement stmt = null;
	   
	   try
	   {
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      stmt = conn.createStatement();
	      
	      return stmt;
	   }
	   catch(SQLException se)
	   {
	      se.printStackTrace();
	   }
	   catch(Exception e)
	   {
	      e.printStackTrace();
	   }
	   return null;
	   
   }
}