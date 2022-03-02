package vn.ithcmute.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ithcmute.dao.impl.ShopDaoImpl;
import vn.ithcmute.model.ProductModel;
import vn.ithcmute.model.ShopModel;
import vn.ithcmute.service.ProductService;
import vn.ithcmute.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/shop" })
public class ShopController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Thiết lập TV
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// Lấy tham số từ JSP
		String sid = req.getParameter("sid");

		// bước 1:Khởi tạo DAO
		ProductService productSerive  = new ProductServiceImpl();
		ShopDaoImpl shopDao = new ShopDaoImpl();

		// bước 2:Sử dụng List chứa DS từ ProductDAO
		List<ProductModel> list = productSerive.getProductBysID(Integer.parseInt(sid));
		ShopModel shop = shopDao.get(Integer.parseInt(sid));
		// bước 3: Thiết lập dữ liệu lên JSP
		req.setAttribute("list", list);
		req.setAttribute("shop", shop);
		// bước 4: Trả về trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/views/shop.jsp");
		rq.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
