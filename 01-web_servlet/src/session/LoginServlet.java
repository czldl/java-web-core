package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆检查，设置Session
 * 
 * @author Niu on 2017年7月26日 上午9:45:15
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取表单信息
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		// 获取session对象
		HttpSession session = req.getSession();

		// 认证(简单测试)
		if ("zxy".equals(username) && "123".equals(password)) {
			
			// 将usernamename信息保存到HttpSession对象
			session.setAttribute("username", username);
			session.setAttribute("password",password);
			
			// 登陆成功后的servlet跳转
			req.getRequestDispatcher("loginSuccess").forward(req, resp);
			
		} else {
			// 登陆失败，提示重新登陆
			resp.setContentType("text/html;charset=UTF-8");
			resp.getWriter().println("验证失败，请重新登陆");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
