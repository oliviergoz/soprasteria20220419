package formationWeb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import quest.config.QuestConfig;
import quest.services.MatiereService;

/**
 * Servlet implementation class MatiereController
 */
@WebServlet("/matiere")
public class MatiereController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MatiereController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MatiereService matiereService = null;
		ServletContext servletContext = request.getServletContext();
		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) servletContext
				.getAttribute("ctxSpring");
		matiereService = ctx.getBean(MatiereService.class);
		RequestDispatcher rd = null;
		String query = request.getParameter("q");
		if (query == null || query.isEmpty()) {
			rd = list(request, response, matiereService);
		} else if (query.equals("delete")) {
			rd = delete(request, response, matiereService);
		}else if(query.equals("add")) {
			
		}else if(query.equals("edit")) {
			rd=edit(request, response, matiereService);
		}
		rd.forward(request, response);
	}

	RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response, MatiereService matiereService) {
		String view = "WEB-INF/matiere/edit.jsp";
		Long id = Long.parseLong(request.getParameter("id"));
		request.setAttribute("matiere", matiereService.getById(id));
		return request.getRequestDispatcher(view);

	}

	RequestDispatcher list(HttpServletRequest request, HttpServletResponse response, MatiereService matiereService) {
		String view = "WEB-INF/matiere/list.jsp";
		request.setAttribute("matieres", matiereService.getAll());
		return request.getRequestDispatcher(view);
	}

	RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response, MatiereService matiereService) {
		Long id = Long.parseLong(request.getParameter("id"));
		matiereService.deleteById(id);
		return list(request, response, matiereService);
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
