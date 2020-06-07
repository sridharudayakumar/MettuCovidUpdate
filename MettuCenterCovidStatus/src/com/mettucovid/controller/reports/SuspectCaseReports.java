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


import com.mettucovid.dao.SuspectDao;

import com.mettucovid.dto.Suspect;

/**
 * Servlet implementation class SuspectCaseReports
 */
@WebServlet("/SuspectCaseReports")
public class SuspectCaseReports extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuspectCaseReports() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Suspect> suspectList = new ArrayList<Suspect>();
		//String ageRange= request.getParameter("ageRange");


		try {
			suspectList = SuspectDao.listSuspects();
			
			request.setAttribute("suspectList", suspectList);
			HttpSession session = request.getSession();
			String role= (String) session.getAttribute("role");
			if(role.equals("Administrator"))
			{
				request.setAttribute("fileName", "include/sidebarmenu.jsp");
			}
			else if(role.equals("Hospital Staff"))
			{
				request.setAttribute("fileName", "include/staffsidemenu.jsp");
			}
			else if(role.equals("PRO"))
			{
				request.setAttribute("fileName", "include/ProSideMenu.jsp");
			}
			else 
			{
				request.setAttribute("fileName", "include/policesidemenu.jsp");
			}
			request.getRequestDispatcher("ReportSuspectCase.jsp").forward(request, response);
		} catch (NullPointerException e) {
			response.sendRedirect("login.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}
