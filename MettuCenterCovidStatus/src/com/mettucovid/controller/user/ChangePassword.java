package com.mettucovid.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("inside doget");
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
		request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
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
			if(status>0)
			{
				PrintWriter out = response.getWriter();

				out.println("<html>");

				out.println("<head>");

				out.print("<script language='JavaScript'>alert('Password Changed Successfully  ');</script>");

				if(role.equals("Administrator"))
					out.println("<script> location.replace('AdminHome'); </script>");
				else
					out.println("<script> location.replace('StaffHome'); </script>");

				out.println("</head>");

				out.println("</html>");
			}
			else
			{
				PrintWriter out = response.getWriter();

				out.println("<html>");

				out.println("<head>");

				out.print("<script language='JavaScript'>alert('Old Password Not Matched. Try Again..');</script>");


				out.println("<script> location.replace('ChangePassword'); </script>");


				out.println("</head>");

				out.println("</html>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
