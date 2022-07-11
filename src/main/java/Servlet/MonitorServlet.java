package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbConnection.MySqlConnection;
import Util.ServletConst;
import Util.UrlConst;

@WebServlet(name = ServletConst.MONITOR, urlPatterns = {UrlConst.HEALTH})
public class MonitorServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		
		switch (path) {
		case UrlConst.HEALTH: {
			if(MySqlConnection.getConnection() != null) {
				resp.getWriter().append("Database connection has been established successfully !");
			} else {
				resp.getWriter().append("Database connection could not be established ");
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}
}
