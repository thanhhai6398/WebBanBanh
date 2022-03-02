package vn.ithcmute.controller.seller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.ithcmute.model.CategoryModel;
import vn.ithcmute.model.ProductModel;
import vn.ithcmute.service.CategoryService;
import vn.ithcmute.service.ProductService;
import vn.ithcmute.service.ShopService;
import vn.ithcmute.service.impl.CategoryServiceImpl;
import vn.ithcmute.service.impl.ProductServiceImpl;
import vn.ithcmute.service.impl.ShopServiceImpl;
import vn.ithcmute.util.Constant;
import vn.ithcmute.util.ShopID;


@WebServlet(urlPatterns= {"/seller/product/edit"})
public class EditProductController extends HttpServlet{
	CategoryService categoryService = new CategoryServiceImpl();
	ShopService shopService = new ShopServiceImpl();
	ProductService productService = new ProductServiceImpl();

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		ArrayList<CategoryModel> listCate = categoryService.getAllCategory();
		if(action.equals("add")) {
			req.setAttribute("listCate", listCate);
			req.getRequestDispatcher("/views/seller/add-product.jsp").forward(req, resp);
		}
		else if(action.equals("update")) {
			String pID = req.getParameter("pID");
			ProductModel productModel = productService.get(Integer.parseInt(pID));
			req.setAttribute("product", productModel);
			req.setAttribute("listCate", listCate);
			req.getRequestDispatcher("/views/seller/edit-product.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductModel product = new ProductModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			String action = req.getParameter("action");
			for (FileItem item : items) {
				if(item.getFieldName().equals("pName")) {
					product.setpName(item.getString("UTF-8"));
				}else if(item.getFieldName().equals("pCategory"))
				{
					product.setCategory(categoryService.get(Integer.parseInt(item.getString())));
				}else if(item.getFieldName().equals("pDescs")) {
					product.setpDescs(item.getString("UTF-8"));
				}else if(item.getFieldName().equals("pPrice")) {
					product.setpPrice(Integer.parseInt(item.getString()));
				}else if(item.getFieldName().equals("pAmount")) {
					product.setpAmount(Integer.parseInt(item.getString()));
				}else if(item.getFieldName().equals("pUnit")){
					product.setpUnit(item.getString("UTF-8"));
				}else if(item.getFieldName().equals("pOrigin")) {
					product.setpOrigin(item.getString("UTF-8"));
				}else if(item.getFieldName().equals("pID")) {
					product.setpID(Integer.parseInt(item.getString()));
				}
				else if (item.getFieldName().equals("pImage")) {
					if(item.getSize()>0) {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/product/" + fileName);
						item.write(file);
						product.setpImage("product/" + fileName);
					}else {
						product.setpImage(null);
					}
				}
			}
			product.setpActive(1);
			//Lay id cua user tu session truy van ra shop bo vo day
			int sID = ShopID.sID;
			product.setShop(shopService.get(sID));
			if(action.equals("add")) {
				productService.insert(product);
			} else if(action.equals("update")) {
				productService.update(product);
			}
			resp.sendRedirect(req.getContextPath() + "/seller/product/list?type=all");
		} catch (FileUploadException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
