package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.UserCreateDto;
import Model.User;
import Service.UserService;
import Util.JspConst;
import Util.UrlConst;

@WebServlet(name = "userServlet", urlPatterns = {
		UrlConst.USER_DASHBOARD,
		UrlConst.USER_PROFILE,
		UrlConst.USER_ADD,
		UrlConst.USER_UPDATE,
		UrlConst.USER_DELETE
})
public class UserServlet extends HttpServlet {
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		userService = new UserService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch(req.getServletPath()) {
		case UrlConst.USER_DASHBOARD:
			getUserDashboard(req,resp);
			break;
		case UrlConst.USER_PROFILE:
			getUserProfile(req,resp);
			break;
		case UrlConst.USER_ADD:
			getUserAdd(req,resp);
			break;
		case UrlConst.USER_UPDATE:
			getUserUpdate(req,resp);
			break;
		case UrlConst.USER_DELETE:
			getUserDelete(req,resp);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch(req.getServletPath()) {
		case UrlConst.USER_DASHBOARD:
			
			break;
		case UrlConst.USER_PROFILE:
			
			break;
		case UrlConst.USER_ADD:
			postUserAdd(req,resp);
			break;
		case UrlConst.USER_UPDATE:
			
			break;
		case UrlConst.USER_DELETE:
			
			break;
		}
	}

	private void getUserDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		int id =Integer.parseInt(req.getParameter("id")); 
		
		userService.deleteById(id);
		
		resp.sendRedirect(req.getContextPath() + UrlConst.USER_DASHBOARD);
	}

	private void getUserUpdate(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void getUserAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.getRequestDispatcher(JspConst.USER_ADD).forward(req, resp);;
	}
	
	private void postUserAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		UserCreateDto dto = extractDtoFromReq(req);
		
		userService.add(dto);
		
		resp.sendRedirect(req.getContextPath() + UrlConst.USER_DASHBOARD);
		
	}
	
	private UserCreateDto extractDtoFromReq(HttpServletRequest req) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		int roleId = Integer.parseInt(req.getParameter("role"));
		
		return new UserCreateDto(email, password, name, address, phone, roleId);
		
		// System.out.printf("%s %s %s %s %d\n", email, password, phone, address, roleId);
	}
	
	private void getUserProfile(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void getUserDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> users = userService.findAll();
		
		if(users != null && !users.isEmpty()) {
			req.setAttribute("users", users);
		}
		
		req.getRequestDispatcher(JspConst.USER_DASHBOARD).forward(req, resp);
	}
}
