package system.controller;

//Import required packages
import java.sql.*;

public class DatabaseConnectionTest {
 public static void main(String[] args) {

     try {
         // Load the MySQL Connector/J driver
         Class.forName("com.mysql.cj.jdbc.Driver");

         // Create a connection
			Connection con = DriverManager.getConnection("jdbc:mysql://bxx0oim5clt3tz9xxlzj-mysql.services.clever-cloud.com:3306/bxx0oim5clt3tz9xxlzj?serverTimezone=Asia/Kuala_Lumpur", "uwaq62nkjirwnjub", "mRrDGZdA1u7UPAXYI5Rm");

         // Check if the connection is successful
         if (con != null) {
             System.out.println("Connected to the database!");
             /*
             PreparedStatement pst = con.prepareStatement("select username from users where userid=1;");
             ResultSet rs = pst.executeQuery();
             while(rs.next()) {
            	 String name = rs.getString("username");
             	System.out.print(name);
             }*/
         } else {
             System.out.println("Failed to connect to the database!");
         }

         // Close the connection
         con.close();
     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}
