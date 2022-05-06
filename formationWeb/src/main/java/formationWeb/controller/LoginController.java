package formationWeb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String view = null;
		if (login == null || password == null) {
			// probleme
			request.setAttribute("erreur", true);
			view = "WEB-INF/login.jsp";
		} else if (login.equals("toto") && password.equals("toto")) {
			view = "WEB-INF/welcome.jsp";
			// request.setAttribute("login", login);
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
		} else {
			request.setAttribute("erreur", true);
			view = "WEB-INF/login.jsp";
		}
		request.getRequestDispatcher(view).forward(request, response);
	}

}
