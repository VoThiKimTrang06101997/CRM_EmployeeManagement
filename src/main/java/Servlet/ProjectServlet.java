package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.JspConst;
import Util.UrlConst;

@WebServlet(name = "projectServlet", urlPatterns = {
		UrlConst.PROJECT_DASHBOARD,
		UrlConst.PROJECT_MANAGE,
		UrlConst.PROJECT_ADD,
		UrlConst.PROJECT_UPDATE,
		UrlConst.PROJECT_DELETE,
		UrlConst.PROJECT_STAFF,
		UrlConst.PROJECT_STAFF_ADD,
		UrlConst.PROJECT_STAFF_REMOVE
})
public class ProjectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch (req.getServletPath()) {
		case UrlConst.PROJECT_DASHBOARD:
			getDashboard(req,resp);
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
		switch (req.getServletPath()) {
		case UrlConst.PROJECT_DASHBOARD:
			getDashboard(req,resp);
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
		// TODO Auto-generated method stub
		req.getRequestDispatcher(JspConst.PROJECT_DASHBOARD).forward(req, resp);
	}
}
