package com.mettucovid.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mettucovid.util.ConnectionUtil;



public class LoginDao {

	public static String checkLoginSession(String username, String password) {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;

		String sql = "SELECT email,password,role FROM users WHERE email=? and password=?";
		

	
		String role = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = null;
			rs = ps.executeQuery();
			
			while (rs.next()) {
				role = rs.getString("role");
				System.out.println(role);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;

	}

}
