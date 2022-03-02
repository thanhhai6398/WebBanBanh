package vn.ithcmute.service.impl;

import java.util.List;
import java.util.Map;

import vn.ithcmute.dao.UserDao;
import vn.ithcmute.dao.impl.UserDaoImpl;
import vn.ithcmute.model.ShopModel;
import vn.ithcmute.model.UserModel;
import vn.ithcmute.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao userDao = new UserDaoImpl();
	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
		
	}
	@Override
	public void insertBuyer(String username, String password) {
		userDao.insertBuyer(username, password);
	}
	@Override
	public UserModel get(int id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}
	@Override
	public UserModel getUname(String username) {
		return userDao.getUname(username);
	}
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.getUname(username);
		if (user != null && password.equals(user.getUpass())) {
			return user;
		}

		return null;
	}
	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}
	@Override
	public boolean register(String username, String password) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		userDao.insertBuyer(username, password);
		return true;
	}
	@Override
	public void edit(UserModel user) {
		// TODO Auto-generated method stub
		userDao.edit(user);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}
	@Override
	public int isUserExist(UserModel user) {
		// TODO Auto-generated method stub
		return userDao.isUserExist(user);
	}
	@Override
	public int getTotalUserByShop() {
		// TODO Auto-generated method stub
		return userDao.getTotalUserByShop();
	}
	@Override
	public Map<String, Integer> getTop6ShopByUser() {
		// TODO Auto-generated method stub
		return userDao.getTop6ShopByUser();
	}
	@Override
	public Map<ShopModel, Integer> getAllShopByUser() {
		// TODO Auto-generated method stub
		return userDao.getAllShopByUser();
	}
	@Override
	public List<UserModel> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}
	@Override
	public List<UserModel> search(String name) {
		// TODO Auto-generated method stub
		return userDao.search(name);
	}
	@Override
	public UserModel LoginDao(String username, String passwd) {
		// TODO Auto-generated method stub
		return userDao.LoginDao(username, passwd);
	}
	@Override
	public void update(UserModel user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}
	@Override
	public UserModel LoginSellerDao(String username, String passwd) {
		// TODO Auto-generated method stub
		return userDao.LoginSellerDao(username, passwd);
	}
	
	

}
