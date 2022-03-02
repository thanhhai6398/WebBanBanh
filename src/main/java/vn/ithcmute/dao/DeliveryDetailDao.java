package vn.ithcmute.dao;

import java.util.List;

import vn.ithcmute.model.DeliveryDetailModel;

public interface DeliveryDetailDao {
	DeliveryDetailModel get(int id);
	List<DeliveryDetailModel> getAll();
	void insert (DeliveryDetailModel deliveryDetail);
	
	//Seller
	void updateDeliveryDetail(DeliveryDetailModel dModel);
}
