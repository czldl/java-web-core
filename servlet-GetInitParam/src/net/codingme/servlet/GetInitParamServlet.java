package net.codingme.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * 
 * Servlet获得初始化参数
 * 
 * @author Niu on 2017年7月25日 下午6:14:23
 */
public class GetInitParamServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//通过getInitParameter方法获得配置文件中设置的初始化值
		String name = this.getInitParameter("name");
		String password = this.getInitParameter("password");
		
		//通过getServletName方法获得配置文件中设置Servlet名字
		String servletName = this.getServletName();
		
		//设置响应文本类型和编码方式
		resp.setContentType("text/html;charset=UTF-8");
		
		//通过输出流向客户端做出相应
		PrintWriter out = resp.getWriter();
		out.println("name："+name);
		out.println("<br>");
		out.println("password："+password);
		out.println("<br>");
		out.println("servletName："+servletName);
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}