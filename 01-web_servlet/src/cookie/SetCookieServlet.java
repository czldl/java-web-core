package cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置Cookie
 * 
 * @author Niu on 2017年7月25日 下午8:43:29
 */
@WebServlet("/setCookie")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取提交过来的username
		String username = req.getParameter("username");

		// 获取输出流
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		// username不为空则创建Cookie对象
		if (username != null && !"".equals(username)) {
			// 创建Cookie对象,注意，Cookie的value值最大长度为20字符
			Cookie usernameCookie = new Cookie("username", username);
			Cookie lastLogin = new Cookie("lastLogin","21:28");

			// 设置存活时间（单位：秒）
			usernameCookie.setMaxAge(3600);
			lastLogin.setMaxAge(3600);

			// 添加cookie
			resp.addCookie(lastLogin);
			resp.addCookie(usernameCookie);

			out.println("登陆的用户名已经保存至Cookie");
			out.println("<a href='getCookie'>读取Cookie信息</a>");

		} else {
			out.println("用户名为空，请重新输入");
		}
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
