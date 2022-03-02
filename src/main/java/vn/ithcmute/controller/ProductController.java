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
import vn.ithcmute.model.CategoryModel;
import vn.ithcmute.model.ProductModel;
import vn.ithcmute.service.ProductService;
import vn.ithcmute.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/product", "/san-pham" })
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Thiết lập TV
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// Lấy tham số từ JSP
		String cid = req.getParameter("cid");
		String indexPage = req.getParameter("index");

		// khởi tạo trang đầu
		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		int cid1 = Integer.parseInt(cid);

		// bước 1:Khởi tạo DAO
		ProductService productSerive  = new ProductServiceImpl();
		CategoryDaoImpl cateDao = new CategoryDaoImpl();

		// bước 2:Sử dụng List chứa DS từ ProductDAO
		List<ProductModel> list2 = productSerive.getTop8BestSeller();
		List<CategoryModel> listC = cateDao.getAllCategory();
	
		// bước 3: Thiết lập dữ liệu lên JSP
		if ("0".equals(cid)) { // All product
			int count = productSerive.countAll();
			// chia trang cho count
			int endPage = count / 6;
			if (count % 6 != 0) {
				endPage++;
			}
			List<ProductModel> list = productSerive.pagingProduct(index);
			req.setAttribute("endP", endPage);
			req.setAttribute("listAllproduct", list);
		} else {
			
			int count = productSerive.countCid(cid1);
			int endPage = count / 6;
			if (count % 6 != 0) {
				endPage++;
			}
			List<ProductModel> listPC = productSerive.pagingProductByCID(cid, index);
			req.setAttribute("endP", endPage);
			req.setAttribute("listAllproduct", listPC);
			
		}
			req.setAttribute("cate", listC);

		req.setAttribute("list4BestSeller", list2);
		req.setAttribute("listcate", listC);
		req.setAttribute("tagactive", cid);
		req.setAttribute("tag", index);
		// bước 4: Trả về trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/views/product.jsp");
		rq.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}

