package net.codingme.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 访问/admin/*，使用过滤器进行检查。
 */
public class AdminFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {

	}

	/**
	 * 过滤器，访问/admin/*，如果session中存在用户名，则可以访问，如果不存在，提示请先进行登陆。
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp =(HttpServletResponse) response;
		resp.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = req.getSession();
		
		String username = (String) session.getAttribute("username");
		if(username !=null){
			chain.doFilter(request, response);
		}
		
		if(username == null){
			PrintWriter out = resp.getWriter();
			out.println("请先进行登陆！");
		} 
	}

	public void destroy() {

	}

}
