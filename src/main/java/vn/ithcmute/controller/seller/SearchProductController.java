package vn.ithcmute.controller.seller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ithcmute.model.CategoryModel;
import vn.ithcmute.model.ProductModel;
import vn.ithcmute.service.CategoryService;
import vn.ithcmute.service.ProductService;
import vn.ithcmute.service.impl.CategoryServiceImpl;
import vn.ithcmute.service.impl.ProductServiceImpl;


@WebServlet(urlPatterns = { "/seller/product/search" })
public class SearchProductController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		List<ProductModel> list = new ArrayList<ProductModel>();
		ArrayList<CategoryModel> listCate = categoryService.getAllCategory();
		String txt = req.getParameter("sTxt");
		String cateID = req.getParameter("cate");
		if(txt!=null) {
			list = productService.search(txt);
			req.setAttribute("sTXT", txt);
			req.setAttribute("listAll", list);
		}else if(cateID!=null) {
			list = productService.getProductByCID(Integer.parseInt(cateID));
			req.setAttribute("cateID", Integer.parseInt(cateID));
			req.setAttribute("listAll", list);
			
		}
		req.setAttribute("listCate", listCate);
		req.getRequestDispatcher("/views/seller/list-product.jsp").forward(req, resp);	
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

	}

}
