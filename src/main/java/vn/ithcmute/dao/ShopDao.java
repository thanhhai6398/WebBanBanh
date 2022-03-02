package vn.ithcmute.dao;

import java.util.List;

import vn.ithcmute.model.ShopModel;

public interface ShopDao {
	ShopModel get(int id);
	List<ShopModel> getAll();
	void insert (ShopModel shop);
	void edit(ShopModel newShop);
	void delete (int id);
	ShopModel search(String ShopName);

}