package com.mettucovid.controller.user;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mettucovid.dao.UserDao;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		HttpSession session = request.getSession();
		System.out.println("inside doget");
		String role= (String) session.getAttribute("role");
		System.out.println(role);
		try {
		if(role.equals("null"))
		{
			response.sendRedirect("login.jsp");
		}
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
		
			request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
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
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		HttpSession session = request.getSession();
		String role= (String) session.getAttribute("role");
		String username = (String) session.getAttribute("userName");
		System.out.println(username);
		try {
			int status = UserDao.changePassword(username,oldPassword,newPassword);
			if(role.equals("null"))
			{
				response.sendRedirect("login.jsp");
			}
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
			if(status>0)
			{
				
				
					request.setAttribute("message", "Password Changed Successfully");
					request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
			}
			else
			{
				
				request.setAttribute("message", "Old Password Not Matched. Try Again..");
				request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
