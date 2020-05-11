package com.mettucovid.controller.patient;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mettucovid.dao.PatientDao;

import com.mettucovid.dto.PatientDailyStatus;


/**
 * Servlet implementation class AddPatientDailyStatus
 */
@WebServlet("/AddPatientDailyStatus")
public class AddPatientDailyStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPatientDailyStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		HttpSession session = request.getSession();

		String patientId = request.getParameter("id");

		session.setAttribute("patientId", patientId);
		String role=(String) session.getAttribute("role");
		try {
			if(role.equals("Administrator"))
			{
				request.setAttribute("fileName", "include/sidebarmenu.jsp");
			}
			else if(role.equals("Hospital Staff"))
			{
				request.setAttribute("fileName", "include/staffsidemenu.jsp");
			}



			request.getRequestDispatcher("PatientDailyObservation.jsp").forward(request, response);
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
		HttpSession session = request.getSession();

		String symptoms="";

		PatientDailyStatus patient = new PatientDailyStatus();

		patient.setPatientId(Integer.parseInt(request.getParameter("patientId")));
		patient.setDoo(request.getParameter("doo"));
		patient.setTemperature(Integer.parseInt(request.getParameter("temperature")));
		patient.setBp(request.getParameter("bp"));
		patient.setRbc(request.getParameter("rbc"));
		patient.setWbc(request.getParameter("wbc"));
		patient.setHb(request.getParameter("hb"));
		patient.setHct(request.getParameter("hct"));
		patient.setPlatelets(request.getParameter("platelet"));
		patient.setSpo2(request.getParameter("spo2"));
		String[] tempString = request.getParameterValues("symptoms");
		for(int i=0;i<tempString.length;i++)
		{
			if(i<tempString.length-1)
				symptoms+=tempString[i]+",";
			else
				symptoms+=tempString[i];
		}
		patient.setSymptoms(symptoms);
		System.out.println(patient);

		int result;
		try {
			result = PatientDao.insertDailyStatus(patient);

			System.out.println(result);
			if (result > 0) {

				String role=(String) session.getAttribute("role");
				if(role.equals("Administrator"))
				{
					request.setAttribute("fileName", "include/sidebarmenu.jsp");
				}
				else if(role.equals("Hospital Staff"))
				{
					request.setAttribute("fileName", "include/staffsidemenu.jsp");
				}


				request.getRequestDispatcher("ViewPatientController").forward(request, response);

			} else {
				session.setAttribute("FailureText", "Registration Failed");
				request.getRequestDispatcher("PatientDailyObservation.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*}catch (Exception  e) {
			System.out.println(e);
			session.setAttribute("FailureText", "Registration Failed due to duplicate email id");
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
		}*/
	}

}
