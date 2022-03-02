package vn.ithcmute.controller.seller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.ithcmute.model.DeliveryDetailModel;
import vn.ithcmute.service.DeliveryDetailService;
import vn.ithcmute.service.impl.DeliveryDetailServiceImpl;


@WebServlet(urlPatterns= {"/ajax/receipt"})
public class LoadReceiptAjaxController extends HttpServlet{
	DeliveryDetailService service = new DeliveryDetailServiceImpl();

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String receiptID = req.getParameter("receiptID");
		DeliveryDetailModel d = service.get(Integer.parseInt(receiptID));
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		PrintWriter out = resp.getWriter();
		out.println("<div class=\"modal-content\">\r\n" + 
				"			<div class=\"modal-header\">\r\n" + 
				"				<h5 class=\"modal-title\" id=\"exampleModalLongTitle\">Xác nhận đơn\r\n" + 
				"					hàng</h5>\r\n" + 
				"				<button type=\"button\" class=\"close\" data-dismiss=\"modal\"\r\n" + 
				"					aria-label=\"Close\">\r\n" + 
				"					<span aria-hidden=\"true\">&times;</span>\r\n" + 
				"				</button>\r\n" + 
				"			</div>\r\n" + 
				"			<div class=\"modal-body\">\r\n" + 
				"				<div class=\"modal-order-info\">\r\n" + 
				"					<h5>Đơn vị vận chuyển:</h5>\r\n" + 
				"					<p>"+d.getCompany().getComName()+"</p>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"modal-order-info\">\r\n" + 
				"					<h5>Giá trị đơn hàng:</h5>\r\n" + 
				"					<p>"+d.getRepPrice()+"</p>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"modal-order-receiver\">\r\n" + 
				"					<h5>Người nhận hàng</h5>\r\n" + 
				"					<div>\r\n" + 
				"						<p>Tên: "+d.getReceipt().getuId().getUname()+"</p>\r\n" + 
				"						<p>Ngày đặt: "+formatter.format(d.getReceipt().getDate())+"</p>\r\n" +
				"						<p>Địa chỉ: "+d.getReceipt().getAddress()+"</p>\r\n" +
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"modal-order-receiver\">\r\n" + 
				"					<h5>Địa chỉ lấy hàng</h5>\r\n" + 
				"					<div>\r\n" + 
				"						<h6>\r\n" + d.getReceipt().getsId().getsName()+"<span>"+d.getReceipt().getsId().getsPhone()+"</span>\r\n" + 
				"						</h6>\r\n" + 
				"						<p>"+d.getReceipt().getsId().getsAddrs()+"</p>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"			</div>\r\n" + 
				"			<div class=\"modal-footer\">\r\n" + 
				"				<button type=\"button\" class=\"btn btn-modal btn-cancel\"\r\n" + 
				"					data-dismiss=\"modal\">Đóng</button>\r\n" + 
				"				<a href=\""+req.getContextPath()+"/seller/receipt/check?rID="+d.getReceipt().getrId()+"&state="+d.getReceipt().getStId().getStId()+"\" class=\"btn btn-modal btn-save\">Xác nhận</a>\r\n" + 
				"			</div>\r\n" + 
				"		</div>");
		
	}

}
