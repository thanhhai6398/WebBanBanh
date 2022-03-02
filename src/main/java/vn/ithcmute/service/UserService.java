package vn.ithcmute.service;

import java.util.List;
import java.util.Map;

import vn.ithcmute.model.ShopModel;
import vn.ithcmute.model.UserModel;

public interface UserService {
	void insert (UserModel user);
	void edit(UserModel user);
	void delete(int id);
	void insertBuyer(String username, String password);
	UserModel get(int id);
	UserModel getUname(String username);
	UserModel login(String username, String password);
	boolean checkExistUsername(String username);
	boolean register(String username, String password);
	
	List<UserModel> getAll();
	List<UserModel> search(String name);
	
	int isUserExist(UserModel user);
	int getTotalUserByShop();
	
	Map<String, Integer> getTop6ShopByUser();
	
	Map<ShopModel, Integer> getAllShopByUser();
	
	//Seller
	UserModel LoginDao(String username, String passwd);

	void update(UserModel user);

	UserModel LoginSellerDao(String username, String passwd);
}
