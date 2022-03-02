package vn.ithcmute.service.impl;

import java.util.List;

import vn.ithcmute.dao.ProductDao;
import vn.ithcmute.dao.ReceiptDetailDao;
import vn.ithcmute.dao.impl.ProductDaoImpl;
import vn.ithcmute.dao.impl.ReceiptDetailDaoImpl;
import vn.ithcmute.model.DeliveryDetailModel;
import vn.ithcmute.model.ProductModel;
import vn.ithcmute.model.ReceiptDetailModel;
import vn.ithcmute.service.DeliveryDetailService;
import vn.ithcmute.service.ReceiptDetailService;

public class ReceiptDetailServiceImpl implements ReceiptDetailService {

	ReceiptDetailDao receiptDetailDao = new ReceiptDetailDaoImpl();
	ProductDao pDao = new ProductDaoImpl();
	DeliveryDetailService deliveryDetailService = new DeliveryDetailServiceImpl();
	@Override
	public void insert(ReceiptDetailModel ReceiptDetail) {
		receiptDetailDao.insert(ReceiptDetail);

	}

	@Override
	public void delete(int id) {
		receiptDetailDao.delete(id);

	}

	@Override
	public List<ReceiptDetailModel> getList(int receiptID) {
		// TODO Auto-generated method stub
		return receiptDetailDao.getList(receiptID);
	}

	@Override
	public List<ReceiptDetailModel> getAll() {
		// TODO Auto-generated method stub
		return receiptDetailDao.getAll();
	}

	@Override
	public void deleteDetail(int detailID) {
		// TODO Auto-generated method stub
		receiptDetailDao.deleteDetail(detailID);
	}

	@Override
	public String updateAmountProduct(int rID) {
		// Khong can kiem tra ShopID vi list da kiem tra roi
		String msg = "";
		List<ReceiptDetailModel> listDetail = this.getList(rID);
		DeliveryDetailModel deliveryDetailModel = deliveryDetailService.get(rID);
		int receiptPrice = deliveryDetailModel.getRepPrice();
		for (ReceiptDetailModel rd : listDetail) {
			ProductModel p = rd.getpId();
			if (p.getpAmount() >= rd.getAmount()) {
				p.setpAmount(p.getpAmount() - rd.getAmount());
				pDao.update(p);
			} else {
				receiptDetailDao.deleteDetail(rd.getdId());
				receiptPrice -= p.getpPrice();
				msg += p.getpName() + " hết hàng\n";
			}
		}
		deliveryDetailModel.setRepPrice(receiptPrice);
		deliveryDetailService.updateDeliveryDetail(deliveryDetailModel);
		return msg;
	}

}
