package tech.hongjian.chapter7.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

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
		String err = null;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			err = "用户名错误";
		} catch (IncorrectCredentialsException e) {
			err = "密码不正确";
		} catch (AuthenticationException e) {
			err = "认证错误";
		}
		if (err != null) {
			req.setAttribute("err", err);
			req.getRequestDispatcher(Consts.JSP_PATH + "/login.jsp").forward(req, resp);
			return;
		}
		resp.sendRedirect("/loginSuccess");
	}

}
