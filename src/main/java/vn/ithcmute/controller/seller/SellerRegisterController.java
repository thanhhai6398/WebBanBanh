package vn.ithcmute.controller.seller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ithcmute.model.ShopModel;
import vn.ithcmute.model.UserModel;
import vn.ithcmute.service.ShopService;
import vn.ithcmute.service.UserService;
import vn.ithcmute.service.impl.ShopServiceImpl;
import vn.ithcmute.service.impl.UserServiceImpl;

@WebServlet(urlPatterns= {"/seller/register"})
public class SellerRegisterController extends HttpServlet{
	UserService userService = new UserServiceImpl();
	ShopService shopService = new ShopServiceImpl();

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
		String shopName=req.getParameter("shopName");
		String shopAddrs = req.getParameter("shopAddrs");
		String shopPhone = req.getParameter("shopPhone");
		
		UserModel seller = userService.LoginDao(username, passwd);
		if(seller==null) {
			req.setAttribute("msg", "Sai tài khoản và mật khẩu");
			req.getRequestDispatcher("/decorators/seller-login.jsp").forward(req, resp);
		}
		else {
			ShopModel shopModel = new ShopModel();
			shopModel.setsName(shopName);
			shopModel.setsAddrs(shopAddrs);
			shopModel.setsPhone(shopPhone);
			shopModel.setsID(seller.getUid());
			shopService.insert(shopModel);
			
			seller.setIsSel(1);
			seller.setShop(shopModel);
			userService.update(seller);
			resp.sendRedirect(req.getContextPath()+"/login");
			
		}
		
	}

}
