package vn.ithcmute.service.impl;

import java.util.List;

import vn.ithcmute.dao.StateReceiptDao;
import vn.ithcmute.dao.impl.StateReceiptDaoImpl;
import vn.ithcmute.model.StateReceiptModel;
import vn.ithcmute.service.StateReceiptService;

public class StateReceiptServiceImpl implements StateReceiptService{
	StateReceiptDao statedao = new StateReceiptDaoImpl();
	@Override
	public void insert(StateReceiptModel StateReceipt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(StateReceiptModel StateReceipt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StateReceiptModel get(int id) {
		// TODO Auto-generated method stub
		return statedao.get(id);
	}

	@Override
	public List<StateReceiptModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateReceiptModel> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
