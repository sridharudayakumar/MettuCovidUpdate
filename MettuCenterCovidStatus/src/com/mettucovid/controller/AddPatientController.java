package com.mettucovid.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mettucovid.dao.PatientDao;
import com.mettucovid.dto.Patient;


/**
 * Servlet implementation class AddPatientController
 */
@WebServlet("/AddPatientController")
public class AddPatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
				
		
		
		try {

			Patient patient = new Patient();
			patient.setFirstName(request.getParameter("firstName"));
			patient.setLastName(request.getParameter("lastName"));
			patient.setAge(Integer.parseInt(request.getParameter("age")));
			patient.setGender(request.getParameter("gender"));
			patient.setAddress(request.getParameter("address"));
			patient.setRegion(request.getParameter("region"));
			patient.setCountry(request.getParameter("country"));
			patient.setPhoneNo(Long.parseLong(request.getParameter("phoneNo")));
			patient.setRelativePhoneNo(Long.parseLong(request.getParameter("relativePhoneNo")));
			patient.setTravelHistory(request.getParameter("travelHistory"));
			patient.setPreDisease(request.getParameter("preDisease"));
			patient.setNatureOfJob(request.getParameter("natureOfJob"));
			patient.setAdmittedOn(request.getParameter("admittedOn"));
			patient.setContactWithCases(request.getParameter("contactWithCases"));
			patient.setPresentStatus(request.getParameter("presentStatus"));
			patient.setStatus("active");
				
			
			int result = PatientDao.insertPatient(patient);
			System.out.println(result);
			if (result > 0) {

				String SuccessText = "Record Inserted";
				session.setAttribute("SuccessText", SuccessText);
				out.print("<script language='JavaScript'>alert('Data Inserted ');</script>");
				request.getRequestDispatcher("Registerpatients.jsp").forward(request, response);

			} else {
				out.print("<script language='JavaScript'>alert('Data Inserted Failed ');</script>");
				request.getRequestDispatcher("Registerpatients.jsp").forward(request, response);
			}
		}catch (Exception  e) {
			System.out.println(e);
			request.getRequestDispatcher("404.html").forward(request, response);
		}



	}

}
