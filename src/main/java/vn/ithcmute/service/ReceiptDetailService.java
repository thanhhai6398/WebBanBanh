package vn.ithcmute.service;

import java.util.List;

import vn.ithcmute.model.ReceiptDetailModel;

public interface ReceiptDetailService {
	void insert(ReceiptDetailModel ReceiptDetail);

	void delete(int id);

	List<ReceiptDetailModel>getList(int receiptID);

	List<ReceiptDetailModel>getAll();
	
	//Seller
	void deleteDetail(int detailID);
	
	String updateAmountProduct(int rID);
}
