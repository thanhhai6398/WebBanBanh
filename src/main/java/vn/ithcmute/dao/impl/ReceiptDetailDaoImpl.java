package vn.ithcmute.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.ithcmute.connection.DBConnection;
import vn.ithcmute.dao.ReceiptDao;
import vn.ithcmute.dao.ReceiptDetailDao;
import vn.ithcmute.dao.UserDao;
import vn.ithcmute.model.ReceiptDetailModel;
import vn.ithcmute.service.ProductService;
import vn.ithcmute.service.impl.ProductServiceImpl;

public class ReceiptDetailDaoImpl extends DBConnection implements ReceiptDetailDao {
	UserDao userDao = new UserDaoImpl();
	ReceiptDao receiptService = new ReceiptDaoImpl();
	ProductService productService = new ProductServiceImpl();

	@Override
	public void insert(ReceiptDetailModel ReceiptDetail) {
		String sql = "INSERT INTO ReceiptDetail(ReceiptID, ProductID, Amount) VALUES (?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ReceiptDetail.getrId().getrId());
			ps.setInt(2, ReceiptDetail.getpId().getpID());
			ps.setInt(3, ReceiptDetail.getAmount());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM ReceiptDetail WHERE ReceiptID = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<ReceiptDetailModel> getList(int receiptID) {
		List<ReceiptDetailModel> list = new ArrayList<ReceiptDetailModel>();
		String sql = "select * from ReceiptDetail where ReceiptID=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);		
			ps.setInt(1, receiptID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ReceiptDetailModel detail = new ReceiptDetailModel();
				detail.setdId(rs.getInt(1));
				detail.setrId(receiptService.get(rs.getInt(2)));
				detail.setpId(productService.get(rs.getInt(3)));
				detail.setAmount(rs.getInt(4));
				list.add(detail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ReceiptDetailModel> getAll() {
		List<ReceiptDetailModel> list = new ArrayList<ReceiptDetailModel>();
		String sql = "select * from ReceiptDetail";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ReceiptDetailModel detail = new ReceiptDetailModel();
				detail.setdId(rs.getInt(1));
				detail.setrId(receiptService.get(rs.getInt(2)));
				detail.setpId(productService.get(rs.getInt(3)));
				detail.setAmount(rs.getInt(4));
				list.add(detail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void deleteDetail(int detailID) {
		// TODO Auto-generated method stub
		String sql="delete from ReceiptDetail where DetailID=?";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, detailID);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
