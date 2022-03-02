package vn.ithcmute.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ithcmute.dao.impl.CategoryDaoImpl;
import vn.ithcmute.dao.impl.DeliveryCompanyDaoImpl;
import vn.ithcmute.model.CategoryModel;
import vn.ithcmute.model.DeliveryCompanyModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/cart" })
public class CartController extends HttpServlet implements Serializable {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Thiết lập TV
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		CategoryDaoImpl cateDao = new CategoryDaoImpl();
		DeliveryCompanyDaoImpl deliDao = new DeliveryCompanyDaoImpl();
		
		List<CategoryModel> listC = cateDao.getAllCategory();
		List<DeliveryCompanyModel> listDeli = deliDao.getAll();
		
		req.setAttribute("listcate", listC);
		req.setAttribute("listDeli", listDeli);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/listcart.jsp");
		dispatcher.forward(req, resp);
	}
}
