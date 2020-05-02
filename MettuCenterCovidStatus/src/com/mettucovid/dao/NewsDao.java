package com.mettucovid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mettucovid.dto.News;

import com.mettucovid.util.ConnectionUtil;

public class NewsDao {

	public static ArrayList<News> listAllnews() throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		String sql = "SELECT * FROM newsfeed ";

		ps = conn.prepareStatement(sql);
		
		rs = ps.executeQuery();

		ArrayList<News> newsList = new ArrayList<News>();
		while (rs.next()) {
			News news = new News();
			news.setId(rs.getInt(1));
			news.setUrl(rs.getString(2));
			news.setDescription(rs.getString(3));
			newsList.add(news);

		}
		return newsList;
	}

	public static int deleteNews(int id) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from newsfeed WHERE id=?";
		ps = conn.prepareStatement(sql);

		
		ps.setInt(1, id);
		

		int result = ps.executeUpdate();
		return result;
	}

	public static int AddNews(News news) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();

		PreparedStatement ps = null;


		String sql = "INSERT INTO newsfeed (url,description) VALUES (?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, news.getUrl());
		ps.setString(2,news.getDescription());
		
		int result = ps.executeUpdate();
		System.out.println("new user");
		ConnectionUtil.closeConnection(ps, conn);
		return result;
	}
	

}
