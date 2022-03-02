package vn.ithcmute.controller.seller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.InsufficientResourcesException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ithcmute.model.CategoryModel;
import vn.ithcmute.model.ProductModel;
import vn.ithcmute.model.ShopModel;
import vn.ithcmute.service.CategoryService;
import vn.ithcmute.service.ProductService;
import vn.ithcmute.service.ShopService;
import vn.ithcmute.service.impl.CategoryServiceImpl;
import vn.ithcmute.service.impl.ProductServiceImpl;
import vn.ithcmute.service.impl.ShopServiceImpl;
import vn.ithcmute.util.ShopID;


@WebServlet(urlPatterns = { "/view-shop" })
public class ViewShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ShopService shopService = new ShopServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();
	ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		//Lay bien cateID
		String cateID = req.getParameter("cateID");
		//Lay bien search
		String txt = req.getParameter("sTxt");
		
		
		List<ProductModel> listP= new ArrayList<ProductModel>();
		HashMap<Integer, Integer> map = productService.getSoldAmount();
		
		if(txt!=null) {
			listP = productService.search(txt);
		}
		if(cateID==null) {
			listP = productService.getAll();
		}else {
			int id = Integer.parseInt(cateID);
			listP = productService.getProductByCID(id);
			req.setAttribute("cate", cateID);
		}

		// Lay shop model tu User
		int sID = ShopID.sID;
		ShopModel shop = shopService.get(sID);
		List<CategoryModel> listCate = cateService.getListByShop();
		
		req.setAttribute("shop", shop);
		
		req.setAttribute("listCate", listCate);
		req.setAttribute("listP", listP);
		req.setAttribute("soldAmount", map);
		
		req.getRequestDispatcher("/decorators/viewshop.jsp").forward(req, resp);
	}
}
