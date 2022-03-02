package vn.ithcmute.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.ithcmute.connection.DBConnection;
import vn.ithcmute.dao.StatisticsDao;
import vn.ithcmute.model.StatisticsModel;
import vn.ithcmute.util.ShopID;


public class StatisticsDaoImpl implements StatisticsDao{
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<StatisticsModel> getStatistics(String sql) {
		List<StatisticsModel> list = new ArrayList<StatisticsModel>();
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ShopID.sID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new StatisticsModel(rs.getString(1),rs.getInt(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Thong ke so san pham bang duoc
	@Override
	public List<StatisticsModel> getStatisticsProduct() {
		String sql = "select top 8 ProductName,sum(ReceiptDetail.Amount) from Product,ReceiptDetail\r\n" + 
				"where Product.ProductID=ReceiptDetail.ProductID and ShopID=?\r\n" + 
				"group by Product.ProductID,ProductName order by sum(ReceiptDetail.Amount) desc";
		return getStatistics(sql);
	}

	// Thong ke so san pham theo tung category bang duoc
	@Override
	public List<StatisticsModel> getStatisticsCategory() {
		String sql = "select count(ProductID),CategoryName\r\n" + "from Product,Category\r\n"
				+ "where Product.CategoryID=Category.CategoryID and ShopID=?\r\n"
				+ "group by Category.CategoryID,CategoryName\r\n" + "order by count(ProductID)";
		return getStatistics(sql);
	}

	// Don thanh cong trong 4 thang gan day
	@Override
	public List<StatisticsModel> getListDeliveredReceipt() {
		String sql = "select Month(Date) as 'Thang',count(ReceiptID) as 'SL' from Receipt where\r\n"
				+ "ShopID=? and StateID=3 and MONTH(date) <= Month(CURRENT_TIMESTAMP) and MONTH(date)> (Month(CURRENT_TIMESTAMP)-4)\r\n"
				+ "group by Month(Date)";
		return getStatistics(sql);
	}

	// Lay so hoa don theo thang
	@Override
	public List<StatisticsModel> getListAllReceipt() {
		String sql = "select Month(Date),count(ReceiptID) from Receipt where\r\n"
				+ "ShopID=? and (StateID=3 or StateID=4) and MONTH(date) <= Month(CURRENT_TIMESTAMP) and MONTH(date)> (Month(CURRENT_TIMESTAMP)-4)\r\n"
				+ "group by Month(Date)";
		return getStatistics(sql);
	}

}
