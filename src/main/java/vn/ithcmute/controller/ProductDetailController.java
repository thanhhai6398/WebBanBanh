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

@WebServlet(urlPatterns = { "/productdetail" })
public class ProductDetailController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Thiết lập TV
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// Lấy tham số từ JSP
		String pid = req.getParameter("pid");
		String cid = req.getParameter("cid");
		String sid = req.getParameter("sid");
		// bước 1:Khởi tạo DAO
		ProductDaoImpl productDao = new ProductDaoImpl();
		CategoryDaoImpl cateDao = new CategoryDaoImpl();

		// bước 2:Sử dụng List chứa DS từ ProductDAO
		int pID = Integer.parseInt(pid);  
		int cID = Integer.parseInt(cid);
		int sID = Integer.parseInt(sid);
		
		ProductModel pdetail = productDao.get(pID);
		List<ProductModel> listPbC = productDao.getProductByCID(cID);
		List<CategoryModel> listC = cateDao.getAllCategory();
		CategoryModel cdetail = cateDao.get(cID);
		List<ProductModel> listPbS = productDao.getProductBySID(sID);

		// bước 3: Thiết lập dữ liệu lên JSP
		req.setAttribute("cdetail", cdetail);
		req.setAttribute("pdetail", pdetail);
		req.setAttribute("listcate", listC);
		req.setAttribute("listpro", listPbC);
		req.setAttribute("listproShop", listPbS);
		// bước 4: Trả về trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/views/productdetail.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
