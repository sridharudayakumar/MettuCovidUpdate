package com.mettucovid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mettucovid.dto.News;
import com.mettucovid.dto.User;
import com.mettucovid.util.ConnectionUtil;

public class UserDao {

	public static int insertUser(User user) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();

		PreparedStatement ps = null;


		String sql = "INSERT INTO users(firstName,lastName,email,password,role,status) VALUES (?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, user.getFirstName());
		ps.setString(2,user.getLastName());
		ps.setString(3,user.getEmail());
		ps.setString(4,user.getPassword());
		ps.setString(5,user.getRole());
		ps.setString(6,user.getStatus());
		int result = ps.executeUpdate();
		System.out.println("new user");
		ConnectionUtil.closeConnection(ps, conn);
		return result;
	}

	public static int deleteUser(int id) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from users WHERE USERID=?";
		ps = conn.prepareStatement(sql);

		ps.setInt(1, id);

		int result = ps.executeUpdate();
		return result;
	}

	public static ArrayList<User> listAllUsers() throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String status = "active";

		String sql = "SELECT * FROM users where status=?";

		ps = conn.prepareStatement(sql);
		ps.setString(1, status);
		rs = ps.executeQuery();

		ArrayList<User> userList = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setUserId(rs.getInt(1));
			user.setFirstName(rs.getString(2));
			user.setLastName(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setPassword(rs.getString(5));
			user.setRole(rs.getString(6));


			userList.add(user);

		}
		return userList;
	}

	public static User findOne(int userId) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		// int status = 1;
		String sql = "SELECT * FROM users WHERE userId=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, userId);

		rs = ps.executeQuery();
		User user = new User();
		if (rs.next()) {

			user.setUserId(rs.getInt(1));
			user.setFirstName(rs.getString(2));
			user.setLastName(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setPassword(rs.getString(5));
			user.setRole(rs.getString(6));


		}

		return user;
	}

	public static int updateUser(User user, int id) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "UPDATE users SET firstName=?,lastName=?,email=?,password=?,role=? WHERE userId=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, user.getFirstName());
		ps.setString(2, user.getLastName());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getPassword());
		ps.setString(5, user.getRole());
		ps.setInt(6, id);

		int result = ps.executeUpdate();
		return result;
	}

	public static int changePassword(String username,String oldPassword, String newPassword) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		int status = 1;
		String sql = "SELECT * FROM users WHERE email=? and password=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, oldPassword);
		rs = ps.executeQuery();

		if (rs.next()) {

			sql = "UPDATE users SET password=? WHERE email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, username);


			status = ps.executeUpdate();

		}
		else
		{
			status=0;
		}
		return status;
	}

	public static User checkEmailAvailability(String email) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		// int status = 1;
		String sql = "SELECT * FROM users WHERE email=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, email);

		rs = ps.executeQuery();
		User user = new User();
		if (rs.next()) {

			user.setUserId(rs.getInt(1));
			user.setFirstName(rs.getString(2));
			user.setLastName(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setPassword(rs.getString(5));
			user.setRole(rs.getString(6));


		}else
		{
			user.setFirstName("");
		}

		return user;
	}



}
