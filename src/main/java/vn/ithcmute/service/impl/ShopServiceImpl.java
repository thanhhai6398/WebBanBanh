package vn.ithcmute.service.impl;

import java.util.List;

import vn.ithcmute.dao.ShopDao;
import vn.ithcmute.dao.impl.ShopDaoImpl;
import vn.ithcmute.model.ShopModel;
import vn.ithcmute.service.ShopService;

public class ShopServiceImpl implements ShopService{
	ShopDao dao = new ShopDaoImpl();

	@Override
	public ShopModel get(int id) {
		return dao.get(id);
	}

	@Override
	public List<ShopModel> getAll() {
		return dao.getAll();
	}

	@Override
	public void insert(ShopModel shop) {
		dao.insert(shop);
		
	}

	@Override
	public void edit(ShopModel newShop) {
		ShopModel oldShop = dao.get(newShop.getsID());
		oldShop.setsName(newShop.getsName());
		oldShop.setsAddrs(newShop.getsAddrs());
		oldShop.setsPhone(newShop.getsPhone());
		dao.edit(oldShop);
		
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
		
	}

	@Override
	public ShopModel search(String ShopName) {
		return dao.search(ShopName);
	}

}
