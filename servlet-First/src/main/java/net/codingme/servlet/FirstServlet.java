package net.codingme.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 第一个servlet测试
 * 
 */
// @WebServlet("/firstServlet")　
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirstServlet() {
		super();
	}

	// get请求处理
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置相应的文本类型和字符编码
		response.setContentType("text/html;charset=UTF-8");
		//通过输出流向客户端做出相应
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>firest servlet</h3>");
		out.println("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}