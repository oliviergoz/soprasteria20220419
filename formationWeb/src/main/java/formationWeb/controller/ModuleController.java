package formationWeb.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import quest.entity.Formateur;
import quest.entity.Matiere;
import quest.entity.Module;
import quest.entity.Session;
import quest.services.CompteService;
import quest.services.MatiereService;
import quest.services.ModuleService;

/**
 * Servlet implementation class MatiereController
 */
@WebServlet("/module")
public class ModuleController extends HttpServlet {
	
	//findAll (doGet avec aucun param)
	//findById (doGet avec param id + q=find)
	//delete (doGet avec param id + q=delete)
	//insert (doPost avec params + q=insert)
	//update (doPost avec params matiere + q=update)
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext servletContext = request.getServletContext();
		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) servletContext
				.getAttribute("ctxSpring");
		
		MatiereService matiereService = ctx.getBean(MatiereService.class);
		ModuleService moduleService = ctx.getBean(ModuleService.class);
		CompteService formateurService = ctx.getBean(CompteService.class);
		RequestDispatcher rd = null;
		
		
		
		
		
		String query = request.getParameter("q");
		//Si on a pas de query => findAll + redriect vers la page list
		
		if (query == null || query.isEmpty()) {
			rd = list(request, response, moduleService,matiereService,formateurService);
		} 
		
		//Query = delete => delete + redirect vers la page list
		else if (query.equals("delete")) {
			rd = delete(request, response,moduleService,matiereService,formateurService);
		}
		//Query =edit => charger la matiere a edit + redirect vers la page d'edition	
		else if(query.equals("edit")) {
			rd=edit(request, response,moduleService,matiereService,formateurService);
		}
		rd.forward(request, response);
	}

	
	
	
	
	
	RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response,  ModuleService moduleService,MatiereService matiereService, CompteService formateurService) {
		String view = "WEB-INF/module/edit.jsp";
		Long id = Long.parseLong(request.getParameter("id"));
		request.setAttribute("matieres", matiereService.getAll());
		request.setAttribute("formateurs", formateurService.getAllFormateurs());
		request.setAttribute("module", moduleService.getById(id));
		return request.getRequestDispatcher(view);

	}

	RequestDispatcher list(HttpServletRequest request, HttpServletResponse response, ModuleService moduleService,MatiereService matiereService, CompteService formateurService) {
		
		Long idSession = Long.parseLong(request.getParameter("session"));
		
		String view = "WEB-INF/module/list.jsp?session="+idSession;
		request.setAttribute("matieres", matiereService.getAll());
		request.setAttribute("formateurs", formateurService.getAllFormateurs());
		request.setAttribute("modules", moduleService.getAllBySession(idSession));
		return request.getRequestDispatcher(view);
	}

	RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response, ModuleService moduleService,MatiereService matiereService, CompteService formateurService) {
		Long id = Long.parseLong(request.getParameter("id"));
		moduleService.deleteById(id);
		return list(request, response, moduleService,matiereService,formateurService);
	}

	

	RequestDispatcher insert(HttpServletRequest request, HttpServletResponse response,  ModuleService moduleService,MatiereService matiereService, CompteService formateurService) {
	
		
		String debut = request.getParameter("debut");
		String fin = request.getParameter("fin");
		Long idFormateur = Long.parseLong(request.getParameter("formateur"));
		Long idMatiere = Long.parseLong(request.getParameter("matiere"));
		
		Formateur f = new Formateur();
		f.setId(idFormateur);
		
		Matiere m = new Matiere();
		m.setId(idMatiere);
		
		Long idSession = Long.parseLong(request.getParameter("session"));
		Session s = new Session();
		s.setId(idSession);
		
		Module module=new Module(LocalDate.parse(debut),LocalDate.parse(fin),m,f,s);
		
		moduleService.create(module);
		
		return list(request, response,  moduleService,matiereService,formateurService);
	}

	
	
	RequestDispatcher update(HttpServletRequest request, HttpServletResponse response, ModuleService moduleService,MatiereService matiereService, CompteService formateurService) {
	
		Long id = Long.parseLong(request.getParameter("id"));
		
		Module module = moduleService.getById(id);
		
		String debut = request.getParameter("debut");
		String fin = request.getParameter("fin");
		Long idFormateur = Long.parseLong(request.getParameter("formateur"));
		Long idMatiere = Long.parseLong(request.getParameter("matiere"));
		
		Formateur f = new Formateur();
		f.setId(idFormateur);
		
		Matiere m = new Matiere();
		m.setId(idMatiere);
		
		module.setDebut(LocalDate.parse(debut));
		module.setFin(LocalDate.parse(fin));
		module.setFormateur(f);
		module.setMatiere(m);
		
		moduleService.update(module);
		
		return list(request, response,  moduleService,matiereService,formateurService);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ServletContext servletContext = request.getServletContext();
		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) servletContext
				.getAttribute("ctxSpring");
		
		MatiereService matiereService = ctx.getBean(MatiereService.class);
		ModuleService moduleService = ctx.getBean(ModuleService.class);
		CompteService formateurService = ctx.getBean(CompteService.class);
		
		RequestDispatcher rd = null;
		
		
		String query = request.getParameter("q");
		
		if(query.equals("insert")) 
		{
			rd = insert(request, response, moduleService,matiereService,formateurService);
		}
		else 
		{
			rd = update(request, response, moduleService,matiereService,formateurService);
		}
		
		rd.forward(request, response);
	}

}
