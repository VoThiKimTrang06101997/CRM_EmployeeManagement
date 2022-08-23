package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import DTO.ProjectDto;
import DTO.UserCreateDto;
import Model.Project;
import Model.User;
import Repository.ProjectRepository;
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
	private ProjectRepository projectRepository;
	
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
			getProjectAdd(req,resp);
			break;
		case UrlConst.PROJECT_UPDATE:
			getProjectUpdate(req,resp);
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
		 HttpSession session = req.getSession();
		 UserCreateDto dto = (UserCreateDto) session.getAttribute("USER_LOGIN");
		 
		String action = req.getServletPath();
		
		switch (req.getServletPath()) {
		case UrlConst.PROJECT_DASHBOARD:
			
			break;
		case UrlConst.PROJECT_MANAGE:
			
			break;
		case UrlConst.PROJECT_ADD:
			postProjectAdd(req,resp);
			break;
		case UrlConst.PROJECT_UPDATE:
			postProjectUpdate(req,resp);
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
	
	private ProjectDto postProjectUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProjectDto projectDto = new ProjectDto();
		
		int id = Integer.parseInt(req.getParameter("id")); 
		// String id = req.getParameter("id");
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String startDate = req.getParameter("start_date");
		String endDate = req.getParameter("end_date");
		int owner = Integer.parseInt(req.getParameter("owner"));
		
		try {
			projectService.update(projectDto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Nếu có id => Cập nhật
//		if(id != null && !id.isEmpty()) {
//			projectDto.setId(Integer.parseInt(id));
//			if(projectService.update(projectDto) > 0) {
//				req.setAttribute("success", "Cập nhật thành công");
//			} else {
//				req.setAttribute("error", "Cập nhật thất bại");
//			}
//		}
		
		
		// req.setAttribute("projects", projectService.getAll());
		
		 resp.sendRedirect(req.getContextPath() + UrlConst.PROJECT_DASHBOARD);
		 return new ProjectDto(0, name, description, Date.valueOf(startDate), Date.valueOf(endDate), owner);
		// req.getRequestDispatcher(JspConst.PROJECT_DASHBOARD).forward(req, resp);
		// return new ProjectDto(); 
		
		
	}

	private void getProjectUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		// int id = Integer.parseInt(req.getParameter("id"));
		String action = req.getParameter("action");
		
		// Nếu có id => Cập nhật hoặc Delete
		if(id != null && id.isEmpty()) {
			if(action.equals("edit")) { // Cập nhật
				PrintWriter writer = resp.getWriter();
				resp.setContentType("application/json");
				
				Gson gson = new Gson();
				ProjectDto model = projectRepository.findById(Integer.parseInt("id"));
				
				String objectToReturn = gson.toJson(model);
				
				writer.write(objectToReturn);    // Đưa Json trả về Ajax
				writer.flush();
				return;
			} else { // Xóa
				
			}
		}
		req.getRequestDispatcher(JspConst.PROJECT_UPDATE).forward(req, resp);	
	}

	private void postProjectAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProjectDto projectDto = extractDtoFromReq(req);

		projectService.insert(projectDto);
		resp.sendRedirect(req.getContextPath() + UrlConst.PROJECT_DASHBOARD);
	}

	private ProjectDto extractDtoFromReq(HttpServletRequest req) {
		// int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String startDate = req.getParameter("start_date");
		String endDate = req.getParameter("end_date");
		int owner = Integer.parseInt(req.getParameter("owner"));
		return new ProjectDto(0, name, description, Date.valueOf(startDate), Date.valueOf(endDate), owner);
	}
	
	private void getProjectAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProjectDto projectDto;
//		if(!projectService.insert(projectDto)) {
//			req.setAttribute("Message", "Thêm mới thất bại");
//			req.getRequestDispatcher(JspConst.PROJECT_ADD).forward(req, resp);
//		} else {
//			resp.sendRedirect(req.getContextPath() + UrlConst.PROJECT_ADD);
//		}
		 req.getRequestDispatcher(JspConst.PROJECT_ADD).forward(req, resp);
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
