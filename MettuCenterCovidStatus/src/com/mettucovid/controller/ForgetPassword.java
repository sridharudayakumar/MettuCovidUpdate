package com.mettucovid.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mettucovid.dao.UserDao;
import com.mettucovid.dto.User;
import com.mettucovid.services.EmailServices;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassword() {
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
		String email = request.getParameter("email");
		try {
			User user = UserDao.checkEmailAvailability(email);
			if(user.getFirstName().equals(""))
			{
				String errortext = "Email does not exist";
				request.setAttribute("message", errortext);


				request.getRequestDispatcher("forgetpassword.jsp").forward(request, response);
			}else
			{
				String userName = user.getFirstName()+" "+user.getLastName();
				EmailServices.sendMail(email,userName, user.getPassword());	
				String message = "Password sent to your mail,Please check it.";
				request.setAttribute("message",message);
				
				request.getRequestDispatcher("forgetpassword.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
