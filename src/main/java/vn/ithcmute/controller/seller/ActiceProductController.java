package vn.ithcmute.controller.seller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ithcmute.service.ProductService;
import vn.ithcmute.service.impl.ProductServiceImpl;



@WebServlet(urlPatterns= {"/seller/product/active"})
public class ActiceProductController extends HttpServlet{
	ProductService productService = new ProductServiceImpl();

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		int pID = Integer.parseInt(req.getParameter("pID"));
		int state = Integer.parseInt(req.getParameter("state"));
		productService.activeProduct(pID, state);
		resp.sendRedirect(req.getContextPath()+"/seller/product/list?type=all");
	}

}
