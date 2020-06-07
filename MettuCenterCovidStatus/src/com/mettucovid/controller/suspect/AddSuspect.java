package com.mettucovid.controller.suspect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mettucovid.dao.SuspectDao;
import com.mettucovid.dto.Suspect;


/**
 * Servlet implementation class AddSuspect
 */
@WebServlet("/AddSuspect")
public class AddSuspect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSuspect() {
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

		String SuccessText = "";
		session.setAttribute("SuccessText", SuccessText);
		String FailureText = "";
		session.setAttribute("FailureText", FailureText);

		try {
			Suspect suspect = new Suspect();
			suspect.setName(request.getParameter("name"));
			suspect.setAge(Integer.parseInt(request.getParameter("age")));
			suspect.setGender(request.getParameter("gender"));
			suspect.setEmail(request.getParameter("email"));
			suspect.setPhoneNo(Long.parseLong(request.getParameter("phoneNo")));
			suspect.setAddress(request.getParameter("address"));
			suspect.setKebele(request.getParameter("kebele"));
			suspect.setWoreda(request.getParameter("woreda"));
			suspect.setZone(request.getParameter("zone"));
			suspect.setRegion(request.getParameter("region"));
			suspect.setCountry(request.getParameter("country"));
			suspect.setCitizenship(request.getParameter("citizenship"));
			suspect.setCaseType(request.getParameter("caseType"));
			suspect.setMessage(request.getParameter("message"));
			
			int result = SuspectDao.insertSuspect(suspect);
			System.out.println(result);
			if (result > 0) {

				 SuccessText = "Suspect Registered";
				session.setAttribute("SuccessText", SuccessText);

				request.getRequestDispatcher("SuspectRegistration.jsp").forward(request, response);

			} else {


				FailureText = "Registration Failed";
				session.setAttribute("FailureText", FailureText);

				request.getRequestDispatcher("SuspectRegistration.jsp").forward(request, response);
				//request.getRequestDispatcher("RegisterUser.jsp").forward(request, response);
			}
		}catch (Exception  e) {
			System.out.println(e);
			FailureText = "Registration Failed";
			session.setAttribute("FailureText", FailureText);

			request.getRequestDispatcher("SuspectRegistration.jsp").forward(request, response);
			/*session.setAttribute("FailureText", "Registration Failed due to duplicate email id");
			request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);*/
		}

	}

}
