package vn.ithcmute.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.ithcmute.connection.DBConnection;
import vn.ithcmute.dao.ShopDao;
import vn.ithcmute.model.ShopModel;

public class ShopDaoImpl implements ShopDao{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ShopModel get(int id) {
		ShopModel shopModel = new ShopModel();
		String sql ="select * from Shop where ShopID=?";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				shopModel.setsID(rs.getInt(1));
				shopModel.setsName(rs.getString(2));
				shopModel.setsAddrs(rs.getString(3));
				shopModel.setsPhone(rs.getString(4));
				return shopModel;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ShopModel> getAll() {
		List<ShopModel> list = new ArrayList<ShopModel>();
		String sql ="select * from Shop";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ShopModel shopModel = new ShopModel();
				shopModel.setsID(rs.getInt(1));
				shopModel.setsName(rs.getString(2));
				shopModel.setsAddrs(rs.getString(3));
				shopModel.setsPhone(rs.getString(4));
				list.add(shopModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void insert(ShopModel shop) {
		String sql ="insert into Shop(ShopName,ShopAddress,Phone) values(?,?,?)";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,shop.getsName());
			ps.setString(2, shop.getsAddrs());
			ps.setString(3, shop.getsPhone());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void edit(ShopModel newShop) {
		String sql ="update Shop set ShopName=?,ShopAddress=?,Phone=?\r\n" + 
				"where ShopID=?";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,newShop.getsName());
			ps.setString(2, newShop.getsAddrs());
			ps.setString(3, newShop.getsPhone());
			ps.setInt(4, newShop.getsID());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql ="delete from Shop where ShopID=?";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public ShopModel search(String ShopName) {
		ShopModel shopModel = new ShopModel();
		String sql="select * from Shop where ShopName like ?";
		try {
			con = new DBConnection().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+ShopName+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				shopModel.setsName(rs.getString(1));
				shopModel.setsAddrs(rs.getString(2));
				shopModel.setsPhone(rs.getString(3));
				return shopModel;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}