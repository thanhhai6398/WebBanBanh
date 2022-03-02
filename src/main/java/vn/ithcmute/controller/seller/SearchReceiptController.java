package vn.ithcmute.controller.seller;

import java.io.IOException;
import java.nio.channels.NonWritableChannelException;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ithcmute.model.DeliveryDetailModel;
import vn.ithcmute.model.ReceiptDetailModel;
import vn.ithcmute.service.DeliveryDetailService;
import vn.ithcmute.service.ReceiptDetailService;
import vn.ithcmute.service.ReceiptService;
import vn.ithcmute.service.impl.DeliveryDetailServiceImpl;
import vn.ithcmute.service.impl.ReceiptDetailServiceImpl;
import vn.ithcmute.service.impl.ReceiptServiceImpl;


@WebServlet(urlPatterns= {"/seller/receipt/search"})
public class SearchReceiptController extends HttpServlet{
	ReceiptService service = new ReceiptServiceImpl();
	DeliveryDetailService deliveryDetailService = new DeliveryDetailServiceImpl();
	ReceiptDetailService receiptDetailService = new ReceiptDetailServiceImpl();

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		Map<DeliveryDetailModel, List<ReceiptDetailModel>> map = new HashMap<DeliveryDetailModel, List<ReceiptDetailModel>>();
		
		String rID=req.getParameter("rID");
		String dateStart = req.getParameter("dateStart");
		String dateEnd = req.getParameter("dateEnd");
		
		DeliveryDetailModel detailModel = new DeliveryDetailModel();
		List<ReceiptDetailModel> list = new ArrayList<ReceiptDetailModel>();
		if(rID!=null) {
			int receiptID = Integer.parseInt(rID);
			detailModel= deliveryDetailService.get(receiptID);
			list = receiptDetailService.getList(receiptID);
			map.put(detailModel, list);
			req.setAttribute("orderList", map);
			req.getRequestDispatcher("/views/seller/list-order.jsp").forward(req, resp);	
		}
		if(dateEnd.isEmpty()) {
			Date orderDateStart = Date.valueOf(dateStart);
			Calendar calendar = Calendar.getInstance();
			Date orderDateEnd = new Date(calendar.getTime().getTime());
			map = service.getReceiptListByDate(orderDateStart,orderDateEnd);
			req.setAttribute("orderList", map);
			req.setAttribute("dateStart", dateStart);
			req.setAttribute("dateEnd",orderDateEnd.toString());
			req.getRequestDispatcher("/views/seller/list-order.jsp").forward(req, resp);
		}
		else {
			Date orderDateStart = Date.valueOf(dateStart);
			Date orderDateEnd = Date.valueOf(dateEnd);
			map = service.getReceiptListByDate(orderDateStart,orderDateEnd);
			req.setAttribute("orderList", map);
			req.setAttribute("dateStart", dateStart);
			req.setAttribute("dateEnd",dateEnd);
			req.getRequestDispatcher("/views/seller/list-order.jsp").forward(req, resp);
		}
		
	}

}
