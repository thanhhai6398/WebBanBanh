package vn.ithcmute.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.ithcmute.model.ReceiptModel;
import vn.ithcmute.model.UserModel;
import vn.ithcmute.model.DeliveryDetailModel;
import vn.ithcmute.model.ReceiptDetailModel;
import vn.ithcmute.service.DeliveryCompanyService;
import vn.ithcmute.service.DeliveryDetailService;
import vn.ithcmute.service.ReceiptDetailService;
import vn.ithcmute.service.ReceiptService;
import vn.ithcmute.service.ShopService;
import vn.ithcmute.service.StateReceiptService;
import vn.ithcmute.service.impl.ReceiptServiceImpl;
import vn.ithcmute.service.impl.ShopServiceImpl;
import vn.ithcmute.service.impl.StateReceiptServiceImpl;
import vn.ithcmute.service.impl.DeliveryCompanyServiceImpl;
import vn.ithcmute.service.impl.DeliveryDetailServiceImpl;
import vn.ithcmute.service.impl.ReceiptDetailServiceImpl;
import vn.ithcmute.util.RandomUUID;

@WebServlet(urlPatterns = "/order")
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StateReceiptService stateService = new StateReceiptServiceImpl();
	ShopService shopService = new ShopServiceImpl();
	ReceiptService receiptService = new ReceiptServiceImpl();
	ReceiptDetailService detailService = new ReceiptDetailServiceImpl();
	
	// New
	DeliveryCompanyService deliveryCompanyService = new DeliveryCompanyServiceImpl();
	DeliveryDetailService deliveryDetailService = new DeliveryDetailServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// Lay cart, account tu session
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");
		UserModel buyer = (UserModel) httpSession.getAttribute("acc");

		Calendar calendar = Calendar.getInstance();
		@SuppressWarnings("unused")
		Date date = new Date(calendar.getTime().getTime());

		// Chia so don
		Map<Integer, ArrayList<ReceiptDetailModel>> listReceipt = new HashMap<Integer, ArrayList<ReceiptDetailModel>>();

		if (obj != null) {
			Map<Integer, ReceiptDetailModel> map = extracted(obj);
			for (Map.Entry<Integer, ReceiptDetailModel> set : map.entrySet()) {

				if (listReceipt.get(set.getValue().getpId().getShop().getsID()) == null) {
					ArrayList<ReceiptDetailModel> detailList = new ArrayList<ReceiptDetailModel>();
					detailList.add(set.getValue());
					listReceipt.put(set.getValue().getpId().getShop().getsID(), detailList);
				} else {
					listReceipt.get(set.getValue().getpId().getShop().getsID()).add(set.getValue());
				}
			}
		}
		
		// 12-10-2021
		String comID = req.getParameter("comID");
		String adrs = req.getParameter("adrs");
		int sum;
		// Tao don
		@SuppressWarnings("unused")
		int numberOfReceipt = listReceipt.size();
		for (Map.Entry<Integer, ArrayList<ReceiptDetailModel>> set : listReceipt.entrySet()) {
			sum = deliveryCompanyService.get(Integer.parseInt(comID)).getComPrice();
			ReceiptModel receiptModel = new ReceiptModel();
			int receiptID = RandomUUID.getRandom();
			receiptModel.setrId(receiptID);
			receiptModel.setsId(shopService.get(set.getKey()));
			receiptModel.setuId(buyer);
			receiptModel.setAddress(adrs);
			receiptService.insert(receiptModel);
			for (ReceiptDetailModel d : set.getValue()) {
				d.setrId(receiptModel);
				detailService.insert(d);
				
				// 12-10-2021
				sum = sum + d.getpId().getpPrice();
			}
			DeliveryDetailModel deliveryDetailModel = new DeliveryDetailModel();
			deliveryDetailModel.setCompany(deliveryCompanyService.get(Integer.parseInt(comID)));
			deliveryDetailModel.setReceipt(receiptModel);
			deliveryDetailModel.setRepPrice(sum);
			deliveryDetailService.insert(deliveryDetailModel);
		}
		httpSession.removeAttribute("cart");
		resp.sendRedirect(req.getContextPath() + "/waiting");
	}

	@SuppressWarnings("unchecked")
	private Map<Integer, ReceiptDetailModel> extracted(Object obj) {
		return (Map<Integer, ReceiptDetailModel>) obj;
	}

}