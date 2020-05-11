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

import com.mettucovid.dto.User;


/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		int userId = Integer.parseInt(request.getParameter("id"));

		try {
			user = UserDao.findOne(userId);
			request.setAttribute("user", user);
			request.setAttribute("id", userId);

			request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);
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
		User user = new User();

		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setRole(request.getParameter("role"));
		System.out.println(request.getParameter("userId"));

		int id = Integer.parseInt(request.getParameter("userId"));

		try {
			int result = UserDao.updateUser(user, id);

			if (result > 0) {
				HttpSession session = request.getSession();
				String SuccessText = "Record Updated";
				session.setAttribute("SuccessText", SuccessText);
				request.getRequestDispatcher("ShowUsers").forward(request, response);

			} else {
				request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);
			}

		} catch (

				SQLException e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

