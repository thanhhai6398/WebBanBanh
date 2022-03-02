package vn.ithcmute.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import vn.ithcmute.connection.DBConnection;
import vn.ithcmute.dao.UserDao;
import vn.ithcmute.model.ShopModel;
import vn.ithcmute.model.UserModel;
import vn.ithcmute.service.ShopService;
import vn.ithcmute.service.impl.ShopServiceImpl;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	ShopService shopService = new ShopServiceImpl();
	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO Users (Username, Password, isSeller, isAdmin,ShopID) VALUES (?, ?, ?, ?, ?)";
		try {
			ShopModel shop = user.getShop();
			if (shop == null)
			{
				sql = "INSERT INTO Users (Username, Password, isSeller, isAdmin) VALUES (?, ?, ?, ?)";
			}
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpass());
			ps.setInt(3, user.getIsSel());
			ps.setInt(4, user.getIsAd());
			if (shop != null)
			{
				ps.setInt(5, user.getShop().getsID());
			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void insertBuyer(String username, String password) {
		String sql = "INSERT INTO Users(Username, Password, isSeller, isAdmin, ShopID) VALUES (?,?,0,0,null)";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public UserModel get(int id) {
		String sql = "SELECT * FROM Users WHERE UserID = ?";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel userModel = new UserModel();
				userModel.setUid(rs.getInt("UserID"));
				userModel.setUname(rs.getString("Username"));
				userModel.setUpass(rs.getString("Password"));
				userModel.setIsSel(rs.getInt("isSeller"));
				userModel.setIsAd(rs.getInt("isAdmin"));
				try
				{
					int shopID = rs.getInt("ShopID");
					userModel.setShop(shopService.get(shopID));

				}
				catch (Exception e)
				{
					userModel.setShop(null);
				}
				return userModel;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel getUname(String username) {
		String sql = "SELECT * FROM Users WHERE Username = ? ";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setIsAd(rs.getInt("isAdmin"));
				user.setIsSel(rs.getInt("isSeller"));
				ShopModel shop = new ShopModel();
				shop.setsID(rs.getInt("ShopID"));
				user.setUpass(rs.getString("Password"));
				user.setUid(rs.getInt("UserID"));
				user.setUname(rs.getString("Username"));

				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String sql = "select * from Users where Username = ?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
		} catch (Exception ex) {
		}
		return duplicate;
	}
	@Override
	public void edit(UserModel user) {
		// TODO Auto-generated method stub
		try {
			ShopModel shop = user.getShop();
			if (shop == null)
			{
				String sql = "UPDATE Users SET Username = ?, Password = ?, isSeller = ?, isAdmin = ?, ShopID = NULL WHERE UserID = ?";
				Connection con = new DBConnection().getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(5, user.getUid());
				ps.setString(1, user.getUname());
				ps.setString(2, user.getUpass());
				ps.setInt(3, user.getIsSel());
				ps.setInt(4, user.getIsAd());
				ps.executeUpdate();
			}
			else
			{
				String sql = "UPDATE Users SET Username = ?, Password = ?, isSeller = ?, isAdmin = ?, ShopID = ? WHERE UserID = ?";
				Connection con = new DBConnection().getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(6, user.getUid());
				ps.setString(1, user.getUname());
				ps.setString(2, user.getUpass());
				ps.setInt(3, user.getIsSel());
				ps.setInt(4, user.getIsAd());
				ps.setInt(5, user.getShop().getsID());
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Users WHERE UserID = ?";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<UserModel> getAll() {
		// TODO Auto-generated method stub
		List<UserModel> list = new ArrayList<UserModel>();
		String sql = "SELECT * FROM Users";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel userModel = new UserModel();
				userModel.setUid(rs.getInt("UserID"));
				userModel.setUname(rs.getString("Username"));
				userModel.setUpass(rs.getString("Password"));
				userModel.setIsSel(rs.getInt("isSeller"));
				userModel.setIsAd(rs.getInt("isAdmin"));
				try
				{
					int shopID = rs.getInt("ShopID");
					userModel.setShop(shopService.get(shopID));

				}
				catch (Exception e)
				{
					userModel.setShop(null);
				}
				list.add(userModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<UserModel> search(String name) {
		// TODO Auto-generated method stub
		List<UserModel> list = new ArrayList<UserModel>();
		String sql = "SELECT * FROM Users LEFT OUTER JOIN Shop ON Users.ShopID = Shop.ShopID WHERE Username LIKE ?";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel userModel = new UserModel();
				userModel.setUid(rs.getInt("UserID"));
				userModel.setUname(rs.getString("Username"));
				userModel.setUpass(rs.getString("Password"));
				userModel.setIsSel(rs.getInt("isSeller"));
				userModel.setIsAd(rs.getInt("isAdmin"));
				try
				{
					int shopID = rs.getInt("ShopID");
					userModel.setShop(shopService.get(shopID));

				}
				catch (Exception e)
				{
					userModel.setShop(null);
				}
				list.add(userModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int isUserExist(UserModel user) {
		// TODO Auto-generated method stub
		String sql ="select * from Users where Username =?";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int getTotalUserByShop() {
		// TODO Auto-generated method stub
		int count = 0;
		String sql = "SELECT ISNULL(COUNT(UserID), 0) AS TongNguoiDung\r\n" + 
				"FROM Receipt\r\n" + 
				"WHERE MONTH(Receipt.Date) = MONTH(GETDATE())";
		
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("TongNguoiDung");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public Map<String, Integer> getTop6ShopByUser() {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		String sql = "SELECT TOP 6 Shop.ShopID, ISNULL(TongNguoiDung, 0) AS TongNguoiDung\r\n" + 
				"FROM Shop LEFT OUTER JOIN\r\n" + 
				"(SELECT Receipt.ShopID, COUNT(UserID) AS TongNguoiDung\r\n" + 
				"FROM Receipt\r\n" + 
				"WHERE MONTH(Receipt.Date) = MONTH(GETDATE())\r\n" + 
				"GROUP BY Receipt.ShopID) AS R\r\n" + 
				"ON Shop.ShopID = R.ShopID\r\n" + 
				"ORDER BY TongNguoiDung DESC";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ShopModel shop = shopService.get(rs.getInt("ShopID"));
				int count = rs.getInt("TongNguoiDung");
				map.put(shop.getsName(), count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public Map<ShopModel, Integer> getAllShopByUser() {
		// TODO Auto-generated method stub
		Map<ShopModel, Integer> map = new HashMap<ShopModel, Integer>();
		String sql = "SELECT Shop.ShopID, ISNULL(TongNguoiDung, 0) AS TongNguoiDung\r\n" + 
				"FROM Shop LEFT OUTER JOIN\r\n" + 
				"(SELECT Receipt.ShopID, COUNT(UserID) AS TongNguoiDung\r\n" + 
				"FROM Receipt\r\n" + 
				"WHERE MONTH(Receipt.Date) = MONTH(GETDATE())\r\n" + 
				"GROUP BY Receipt.ShopID) AS R\r\n" + 
				"ON Shop.ShopID = R.ShopID\r\n" + 
				"ORDER BY TongNguoiDung DESC";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ShopModel shop = shopService.get(rs.getInt("ShopID"));
				int count = rs.getInt("TongNguoiDung");
				map.put(shop, count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public UserModel LoginDao(String username, String passwd) {
		UserModel userModel = new UserModel();
		String sql="select * from Users where Username=? and Password=? and ShopID is  Null";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, passwd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				userModel.setUid(rs.getInt(1));
				userModel.setUname(rs.getString(2));
				userModel.setUpass(rs.getString(3));
				userModel.setIsAd(rs.getInt(4));
				userModel.setIsSel(rs.getInt(5));
				userModel.setShop(shopService.get(rs.getInt(6)));
				return userModel;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void update(UserModel user) {
		// TODO Auto-generated method stub
		String sql="update Users set Username=?,Password=?,isSeller=?,isAdmin=?,ShopID=?\r\n" + 
				"where UserID=?";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpass());
			ps.setInt(3, user.getIsSel());
			ps.setInt(4, user.getIsAd());
			ps.setInt(5, user.getShop().getsID());
			ps.setInt(6, user.getUid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public UserModel LoginSellerDao(String username, String passwd) {
		// TODO Auto-generated method stub
		UserModel userModel = new UserModel();
		String sql="select * from Users where Username=? and Password=? and ShopID is not Null";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, passwd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				userModel.setUid(rs.getInt(1));
				userModel.setUname(rs.getString(2));
				userModel.setUpass(rs.getString(3));
				userModel.setIsAd(rs.getInt(4));
				userModel.setIsSel(rs.getInt(5));
				userModel.setShop(shopService.get(rs.getInt(6)));
				return userModel;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
