package net.codingme;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 表单的处理 
 * 处理Get方式的表单
 * 
 * @author Niu on 2017年8月5日 下午4:18:03
 */
@WebServlet(urlPatterns={"/receiveGet"})
public class ReceiveGetServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		// 获取参数值
		String name = request.getParameter("name");
		// 获取输出流对象
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html><head><meta charset=\"utf-8\"><title>Get</title></head><body>");
		out.println("<h3>读取GET方法数据</h3>");
		out.println("<hr>");
		out.println("<h3>name："+name+"</h3>");
		out.println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
