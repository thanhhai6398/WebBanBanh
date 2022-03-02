package vn.ithcmute.service;

import java.util.List;

import vn.ithcmute.model.DeliveryDetailModel;

public interface DeliveryDetailService {
	DeliveryDetailModel get(int id);
	List<DeliveryDetailModel> getAll();
	void insert (DeliveryDetailModel deliveryDetail);
	
	//Seller
	void updateDeliveryDetail(DeliveryDetailModel dModel);
}
