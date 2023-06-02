package system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import system.model.User;

public class UserDAO {
	
	//User Registration Purpose
	public int registerUser(User user) throws ClassNotFoundException{
		String insert_sql = "insert into User (user_first_name, user_last_name, user_uname, user_phone, user_email, user_pass, user_wallet) values (?, ?, ?, ?, ?, ?, ?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		int rowCount = 0;
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://bxx0oim5clt3tz9xxlzj-mysql.services.clever-cloud.com:3306/bxx0oim5clt3tz9xxlzj?serverTimezone=Asia/Kuala_Lumpur", "uwaq62nkjirwnjub", "mRrDGZdA1u7UPAXYI5Rm");
			PreparedStatement pst = con.prepareStatement(insert_sql);
			pst.setString(1, user.getUser_first_name());
			pst.setString(2, user.getUser_last_name());
			pst.setString(3, user.getUser_uname());
			pst.setString(4, user.getUser_phone());
			pst.setString(5, user.getUser_email());
			pst.setString(6, user.getUser_pass());
			pst.setDouble(7, user.getUser_wallet());
			
			rowCount = pst.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
	}
	
	//User Login Purpose
	public User loginValidation(String email, String password) {
		User user = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://bxx0oim5clt3tz9xxlzj-mysql.services.clever-cloud.com:3306/bxx0oim5clt3tz9xxlzj?serverTimezone=Asia/Kuala_Lumpur", "uwaq62nkjirwnjub", "mRrDGZdA1u7UPAXYI5Rm");
			PreparedStatement pst = con.prepareStatement("select * from User where user_email=? and user_pass=?");
			pst.setString(1, email);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setUser_first_name(rs.getString("user_first_name"));
				user.setUser_last_name(rs.getString("user_last_name"));
				user.setUser_uname(rs.getString("user_uname"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_pass(rs.getString("user_pass"));
				user.setUser_wallet(rs.getDouble("user_wallet"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
