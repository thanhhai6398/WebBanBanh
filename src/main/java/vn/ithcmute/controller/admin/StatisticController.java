package vn.ithcmute.controller.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import vn.ithcmute.model.ShopModel;
import vn.ithcmute.service.ProductService;
import vn.ithcmute.service.ReceiptService;
import vn.ithcmute.service.UserService;
import vn.ithcmute.service.impl.ProductServiceImpl;
import vn.ithcmute.service.impl.ReceiptServiceImpl;
import vn.ithcmute.service.impl.UserServiceImpl;



@WebServlet(urlPatterns = { "/admin/statistic" })
public class StatisticController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1836972594151777481L;
	
	ProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String type = req.getParameter("type");
		if (type.equals("sanpham"))
		{
			int count = productService.getTotalSoldProductByShop();
			
			Map<ShopModel, Integer> myShopMap = productService.getAllShopByProduct();
			
			Map<String, Integer> ShopMapForBarCharts = productService.getTop6ShopByProduct();
			
			int sum = 0;
			for (int i : ShopMapForBarCharts.values()) {
				  sum = sum + i;
			}
			ShopMapForBarCharts.put("Other", count - sum);
			
			GsonBuilder gsonMapBuilder = new GsonBuilder();
			 
			Gson gsonObject = gsonMapBuilder.create();
	 
			String JSONObject = gsonObject.toJson(ShopMapForBarCharts);
			
			req.setAttribute("myShopMap", myShopMap);
			req.setAttribute("productCount", count);
			req.setAttribute("ShopMapForBarCharts", JSONObject);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin_thongkesanpham.jsp");
			dispatcher.forward(req, resp);
		}
		else if (type.equals("donhang"))
		{ 
			ReceiptService receiptService = new ReceiptServiceImpl();
			int count = receiptService.getTotalReceiptByShop();
			
			Map<ShopModel, Integer> myShopMap = receiptService.getAllShopByReceipt();
			
			Map<String, Integer> ShopMapForBarCharts = receiptService.getTop6ShopByReceipt();
			
			int sum = 0;
			for (int i : ShopMapForBarCharts.values()) {
				  sum = sum + i;
			}
			ShopMapForBarCharts.put("Other", count - sum);
			
			GsonBuilder gsonMapBuilder = new GsonBuilder();
			 
			Gson gsonObject = gsonMapBuilder.create();
	 
			String JSONObject = gsonObject.toJson(ShopMapForBarCharts);
			
			req.setAttribute("myShopMap", myShopMap);
			req.setAttribute("receiptCount", count);
			req.setAttribute("ShopMapForBarCharts", JSONObject);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin_thongkedonhang.jsp");
			dispatcher.forward(req, resp);
		}
		else if (type.equals("nguoidung"))
		{
			UserService userService = new UserServiceImpl();
			int count = userService.getTotalUserByShop();
			
			Map<ShopModel, Integer> myShopMap = userService.getAllShopByUser();
			
			Map<String, Integer> ShopMapForBarCharts = userService.getTop6ShopByUser();
			
			int sum = 0;
			for (int i : ShopMapForBarCharts.values()) {
				  sum = sum + i;
			}
			ShopMapForBarCharts.put("Other", count - sum);
			
			GsonBuilder gsonMapBuilder = new GsonBuilder();
			 
			Gson gsonObject = gsonMapBuilder.create();
	 
			String JSONObject = gsonObject.toJson(ShopMapForBarCharts);
			
			req.setAttribute("myShopMap", myShopMap);
			req.setAttribute("userCount", count);
			req.setAttribute("ShopMapForBarCharts", JSONObject);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin_thongkenguoidung.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
