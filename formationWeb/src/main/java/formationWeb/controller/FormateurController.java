package formationWeb.controller;

import java.io.Console;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import quest.entity.Compte;
import quest.entity.Formateur;
import quest.services.CompteService;

/**
 * Servlet implementation class FormateurController
 */
@WebServlet("/formateur")
public class FormateurController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FormateurController() {
		super();

	}

	// FindAll
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CompteService compteService = null;
		ServletContext servletContext = request.getServletContext();
		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) servletContext
				.getAttribute("ctxSpring");
		compteService = ctx.getBean(CompteService.class);

		String q = request.getParameter("q");
		String view = null;
		System.out.println("passage");

		if (q == null) {
			request.setAttribute("formateurs", compteService.getAllFormateurs()); // info
			view = "WEB-INF/formateur.jsp"; // endroit
			request.getRequestDispatcher(view).forward(request, response);
		}

		else if (q.equals("edit")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Compte f = compteService.getById(id);

			view = "WEB-INF/editFormateur.jsp";
			request.setAttribute("formateur", f);
			request.getRequestDispatcher(view).forward(request, response);

		}

		else if (q.equals("ajout")) {

			Formateur f = new Formateur();

			view = "WEB-INF/editFormateur.jsp";
			request.setAttribute("formateur", f);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

	// Create et le Update
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CompteService compteService = null;
		ServletContext servletContext = request.getServletContext();
		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) servletContext
				.getAttribute("ctxSpring");
		compteService = ctx.getBean(CompteService.class);

		String id = request.getParameter("id");

		if (id == null || id.isEmpty() ) {

			Formateur f = new Formateur();
			f.setNom(request.getParameter("nom"));
			f.setPrenom(request.getParameter("prenom"));
			f.setPassword(request.getParameter("pwd"));
			f.setLogin(request.getParameter("login"));
			compteService.create(f);
		}
		else {
			Long idL = Long.parseLong(id);
			Formateur f = (Formateur) compteService.getById(idL); 
			f.setNom(request.getParameter("nom"));
			f.setPrenom(request.getParameter("prenom"));
			f.setPassword(request.getParameter("pwd"));
			f.setLogin(request.getParameter("login"));
			compteService.update(f);
		}
		
		
		
		
		request.setAttribute("formateurs", compteService.getAllFormateurs());
		String view = "WEB-INF/formateur.jsp"; // endroit

		request.getRequestDispatcher(view).forward(request, response);

	}

}
