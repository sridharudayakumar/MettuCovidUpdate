package com.mettucovid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.mettucovid.dto.Suspect;
import com.mettucovid.util.ConnectionUtil;

public class SuspectDao {

	public static int insertSuspect(Suspect suspect) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();

		PreparedStatement ps = null;


		String sql = "INSERT INTO suspect(name,age,gender,email,phoneNo,address,zone,kebele,woreda,region,country,citizenship,caseType,message) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, suspect.getName());
		ps.setInt(2, suspect.getAge());
		ps.setString(3,suspect.getGender());
		ps.setString(4, suspect.getEmail());
		ps.setLong(5,suspect.getPhoneNo());
		ps.setString(6, suspect.getAddress());
		ps.setString(7, suspect.getZone());
		ps.setString(8,suspect.getKebele());
		ps.setString(9,suspect.getWoreda());
		ps.setString(10, suspect.getRegion());
		ps.setString(11,suspect.getCountry());
		ps.setString(12,suspect.getCitizenship());
		ps.setString(13,suspect.getCaseType());
		ps.setString(14, suspect.getMessage());
		int result = ps.executeUpdate();
		System.out.println("new Suspect");
		ConnectionUtil.closeConnection(ps, conn);
		return result;
	}

	public static ArrayList<Suspect> listSuspects() throws SQLException {

		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		

		String sql = "SELECT * FROM suspect order by id desc;";

		ps = conn.prepareStatement(sql);
	
		rs = ps.executeQuery();

		ArrayList<Suspect> suspectList = new ArrayList<Suspect>();
		while (rs.next()) {
			Suspect suspect = new Suspect();
			suspect.setId(rs.getInt("id"));
			suspect.setName(rs.getString("name"));
			suspect.setAge(rs.getInt("age"));
			suspect.setGender(rs.getString("gender"));
			suspect.setEmail(rs.getString("email"));
			suspect.setPhoneNo(rs.getLong("phoneNo"));
			suspect.setAddress(rs.getString("address"));
			suspect.setZone(rs.getString("zone"));
			suspect.setKebele(rs.getString("kebele"));
			suspect.setWoreda(rs.getString("woreda"));
			suspect.setRegion(rs.getString("region"));
			suspect.setCountry(rs.getString("country"));
			suspect.setCitizenship(rs.getString("citizenship"));
			suspect.setCaseType(rs.getString("caseType"));
			suspect.setMessage(rs.getString("message"));
		



			suspectList.add(suspect);

		}
		return suspectList;
	}



}
