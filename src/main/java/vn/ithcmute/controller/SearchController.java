package vn.ithcmute.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ithcmute.dao.impl.CategoryDaoImpl;
import vn.ithcmute.dao.impl.ProductDaoImpl;
import vn.ithcmute.model.CategoryModel;
import vn.ithcmute.model.ProductModel;

@WebServlet(urlPatterns = {"/search"})
public class SearchController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String txt1 = req.getParameter("txt");
		String cid = req.getParameter("cid");
		// bước 1: Khởi tạo DAO
		ProductDaoImpl productDao = new ProductDaoImpl();
		CategoryDaoImpl cateDao = new CategoryDaoImpl();

		// bước 2:Sử dụng List chứa DS từ ProductDAO
		List<CategoryModel> listC = cateDao.getAllCategory();
		List<ProductModel> list = productDao.search(txt1);

		// bước 3: Thiết lập dữ liệu lên JSP
		req.setAttribute("txtS", txt1);
		req.setAttribute("listAllproduct", list);
		req.setAttribute("cate", listC);
		req.setAttribute("listcate", listC);
		req.setAttribute("tagactive", cid);

		// bước 4: Trả v�? trang JSP nào
		req.getRequestDispatcher("/views/product.jsp").forward(req, resp);
	}
}

