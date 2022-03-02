package vn.ithcmute.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import vn.ithcmute.model.DeliveryDetailModel;
import vn.ithcmute.model.ReceiptDetailModel;
import vn.ithcmute.model.ReceiptModel;
import vn.ithcmute.model.ShopModel;

public interface ReceiptService {
	void insert(ReceiptModel Receipt);

	void edit(ReceiptModel Receipt);

	ReceiptModel get(int id);

	List<ReceiptModel> getAll();

	List<ReceiptModel> getByU(int uid, int stId);

	Map<DeliveryDetailModel, List<ReceiptDetailModel>> getReceiptListByUser(int uid);

	// List<ReceiptModel> search(String name);
	int updateState(int rID, int state);

	// Admin
	int getTotalReceiptByShop();

	Map<String, Integer> getTop6ShopByReceipt();

	Map<ShopModel, Integer> getAllShopByReceipt();

	// Seller
	List<ReceiptModel> getListByShopID(String sql);

	List<ReceiptModel> getStateReceiptList(int stateID);

	List<ReceiptModel> getListByDate(Date dateStart, Date dateEnd);

	int CountState(int stateID);

	int countAll();
	
	Map<DeliveryDetailModel, List<ReceiptDetailModel>> getReceiptListByShop(int state);
	
	Map<DeliveryDetailModel, List<ReceiptDetailModel>> getReceiptListByDate(Date date1,Date date2);
}
