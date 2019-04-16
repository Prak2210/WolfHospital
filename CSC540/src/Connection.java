/*
 *
 * This is an end-point for all application programs to interface with our database. All connections to the database are established from here
 * All db related connections are generated in a generic fashion & this file is a center for this.
 * */
import java.sql.*;
import java.util.List;

public class Connection 
{

   static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
   static final String DB_URL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/pmshah";

   static final String USER = "pmshah";
   static final String PASS = "200251092";
   
   public static ResultSet getResultset(Statement stmt , String query)
   {
	   try 
	   {
		   ResultSet rs = stmt.executeQuery(query);
		   return rs;
	   }
	   catch(SQLException se)
	   {
		   System.out.println("Exception @getResultset "+se.getMessage());
	   }
	   return null;
   }
   
   public static void prepareInsertUpdate(String query , List<String> values)
   {
	   try
	   {
		   Class.forName("org.mariadb.jdbc.Driver").newInstance();
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
		   System.out.println("SQL Exception thwon @Prepapredstamt "+e.getMessage());
	   }
	   
   }
   
   public static boolean insertUpdate(Statement stmt, String query) {
	   try {
		   stmt.executeUpdate(query);
		   System.out.println("Transaction Success!");
	   }
	   catch(SQLException se) {
		   System.out.println("Exception Occurred in given details");
		   try {
			   Connection.getConnectionInstance().rollback();
		   }catch (Exception e){

		   }
		   return false;
	   }
	   return true;
   }
   public static java.sql.Connection getConnectionInstance()
   {
	   java.sql.Connection conn = null;

	   try
	   {
	      Class.forName("org.mariadb.jdbc.Driver").newInstance();
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		   return conn;
	   }
	   catch(Exception e)
	   {
	      e.printStackTrace();
	   }
	   return null;
	   
   }
   public static Statement getInstance()
   {
	   java.sql.Connection conn = null;
	   Statement stmt = null;
	   
	   try
	   {
	      Class.forName("org.mariadb.jdbc.Driver").newInstance();
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

	public static Statement getInstance(java.sql.Connection conn)
	{
		Statement stmt = null;

		try
		{
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