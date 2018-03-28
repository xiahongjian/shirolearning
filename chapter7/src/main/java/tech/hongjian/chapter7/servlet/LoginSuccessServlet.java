package tech.hongjian.chapter7.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiahongjian 
 * @time   2018-03-28 17:35:26
 *
 */
@WebServlet(name = "loginSuccessServlet", urlPatterns = "/loginSuccess")
public class LoginSuccessServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(Consts.JSP_PATH + "/loginSuccess.jsp").forward(req, resp);
	}

}
