package net.codingme.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 功能概述：Servlet生命周期测试
 * 
 * @author Niu on 2017年7月24日 上午11:04:40
 */

public class LiftServlet extends HttpServlet {

	// 可以添加特定的初始化代码
	@Override
	public void init() throws ServletException {
		System.out.println("init()");
		super.init();
	}

	// 不能被覆盖，这里是web服务器的servlet初始化
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(ServletConfi confit)");
		super.init(config);
	}

	// service会检查请求类型，用来判断调用什么方法
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service(HttpServletRequest arg0, HttpServletResponse arg1)");
		super.service(arg0, arg1);
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service(ServletRequest arg0, ServletResponse arg1)");
		super.service(arg0, arg1);
	}

	/**
	 * get方法
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()");
		resp.getWriter().println("servlet get");
	}

	// 当web服务器正常停止时调用次销毁方法
	@Override
	public void destroy() {
		System.out.println("destroy()");
		super.destroy();
	}
}