package com.mettucovid.controller.patient;

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
 * Servlet implementation class AddPatientInfoController
 */
@WebServlet("/AddPatientInfoController")
public class AddPatientInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPatientInfoController() {
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
		String symptoms = "";



		try {

			Patient patient = new Patient();
			patient.setFirstName(request.getParameter("firstName"));
			patient.setMiddleName(request.getParameter("middleName"));
			patient.setLastName(request.getParameter("lastName"));
			patient.setDob(request.getParameter("dob"));
			patient.setGender(request.getParameter("gender"));
			patient.setEmail(request.getParameter("email"));
			patient.setPhoneNo(Long.parseLong(request.getParameter("phoneNo")));
			patient.setAddress(request.getParameter("address"));
			patient.setZone(request.getParameter("zone"));
			patient.setWoreda(request.getParameter("woreda"));
			patient.setRegion(request.getParameter("region"));
			patient.setCountry(request.getParameter("country"));
			patient.setNatureOfJob(request.getParameter("natureOfJob"));
			patient.setPreDisease(request.getParameter("preDisease"));
			patient.setAdmittedOn(request.getParameter("admittedOn"));
			patient.setTravelHistory(request.getParameter("travelHistory"));
			patient.setContactWithCases(request.getParameter("contactWithCases"));
			patient.setPresentStatus(request.getParameter("presentStatus"));

			patient.setEcfirstName(request.getParameter("ecfirstName"));
			patient.setRelationShip(request.getParameter("relationShip"));
			patient.setEcAddress(request.getParameter("ecAddress"));
			patient.setEcPhoneNo(Long.parseLong(request.getParameter("ecPhoneNo")));
			patient.setEcEmail(request.getParameter("ecEmail"));
			patient.setAllergies(request.getParameter("allergies"));
			patient.setMedications(request.getParameter("medications"));
			patient.setOperation1(request.getParameter("operation1"));
			patient.setDoo1(request.getParameter("doo1"));
			patient.setOperation2(request.getParameter("operation2"));
			patient.setDoo2(request.getParameter("doo2"));
			patient.setOperation3(request.getParameter("operation3"));
			patient.setDoo3(request.getParameter("doo3"));
			patient.setFamilyHistory(request.getParameter("familyHistory"));
			patient.setSmoke(request.getParameter("smoke"));
			patient.setPregnantRisk(request.getParameter("pregnantRisk"));
			String[] tempString = request.getParameterValues("symptoms");
			for(int i=0;i<tempString.length;i++)
			{
				if(i<tempString.length-1)
					symptoms+=tempString[i]+",";
				else
					symptoms+=tempString[i];
			}
			System.out.println(symptoms);
			
			patient.setSymptoms(symptoms);
			

			patient.setStatus("active");


			int result = PatientDao.insertPatient(patient);
			System.out.println(result);
			if (result > 0) {

				String SuccessText = "Record Inserted";
				session.setAttribute("SuccessText", SuccessText);

				String role= (String) session.getAttribute("role");
				if(role.equals("Administrator"))
					request.getRequestDispatcher("PatientInfoRegistration.jsp").forward(request, response);
				else
					request.getRequestDispatcher("StaffRegisterpatients.jsp").forward(request, response);

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


