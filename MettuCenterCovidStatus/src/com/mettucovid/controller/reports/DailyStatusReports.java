package com.mettucovid.controller.reports;

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

import com.mettucovid.dto.PatientDailyStatus;

/**
 * Servlet implementation class DailyStatusReports
 */
@WebServlet("/DailyStatusReports")
public class DailyStatusReports extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DailyStatusReports() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		HttpSession session = request.getSession();

		String role= (String) session.getAttribute("role");
		try {
			if(role.equals("Administrator"))
			{
				request.setAttribute("fileName", "include/sidebarmenu.jsp");
			}
			else if(role.equals("Hospital Staff"))
			{
				request.setAttribute("fileName", "include/staffsidemenu.jsp");
			}


			request.getRequestDispatcher("ReportPatientDailyStatus.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException e) {
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<PatientDailyStatus> patientList = new ArrayList<PatientDailyStatus>();
		HttpSession session = request.getSession();
		int patientId= Integer.parseInt(request.getParameter("patientId"));
		try {
			patientList = PatientDao.listPatientStaus(patientId);

			String role= (String) session.getAttribute("role");
			if(role.equals("Administrator"))
			{
				request.setAttribute("fileName", "include/sidebarmenu.jsp");
			}
			else if(role.equals("Hospital Staff"))
			{
				request.setAttribute("fileName", "include/staffsidemenu.jsp");
			}

			request.setAttribute("patientList", patientList);
			request.getRequestDispatcher("ReportPatientDailyStatus.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
