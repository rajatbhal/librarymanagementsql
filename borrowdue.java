package dbproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class borrowdue
{

    public static void main(String a[]) //Main Function
{
         
        try
   {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//acaddbprod-1.uta.edu:1523/pcse1p.data.uta.edu","rxc4370","Mustbechanged25");
            Statement stmt = con.createStatement();
            System.out.println("Created DB Connection...."); //Displaying if connection is established with database
            ResultSet rs = stmt.executeQuery("SELECT BOOKINLIB.Title, BOOKINLIB.ISBN, ISSUE_BOOK.SSN FROM BOOKINLIB, ISSUE_BOOK  WHERE BOOKINLIB.ISBN=ISSUE_BOOK.ISBN AND  ISSUE_BOOK.Due_date < SYSDATE;"); 
            while(rs.next())
   {
                System.out.println(rs.getString(1)); //Printing the book title
                System.out.println(rs.getString(2)); //Printing the borrower name
            }
            rs.close();
            con.close(); //Closing the connection with database
        }
  catch (ClassNotFoundException e)
  {
            System.err.print("SQLException: ");
   e.printStackTrace();
        } catch (SQLException e)
  {
            System.err.print("SQLException: ");
   e.printStackTrace();
        }
    }
}