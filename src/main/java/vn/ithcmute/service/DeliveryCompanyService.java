package vn.ithcmute.service;

import java.util.List;

import vn.ithcmute.model.DeliveryCompanyModel;

public interface DeliveryCompanyService {
	DeliveryCompanyModel get(int id);
	List<DeliveryCompanyModel> getAll();
}
