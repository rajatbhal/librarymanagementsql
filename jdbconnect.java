package dbproject1;


import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc.OracleDriver;


public class jdbconnect {
	
	
	  public static void main(String[] args) throws Exception {
		  Class.forName("oracle.jdbc.OracleDriver");
		  DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		 // Connection con= DriverManager.getConnection("jdbc:oracle:thin:@//omega.uta.edu:1531/xe","rxc4370","Mustbechanged25");
	    String url = "jdbc:oracle:thin:@//acaddbprod-1.uta.edu:1523/pcse1p.data.uta.edu";
	    
	    Connection conn = DriverManager.getConnection(url, "rxc4370", "Mustbechanged25");
	    System.out.println("Database connection established");
	 //   conn.close();
	   // System.out.println("Database connection terminated");
	  }
	}