package vn.ithcmute.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ithcmute.service.ProductService;
import vn.ithcmute.service.ReceiptService;
import vn.ithcmute.service.UserService;
import vn.ithcmute.service.impl.ProductServiceImpl;
import vn.ithcmute.service.impl.ReceiptServiceImpl;
import vn.ithcmute.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin/dashboard" })
public class DashboardController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7657768952319116431L;
	UserService userService = new UserServiceImpl();
	ProductService productService = new ProductServiceImpl();
	ReceiptService receiptService = new ReceiptServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		int userCount = userService.getTotalUserByShop();
		int productCount =  productService.getTotalSoldProductByShop();
		int receiptCount = receiptService.getTotalReceiptByShop();
		req.setAttribute("totalUser", userCount);
		req.setAttribute("totalProduct", productCount);
		req.setAttribute("totalReceipt", receiptCount);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin_dashboard.jsp");
		dispatcher.forward(req, resp);
	}

}
