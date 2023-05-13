package system.controller;

//Import required packages
import java.sql.*;

public class DatabaseConnectionTest {
 public static void main(String[] args) {

     try {
         // Load the MySQL Connector/J driver
         Class.forName("com.mysql.cj.jdbc.Driver");

         // Create a connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sewa?serverTimezone=Asia/Kuala_Lumpur", "root", "amirulfitriyahya");

         // Check if the connection is successful
         if (con != null) {
             System.out.println("Connected to the database!");
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
