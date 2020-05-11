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
import com.mettucovid.dto.Patient;

/**
 * Servlet implementation class ShowPatientsInDetail
 */
@WebServlet("/ShowPatientsInDetail")
public class ShowPatientsInDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowPatientsInDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		try {
			patientList = PatientDao.listAllPatients();
			request.setAttribute("patientList", patientList);
			HttpSession session = request.getSession();
			String role= (String) session.getAttribute("role");
			if(role.equals("Police")||role.equals("Zone Health Bureau"))
			{
				request.setAttribute("fileName", "include/policesidemenu.jsp");
				request.getRequestDispatcher("ShowPatientsinDetail.jsp").forward(request, response);
			}
			else if(role.equals("PRO"))
			{
				request.setAttribute("fileName", "include/ProSideMenu.jsp");
				request.getRequestDispatcher("ShowPatientsinDetail.jsp").forward(request, response);
			}
			else
				request.getRequestDispatcher("ShowPatientsStaff.jsp").forward(request, response);

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
