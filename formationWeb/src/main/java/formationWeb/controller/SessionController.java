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
import quest.services.SessionService;

@WebServlet("/session")
public class SessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher list(HttpServletRequest request, HttpServletResponse response, SessionService sessionService) {
		String view = "WEB-INF/session/session.jsp";
		request.setAttribute("sessions", sessionService.getAll());
		return request.getRequestDispatcher(view);
	}

	RequestDispatcher update(HttpServletRequest request, HttpServletResponse response, SessionService sessionService) {
		Long id = Long.parseLong(request.getParameter("id"));
		String libelle = request.getParameter("libelle");
		Session s = sessionService.getById(id);
		s.setLibelle(libelle);
		sessionService.update(s);
		return list(request, response, sessionService);

	}
	
	RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response, SessionService sessionService) {
		String view = "WEB-INF/session/edit.jsp";
		Long id = Long.parseLong(request.getParameter("id"));
		request.setAttribute("sessions", sessionService.getById(id));
		return request.getRequestDispatcher(view);

	}
	
	RequestDispatcher insert(HttpServletRequest request, HttpServletResponse response, SessionService sessionService) {
		String libelle = request.getParameter("libelle");
		sessionService.create(new Session(libelle));
		return list(request, response, sessionService);
	}

	
	/*
	RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response, SessionService sessionService) {
		Long id = Long.parseLong(request.getParameter("id"));
		
		
		ModuleService ms = new ModuleService();
		//recup list module
		//les récupérer un à un
		//les suppr un à un
		sessionService.deleteById(id);
		return list(request, response, sessionService);
	}
	*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionService sessionService = null;
		ServletContext servletContext = request.getServletContext();
		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) servletContext.getAttribute("ctxSpring");
		sessionService = ctx.getBean(SessionService.class);
		RequestDispatcher rd = null;

		String query = request.getParameter("q");

		if (query == null || query.isEmpty()) {
			rd = list(request, response, sessionService);
		}
		else if(query.equals("edit")) {
			rd=edit(request, response, sessionService);
		}
		// delete
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionService sessionService = null;
		ServletContext servletContext = request.getServletContext();
		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) servletContext.getAttribute("ctxSpring");
		sessionService = ctx.getBean(SessionService.class);
		RequestDispatcher rd = null;
		
		
		String query = request.getParameter("q");
		
		if(query.equals("insert")) 
		{
			rd = insert(request, response, sessionService);
		}
		else 
		{
			rd = update(request, response, sessionService);
		}
		
		rd.forward(request, response);
	}

}
