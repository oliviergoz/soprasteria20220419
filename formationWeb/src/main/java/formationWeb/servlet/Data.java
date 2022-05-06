package formationWeb.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Data
 */
@WebServlet("/Data")
public class Data extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// parametre
		// recevoir des donnees du client via la requete
		request.getParameter("nomParametre");

		// Attributs de la requete

		// Session
		HttpSession session = request.getSession();
		session.setAttribute("monAttributEnSession", "un text dans la session");

		// ServletContext (variable d'application)
		ServletContext ctx = request.getServletContext();
		ctx.setAttribute("application1", "un texte dans le servletContext");

		//Cookie
		Cookie cookie=new Cookie("hello", "hello_world");
		cookie.setMaxAge(3600*24);
		
		response.addCookie(cookie);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
