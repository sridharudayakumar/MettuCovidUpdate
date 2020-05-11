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
 * Servlet implementation class UpdatePatientInfoController
 */
@WebServlet("/UpdatePatientInfoController")
public class UpdatePatientInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePatientInfoController() {
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

			String role=(String) session.getAttribute("role");
			if(role.equals("Administrator"))
				request.getRequestDispatcher("UpdatePatientInfo.jsp").forward(request, response);
			else
				request.getRequestDispatcher("StaffUpdatePatient.jsp").forward(request, response);
		} catch (SQLException e) {
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
		Patient patient = new Patient();

		patient.setFirstName(request.getParameter("firstName"));
		patient.setMiddleName(request.getParameter("middleName"));
		patient.setLastName(request.getParameter("lastName"));

		patient.setAge(Integer.parseInt(request.getParameter("age")));
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
		patient.setSymptoms(request.getParameter("symptoms"));

		int id = Integer.parseInt(request.getParameter("patientId"));

		try {
			int result = PatientDao.updatePatient(patient, id);

			if (result > 0) {
				HttpSession session = request.getSession();
				String SuccessText = "Record Updated";
				session.setAttribute("SuccessText", SuccessText);
				String role=(String) session.getAttribute("role");
				System.out.println(role);
				if(role.equals("Administrator"))
					request.getRequestDispatcher("ViewPatientController").forward(request, response);
				else
					request.getRequestDispatcher("ShowPatientsInDetail").forward(request, response);

			} else {
				request.getRequestDispatcher("UpdatePatientInfo.jsp").forward(request, response);
			}

		} catch (

				SQLException e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


