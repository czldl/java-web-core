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
 * 利用Servlet一个实例对象特点统计页面访问次数
 * 
 * @author Niu on 2017年8月17日 下午7:42:01
 */
@WebServlet("/pageCount2")
public class PageCountServlet2 extends HttpServlet {
	
	
	private  Integer count;
	@Override
	public void init() throws ServletException {
		count = 0;
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		count++;
		
		System.out.println("Page View Count:"+count);
		
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html><html><head><title>PageCount</title></head><body>");
		out.print("<h3>Page View Count:"+count+"</h3>");
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}
