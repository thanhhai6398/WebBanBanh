package vn.ithcmute.controller.seller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import vn.ithcmute.service.ShopService;
import vn.ithcmute.service.impl.CategoryServiceImpl;
import vn.ithcmute.service.impl.ProductServiceImpl;
import vn.ithcmute.service.impl.ShopServiceImpl;



@WebServlet(urlPatterns= {"/seller/product/list"})
public class ListProductController extends HttpServlet{
	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	ShopService shopService = new ShopServiceImpl();
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
	
		
		List<ProductModel> list = new ArrayList<ProductModel>();
		ArrayList<CategoryModel> listCate = categoryService.getAllCategory();
		HashMap<Integer, Integer> map = productService.getSoldAmount();
		
		String type=req.getParameter("type");
		if(type.equals("all")) {
			list = productService.getAll();
		}
		else if(type.equals("active")) {
			list = productService.getActiveProduct();
		} else if(type.equals("noActive")) {
			list = productService.getNoActiveProduct();
		}else if(type.equals("none")) {
			list = productService.getOutOfStockProduct();
		}
		String choose = req.getParameter("type");
		req.setAttribute("type",choose);
		req.setAttribute("listCate", listCate);
		req.setAttribute("listAll", list);
		req.setAttribute("soldAmount", map);
		req.getRequestDispatcher("/views/seller/list-product.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}

}
