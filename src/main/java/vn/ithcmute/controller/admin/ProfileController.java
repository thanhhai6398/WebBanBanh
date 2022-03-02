package vn.ithcmute.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.ithcmute.model.ShopModel;
import vn.ithcmute.model.UserModel;
import vn.ithcmute.service.ShopService;
import vn.ithcmute.service.UserService;
import vn.ithcmute.service.impl.ShopServiceImpl;
import vn.ithcmute.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/user/profile" })
public class ProfileController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5136527194500530575L;
	
	UserService userService = new UserServiceImpl();
	ShopService shopService = new ShopServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(req.getParameter("uid"));
		UserModel userModel = userService.get(id);
		List<ShopModel> shopList = shopService.getAll();
		req.setAttribute("shopList", shopList);
		req.setAttribute("user", userModel);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin_profile.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		int uid = Integer.parseInt(req.getParameter("uid"));
		String uname = req.getParameter("username");
		String upass = req.getParameter("password");
		int isAd = Integer.parseInt(req.getParameter("isAd"));
		int isSel = Integer.parseInt(req.getParameter("isSel"));
		ShopModel shop = shopService.get(Integer.parseInt(req.getParameter("shop")));
		if ((isSel == 0 && shop == null) || (isSel == 1 && shop != null))
		{
			UserModel uModel = new UserModel();
			uModel.setUid(uid);
			uModel.setUname(uname);
			uModel.setUpass(upass);
			uModel.setIsAd(isAd);
			uModel.setIsSel(isSel);
			uModel.setShop(shop);
			if (userService.isUserExist(uModel) == 1)
			{
				UserModel oldUModel = userService.get(uid);
				String warn = "Username đã tồn tại";
				List<ShopModel> shopList = shopService.getAll();
				req.setAttribute("warn", warn);
				req.setAttribute("shopList", shopList);
				req.setAttribute("user", oldUModel);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin_profile.jsp");
				dispatcher.forward(req, resp);
			}
			else
			{
				userService.edit(uModel);
				String info = "Thay đổi thông tin thành công";
				HttpSession session = req.getSession(true);
				session.setAttribute("acc", uModel);
				List<ShopModel> shopList = shopService.getAll();
				req.setAttribute("info", info);
				req.setAttribute("shopList", shopList);
				req.setAttribute("user", uModel);
			}
		}
		else
		{
			UserModel oldUModel = userService.get(uid);
			String warn = "Thông tin nhập không hợp lệ";
			List<ShopModel> shopList = shopService.getAll();
			req.setAttribute("warn", warn);
			req.setAttribute("shopList", shopList);
			req.setAttribute("user", oldUModel);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin_profile.jsp");
			dispatcher.forward(req, resp);
		}
		List<UserModel> userList = userService.getAll();
		req.setAttribute("userList", userList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin_profile.jsp");
		dispatcher.forward(req, resp);
		
	}
}
