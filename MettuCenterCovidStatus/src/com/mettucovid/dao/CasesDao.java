package com.mettucovid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mettucovid.dto.CaseNumbers;

import com.mettucovid.util.ConnectionUtil;

public class CasesDao {

	public static int updateCases(CaseNumbers ethCases, int id) throws SQLException {

		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		String sql;
		int result = 0;
		int rc=CasesDao.findRecord();
		if(rc==0)
		{
			sql = "INSERT INTO covidcase(id,total,active,cured,critical,deaths) VALUES (?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, ethCases.getTotal());
			ps.setInt(3, ethCases.getActive());
			ps.setInt(4, ethCases.getCured());
			ps.setInt(5, ethCases.getCritical());
			ps.setInt(6, ethCases.getDeath());
			

			 result = ps.executeUpdate();
		}
			
		else
		{
			sql = "UPDATE covidcase SET total=?,active=?,cured=?,critical=?,deaths=? WHERE id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ethCases.getTotal());
			ps.setInt(2, ethCases.getActive());
			ps.setInt(3, ethCases.getCured());
			ps.setInt(4, ethCases.getCritical());
			ps.setInt(5, ethCases.getDeath());
			ps.setInt(6, id);

			 result = ps.executeUpdate();
		}
		return result;
	}

	private static int findRecord() throws SQLException {

		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int recordCount =0;
		String sql = "SELECT * FROM covidcase";
		ps = conn.prepareStatement(sql);


		rs = ps.executeQuery();

		if (rs.next()) {
			recordCount=1;
		}
		return recordCount;
	}

	public static CaseNumbers findOne(int id) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		// int status = 1;
		String sql = "SELECT * FROM covidcase WHERE id=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);

		rs = ps.executeQuery();
		CaseNumbers ethCases= new CaseNumbers();
		if (rs.next()) {

			ethCases.setTotal(rs.getInt("total"));
			ethCases.setActive(rs.getInt("active"));
			ethCases.setCured(rs.getInt("cured"));
			ethCases.setCritical(rs.getInt("critical"));
			ethCases.setDeath(rs.getInt("deaths"));


		}

		return ethCases;
	}



}
