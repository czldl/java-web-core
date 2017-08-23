package net.codingme.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆成功可以访问的管理页面
 */
@WebServlet("/admin/manager")
public class AdminManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminManagerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		PrintWriter out = response.getWriter();
		out.println(username+"的管理页面");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
