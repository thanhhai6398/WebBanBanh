package vn.ithcmute.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ithcmute.service.ReceiptService;
import vn.ithcmute.service.impl.ReceiptServiceImpl;

@WebServlet(urlPatterns = { "/editState" })
public class EditStateReceiptController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ReceiptService receiptService = new ReceiptServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String stId = req.getParameter("stId");
		
		receiptService.updateState(Integer.parseInt(id), Integer.parseInt(stId));
		
		resp.sendRedirect(req.getContextPath() + "/home");
	}	
		
}
