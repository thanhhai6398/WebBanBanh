package vn.ithcmute.dao;

import java.util.List;

import vn.ithcmute.model.StateReceiptModel;

public interface StateReceiptDao {
	void insert(StateReceiptModel StateReceipt);

	void edit(StateReceiptModel StateReceipt);

	void delete(int id);

	StateReceiptModel get(int id);

	List<StateReceiptModel> getAll();

	List<StateReceiptModel> search(String name);
}
