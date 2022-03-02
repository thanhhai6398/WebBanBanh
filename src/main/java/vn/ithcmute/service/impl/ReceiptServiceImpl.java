package vn.ithcmute.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vn.ithcmute.dao.ReceiptDao;
import vn.ithcmute.dao.ReceiptDetailDao;
import vn.ithcmute.dao.impl.ReceiptDaoImpl;
import vn.ithcmute.dao.impl.ReceiptDetailDaoImpl;
import vn.ithcmute.model.DeliveryDetailModel;
import vn.ithcmute.model.ReceiptDetailModel;
import vn.ithcmute.model.ReceiptModel;
import vn.ithcmute.model.ShopModel;
import vn.ithcmute.service.DeliveryDetailService;
import vn.ithcmute.service.ReceiptService;
import vn.ithcmute.util.ShopID;

public class ReceiptServiceImpl implements ReceiptService{
	ReceiptDao receiptDao = new ReceiptDaoImpl();
	ReceiptDetailDao detailService = new ReceiptDetailDaoImpl();
	DeliveryDetailService deliveryDetailService = new DeliveryDetailServiceImpl();
	@Override
	public void insert(ReceiptModel Receipt) {
		receiptDao.insert(Receipt);
		
	}

	@Override
	public void edit(ReceiptModel newReceipt) {
		ReceiptModel oldReceipt = receiptDao.get(newReceipt.getrId());		
		oldReceipt.setuId(newReceipt.getuId());
		oldReceipt.setsId(newReceipt.getsId());
		oldReceipt.setStId(newReceipt.getStId());
		oldReceipt.setDate(newReceipt.getDate());
		oldReceipt.setAddress(newReceipt.getAddress());
		receiptDao.edit(oldReceipt);
		
	}

	@Override
	public ReceiptModel get(int id) {
		// TODO Auto-generated method stub
		return receiptDao.get(id);
	}

	@Override
	public List<ReceiptModel> getAll() {
		// TODO Auto-generated method stub
		return receiptDao.getAll();
	}

	@Override
	public List<ReceiptModel> getByU(int uid, int stId) {
		// TODO Auto-generated method stub
		return receiptDao.getByU(uid, stId);
	}

	@Override
	public Map<DeliveryDetailModel, List<ReceiptDetailModel>> getReceiptListByUser(int uid) {
		/*Map<DeliveryDetailModel, List<ReceiptDetailModel>> map = new HashMap<DeliveryDetailModel, List<ReceiptDetailModel>>();
		List<ReceiptModel> listReceipt = new ArrayList<ReceiptModel>();
		List<ReceiptDetailModel> listDetail = new ArrayList<ReceiptDetailModel>();
		DeliveryDetailModel deliveryDetailModel = new DeliveryDetailModel();
		
		listReceipt = this.getByU(uid);
		
		for(ReceiptModel receipt : listReceipt) {
			UserModel userModel = receipt.getuId();
			if(userModel.getUid()==ShopID.sID) {
				//Lay danh sach items theo ma hoa don
				listDetail = detailService.getList(receipt.getrId());
				//Lay thong tin giao hang theo ma hoa don
				deliveryDetailModel = deliveryDetailService.get(receipt.getrId());
				map.put(deliveryDetailModel, listDetail);
			}
		}

		return map;*/
		return null;
	}

	@Override
	public int updateState(int rID, int state) {
		// TODO Auto-generated method stub
		return receiptDao.updateState(rID, state);
	}

	@Override
	public int getTotalReceiptByShop() {
		// TODO Auto-generated method stub
		return receiptDao.getTotalReceiptByShop();
	}

	@Override
	public Map<String, Integer> getTop6ShopByReceipt() {
		// TODO Auto-generated method stub
		return receiptDao.getTop6ShopByReceipt();
	}

	@Override
	public Map<ShopModel, Integer> getAllShopByReceipt() {
		// TODO Auto-generated method stub
		return receiptDao.getAllShopByReceipt();
	}

	@Override
	public List<ReceiptModel> getListByShopID(String sql) {
		// TODO Auto-generated method stub
		return receiptDao.getListByShopID(sql);
	}

	@Override
	public List<ReceiptModel> getStateReceiptList(int stateID) {
		// TODO Auto-generated method stub
		return receiptDao.getStateReceiptList(stateID);
	}

	@Override
	public List<ReceiptModel> getListByDate(Date dateStart, Date dateEnd) {
		// TODO Auto-generated method stub
		return receiptDao.getListByDate(dateStart, dateEnd);
	}

	@Override
	public int CountState(int stateID) {
		// TODO Auto-generated method stub
		return receiptDao.CountState(stateID);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return receiptDao.countAll();
	}

	@Override
	public Map<DeliveryDetailModel, List<ReceiptDetailModel>> getReceiptListByShop(int state) {
		// TODO Auto-generated method stub
		Map<DeliveryDetailModel, List<ReceiptDetailModel>> map = new HashMap<DeliveryDetailModel, List<ReceiptDetailModel>>();
		List<ReceiptModel> listReceipt = new ArrayList<ReceiptModel>();
		List<ReceiptDetailModel> listDetail = new ArrayList<ReceiptDetailModel>();
		DeliveryDetailModel deliveryDetailModel = new DeliveryDetailModel();
		
		if(state==0) {
			listReceipt = this.getAll();
		}
		else listReceipt = this.getStateReceiptList(state);
		
		for(ReceiptModel receipt : listReceipt) {
			ShopModel shopModel = receipt.getsId();
			if(shopModel.getsID()==ShopID.sID) {
				//Lay danh sach items theo ma hoa don
				listDetail = detailService.getList(receipt.getrId());
				//Lay thong tin giao hang theo ma hoa don
				deliveryDetailModel = deliveryDetailService.get(receipt.getrId());
				map.put(deliveryDetailModel, listDetail);
			}
		}

		return map;
	}

	@Override
	public Map<DeliveryDetailModel, List<ReceiptDetailModel>> getReceiptListByDate(Date date1, Date date2) {
		// TODO Auto-generated method stub
		Map<DeliveryDetailModel, List<ReceiptDetailModel>> map = new HashMap<DeliveryDetailModel, List<ReceiptDetailModel>>();
		List<ReceiptModel> listReceipt = new ArrayList<ReceiptModel>();
		List<ReceiptDetailModel> listDetail = new ArrayList<ReceiptDetailModel>();
		DeliveryDetailModel deliveryDetailModel = new DeliveryDetailModel();
		
		listReceipt = this.getListByDate(date1,date2);
		
		for(ReceiptModel receipt : listReceipt) {
			
				//Lay danh sach items theo ma hoa don
				listDetail = detailService.getList(receipt.getrId());
				//Lay thong tin giao hang theo ma hoa don
				deliveryDetailModel = deliveryDetailService.get(receipt.getrId());
				map.put(deliveryDetailModel, listDetail);
		}

		return map;
	}

}
