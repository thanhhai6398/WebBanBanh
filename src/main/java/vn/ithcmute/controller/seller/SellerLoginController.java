package vn.ithcmute.controller.seller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.ithcmute.model.UserModel;
import vn.ithcmute.service.UserService;
import vn.ithcmute.service.impl.UserServiceImpl;


@WebServlet(urlPatterns= {"/seller/login"})
public class SellerLoginController extends HttpServlet{
	UserService userService = new UserServiceImpl();

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/decorators/seller-login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String passwd = req.getParameter("passwd");
		
		UserModel userModel = userService.LoginSellerDao(username, passwd);
		if(userModel==null) {
			req.setAttribute("msg", "Sai tài khoản và mật khẩu");
			req.getRequestDispatcher("/decorators/seller-login.jsp").forward(req, resp);
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("acc",userModel);
			//session.setMaxInactiveInterval(1000);
			resp.sendRedirect(req.getContextPath()+"/seller/home");
		}
		
		
	}

}
