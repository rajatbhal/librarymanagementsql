package dbproject1;

import java.sql.*;

public class JDBCExample {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:oracle:thin:@//acaddbprod-1.uta.edu:1523/pcse1p.data.uta.edu";

   //  Database credentials
   static final String USER = "rxc4370";
   static final String PASS = "Mustbechanged25";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");
      stmt = conn.createStatement();
      
      String sql = "INSERT INTO LIBRARY_MEMBER " +
                   "VALUES (8142657943, '39 ARBOR OAKS', '44 MITCHELL LANE DALLAS', 4634464748,2,'NO','Active')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO BOOKINLIB " +
                "VALUES ( 978-0465096763, 'Wealthy Poverty Politics', 'Hardcover', 'English','Thomas Sowell','Politics','YES','YES',2,1,'Wealth, Poverty and Politics challenges the assumptions, the definitions, the evidence and the reasoning of most of what is said about differences of income and wealth by people in the media, in academia and in politics')";
    //  stmt.executeUpdate(sql);
    //  sql = "INSERT INTO Registration " +
     //              "VALUES (102, 'Zaid', 'Khan', 30)";
    //  stmt.executeUpdate(sql);
   //   sql = "INSERT INTO Registration " +
    //               "VALUES(103, 'Sumit', 'Mittal', 28)";
      stmt.executeUpdate(sql);
      System.out.println("Inserted records into the table...");

   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample