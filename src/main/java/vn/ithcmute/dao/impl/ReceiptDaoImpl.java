package vn.ithcmute.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vn.ithcmute.connection.DBConnection;
import vn.ithcmute.dao.ReceiptDao;
import vn.ithcmute.model.UserModel;
import vn.ithcmute.service.ShopService;
import vn.ithcmute.service.StateReceiptService;
import vn.ithcmute.service.UserService;
import vn.ithcmute.service.impl.ShopServiceImpl;
import vn.ithcmute.service.impl.StateReceiptServiceImpl;
import vn.ithcmute.service.impl.UserServiceImpl;
import vn.ithcmute.util.ShopID;
import vn.ithcmute.model.ReceiptModel;
import vn.ithcmute.model.ShopModel;
import vn.ithcmute.model.StateReceiptModel;

public class ReceiptDaoImpl extends DBConnection implements ReceiptDao {
	UserService userS = new UserServiceImpl();
	ShopService shopS = new ShopServiceImpl();
	StateReceiptService stateS = new StateReceiptServiceImpl();

	@Override
	public void insert(ReceiptModel Receipt) {
		String sql = "INSERT INTO Receipt(ReceiptID, UserID, ShopID, StateID, Date, Address) VALUES (?,?,?,1,?,?)";
		try {
			@SuppressWarnings("unused")
			Calendar calendar = Calendar.getInstance();
			//Date date = new Date(calendar.getTime().getTime());
			
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Receipt.getrId());
			ps.setInt(2, Receipt.getuId().getUid());
			ps.setInt(3, Receipt.getsId().getsID());
			ps.setDate(4, date);
			ps.setString(5, Receipt.getAddress());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(ReceiptModel Receipt) {
		String sql = "UPDATE Receipt SET StateID=? WHERE ReceiptID = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Receipt.getsId().getsID());
			ps.setInt(2, Receipt.getrId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ReceiptModel get(int id) {
		String sql = "SELECT * FROM Receipt, Shop, StateReceipt, Users \r\n"
				+ "WHERE Receipt.ShopID = Shop.ShopID AND Receipt.StateID = StateReceipt.StateID AND Receipt.UserID= Users.UserID AND Receipt.ReceiptID=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = userS.get(rs.getInt("UserID"));
				ShopModel shop = shopS.get(rs.getInt("ShopID"));
				StateReceiptModel state = stateS.get(rs.getInt("StateID"));
				ReceiptModel Receipt = new ReceiptModel();

				Receipt.setrId(rs.getInt("ReceiptID"));
				Receipt.setDate(rs.getDate("Date"));
				Receipt.setAddress(rs.getString("Address"));
				Receipt.setuId(user);
				Receipt.setsId(shop);
				Receipt.setStId(state);
				return Receipt;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ReceiptModel> getAll() {
		List<ReceiptModel> ReceiptList = new ArrayList<ReceiptModel>();
		String sql = "SELECT * FROM Receipt, Shop, StateReceipt, Users "
				+ "WHERE Receipt.ShopID = Shop.ShopID AND Receipt.StateID = StateReceipt.StateID AND Receipt.UserID= Users.UserID";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = userS.get(rs.getInt("UserID"));
				ShopModel shop = shopS.get(rs.getInt("ShopID"));
				StateReceiptModel state = stateS.get(rs.getInt("StateID"));
				ReceiptModel Receipt = new ReceiptModel();

				Receipt.setrId(rs.getInt("ReceiptID"));
				Receipt.setDate(rs.getDate("Date"));
				Receipt.setAddress(rs.getString("Address"));
				Receipt.setuId(user);
				Receipt.setsId(shop);
				Receipt.setStId(state);

				ReceiptList.add(Receipt);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ReceiptList;
	}

	@Override
	public List<ReceiptModel> getByU(int uid, int stId) {
		List<ReceiptModel> ReceiptList = new ArrayList<ReceiptModel>();
		String sql = "SELECT * FROM Receipt, Shop, StateReceipt, Users \r\n"
				+ "WHERE Receipt.ShopID = Shop.ShopID AND Receipt.StateID = StateReceipt.StateID AND Receipt.UserID= Users.UserID and Users.UserID = ? and Receipt.StateID =? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setInt(2, stId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ReceiptModel Receipt = new ReceiptModel();

				Receipt.setrId(rs.getInt("ReceiptID"));
				Receipt.setuId(userS.get(rs.getInt("UserID")));
				Receipt.setsId(shopS.get(rs.getInt("ShopID")));
				Receipt.setStId(stateS.get(rs.getInt("StateID")));
				Receipt.setDate(rs.getDate("Date"));
				Receipt.setAddress(rs.getString("Address"));

				ReceiptList.add(Receipt);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ReceiptList;
	}

	@Override
	public int updateState(int rID, int state) {
		String sql = "update Receipt set StateID=? where ReceiptID=?";
		int result = 0;
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, state);
			ps.setInt(2, rID);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getTotalReceiptByShop() {
		// TODO Auto-generated method stub
		int count = 0;
		String sql = "SELECT ISNULL(COUNT(ReceiptID), 0) AS TongDonHang\r\n" + "FROM Receipt\r\n"
				+ "WHERE MONTH(Receipt.Date) = MONTH(GETDATE())";

		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("TongDonHang");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Map<String, Integer> getTop6ShopByReceipt() {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		String sql = "SELECT TOP 6 Shop.ShopID, ISNULL(TongDonHang, 0) AS TongDonHang\r\n"
				+ "FROM Shop LEFT OUTER JOIN\r\n" + "(SELECT Receipt.ShopID, COUNT(ReceiptID) AS TongDonHang\r\n"
				+ "FROM Receipt\r\n" + "WHERE MONTH(Receipt.Date) = MONTH(GETDATE())\r\n"
				+ "GROUP BY Receipt.ShopID) AS R\r\n" + "ON Shop.ShopID = R.ShopID\r\n" + "ORDER BY TongDonHang DESC";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ShopModel shop = shopS.get(rs.getInt("ShopID"));
				int count = rs.getInt("TongDonHang");
				map.put(shop.getsName(), count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<ShopModel, Integer> getAllShopByReceipt() {
		// TODO Auto-generated method stub
		Map<ShopModel, Integer> map = new HashMap<ShopModel, Integer>();
		String sql = "SELECT Shop.ShopID, ISNULL(TongDonHang, 0) AS TongDonHang\r\n" + "FROM Shop LEFT OUTER JOIN\r\n"
				+ "(SELECT Receipt.ShopID, COUNT(ReceiptID) AS TongDonHang\r\n" + "FROM Receipt\r\n"
				+ "WHERE MONTH(Receipt.Date) = MONTH(GETDATE())\r\n" + "GROUP BY Receipt.ShopID) AS R\r\n"
				+ "ON Shop.ShopID = R.ShopID\r\n" + "ORDER BY TongDonHang DESC";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ShopModel shop = shopS.get(rs.getInt("ShopID"));
				int count = rs.getInt("TongDonHang");
				map.put(shop, count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public List<ReceiptModel> getListByShopID(String sql) {
		// TODO Auto-generated method stub
		List<ReceiptModel> list = new ArrayList<ReceiptModel>();
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ShopID.sID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ReceiptModel receipt = new ReceiptModel();
				receipt.setrId(rs.getInt(1));
				receipt.setuId(userS.get(rs.getInt(2)));
				receipt.setsId(shopS.get(rs.getInt(3)));
				receipt.setStId(stateS.get(rs.getInt(4)));
				receipt.setDate(rs.getDate(5));
				receipt.setAddress(rs.getString(6));
				list.add(receipt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ReceiptModel> getStateReceiptList(int stateID) {
		// TODO Auto-generated method stub
		String sql = "select * from Receipt where StateID=? and ShopID=?";
		List<ReceiptModel> list = new ArrayList<ReceiptModel>();
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, stateID);
			ps.setInt(2, ShopID.sID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ReceiptModel receipt = new ReceiptModel();
				receipt.setrId(rs.getInt(1));
				receipt.setuId(userS.get(rs.getInt(2)));
				receipt.setsId(shopS.get(rs.getInt(3)));
				receipt.setStId(stateS.get(rs.getInt(4)));
				receipt.setDate(rs.getDate(5));
				receipt.setAddress(rs.getString(6));
				list.add(receipt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ReceiptModel> getListByDate(java.sql.Date dateStart, java.sql.Date dateEnd) {
		// TODO Auto-generated method stub
		String sql = "select * from Receipt where Date between ? and ? and ShopID=?";
		List<ReceiptModel> list = new ArrayList<ReceiptModel>();
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDate(1, dateStart);
			ps.setDate(2, dateEnd);
			ps.setInt(3, ShopID.sID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ReceiptModel receipt = new ReceiptModel();
				receipt.setrId(rs.getInt(1));
				receipt.setuId(userS.get(rs.getInt(2)));
				receipt.setsId(shopS.get(rs.getInt(3)));
				receipt.setStId(stateS.get(rs.getInt(4)));
				receipt.setDate(rs.getDate(5));
				receipt.setAddress(rs.getString(6));
				list.add(receipt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int CountState(int stateID) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from Receipt where StateID=? and ShopId=?";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, stateID);
			ps.setInt(2, ShopID.sID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from Receipt where ShopId=?";
		return this.getCount(sql);
	}

	// Ham count chung
	public int getCount(String sql) {
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ShopID.sID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
