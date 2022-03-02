package vn.ithcmute.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.ithcmute.model.ProductModel;
import vn.ithcmute.model.ReceiptDetailModel;
import vn.ithcmute.service.ProductService;
import vn.ithcmute.service.impl.ProductServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/cart-add" }) // ?pId=123
public class CartAddController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String pId = req.getParameter("pId");
		String quantity = req.getParameter("quantity");
		
		ProductModel product = productService.get(Integer.parseInt(pId));
		ReceiptDetailModel ReceiptDetail = new ReceiptDetailModel();
		
		ReceiptDetail.setAmount(Integer.parseInt(quantity));
		ReceiptDetail.setpId(product);
		
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");
		if (obj == null) {
			Map<Integer, ReceiptDetailModel> map = new HashMap<Integer, ReceiptDetailModel>();
			map.put(ReceiptDetail.getpId().getpID(), ReceiptDetail);
			httpSession.setAttribute("cart", map);
		} else {
			Map<Integer, ReceiptDetailModel> map = extracted(obj);
			ReceiptDetailModel existedReceiptDetail = map.get(Integer.valueOf(pId));
			if (existedReceiptDetail == null) {
				map.put(product.getpID(), ReceiptDetail);
			} else {
				existedReceiptDetail.setAmount(existedReceiptDetail.getAmount() + Integer.parseInt(quantity));
			}
			httpSession.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath() + "/cart");
	}

	@SuppressWarnings("unchecked")
	private Map<Integer, ReceiptDetailModel> extracted(Object obj) {
		return (Map<Integer, ReceiptDetailModel>) obj;
	}
}
