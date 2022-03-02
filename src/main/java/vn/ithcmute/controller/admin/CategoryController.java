package vn.ithcmute.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ithcmute.model.CategoryModel;
import vn.ithcmute.service.CategoryService;
import vn.ithcmute.service.impl.CategoryServiceImpl;



@WebServlet(urlPatterns = { "/admin/cate/list" })
public class CategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7118185900565619848L;
	
	CategoryService categoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String type = req.getParameter("type");
		if (type.equals("list"))
		{
			List<CategoryModel> cateList = categoryService.getAllCategory();
			req.setAttribute("cateList", cateList);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin_danhsachdanhmuc.jsp");
			dispatcher.forward(req, resp);
		}
		else if (type.equals("add"))
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin_themdanhmuc.jsp");
			dispatcher.forward(req, resp);
		}
		else if (type.equals("edit"))
		{
			int id = Integer.parseInt(req.getParameter("cid"));
			CategoryModel categoryModel = categoryService.get(id);
			req.setAttribute("cate", categoryModel);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin_suadanhmuc.jsp");
			dispatcher.forward(req, resp);
		}
		else if (type.equals("delete"))
		{
			int id = Integer.parseInt(req.getParameter("cid"));
			categoryService.delete(id);
			List<CategoryModel> cateList = categoryService.getAllCategory();
			req.setAttribute("cateList", cateList);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin_danhsachdanhmuc.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String type = req.getParameter("type");
		
		if (type.equals("add"))
		{
			String cName = req.getParameter("catename");
			CategoryModel cateModel = new CategoryModel();
			cateModel.setcName(cName);
			if (categoryService.isCategoryExist(cateModel) == 1)
			{
				String warn = "Danh mục đã tồn tại";
				req.setAttribute("warn", warn);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin_themdanhmuc.jsp");
				dispatcher.forward(req, resp);
			}
			else
			{
				categoryService.insert(cateModel);
			}
		}
		else if (type.equals("edit"))
		{
			int cID = Integer.parseInt(req.getParameter("cid"));
			String cName = req.getParameter("catename");
			CategoryModel cateModel = new CategoryModel();
			cateModel.setcID(cID);
			cateModel.setcName(cName);
			if (categoryService.isCategoryExist(cateModel) == 1)
			{
				String warn = "Danh mục đã tồn tại";
				req.setAttribute("warn", warn);
				int id = Integer.parseInt(req.getParameter("cid"));
				CategoryModel categoryModel = categoryService.get(id);
				req.setAttribute("cate", categoryModel);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin_suadanhmuc.jsp");
				dispatcher.forward(req, resp);
			}
			else
			{
				categoryService.edit(cateModel);
			}
		}
		List<CategoryModel> cateList = categoryService.getAllCategory();
		req.setAttribute("cateList", cateList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin_danhsachdanhmuc.jsp");
		dispatcher.forward(req, resp);
	}
}
