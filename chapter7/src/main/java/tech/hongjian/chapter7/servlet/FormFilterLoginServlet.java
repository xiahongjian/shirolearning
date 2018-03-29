package tech.hongjian.chapter7.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;

/**
 * @author xiahongjian 
 * @time   2018-03-28 17:51:01
 *
 */
@WebServlet(name = "formFilterLoginServlet", urlPatterns = "/formfilterlogin")
public class FormFilterLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String errorClassName = (String) req.getAttribute("shiroLoginFailure");
		String err = null;
		if (UnknownAccountException.class.getName().equals(errorClassName)) {
			err = "用户名错误";
		} else if (IncorrectCredentialsException.class.getName().equals(errorClassName)) {
			err = "密码不正确";
		} else {
			err = "认证错误";
		}
		req.setAttribute("err", err);
		req.getRequestDispatcher(Consts.JSP_PATH + "/formfilterlogin.jsp").forward(req, resp);
	}

}
