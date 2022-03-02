package vn.ithcmute.controller.seller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.ithcmute.model.ShopModel;
import vn.ithcmute.service.ProductService;
import vn.ithcmute.service.ReceiptService;
import vn.ithcmute.service.ShopService;
import vn.ithcmute.service.impl.ProductServiceImpl;
import vn.ithcmute.service.impl.ReceiptServiceImpl;
import vn.ithcmute.service.impl.ShopServiceImpl;
import vn.ithcmute.util.ShopID;


@WebServlet(urlPatterns = { "/seller/shop/setting" })
public class ShopSettingController extends HttpServlet {
	ShopService shopService = new ShopServiceImpl();
	ProductService productService = new ProductServiceImpl();
	ReceiptService receiptService = new ReceiptServiceImpl();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// Lay shop model tu User
		int sID = ShopID.sID;
		ShopModel shop = shopService.get(sID);
		
		int countProduct = productService.CountProduct();
		int countDelivered = receiptService.CountState(3);
		// Day len trang JSP
		String msg = "Xem tình trạng và thiết lập hồ sơ shop";
		req.setAttribute("msg", msg);
		req.setAttribute("shop", shop);
		req.setAttribute("countProduct", countProduct);
		req.setAttribute("countDelivered", countDelivered);
		req.getRequestDispatcher("/views/seller/setting-shop.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		ShopModel sModel = new ShopModel();
		String msg = "";

		String sID = req.getParameter("sID");
		String sName = req.getParameter("sName");
		String sPhone = req.getParameter("sPhone");
		String sAddrs = req.getParameter("sAddrs");

		sModel.setsID(Integer.parseInt(sID));
		sModel.setsName(sName);
		sModel.setsPhone(sPhone);
		sModel.setsAddrs(sAddrs);
		shopService.edit(sModel);
		
		int countProduct = productService.CountProduct();
		
		msg = "Chỉnh sửa thông tin Shop thành công";
		req.setAttribute("shop", sModel);
		req.setAttribute("msg", msg);
		req.setAttribute("countProduct", countProduct);
		req.getRequestDispatcher("/views/seller/setting-shop.jsp").forward(req, resp);

	}
}
