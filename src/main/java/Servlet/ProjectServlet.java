package Servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.ProjectDto;
import DTO.UserCreateDto;
import Model.Project;
import Model.User;
import Service.ProjectService;
import Util.JspConst;
import Util.UrlConst;

@WebServlet(name = "projectServlet", urlPatterns = {
		UrlConst.PROJECT_DASHBOARD,
		UrlConst.PROJECT_MANAGE,
		UrlConst.PROJECT_ADD,
		UrlConst.PROJECT_UPDATE,
		UrlConst.PROJECT_EDIT,
		UrlConst.PROJECT_DELETE,
		UrlConst.PROJECT_STAFF,
		UrlConst.PROJECT_STAFF_ADD,
		UrlConst.PROJECT_STAFF_REMOVE
})

public class ProjectServlet extends HttpServlet {
	private ProjectService projectService;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		projectService = new ProjectService();
	}
	
//	public ProjectServlet() {
//		projectService = new ProjectService();
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		// String action = req.getServletPath();
		
		switch (req.getServletPath()) {
		case UrlConst.PROJECT_DASHBOARD:
			getDashboard(req, resp);
			break;

		case UrlConst.PROJECT_MANAGE:
			
			break;
		case UrlConst.PROJECT_ADD:
			
			break;
		case UrlConst.PROJECT_UPDATE:
			
			break;
		case UrlConst.PROJECT_DELETE:
			
			break;
		case UrlConst.PROJECT_STAFF:
			
			break;
		case UrlConst.PROJECT_STAFF_ADD:
			
			break;
		case UrlConst.PROJECT_STAFF_REMOVE:
			
			break;
		default:
			
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// HttpSession session = req.getSession();
		// UserCreateDto dto = (UserCreateDto) session.getAttribute("USER_LOGIN");
		// String name = req.getParameter("name");
		
		// String startDate = req.getParameter("start_date");
		// String endDate = req.getParameter("end_date");
		// int id = Integer.parseInt(req.getParameter("id"));
		// int owner = dto.getRoleId();
		
		switch (req.getServletPath()) {
		case UrlConst.PROJECT_DASHBOARD:
			
			break;
		case UrlConst.PROJECT_MANAGE:
			
			break;
		case UrlConst.PROJECT_ADD:
			
			break;
		case UrlConst.PROJECT_UPDATE:
			
			break;
		case UrlConst.PROJECT_DELETE:
			
			break;
		case UrlConst.PROJECT_STAFF:
			
			break;
		case UrlConst.PROJECT_STAFF_ADD:
			
			break;
		case UrlConst.PROJECT_STAFF_REMOVE:
			
			break;
		default:
			
			break;
		}
	}
	
	private void getDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// List<ProjectDto> projects = projectService.getAll();
		
//		if(projects != null && !projects.isEmpty()) {
//			req.setAttribute("projects", projects);
//		}
		
		req.setAttribute("projects", projectService.getAll());
		req.getRequestDispatcher(JspConst.PROJECT_DASHBOARD).forward(req, resp);
	}

}
