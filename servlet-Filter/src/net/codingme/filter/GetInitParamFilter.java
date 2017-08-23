package net.codingme.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * 过滤器获取初始化参数
 * @author Niu on 2017年8月23日 上午10:14:06
 */

public class GetInitParamFilter implements Filter {

	/**
	 * 初始化
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String name = filterConfig.getInitParameter("name");
		System.out.println("name：" + name);
	}

	/**
	 * 过滤操作
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

	}

	/**
	 * 销毁
	 */
	@Override
	public void destroy() {

	}

}
