package com.mettucovid.controller.patient;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mettucovid.dao.PatientDao;
import com.mettucovid.dto.Patient;

/**
 * Servlet implementation class AdminPatientInfo
 */
@WebServlet("/AdminPatientInfo")
public class AdminPatientInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPatientInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Patient patient = new Patient();
		int patientId = Integer.parseInt(request.getParameter("id"));

		try {
			patient = PatientDao.findOne(patientId);
			request.setAttribute("patient", patient);
			request.setAttribute("id", patientId);
			HttpSession session = request.getSession();
			String role= (String) session.getAttribute("role");
			if(role.equals("Police")||role.equals("Zone Health Bureau")){
				
				request.setAttribute("fileName", "include/policesidemenu.jsp");
				request.getRequestDispatcher("PolicePatientInfo.jsp").forward(request, response);
			}
			if(role.equals("PRO")){
				request.setAttribute("fileName", "include/ProSideMenu.jsp");
				request.getRequestDispatcher("PolicePatientInfo.jsp").forward(request, response);
				
			}
			
			else if(role.equals("Administrator"))
			request.getRequestDispatcher("AdminPatientInfo.jsp").forward(request, response);
			else
				request.getRequestDispatcher("StaffPatientInfo.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
