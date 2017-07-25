package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取Cookie
 * 
 * @author Niu on 2017年7月25日 下午8:43:29
 */
@WebServlet("/getCookie")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取输出流
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		out.println("从Cookie中读取用户名和登陆时间");
		out.println("<br/>");

		// 获取Cookie
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("username")){
				out.println("用户名："+cookie.getValue());
				out.println("<br/>");
			}
			if(name.equals("lastLogin")){
				out.println("上次登陆时间："+cookie.getValue());
				out.println("<br/>");
			}
		}

		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
