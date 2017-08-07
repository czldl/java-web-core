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
 * 处理Post方式的表单
 * 
 * @author Niu on 2017年8月5日 下午4:20:03
 */
//使用注解来配置访问路径，省去web.xml中的访问路径配置
@WebServlet(urlPatterns={"/receivePost"})
public class ReceivePostServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 请求参数编码方式
		request.setCharacterEncoding("UTF-8");
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		
		// 获取参数值
		//普通文本框
		String name = request.getParameter("name");
		//单选框
		String sex = request.getParameter("sex");
		//复选框
		String[] skill = request.getParameterValues("skill");
		
		// 获取输出流对象
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html><head><meta charset=\"utf-8\"><title>POST</title></head><body>");
		out.println("<h3>读取POST方法数据</h3>");
		out.println("<hr>");
		out.println("<p>name："+name+"</p>");
		out.println("<p>sex："+sex+"</p>");
		out.println("<p>skill：");
		for (String string : skill) {
			out.println(string);
		}
		out.println("</p>");
		out.println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
