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

import quest.entity.Session;
import quest.entity.Stagiaire;
import quest.services.CompteService;
import quest.services.SessionService;

/**
 * Servlet implementation class StagiaireController
 */
@WebServlet("/stagiaire")
public class StagiaireController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StagiaireController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CompteService stagiaireService = null;
		ServletContext servletContext = request.getServletContext();
		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) servletContext
				.getAttribute("ctxSpring");
		stagiaireService = ctx.getBean(CompteService.class);
		
		SessionService sessionService=ctx.getBean(SessionService.class);
		
		RequestDispatcher rd = null;

		String query = request.getParameter("q");
		// Si on a pas de query => findAll + redriect vers la page list

		if (query == null || query.isEmpty()) {
			rd = list(request, response, stagiaireService,sessionService);
		}

		// Query = delete => delete + redirect vers la page list
		else if (query.equals("delete")) {
			rd = delete(request, response, stagiaireService,sessionService);
		}
		// Query =edit => charger la matiere a edit + redirect vers la page d'edition
		else if (query.equals("edit")) {
			rd = edit(request, response, stagiaireService,sessionService);
		}
		rd.forward(request, response);
	}

	RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response, CompteService stagiaireService,SessionService sessionService) {
		String view = "WEB-INF/stagiaire/edit.jsp";
		Long id = Long.parseLong(request.getParameter("id"));
		request.setAttribute("sessions", sessionService.getAll());
		request.setAttribute("stagiaire", stagiaireService.getById(id));
		return request.getRequestDispatcher(view);

	}

	RequestDispatcher list(HttpServletRequest request, HttpServletResponse response, CompteService stagiaireService,SessionService sessionService) {
		String view = "WEB-INF/stagiaire/list.jsp";
		request.setAttribute("sessions", sessionService.getAll());
		request.setAttribute("stagiaires", stagiaireService.getAllStagiaires());
		return request.getRequestDispatcher(view);
	}

	RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response, CompteService stagiaireService,SessionService sessionService) {
		Long id = Long.parseLong(request.getParameter("id"));
		stagiaireService.deleteByIdStagiaire(id);
		return list(request, response, stagiaireService,sessionService);
	}

	RequestDispatcher insert(HttpServletRequest request, HttpServletResponse response, CompteService stagiaireService,SessionService sessionService) {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Long id = Long.parseLong(request.getParameter("session"));
		
		Session s = new Session();
		s.setId(id);
	
		stagiaireService.create(new Stagiaire(login, password, nom, prenom, s));
		return list(request, response, stagiaireService,sessionService);
	}

	RequestDispatcher update(HttpServletRequest request, HttpServletResponse response, CompteService stagiaireService,SessionService sessionService) {
		Long id = Long.parseLong(request.getParameter("id"));
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		Long idSession = Long.parseLong(request.getParameter("session"));
		
		Session session = new Session();
		session.setId(idSession);

		Stagiaire s = (Stagiaire) stagiaireService.getById(id);
		
		s.setLogin(login);
		s.setPassword(password);
		s.setNom(nom);
		s.setPrenom(prenom);
		s.setSession(session);
		
		stagiaireService.update(s); 
		
		return list(request, response, stagiaireService,sessionService);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CompteService stagiaireService = null;
		ServletContext servletContext = request.getServletContext();
		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) servletContext
				.getAttribute("ctxSpring");
		stagiaireService = ctx.getBean(CompteService.class);
		SessionService sessionService=ctx.getBean(SessionService.class);
		RequestDispatcher rd = null;

		String query = request.getParameter("q");

		if (query.equals("insert")) {
			rd = insert(request, response, stagiaireService,sessionService);
		} else {
			rd = update(request, response, stagiaireService,sessionService);
		}

		rd.forward(request, response);
	}

}
