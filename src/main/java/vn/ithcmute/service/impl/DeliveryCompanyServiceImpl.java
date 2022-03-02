package vn.ithcmute.service.impl;

import java.util.List;

import vn.ithcmute.dao.DeliveryCompanyDao;
import vn.ithcmute.dao.impl.DeliveryCompanyDaoImpl;
import vn.ithcmute.model.DeliveryCompanyModel;
import vn.ithcmute.service.DeliveryCompanyService;

public class DeliveryCompanyServiceImpl implements DeliveryCompanyService{
	DeliveryCompanyDao dao = new DeliveryCompanyDaoImpl();
	@Override
	public DeliveryCompanyModel get(int id) {
		return dao.get(id);
	}
	@Override
	public List<DeliveryCompanyModel> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}
	

}
