package net.codingme.listener;

import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/** 
 * 
 * 统计在线人数
 * @author Niu on 2017年8月25日 下午2:30:46
 */

public class CountOnlineListener implements HttpSessionListener {


	/**
	 * session 创建时
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// 使用HashSet存放session，HashSet可以保证唯一性
		HttpSession session = event.getSession();
		// 设置session存货20秒，方便测试！
		session.setMaxInactiveInterval(20);
		
		ServletContext servletContext = session.getServletContext();
		HashSet<HttpSession> sessionList= (HashSet<HttpSession>) servletContext.getAttribute("sessionList");
		
		if(sessionList == null){
			sessionList = new HashSet<HttpSession>();
			servletContext.setAttribute("sessionList", sessionList);
		}
		
		sessionList.add(session);
	}
	
	
	/**
	 * session 销毁时
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		ServletContext servletContext = session.getServletContext();
		HashSet<HttpSession> sessionList= (HashSet<HttpSession>) servletContext.getAttribute("sessionList");
		
		if(sessionList != null){
			sessionList.remove(session);
		}
		servletContext.setAttribute("sessionList", sessionList);
	}

}
