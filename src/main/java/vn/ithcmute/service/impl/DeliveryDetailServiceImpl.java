package vn.ithcmute.service.impl;

import java.util.List;

import vn.ithcmute.dao.DeliveryDetailDao;
import vn.ithcmute.dao.impl.DeliveryDetailDaoImpl;
import vn.ithcmute.model.DeliveryDetailModel;
import vn.ithcmute.service.DeliveryDetailService;

public class DeliveryDetailServiceImpl implements DeliveryDetailService{
	DeliveryDetailDao dao = new DeliveryDetailDaoImpl();
	@Override
	public DeliveryDetailModel get(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}
	@Override
	public List<DeliveryDetailModel> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}
	@Override
	public void insert(DeliveryDetailModel deliveryDetail) {
		dao.insert(deliveryDetail);
		
	}
	@Override
	public void updateDeliveryDetail(DeliveryDetailModel dModel) {
		// TODO Auto-generated method stub
		dao.updateDeliveryDetail(dModel);
	}

}
