package vn.ithcmute.dao;

import java.util.List;

import vn.ithcmute.model.ReceiptDetailModel;

public interface ReceiptDetailDao {
	void insert(ReceiptDetailModel ReceiptDetail);

	void delete(int id);

	List<ReceiptDetailModel>getList(int receiptID);
	
	List<ReceiptDetailModel>getAll();
	
	void deleteDetail(int detailID);
}
