package vn.ithcmute.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.ithcmute.service.UserService;
import vn.ithcmute.service.impl.UserServiceImpl;
import vn.ithcmute.util.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			resp.sendRedirect(req.getContextPath() + "/admin");
			return;
		}
		// Check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/admin");
					return;
				}
			}
		}
		req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
	}

	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		String repassword = req.getParameter("repass");
		UserService service = new UserServiceImpl();
		String messMsg = "";
		if (service.checkExistUsername(username) & password!= repassword) {
			messMsg = "Username đã tồn tại! hoặc password không khớp";
			req.setAttribute("mess", messMsg);
			req.getRequestDispatcher("/decorators/register.jsp").forward(req, resp);
			return;
		}
		/*if (password!= repassword) {
			messMsg = "Password không trùng khớp!";
			req.setAttribute("mess", messMsg);
			req.getRequestDispatcher("/decorators/register.jsp").forward(req, resp);
			return;
		}*/
		boolean isSuccess = service.register(username, password);

		if (isSuccess) {
			messMsg = "Đăng ký thành công!";
			req.setAttribute("mess", messMsg);
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			messMsg = "Lỗi hệ thống!";
			req.setAttribute("mess", messMsg);
			req.getRequestDispatcher(Constant.Path.REGISTER).forward(req, resp);
		}
	}

}
