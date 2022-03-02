package vn.ithcmute.dao;

import java.util.List;

import vn.ithcmute.model.DeliveryCompanyModel;

public interface DeliveryCompanyDao {
	DeliveryCompanyModel get(int id);
	List<DeliveryCompanyModel> getAll();
}
