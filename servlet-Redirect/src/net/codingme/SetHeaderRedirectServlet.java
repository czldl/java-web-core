package net.codingme;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 通过设置响应头信息和状态码来进行页面重定向,会重写URL
 * 
 * @author Niu on 2017年8月7日 下午8:43:38
 */
@WebServlet(urlPatterns={"/setHeaderRedirect"})
public class SetHeaderRedirectServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		// 要重定向的新位置
		String site = new String("http://localhost:8080/servlet-Redirect/index.html");
		// 设置状态为3XX，表示重定向—要完成请求必须进行更进一步的操作
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
