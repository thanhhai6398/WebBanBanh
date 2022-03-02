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

import vn.ithcmute.dao.impl.DeliveryDetailDaoImpl;
import vn.ithcmute.dao.impl.ReceiptDaoImpl;
import vn.ithcmute.dao.impl.ReceiptDetailDaoImpl;
import vn.ithcmute.model.DeliveryDetailModel;
import vn.ithcmute.model.ReceiptDetailModel;
import vn.ithcmute.model.ReceiptModel;
@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/myaccount" })
public class MyAccountController extends HttpServlet implements Serializable{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Thiết lập TV
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String uid = req.getParameter("uid");

		ReceiptDaoImpl receipt = new ReceiptDaoImpl();
		DeliveryDetailDaoImpl delivery = new DeliveryDetailDaoImpl();
		ReceiptDetailDaoImpl detail = new ReceiptDetailDaoImpl();
		
		List<ReceiptModel> listReceipt1 = receipt.getByU(Integer.parseInt(uid),1);
		List<ReceiptModel> listReceipt2 = receipt.getByU(Integer.parseInt(uid),2);
		List<ReceiptModel> listReceipt3 = receipt.getByU(Integer.parseInt(uid),3);
		List<ReceiptModel> listReceipt4 = receipt.getByU(Integer.parseInt(uid),4);
		List<DeliveryDetailModel> listDelivery = delivery.getAll();
		List<ReceiptDetailModel> listDetail = detail.getAll();
		
		req.setAttribute("listReceipt1", listReceipt1);
		req.setAttribute("listReceipt2", listReceipt2);
		req.setAttribute("listReceipt3", listReceipt3);
		req.setAttribute("listReceipt4", listReceipt4);
		req.setAttribute("listDeli",listDelivery );
		req.setAttribute("listDetail", listDetail);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/myaccount.jsp");
		dispatcher.forward(req, resp);
	}
}
