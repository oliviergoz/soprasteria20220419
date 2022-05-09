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
import quest.entity.Matiere;
import quest.services.MatiereService;

/**
 * Servlet implementation class MatiereController
 */
@WebServlet("/matiere")
public class MatiereController extends HttpServlet {
	
	//findAll (doGet avec aucun param)
	//findById (doGet avec param id + q=find)
	//delete (doGet avec param id + q=delete)
	//insert (doPost avec params + q=insert)
	//update (doPost avec params matiere + q=update)
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MatiereService matiereService = null;
		ServletContext servletContext = request.getServletContext();
		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) servletContext
				.getAttribute("ctxSpring");
		matiereService = ctx.getBean(MatiereService.class);
		RequestDispatcher rd = null;
		
		
		String query = request.getParameter("q");
		//Si on a pas de query => findAll + redriect vers la page list
		
		if (query == null || query.isEmpty()) {
			rd = list(request, response, matiereService);
		} 
		
		//Query = delete => delete + redirect vers la page list
		else if (query.equals("delete")) {
			rd = delete(request, response, matiereService);
		}
		//Query =edit => charger la matiere a edit + redirect vers la page d'edition	
		else if(query.equals("edit")) {
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

	RequestDispatcher insert(HttpServletRequest request, HttpServletResponse response, MatiereService matiereService) {
		String libelle = request.getParameter("libelle");
		matiereService.create(new Matiere(libelle));
		return list(request, response, matiereService);
	}

	
	
	RequestDispatcher update(HttpServletRequest request, HttpServletResponse response, MatiereService matiereService) {
		Long id = Long.parseLong(request.getParameter("id"));
		String libelle = request.getParameter("libelle");
		Matiere m = matiereService.getById(id);
		m.setLibelle(libelle);
		matiereService.update(m);
		return list(request, response, matiereService);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MatiereService matiereService = null;
		ServletContext servletContext = request.getServletContext();
		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) servletContext
				.getAttribute("ctxSpring");
		matiereService = ctx.getBean(MatiereService.class);
		RequestDispatcher rd = null;
		
		
		String query = request.getParameter("q");
		
		if(query.equals("insert")) 
		{
			rd = insert(request, response, matiereService);
		}
		else 
		{
			rd = update(request, response, matiereService);
		}
		
		rd.forward(request, response);
	}

}
