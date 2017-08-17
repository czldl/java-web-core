package net.codingme.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 使用作用域对象 ServletContext 统计页面的访问次数
 * 
 * @author Niu on 2017年8月17日 下午7:42:01
 */
@WebServlet("/pageCount")
public class PageCountServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取到页面访问统计参数
		Integer count = (Integer) this.getServletContext().getAttribute("count");
		// 为空，则初始化为0
		if (count == null) {
			count = 0;
		}
		count++;
		this.getServletContext().setAttribute("count", count);
		
		System.out.println("<h3>Page View Count:"+count+"</h3>");
		
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html><html><head><title>PageCount</title></head><body>");
		out.print("<h3>Page View Count:"+count+"</h3>");
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}
