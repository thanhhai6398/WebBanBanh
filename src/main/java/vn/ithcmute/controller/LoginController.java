package vn.ithcmute.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.ithcmute.model.UserModel;
import vn.ithcmute.service.UserService;
import vn.ithcmute.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("acc") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}
		// Check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userC")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					
				}
				if (cookie.getName().equals("passC")) {
					session = req.getSession(true);
					session.setAttribute("password", cookie.getValue());
//					resp.sendRedirect(req.getContextPath() + "/waiting");
//					return;
				}
			}
		}

		req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");

		String password = req.getParameter("password");

		boolean isRememberMe = false;
		String remember = req.getParameter("remember");

		if ("1".equals(remember)) {
			isRememberMe = true;
		}
		String alertMsg = "";

		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Username và password không bỏ trống!";
			req.setAttribute("mess", alertMsg);
			req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
			return;
		}

		UserService service = new UserServiceImpl();

		UserModel user = service.login(username, password);

		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("acc", user);

			if (isRememberMe) {
				//saveRemeberMe(resp, username);
				Cookie u = new  Cookie("userC", username);
				Cookie p = new  Cookie("passC", password);
				u.setMaxAge(60);
				p.setMaxAge(60);
				resp.addCookie(u);
				resp.addCookie(p);
			}

			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Username hoặc password không đúng";
			req.setAttribute("mess", alertMsg);
			req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
		}
	}

	/*private void saveRemeberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
	}*/
}
