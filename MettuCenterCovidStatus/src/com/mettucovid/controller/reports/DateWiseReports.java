package com.mettucovid.controller.reports;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mettucovid.dao.PatientDao;
import com.mettucovid.dto.Patient;

/**
 * Servlet implementation class DateWiseReports
 */
@WebServlet("/DateWiseReports")
public class DateWiseReports extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateWiseReports() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Patient> patientList = new ArrayList<Patient>();
		String admittedOn= request.getParameter("admittedOn");
		try {
			patientList = PatientDao.listPatientsByDate(admittedOn);
			request.setAttribute("patientList", patientList);
			request.getRequestDispatcher("ReportDateWise.jsp").forward(request, response);
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
