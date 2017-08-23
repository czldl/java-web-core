package net.codingme.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆验证，判断是否登陆成功。
 * 
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * 登陆验证，成功则请求转发到登陆成功servlet 失败则显示登陆失败
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 设置编码格式
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String username = req.getParameter("username");
		
		if ("xy".equals(username)) {
			System.out.println("登陆成功");
			// 登陆成功，存储session
			req.getSession().setAttribute("username", username);
			req.setAttribute("username", username);
			// 跳转到登陆成功的页面
			req.getRequestDispatcher("/admin/manager").forward(req, resp);
		} else {
			System.out.println("登陆失败");
			PrintWriter out = resp.getWriter();
			out.print("登陆失败！");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}