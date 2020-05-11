package com.mettucovid.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mettucovid.dao.PatientDao;
import com.mettucovid.dto.CaseNumbers;

/**
 * Servlet implementation class StaffHome
 */
@WebServlet("/StaffHome")
public class StaffHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StaffHome() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CaseNumbers> counttempList = new ArrayList<CaseNumbers>();
		try {
			counttempList= PatientDao.findCaseNumbers();

			request.setAttribute("counttempList", counttempList);
			HttpSession session = request.getSession();
			String role= (String) session.getAttribute("role");
			if(role.equals("Police")||role.equals("Zone Health Bureau"))
				request.getRequestDispatcher("PoliceDashboard.jsp").forward(request, response);
			else if(role.equals("PRO"))
			{
				request.getRequestDispatcher("ProDashboard.jsp").forward(request, response);
			}
			else
				request.getRequestDispatcher("StaffDashboard.jsp").forward(request, response);
		} catch (SQLException e) {
			response.sendRedirect("login.jsp");
		}catch (NullPointerException e) {
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
