package com.mettucovid.controller.news;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mettucovid.dao.NewsDao;

import com.mettucovid.dto.News;


/**
 * Servlet implementation class AddNews
 */
@WebServlet("/AddNews")
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNews() {
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
			News news = new News();

			news.setUrl(request.getParameter("url"));
			news.setDescription(request.getParameter("description"));
			

			int result = NewsDao.AddNews(news);
			System.out.println(result);
			if (result > 0) {

				String SuccessText = "News Registered";
				session.setAttribute("SuccessText", SuccessText);
				
				request.getRequestDispatcher("ShowNews").forward(request, response);

			} else {
				session.setAttribute("FailureText", "Registration Failed");
				request.getRequestDispatcher("AddNews").forward(request, response);
			}
		}catch (Exception  e) {
			System.out.println(e);
			session.setAttribute("FailureText", "Registration Failed ");
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
		}

	}

}
