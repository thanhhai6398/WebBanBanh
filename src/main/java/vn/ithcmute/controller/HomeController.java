package vn.ithcmute.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ithcmute.dao.impl.CategoryDaoImpl;
import vn.ithcmute.dao.impl.ProductDaoImpl;
import vn.ithcmute.model.CategoryModel;
import vn.ithcmute.model.ProductModel;
@WebServlet(urlPatterns = {"/home","/trang-chu"})
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Thiết lập TV
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
				
		//bước 1:Khởi tạo DAO
		ProductDaoImpl productDao = new ProductDaoImpl();
		CategoryDaoImpl cateDao = new CategoryDaoImpl();
		
		//bước 2:Sử dụng List chứa DS từ ProductDAO
		List<ProductModel> list = productDao.getTop8New();
		List<ProductModel> list1 = productDao.getTop8BestSeller();
				
		List<CategoryModel> listC = cateDao.getAllCategory();
		
		//bước 3: Thiết lập dữ liệu lên JSP
		req.setAttribute("list8New", list);
		req.setAttribute("list8BestSeller", list1);
		
		req.setAttribute("listcate", listC);
		//bước 4: Trả v�? trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/views/home.jsp");
		rq.forward(req, resp);
	}
}
