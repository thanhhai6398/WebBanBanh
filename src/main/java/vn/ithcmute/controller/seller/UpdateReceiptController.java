package vn.ithcmute.controller.seller;

import java.io.IOException;
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
import vn.ithcmute.service.ReceiptDetailService;
import vn.ithcmute.service.ReceiptService;
import vn.ithcmute.service.impl.ReceiptDetailServiceImpl;
import vn.ithcmute.service.impl.ReceiptServiceImpl;

@WebServlet(urlPatterns= {"/seller/receipt/check"})
public class UpdateReceiptController extends HttpServlet{
	ReceiptService service = new ReceiptServiceImpl();
	ReceiptDetailService detailService  = new ReceiptDetailServiceImpl();
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8"); 
		
		int rID = Integer.parseInt(req.getParameter("rID"));
		int state = Integer.parseInt(req.getParameter("state"));
		
		String msg=detailService.updateAmountProduct(rID);
		if(msg!="") {
			req.setAttribute("msg", msg);
			Map<DeliveryDetailModel, List<ReceiptDetailModel>> map = new HashMap<DeliveryDetailModel, List<ReceiptDetailModel>>();
			map = service.getReceiptListByShop(1);
			req.setAttribute("orderList", map);
			req.getRequestDispatcher("/views/seller/list-order.jsp").forward(req, resp);
		}else if(state==4) {
			resp.sendRedirect(req.getContextPath()+"/seller/receipt/list?type=cancelled");
		}else if(state==3) {
			resp.sendRedirect(req.getContextPath()+"/seller/receipt/list?type=delivered");
		}
		else if(service.updateState(rID, state)>0 && state==1) {
			
			resp.sendRedirect(req.getContextPath()+"/seller/receipt/list?type=delivering");
		}
		else if(service.updateState(rID, state)>0 && state==2) {
			resp.sendRedirect(req.getContextPath()+"/seller/receipt/list?type=delivered");
		}
		else resp.sendRedirect(req.getContextPath()+"/seller/receipt/list?type=waitting");
	
	}
}
