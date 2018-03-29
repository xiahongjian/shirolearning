package tech.hongjian.chapter7.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiahongjian 
 * @time   2018-03-29 10:45:54
 *
 */
@WebServlet(name = "roleServlet", urlPatterns = "/role")
public class RoleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(Consts.JSP_PATH + "/role.jsp").forward(req, resp);
	}

}
