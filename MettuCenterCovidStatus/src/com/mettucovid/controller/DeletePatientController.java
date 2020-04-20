package com.mettucovid.controller;

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


/**
 * Servlet implementation class DeletePatientController
 */
@WebServlet("/DeletePatientController")
public class DeletePatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletePatientController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		int result;
		try {
			result = PatientDao.deletePatient(id);
			if (result > 0) {
				PrintWriter out = response.getWriter();

				HttpSession session = request.getSession();
				String role= (String) session.getAttribute("role");
				if(role.equals("Administrator"))
				{
					out.println("<html>");
					out.println("<head>");
					out.print("<script language='JavaScript'>alert('Data Deleted Successfully  ');</script>");
					out.println("<script> location.replace('ViewPatientController'); </script>");
					out.println("</head>");
					out.println("</html>");
				}
				else
				{
					out.println("<html>");
					out.println("<head>");
					out.print("<script language='JavaScript'>alert('Data Deleted Successfully  ');</script>");
					out.println("<script> location.replace('ShowPatientsInDetail'); </script>");
					out.println("</head>");
					out.println("</html>");
				}
			}
		
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
