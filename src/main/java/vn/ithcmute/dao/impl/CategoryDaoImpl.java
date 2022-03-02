package vn.ithcmute.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.ithcmute.connection.DBConnection;
import vn.ithcmute.dao.CategoryDao;
import vn.ithcmute.model.CategoryModel;
import vn.ithcmute.util.ShopID;

public class CategoryDaoImpl implements CategoryDao{
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public ArrayList<CategoryModel> getAllCategory(){
		ArrayList<CategoryModel> list = new ArrayList<CategoryModel>();
		String sql ="select * from Category";
		try {
			con = new DBConnection().getConnection();
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new CategoryModel(rs.getInt(1),rs.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public CategoryModel get(int id) {
		String sql ="select * from Category where CategoryID =?";
		try {
			con = new DBConnection().getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new CategoryModel(rs.getInt(1),rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void insert(CategoryModel cate) {
		String sql = "INSERT INTO Category (CategoryName) VALUES (?)";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cate.getcName());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void edit(CategoryModel cate) {
		String sql = "UPDATE Category SET CategoryName = ? WHERE CategoryID = ?";
		try {
			Connection con = new DBConnection().getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cate.getcName());
			ps.setInt(2, cate.getcID());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Category WHERE CategoryID = ?";
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
	public int isCategoryExist(CategoryModel cate) {
		String sql ="select * from Category where CategoryName =?";
		try {
			con = new DBConnection().getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, cate.getcName());
			rs = ps.executeQuery();
			while(rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public List<CategoryModel> getListByShop() {
		String sql="select distinct Category.CategoryID,CategoryName \r\n" + 
				"from Category inner join Product on Category.CategoryID=Product.CategoryID\r\n" + 
				"where ShopID=?";
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		try {
			con = new DBConnection().getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, ShopID.sID);
			rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new CategoryModel(rs.getInt(1),rs.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
